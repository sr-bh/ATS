
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
    public static String[] showScreen1(){
        String names[]=new String[5];
        int s;
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
        System.out.println("\nEnter 1 (yes) to continue.");
        System.out.println("Enter 0 (no) to exit from system.");
        System.out.print("\nEnter your choice :");
        s=sc.nextInt();  
        if(s==1){
           DisplayManager.showScreen2();
        }
        else if(s==0) {
            System.exit(0);  //Suggest ways to get rid of System.exit()
        }
        sc.close();
        return names;
    }
    public static void showScreen2(){
        int f;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n********************************************************************************************************************************************************************");
        System.out.println("Please select a filter.");
        System.out.println("Enter 1 to filter by Year. ");
        System.out.println("Enter 2 to filter by Rooms. ");
        System.out.println("Enter 3 to filter by Instructors. \n");
        System.out.print("Enter your filter :");
        f=sc.nextInt();
        switch(f){
            case 1:
                int f1;
                System.out.println("\nSelect year and section.");
                System.out.println("Enter 1 to view time-table of Second Year Section A");
                System.out.println("Enter 2 to view time-table of Second Year Section B");
                System.out.println("Enter 3 to view time-table of Second Year Section C");
                System.out.println("Enter 4 to view time-table of Third Year Section A");
                System.out.println("Enter 5 to view time-table of Third Year Section B");
                System.out.println("Enter 6 to view time-table of Third Year Section C");
                System.out.print("\nEnter your choice :");
                f1=sc.nextInt();
                DisplayManager.showScreen3();          
            break;
            case 2:                               
                DisplayManager.showScreen3();
            break;
            case 3:
                String pn;
                System.out.print("Enter name of instructor whose time-table is to be veiwed :");
                pn=sc.next();                               
                DisplayManager.showScreen3();
            break;
            default:
                System.out.println("Err!!! Please try again");
            System.out.println("\n********************************************************************************************************************************************************************");
        }
    }
    public static void showScreen3(){
        Scanner sc = new Scanner(System.in);
        int f3;
        System.out.println("\n********************************************************************************************************************************************************************");
        System.out.println("________________________________________________________________________________________________________________________________________________");
        System.out.println("| Time      |9:20 - 10:10 |\t10:10 - 11:00\t|11:00 - 11:50\t|11:50 - 12:40\t|12:40 - 13:30\t|13:30 - 14:20\t|14:20 - 15:10\t|15:10 - 16:00 |");
        System.out.println("| Tuesday   |\t1st period|\t 2nd period  \t| 3rd period  \t| 4th period  \t| RECESS      \t| 5th period  \t| 6th period  \t| 7th period   |");
        System.out.println("| Wednesday |\t1st period|\t 2nd period  \t| 3rd period  \t| 4th period  \t| RECESS      \t| 5th period  \t| 6th period  \t| 7th period   |");
        System.out.println("| Thursday  |\t1st period|\t 2nd period  \t| 3rd period  \t| 4th period  \t| RECESS      \t| 5th period  \t| 6th period  \t| 7th period   |");
        System.out.println("| Friday    |\t1st period|\t 2nd period  \t| 3rd period  \t| 4th period  \t| RECESS      \t| 5th period  \t| 6th period  \t| 7th period   |");
        System.out.println("| Saturday  |\t1st period|\t 2nd period  \t| 3rd period  \t| 4th period  \t| RECESS      \t| 5th period  \t| 6th period  \t| 7th period   |");
        System.out.println("________________________________________________________________________________________________________________________________________________");
        System.out.println("\nDo you want to export time-table?");
        System.out.println("Enter 1 (yes) to export.");
        System.out.println("Enter 0 (no) to go to next screen.");
        System.out.print("\nEnter your choice :");
        f3=sc.nextInt();
        if(f3==1){
            System.out.println("\nTime-table exported successfully!!!");
            DisplayManager.showScreen4();
        }
        else if(f3==0) {
            DisplayManager.showScreen4();
        }
        
    }
    public static void showScreen4(){
        System.out.println("\n********************************************************************************************************************************************************************");
        int f4;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDo you wish to continue?");
        System.out.println("Enter 1 (yes) to continue.");
        System.out.println("Enter 0 (no) to exit from system.");
        System.out.print("Enter your choice :");
        f4=sc.nextInt(); 
        if(f4==1){
           DisplayManager.showScreen1();
        }
        else if(f4==0) {
            System.out.println("\nPlease visit us again!!!\n");
            System.exit(0);  //Suggest ways to get rid of System.exit()
        }
        System.out.println("\n********************************************************************************************************************************************************************");
        sc.close();
    }
    public static void main(String args[]){
        DisplayManager mgr = new DisplayManager();
        String n[]=mgr.showScreen1();
        /*System.out.println("\nNames:"); //This is just to check if code working fine. 
        for(int i=0;i<5;i++)
            System.out.println(n[i]);*/
    }
}
