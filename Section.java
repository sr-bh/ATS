/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOThreads
 */
public class Section {
    private int year;
    private char section;
    private String labSection;
    private int enrollment;
    
    public Section(int year,char section,String labSection,int enrollment){
        this.year=year;
        this.section=section;
        this.labSection=labSection;
        this.enrollment=enrollment;
    }
}
