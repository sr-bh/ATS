/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOThreads
 */
public class Instructor {
    private String name;
    private Course[] expertise;
    public Instructor(String name, Course[] expertise){
        this.name=name;
        this.expertise=expertise;
    }
    public Course[] getExpertise(){
        return this.expertise;
    }
    public void printAsString(){
        System.out.print("Instructor name: "+this.name+" with expertise in ");
        for(Course c : this.expertise){
            if(c!=null)
                System.out.print(c.getCode() + " ");
        }
        System.out.println("");
            
    }
}
