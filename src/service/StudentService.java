package service;

import model.Student;
import myUtils.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {

    private final List<Student> students;
    private int id;

    public StudentService() {
        students = FileHandler.readFile();
        if (students.isEmpty()) {
            id = 0;
        } else {
            id = students.get(students.size() - 1).getId();
        }
    }

    public void addStudent(String name, String pSurname, String mSurname, String email, String ci, int years, String subject) {
        id++;
        Student student = new Student(
                id,
                name,
                pSurname,
                mSurname,
                email,
                ci,
                years,
                subject
        );

        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> findById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public boolean updateStudent(int id, String name, String pSurname, String mSurname, String email, String ci, int years, String subject) {
        Optional <Student> optionalStudent = findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(name);
            student.setpSurname(pSurname);
            student.setmSurname(mSurname);
            student.setEmail(email);
            student.setCi(ci);
            student.setYears(years);
            student.setSubject(subject);

            return true;
        }

        return false;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(student -> student.getId() == id);
    }

    public void saveData() {
        FileHandler.writeFile(students);
    }
}
