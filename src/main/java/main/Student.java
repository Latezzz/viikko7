package main;

public class Student implements PrintInfo{
    private String name;
    private String id;

    private String information;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getInformation() {
        information = (this.id + " " + this.name);
        return information;
    }
}
