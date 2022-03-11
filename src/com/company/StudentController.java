package com.company;

import java.rmi.StubNotFoundException;
import java.util.*;

public class StudentController {
    static Scanner sc = new Scanner(System.in);
    static StudentService service = new StudentService();
    static ArrayList<Student> list= service.getListStudent();

    public static void mainMenu(){
       while (true){
           menu();
           int x = sc.nextInt();
           sc.nextLine();
           switch (x){
               case 1:
                   System.out.println(" danh sach học sinh ");
                   service.show(list);
                   break;
               case 2:
                   System.out.println("thêm học sinh mới");
                   addStudent();
                   break;
               case 3:
                   System.out.println("cập nhật điểm học sinh");
                   updatePoint();
                   break;
               case 4:
                   System.out.println("xóa học sinh ");
                   deleteStudent();
                   break;
               case 5:
                   System.out.println("xem danh sách học sinh theo lớp");
                   System.out.println("nhập lớp cần tìm");
                   String classroom= sc.nextLine();
                   if (classroom.contains("10A1")){
                       ArrayList<Student> viewStudent10A1 = service.viewStudent10A1(list);
                       service.show(viewStudent10A1);
                       break;
                   } else if(classroom.contains("10A2")){
                       ArrayList<Student> viewStudent10A2 = service.viewStudent10A2(list);
                       service.show(viewStudent10A2);
                       break;
                   } else if(classroom.contains("10A3")){
                       ArrayList<Student> viewStudent10A3 = service.viewStudent10A3(list);
                       service.show(viewStudent10A3);
                       break;
                   } else {
                       System.out.println("không có lớp phẩm này ");
                   }
                   break;
               case 6:
                   System.out.println("sắp xếp học sinh theo tên ");
                   Collections.sort(list, new Comparator<Student>() {
                       @Override
                       public int compare(Student o1, Student o2) {
                           return o1.getName().compareTo(o2.getName());
                       }
                   });
                   service.show(list);

                   break;
               case 7:
                   System.out.println("sắp xếp học sinh theo tuổi");
                   Collections.sort(list, new Comparator<Student>() {
                       @Override
                       public int compare(Student o1, Student o2) {
                           return o1.getAge() - o2.getAge();
                       }
                   });
                   service.show(list);
                   break;
               case 8:
                   System.out.println("sắp xếp học sinh theo điểm");
                   Collections.sort(list, new Comparator<Student>() {
                       @Override
                       public int compare(Student o1, Student o2) {
                           return o1.getPoint() > o2.getPoint() ? 1:-1;
                       }
                   });
                   service.show(list);
                   break;
               case 0:
                   System.out.println("thoát chương trình");
                   System.exit(0);
                   break;
               default:
                   System.out.println("không có lựa chọn này ");
           }
       }
    }





    public static Student addStudent() {
        System.out.println(" nhập mã học sinh : ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("nhập tên học sinh: ");
        String name = sc.nextLine();
        System.out.println("nhập tuổi học sinh");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("nhập địa chỉ học sinh ");
        String address = sc.nextLine();
        System.out.println("nhập điểm học sinh");
        Double point = sc.nextDouble();
        sc.nextLine();
        System.out.println("chọn  lớp học sinh");
        Classroom classroom = chooseclassroom();
        Student newStudent = new Student(id, name, age, address, point , classroom);

        if (service.addNewStudent(list, newStudent)){
            System.out.println("thêm thành công");
        } else {
            System.out.println("thêm thất bại");
        }
        return newStudent;

    }
        public static Classroom chooseclassroom(){
            System.out.println("1-10A1");
            System.out.println("2- 10A2");
            System.out.println("3-10A3");
            while (true){
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose){
                    case 1:
                        return new Classroom("10A1");
                    case 2:
                        return new Classroom("10A2");
                    case 3:
                        return new Classroom("10A3");
                    default:
                        System.out.println("Không có lựa chọn này, mời chọn lại: ");
                }

            }
        }



    //        cập nhật điểm học sinh
    public static void updatePoint(){
        System.out.println("nhập mã học sinh cần cập nhât điểm");
        int id = sc.nextInt() ;
        sc.nextLine();
        Student findStudentId = service.findStudentbyId(list, id);
        System.out.println(findStudentId);
        System.out.println("nhật điểm cầm cập nhật cho học sinh vừa tìm được");
        double point = sc.nextDouble();
        service.updatePoint(findStudentId, point );
        System.out.println("cập nhật thành công");

    }

//    xóa học sinh
    public static void deleteStudent(){
        System.out.println("nhập mã học sinh cần xóa");
        int id = sc.nextInt() ;
        sc.nextLine();
        Student findStudentId = service.findStudentbyId(list, id);
       service.deleteStudent(list, findStudentId);
        System.out.println("xóa thành công ");

    }





    public static void menu(){
        System.out.println("bạn có thể thực hiện");
        System.out.println("1- xem danh sách học sinh");
        System.out.println("2- thêm học sinh mới");
        System.out.println("3- cập nhật điểm học sinh");
        System.out.println("4- xóa học sinh ");
        System.out.println("5- xem danh sách học sinh theo lớp ");
        System.out.println("6- sắp xếp học sinh theo tên");
        System.out.println("7- sắp xếp học sinh theo tuổi");
        System.out.println("8- sắp xếp theo điểm");
        System.out.println("0- thoát chương trình ");
    }
}
