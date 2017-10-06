
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOThreads
 */
public class DisplayManager {
    /*
    ATSManager mgr;
    public DisplayManager(ATSManager mgr) {
        this.mgr = mgr;
    }
    */
    public String[] showScreen1(){
        String names[]=new String[5];
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println("***************************************************************");
        System.out.println("\t  WELCOME TO ACADEMIC TIME TABLING SYSTEM.");
        System.out.println("***************************************************************");
        System.out.println("Please enter the names of the .csv files one by one. \n");
        System.out.print("For Rooms       :");
        names[0]=sc.next();
        System.out.print("For Courses     :");
        names[1]=sc.next();
        System.out.print("For Instructors :");
        names[2]=sc.next();
        System.out.print("For Time Slots  :");
        names[3]=sc.next();
        System.out.print("For Sections    :");
        names[4]=sc.next();
        System.out.println("\n***************************************************************");
        System.out.println("Enter Y (yes) to continue.");
        s = sc.next();
        sc.close();
        return names;
    }
    public static void main(String args[]){
        DisplayManager mgr = new DisplayManager();
        String n[]=mgr.showScreen1();
        /*System.out.println("\nNames:"); //This is just to check if code working fine. 
        for(int i=0;i<5;i++)
            System.out.println(n[i]);*/
    }
}
