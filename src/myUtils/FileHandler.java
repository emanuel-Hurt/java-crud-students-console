package myUtils;

import model.Student;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;

public class FileHandler {

    private static final Path path = Paths.get("estudiantes.csv");

    private static void createFile() {
        try {
            Files.writeString(path,"id,name,pSurname,mSurname,email,ci,years,subject\n",StandardCharsets.UTF_8,CREATE);
        } catch (IOException e) {
            System.out.println("ERROR AL CREAR ARCHIVO");
            System.out.println(e.getMessage());
        }
    }

    public static List<Student> readFile() {
        List<Student> studentList = new ArrayList<>();
        if (!Files.exists(path)) {
            createFile();
            return studentList;
        }
        try {
            List<String> content = Files.readAllLines(path, StandardCharsets.UTF_8);

            for (String line: content) {
                if (line.startsWith("id,")) continue;

                String[] data = line.split(",");
                if (data.length == 8) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String pSurname = data[2];
                    String mSurname = data[3];
                    String email = data[4];
                    String ci = data[5];
                    int years = Integer.parseInt(data[6]);
                    String subject = data[7];

                    studentList.add(new Student(id,name,pSurname,mSurname,email,ci,years,subject));
                }
            }

        } catch (IOException e) {
            System.out.println("ERROR AL CARGAR ARCHIVO DE DATOS");
            System.out.println(e.getMessage());
        }

        return studentList;
    }

    public static void writeFile(List<Student> students) {
        List<String> studentsCSV = new ArrayList<>();
        studentsCSV.add("id,name,pSurname,mSurname,email,ci,years,subject"); //create header

        students.forEach(student -> studentsCSV.add(student.toCSV())); //add data

        try {
            Files.write(path,studentsCSV, StandardCharsets.UTF_8, TRUNCATE_EXISTING, WRITE);
        } catch (IOException ex) {
            System.out.println("ERROR AL ESCRIBIR ARCHIVO");
            System.out.println(ex.getMessage());
        }
    }
}
