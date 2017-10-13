import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

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
            HashMap<String,String> tempAssociation = new HashMap<>();
            String str, courseName;
            Course partner;
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            br.readLine();
            while((str=br.readLine())!=null){
                //String[] result = str.split("[,]",-1);
                StringTokenizer st = new StringTokenizer(str,",");
                courseName = st.nextToken();
                courses[i]=new Course(courseName,st.nextToken(),Integer.parseInt(st.nextToken()),st.nextToken(),st.nextToken());
                
                //to check for and store the association course
                if(st.hasMoreTokens()){
                    tempAssociation.put(courseName,st.nextToken());
                }
                i++;
            }
            for(Course c : courses){
                if((c!=null) && (tempAssociation.containsKey(c.getCode()))){
                    partner = this.getCourseByCode(courses, tempAssociation.get(c.getCode()));
                    c.setAssociation(partner);
                }
            }
            for(Course c : courses){
                if(c!=null)
                    c.printAsString();
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found for courses. Invalid filename: "+ filename);
        } catch (IOException ex) {
            System.out.println("IOException for courses file with filename: "+ filename);
        }finally{
            try {
                if(br!=null)
                    br.close();
                if(fr!=null)
                    fr.close();
            } catch (IOException ex) {
                System.out.println("Problem closing file with filename: "+ filename);
            }
        }
        return courses; 
    }
    public Instructor[] readInstructors(String filename, Course[] courses) {
        BufferedReader br = null;
        FileReader fr = null;
        Instructor[] instructors=new Instructor[50];
        Course[] expertise = new Course[4];
        String name;
        int i=0;
        try{
            String str;
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            br.readLine();
            while((str=br.readLine())!=null){
                StringTokenizer st = new StringTokenizer(str,",");
                int k=0;
                name=st.nextToken();
                while(st.hasMoreTokens()){
                    expertise[k] = getCourseByCode(courses,st.nextToken());
                    k++;
                }
                instructors[i]=new Instructor(name,expertise);
                i++;
            }
            for(Instructor ins : instructors){
                if(ins!=null){
                   ins.printAsString();
               }
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found for instructors. Invalid filename: "+ filename);
        } catch (IOException ex) {
            System.out.println("IOException for instructors file with filename: "+ filename);
        }finally{
            try {
                if(br!=null)
                    br.close();
                if(fr!=null)
                    fr.close();
            } catch (IOException ex) {
                System.out.println("Problem closing file with filename: "+ filename);
            }
        }
        return instructors;
    }
    
    public Timeslot[] readTimeslots(String filename) {
        BufferedReader br = null;
        FileReader fr = null;
        Timeslot[] timeslots=new Timeslot[50];
        String dayOfWeek;
        int slot,startTime,endTime;
        int i=0;
        try{
            String str;
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            br.readLine();
            while((str=br.readLine())!=null){
                StringTokenizer st = new StringTokenizer(str,",");
                while(st.hasMoreTokens()){
                    dayOfWeek=st.nextToken();
                    slot=Integer.parseInt(st.nextToken());
                    startTime=Integer.parseInt(st.nextToken());
                    endTime=Integer.parseInt(st.nextToken());
                    timeslots[i]=new Timeslot(dayOfWeek,slot,startTime,endTime);
                }
                i++;
            }
            for(Timeslot t: timeslots){
               if(t!=null){
                   t.printAsString();
               }
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found for timeslots. Invalid filename: "+ filename);
        } catch (IOException ex) {
            System.out.println("IOException for timeslots file with filename: "+ filename);
        }finally{
            try {
                if(br!=null)
                    br.close();
                if(fr!=null)
                    fr.close();
            } catch (IOException ex) {
                System.out.println("Problem closing file with filename: "+ filename);
            }
        }
        return timeslots;
    }
    
    /*public Section[] readSections(String filename) {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filename));
        }catch(FileNotFoundException ex){
            System.out.println("File not found for sections. invalid filename: "+ filename);
        }
        return new Section[10]; 
    }*/
    
    public Room[] readRooms(String filename) {
        BufferedReader br = null;
        FileReader fr = null;
        Room[] rooms=new Room[50];
        String resource,type;
        int capacity;
        int i=0;
        try{
            String str;
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            br.readLine();
            while((str=br.readLine())!=null){
                StringTokenizer st = new StringTokenizer(str,",");
                int k=0;
                while(st.hasMoreTokens()){
                    resource=st.nextToken();
                    type=st.nextToken();
                    capacity=Integer.parseInt(st.nextToken());
                    rooms[i]=new Room(resource,type,capacity);
                }
                i++;
            }
            for(Room r : rooms){
               if(r!=null){
                   r.printAsString();
               }
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found for timeslots. Invalid filename: "+ filename);
        } catch (IOException ex) {
            System.out.println("IOException for timeslots file with filename: "+ filename);
        }finally{
            try {
                if(br!=null)
                    br.close();
                if(fr!=null)
                    fr.close();
            } catch (IOException ex) {
                System.out.println("Problem closing file with filename: "+ filename);
            }
        }
        return rooms; 
    }
    public Course getCourseByCode(Course[] courses, String courseCode){
        for(Course c : courses){
            if(c.getCode().equals(courseCode)){
                return c;
            }
        }
        return null;
    }
    
    //test all methods using main
    public static void main(String args[]){
        DataManager dataMgr = new DataManager();
        Course[] courses = dataMgr.readCourses("courses.csv");
        System.out.println("\n=========================================================");
        dataMgr.readInstructors("instructors.csv", courses);
        System.out.println("\n=========================================================");
        dataMgr.readTimeslots("timeslots.csv");
        dataMgr.readRooms("rooms.csv");
        System.out.println("\n=========================================================");
    }
    
}
