/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOThreads
 */
public class LogicManager {
    //this constructor to be used during integration with ATSManager
    /*
    ATSManager mgr;
    public LogicManager(ATSManager mgr) {
        this.mgr = mgr;
    }*/
    
    public Period[] matchCourseToInstructor(Course[] courses, Instructor[] instructors){
        //
        
        //return array of periods containing course and instructor
        return new Period[10];
    }
    
    //test all methods using main
    public static void main(String args[]){
        LogicManager logicMgr = new LogicManager();
        
        Course[] courses = new Course[10];
        Instructor[] instructors = new Instructor[10];
        //add some data to the arrays for testing
        
        logicMgr.matchCourseToInstructor(courses,instructors);
    }
}
