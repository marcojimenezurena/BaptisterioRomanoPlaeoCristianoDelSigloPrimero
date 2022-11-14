/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.baptisteriopaleocristianodelsigloprimero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author mjimen19
 */
public class TicketMachine {
    private static TicketMachine instance;
    private HashMap<LocalDate,Integer> soldTickets = new HashMap<>();
    private final int maxTicketPerDay = 10;
    private final int ticketPrice = 4;

    private TicketMachine(){
        
    }
    
    public static TicketMachine getInstance(){
        if (instance == null) {
            instance = new TicketMachine();
        }
        return instance;
    }
    
    /*
        Returns true if there are at least one ticket sold for the date specified
    */
    private boolean existTicket(LocalDate date){
        return soldTickets.containsKey(date);
    }

    
    /*
        returns true if the number of tickets you want to buy are less
        or equal the amount of tickets sold in the specified date
    */
    private boolean hasEnoughTickets(LocalDate date, int numTickets){
        boolean hasEnough;
        if(existTicket(date)){
            hasEnough = numTickets <= maxTicketPerDay - soldTickets.get(date);
        }else{
            hasEnough = numTickets <= maxTicketPerDay;
        }
        return hasEnough;
    }
    
    /*
        returns true if the money given is exactly equal to the price of the tickets specified
    */
    private boolean hasEnoughMoney(int money, int numTickets){
        return money == numTickets * ticketPrice;
    }
    
    /*
        given a specified date, amount of money and number of tickets, checks if it can buy
        and in that case, adds tickets sold to the hashmap
    */
    public void buy(LocalDate date, int money, int numTickets) throws IllegalArgumentException{
        
        if(!hasEnoughMoney(money,numTickets)){
            throw new IllegalArgumentException("El dineros me lo das enteroooo, no doi cambiooo morosoooo");
//            System.out.println("EL dineros me lo das enteroooo, no doi cambiooo morosoooo");
        }else if (!hasEnoughTickets(date, numTickets)){
            throw new IllegalArgumentException("Eso son muchoos tikees para tan poco baptisterioooo");
//            System.out.println("Eso son muchoos tikees para tan poco baptisterioooo");
        }else{
            if(!existTicket(date)){
                soldTickets.put(date, numTickets);
            }else{
                int newNumTickets = numTickets + soldTickets.get(date);
                soldTickets.replace(date, newNumTickets);
            }
            System.out.println("Has compraoo " + numTickets + " tikees pa ese diaa");
        }
    }
    
    /*
        return the number of tickets left to sell at a specified date
    */
    public int getAvailableTickets(LocalDate date){
        int numTickets;
        if(!existTicket(date)){
            numTickets = maxTicketPerDay;
        }else{
            numTickets = (maxTicketPerDay - soldTickets.get(date));
        }
        return numTickets;
    }
    
    /*
        return a text with the info of all tickets sold each days
    */
    public String getAllTicketsSold(){
        String text = "";
        
        for(LocalDate date : soldTickets.keySet()){
            text += date + " tikee vendidos ese diaa: " + soldTickets.get(date) + "\n";
        }
        
        return text;
    }
    
}
