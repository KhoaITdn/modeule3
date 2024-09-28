package org.example.demo2.model;

public class ClassModel {
    private int classId;
    private String className;

    public ClassModel(int id, String className) {
        this.classId = id;
        this.className = className;
    }

    public ClassModel(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}