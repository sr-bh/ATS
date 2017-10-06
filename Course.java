/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOThreads
 */
public class Course {
    private String code;
    private String name;
    private String contactSlots;
    private String resourceType;
    private String courseType;
    private String association="";
    public Course(String code, String name, String contactSlots, String resourceType, String courseType){
        this.code=code;
        this.name=name;
        this.contactSlots=contactSlots;
        this.resourceType=resourceType;
        this.courseType=courseType;
        //this.association=association;
    }
    public void printAsString(){
        System.out.println("Course code: "+this.code);
        System.out.println("Course name: "+this.name);
        System.out.println("Course slots: "+this.contactSlots);
        System.out.println("Course resType: "+this.resourceType);
        System.out.println("Course type: "+this.courseType);
        System.out.println("Course association: "+this.association);
    }
}
