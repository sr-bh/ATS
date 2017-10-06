/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GOThreads
 */
public class Room {
    private String resource;
    private String type;
    private int capacity;
    
    public Room(String resource,String type,int capacity){
        this.resource=resource;
        this.type=type;
        this.capacity=capacity;
    }
}
