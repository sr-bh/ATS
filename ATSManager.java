/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOThreads
 */
public class ATSManager {
    
    DataManager dataMgr;
    LogicManager logicMgr;
    DisplayManager displayMgr;
 
    
    Timeslot[] timeslots;
    Course[] courses;
    Section[] sections;
    Room[] rooms;
    Instructor[] instructors;
    
    Period[] timetable;

    
    public static void main(String[] args) {
        /*
        ATSManager myMgr = new ATSManager();
        
        // create all managers
        myMgr.dataMgr = new DataManager(myMgr);
        myMgr.logicMgr = new LogicManager(myMgr);
        myMgr.displayMgr = new DisplayManager(myMgr);        

        // initialise data
        myMgr.timeslots = myMgr.dataMgr.readTimeslots("timeslots.csv");
        myMgr.courses = myMgr.dataMgr.readCourses("courses.csv");
        myMgr.sections = myMgr.dataMgr.readSections("sections.csv");
        myMgr.rooms = myMgr.dataMgr.readRooms("rooms.csv");       
        myMgr.instructors = myMgr.dataMgr.readInstructors("instructors.csv");
        
        // generate timetable
        myMgr.periods = myMgr.logicMgr.generate(myMgr.timeslots,myMgr.courses, myMgr.sections,myMgr.rooms,myMgr.instructors);
        */
    }
}
