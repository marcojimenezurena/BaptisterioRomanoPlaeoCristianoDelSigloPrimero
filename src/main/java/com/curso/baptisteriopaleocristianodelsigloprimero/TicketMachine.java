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
    private static HashMap<LocalDate,Integer> soldTickets = new HashMap<>();
    private static final int maxTicketPerDay = 10;
    private static final int ticketPrice = 4;

    private static boolean existTicket(LocalDate date){
        return soldTickets.containsKey(date);
    }

    
    private static boolean hasEnoughTickets(LocalDate date, int numTickets){
        boolean hasEnough = false;
        if(existTicket(date)){
            hasEnough = numTickets <= maxTicketPerDay - soldTickets.get(date);
        }else{
            hasEnough = numTickets <= maxTicketPerDay;
        }
        return hasEnough;
    }
    
    private static boolean hasEnoughMoney(int money, int numTickets){
        return money == numTickets * ticketPrice;
    }
    
    public static void buy(LocalDate date, int money, int numTickets){
        
        if(!hasEnoughMoney(money,numTickets)){
            System.out.println("EL dineros me lo das enteroooo, no doi cambiooo morosoooo");
        }else if (!hasEnoughTickets(date, numTickets)){
            System.out.println("Eso son muchoos tikees para tan poco baptisterioooo");
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
    
    public static int getAvailableTickets(LocalDate date){
        int numTickets;
        if(!existTicket(date)){
            numTickets = maxTicketPerDay;
        }else{
            numTickets = (maxTicketPerDay - soldTickets.get(date));
        }
        return numTickets;
    }
    
    public static String getAllTicketsSold(){
        String text = "";
        
        for(LocalDate date : soldTickets.keySet()){
            text += date + " tikee vendidos ese diaa: " + soldTickets.get(date) + "\n";
        }
        
        return text;
    }
    
}
