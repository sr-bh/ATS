/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOThreads
 */
public class Timeslot {
    private String day;
    private int slot;
    private int startTime;
    private int endTime;
    
    public Timeslot(String day,int slot,int startTime,int endTime){
        this.day=day;
        this.slot=slot;
        this.startTime=startTime;
        this.endTime=endTime;
    }
    public void printAsString(){
        System.out.println("Day Of Week: "+this.day+" Slot Number: "+this.slot);
        System.out.println("Start time: "+this.startTime+" End Time: "+this.endTime);
        System.out.println("=========================================================");
    }
}
