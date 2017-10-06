
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOThreads
 */
public class DataManager {
    //this constructor to be used during integration with ATSManager
    
    /*ATSManager mgr;
    public DataManager(ATSManager mgr) {
        this.mgr = mgr;
    }*/
    
    public Course[] readCourses(String filename) {
        BufferedReader br = null;
        FileReader fr = null;
        Course[] courses=new Course[50];
        int i=0;
        try{
            String str;
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            br.readLine();
            while((str=br.readLine())!=null){
                String[] result = str.split("[,]",-1);
                
                //we need to use another method to input the association course 
                //or maybe figure out something else
                
                courses[i]=new Course(result[0],result[1],Integer.parseInt(result[2]),result[3],result[4]);
                courses[i].printAsString();
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found for courses. Invalid filename: "+ filename);
        } catch (IOException ex) {
            System.out.println("IOException for courses file with filename: "+ filename);
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("Problem closing file with filename: "+ filename);
            }
        }
        return courses; 
    }
    /*public Instructor[] readInstructors(String filename) {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filename));
        }catch(FileNotFoundException ex){
            System.out.println("File not found for instructors. invalid filename: "+ filename);
        }
        return new Instructor[10];
    }
    
    public Timeslot[] readTimeslots(String filename) {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filename));
        }catch(FileNotFoundException ex){
            System.out.println("File not found for timeslots. invalid filename: "+ filename);
        }
        return new Timeslot[10];
    }
    
    public Section[] readSections(String filename) {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filename));
        }catch(FileNotFoundException ex){
            System.out.println("File not found for sections. invalid filename: "+ filename);
        }
        return new Section[10]; 
    }
    
    public Room[] readRooms(String filename) {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filename));
        }catch(FileNotFoundException ex){
            System.out.println("File not found for rooms. invalid filename: "+ filename);
        }
        return new Room[10]; 
    }*/
    
    
    //test all methods using main
    public static void main(String args[]){
        DataManager dataMgr = new DataManager();
        dataMgr.readCourses("courses.csv");
    }
    
}
