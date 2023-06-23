/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Marco
 */
public class Courses {
    private String courseID;
    private String name;
    private String teacher;
    private String description;
    
    public String getCourseID(){
        return courseID;
    }
    
    public void setCourseID(String id){
        this.courseID = id;
    }
    
    public String getNameCourse(){
        return name;
    }
    
    public void setCourseName(String courseName){
        this.name = courseName;
    }
    
    public String getTeacher(){
        return teacher;
    }
    
    public void setTeacher(String teacher){
        this.teacher = teacher;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String desc){
        this.description = desc;
    }
    
    public void describeCourse(){
        System.out.println(this.courseID);
        System.out.println(this.name);
        System.out.println(this.teacher);
        System.out.println(this.description);
    }
    
}
