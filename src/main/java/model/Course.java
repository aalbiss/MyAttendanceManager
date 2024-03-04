package model;

public class Course {

    private String name;
    private String professor;
    private String duration;
    
    public Course() {
        name = "";
        professor = "";
        duration = "";
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getProfessor() {
        return professor;
    }
    
    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
    public String getDuration() {
        return duration;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
}
