import model.Student;
import myUtils.FileHandler;
import service.StudentService;

import java.util.Optional;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();

    public static void main(String[] args) {

        boolean run = true;
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar estudiante por ID");
            System.out.println("4. Actualizar estudiante");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int option = scanner.nextInt();
                switch(option) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        showStudents();
                        break;
                    case 3:
                        findStudent();
                        break;
                    case 4:
                        updateStudent();
                        break;
                    case 5:
                        deleteStudent();
                        break;
                    case 6:
                        run = false;
                        studentService.saveData();
                        break;
                    default:
                        System.out.println("PARA ELEGIR UNA OPCION, SELECCIONE VALORES DEL 1-6");
                }
            }catch (Exception ex) {
                System.out.println("DEBE INGRESAR UN VALOR NUMERICO, SIN CARACTERES ADICIONALES");
                run = false;
            }
        } while(run);
    }

    private static void deleteStudent() {
        System.out.println("--- ELIMINAR ESTUDIANTE ---");
        System.out.print("Ingrese el id. del estudiante a eliminar: ");
        int id = scanner.nextInt();
        if (studentService.deleteStudent(id)) {
            System.out.println("Eliminación exitosa");
        } else {
            System.out.println("Error al trata de eliminar estudiante");
        }
    }

    private static void addStudent() {

        System.out.println("--- AGREGAR ESTUDIANTE ---");
        System.out.println();

        System.out.print("Nombre: ");
        String name = scanner.next();

        System.out.print("Apellido paterno: ");
        String pSurname = scanner.next();

        System.out.print("Apellido materno: ");
        String mSurname = scanner.next();

        System.out.print("Edad: ");
        int years = scanner.nextInt();

        System.out.print("email: ");
        String email = scanner.next();

        System.out.print("c.i: ");
        String ci = scanner.next();

        System.out.print("materia: ");
        String subject = scanner.next();

        //save student
        studentService.addStudent(name,pSurname,mSurname,email,ci,years,subject);
    }

    public static void showStudents() {
        System.out.println("--- LISTA DE ESTUDIANTES ---");
        studentService.getAllStudents().stream()
                .forEach(student -> System.out.println(student.toString()));
    }

    public static void findStudent() {
        System.out.println("--- BUSCAR ESTUDIANTE ---");
        System.out.print("id estudiante: ");
        try {
            int id = scanner.nextInt();
            Optional<Student> optionalStudent = studentService.findById(id);
            optionalStudent.ifPresentOrElse(
                    student -> System.out.println(student.toString()),
                    () -> System.out.println("Estudiante no registrado.")
            );
        }catch (NumberFormatException ex) {
            System.out.println("Debe ingresar un entero positivo para el id del estudiante");
        }
    }

    public static void updateStudent() {
        System.out.println("--- ACTUALIZAR ESTUDIANTE ---");

        System.out.print("Seleccione el id: ");
        int id = scanner.nextInt();

        Optional<Student> optionalStudent = studentService.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            System.out.println("Nombre (actual): " + student.getName());
            System.out.print("Nombre (nuevo): ");
            String name = scanner.next();

            System.out.println("Apellido paterno (actual): " + student.getpSurname());
            System.out.print("Apellido paterno (nuevo): ");
            String pSurname = scanner.next();

            System.out.println("Apellido materno (actual): " + student.getmSurname());
            System.out.print("Apellido materno (nuevo): ");
            String mSurname = scanner.next();

            System.out.println("Edad (actual): " + student.getYears());
            System.out.print("Edad (nuevo): ");
            int years = scanner.nextInt();

            System.out.println("Email (actual): " + student.getEmail());
            System.out.print("Email (nuevo): ");
            String email = scanner.next();

            System.out.println("c.i. (actual): " + student.getCi());
            System.out.print("c.i. (nuevo): ");
            String ci = scanner.next();

            System.out.println("materia (actual): " + student.getSubject());
            System.out.print("materia (nuevo): ");
            String subject = scanner.next();

            boolean update = studentService.updateStudent(id, name, pSurname, mSurname, email, ci, years, subject);
            if (update) {
                System.out.println("Datos actualizados correctamente.");
            } else {
                System.out.println("Error al actualizar los datos");
            }

        } else {
            System.out.println("id incorrecto");
        }
    }
}