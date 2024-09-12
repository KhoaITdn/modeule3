package org.example.demo2.model;
public class Student {
    private int id;
    private String name;
    private String email;
    private boolean gender; // Đổi gender thành boolean
    private double point;
    private String class_name;

    // Constructor đầy đủ
    public Student(int id, String name , String email, boolean gender, double point, String class_name) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.point = point;
        this.class_name = class_name;
    }

    // Constructor không có id (cho trường hợp thêm sinh viên mới)
    public Student(String name,String class_name, String email, boolean gender, double point) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.point = point;
        this.class_name = class_name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public boolean getGender() {
        return gender;
    }

    public String getClassName() {
        return class_name;
    }
}
