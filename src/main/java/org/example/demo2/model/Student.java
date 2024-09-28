package org.example.demo2.model;


public class Student {
    private int id;
    private String name;
//    private Date birthday;
    private String email;
    private int gender;
    private double point;;
    private ClassModel  clazz;

//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    public Student(int id, String name, String email , int gender, double point, ClassModel  clazz) {
        this.id = id;
        this.name = name;
//        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.point = point;
        this.clazz = clazz;
    }

    public Student(String name, String email , int gender, double point, ClassModel  clazz) {
        this.name = name;
//        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.point = point;
        this.clazz = clazz;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClassModel  getClazz() {
        return clazz;
    }

    public void setClazz(ClassModel  clazz) {
        this.clazz = clazz;
    }


}