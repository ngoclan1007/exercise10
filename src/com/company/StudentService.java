package com.company;

import java.util.ArrayList;

public class StudentService {
    Classroom classroom1 = new Classroom("10A1");
    Classroom classroom2 = new Classroom("10A2");
    Classroom classroom3 = new Classroom("10A3");

    public ArrayList<Student> getListStudent(){
      ArrayList<Student> listStudent = new ArrayList<>();
      Student t1=  new Student(1, "An", 20, "HN", 8.5 , classroom1);
      Student t2=  new Student(2, "Hoa", 22, "BN", 7.5, classroom2);
      Student t3=  new Student(3, "Nhung", 20, "HN", 8.0, classroom3);
      Student t4=  new Student(4, "An", 19, "QN", 7.5, classroom2);
      Student t5=  new Student(5, "Sơn", 20, "HP", 9.0, classroom3);
      Student t6=  new Student(6, "Nga", 18, "BG", 7.0, classroom1);
      Student t7=  new Student(7, "Thái", 20, "QN", 8.5, classroom2);
      Student t8=  new Student(8, "Tuấn", 21, "QN", 7.0, classroom1);
      Student t9=  new Student(9, "Thanh", 20, "HN", 9.0, classroom3);
      Student t10=  new Student(10, "Sơn", 18, "TN", 7.5, classroom1);

      listStudent.add(t1);
      listStudent.add(t2);
      listStudent.add(t3);
      listStudent.add(t4);
      listStudent.add(t5);
      listStudent.add(t6);
      listStudent.add(t7);
      listStudent.add(t8);
      listStudent.add(t9);
      listStudent.add(t10);


        return listStudent;
    }

    public  void show(ArrayList<Student> list){
        for (Student t : list){
            System.out.println(t);
        }
    }

    public boolean addNewStudent(ArrayList<Student> list, Student t){
           return list.add(t);
    }


    public Student findStudentbyId(ArrayList<Student> list, int id){
        Student findId = null;
        for (Student t : list){
            if (t.getId() == id){
                findId = t;
            }
        }
        return findId;
    }

    public void updatePoint(Student t , double newPoint){
        t.setPoint(newPoint);
    }

    public boolean deleteStudent(ArrayList<Student> list, Student t){
        return list.remove(t);
    }


//    xem danh sách theo lớp

    public ArrayList<Student> viewStudent10A1(ArrayList<Student> list){
        ArrayList<Student> Vstudent10A1 = new ArrayList<>();
//        String classroom1 = "10A1";
        for (Student t : list){
            if (t.getClassroom().equals(classroom1)){
                Vstudent10A1.add(t);
            }
        }
        return Vstudent10A1;
    }

    public ArrayList<Student> viewStudent10A2(ArrayList<Student> list){
        ArrayList<Student> Vstudent10A2 = new ArrayList<>();
//        String classroom2 = "10A2";
        for (Student t : list){
            if (t.getClassroom().equals(classroom2)){
                Vstudent10A2.add(t);
            }
        }
        return Vstudent10A2;
    }
    public ArrayList<Student> viewStudent10A3(ArrayList<Student> list){
        ArrayList<Student> Vstudent10A3 = new ArrayList<>();
//        String classroom3 = "10A3";
        for (Student t : list){
            if (t.getClassroom().equals(classroom3)){
                Vstudent10A3.add(t);
            }
        }
        return Vstudent10A3;
    }


}
