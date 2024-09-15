package org.example.demo2.model;
public class Student {
    private int id;
    private String name;
    private String email;
    private int gender; // Đổi gender thành boolean
    private double point;
    private ClassName clazz;

    // Constructor đầy đủ
    public Student(int id, String name , String email, int gender, double point, ClassName clazz) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.point = point;
        this.clazz = clazz;
    }

    // Constructor không có id (cho trường hợp thêm sinh viên mới)
    public Student(String name, String email, int gender, double point, ClassName clazz) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }


    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public ClassName getClazz() {
        return clazz;
    }

    public void setClazz(ClassName clazz) {
        this.clazz = clazz;
    }
}
