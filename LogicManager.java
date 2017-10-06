
import java.util.Arrays;
import java.util.Collections;

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
    
    public int[][] matchCourseToInstructor(Course[] courses, Instructor[] instructors){
        
        //initialise the arrays
        int i,j;
        int ilen=instructors.length;
        int clen = courses.length;
        int[] HAT = new int[ilen];
        int[][] CAT = new int[ilen][clen];
        int[] LAT = new int[clen];
        int[][] PAT = new int[ilen][clen];
        Integer[] PQ = new Integer[ilen];
        
        //HAT: Instructor Hours Allocation Table
        //Each instructor has maximum 15 hrs alloted per week
        for(i=0;i<HAT.length;i++){
            HAT[i]=15;
        }
        
        //LAT: Lecture Hours Allocation Table
        for(i=0;i<LAT.length;i++){
            LAT[i]=courses[i].getContactSlots();
        }
        
        //PAT: Preference allocation table must be populated using data from instructors expertise
        for (j=0; j<PAT.length; j++) {
            for(i=0;i<PAT[0].length;i++){
                String courseCode = courses[j].getCode();
                Course[] exp = instructors[i].getExpertise();
                
                if(courseCode.equals(exp[0].getCode())){
                    PAT[i][j]=10;
                }else if(courseCode.equals(exp[1].getCode())){
                    PAT[i][j]=8;
                }else if(courseCode.equals(exp[2].getCode())){
                    PAT[i][j]=6;
                }else if(courseCode.equals(exp[3].getCode())){
                    PAT[i][j]=4;
                }else{
                    PAT[i][j]=2;
                }
            }
        }
        //uncomment to print PAT for testing
        /*
        for (int j=0; j<PAT.length; j++) {
            for(int i=0;i<PAT[0].length;i++){
                System.out.print(PAT[i][j]);
            }
            System.out.println("");
        }
        */
        
        //main allotment loop
        for(int cid=0; cid<clen; cid++){
            while(LAT[cid]>0){
                for(int iid=0; iid<PQ.length; iid++){
                    PQ[iid]=(PAT[iid][cid]/10)*(HAT[iid]/15);
                }
 
                // Sort in descending order
                Arrays.sort(PQ, Collections.reverseOrder());
                
                int x=0;
                //Take each instructor from sorted priority queue and allot
                for(int iid=0; iid<PQ.length; iid++){
                    if(courses[cid].getCourseType().equals("Theory")){
                        for(int k=LAT[cid]; k>0 ;k++){
                            if(HAT[iid]-k>=0){
                                x=k;
                                break;
                            }
                        }
                    }else{
                        if(HAT[iid]-3>=0){
                            x=3;
                        }
                    }
                    if(x>0){
                        CAT[iid][cid]+=x;
                        HAT[iid]-=x;
                        LAT[cid]-=x;
                        break;
                    }
                }
                if(x==0){
                    System.out.println("Time Table generation not possible for given data");
                    System.exit(1);
                }
            }
        }
        
        //return array of periods containing course and instructor
        return CAT;
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
