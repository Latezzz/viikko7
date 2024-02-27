package main;

public class Course implements PrintInfo {
    private int maxNumberOfStudents;
    private String name;
    private String id;

    private String information;

    public Course(int maxNumberOfStudents, String name, String id) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.name = name;
        this.id = id;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }


    public String getInformation() {
        information = (this.id + " " + this.name);
        return information;
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
