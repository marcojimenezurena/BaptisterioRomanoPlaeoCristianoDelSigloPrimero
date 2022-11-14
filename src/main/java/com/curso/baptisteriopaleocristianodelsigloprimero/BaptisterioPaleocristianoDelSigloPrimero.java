/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.baptisteriopaleocristianodelsigloprimero;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mjimen19
 */
public class BaptisterioPaleocristianoDelSigloPrimero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketMachine ticketMachine = TicketMachine.getInstance();
        String option = "";
        
        System.out.println("De momento está usté servidoo. Vamono pal baptisterioo \n");
        
        while (!option.equals("0")){
            System.out.println("""
                               Escoge una opsión romanaa
                               1) Comprá unoh tikesito pal batisterioh romanooo paleohcristianoo
                               2) Comprobá looh tikees vendidooos
                               3) Cantar la canción de Encarnita, a quién no le va a gustaaah
                               0) Salii del baptistetioooh
                               """);
            
            option = sc.nextLine();
            switch (option){
                case "1" -> optionBuy(sc, ticketMachine);
                case "2" -> optionShowTickets(ticketMachine);
                case "3" -> System.out.println("""
                                Te vengo a desiiiii
                                te vengo a desiiiii
                                oooo mi saaalvadooo
                                que te ammooo yo a tiii
                                que te aaaamooo yo a tiii
                                coon el coraaasooooooon
                                Te vengo a desiiiii
                                te vengo a desiiiii
                                tooooda laaa veerdaaa
                                que te ammooo señiioo
                                que te aaaamooo señioooo
                                coon el coraaasooooooon
                                   """);
                case "0" -> System.out.println("Hasta luegooo, viva andalusiiaaa y viva espaaañiiiiaaaaa!");
            }
            
        }
    }
    
    /*
        Method when you choose to buy tickets from the main menu
    */
    private static void optionBuy(Scanner sc, TicketMachine ticketMachine){
        System.out.println("Pa cuando quiere usté veniiiii");
//        sc.next();
        String dateBuy = sc.nextLine();
        try{
            LocalDate date = LocalDate.parse(dateBuy);
            if(ticketMachine.getAvailableTickets(date) == 0){
                System.out.println("No quedaan tikees a la ventaa para ese diaa, zi zeño");
            }else{
                System.out.println("Tieneee dihponiblee " + ticketMachine.getAvailableTickets(date) + " tikee pa ese diaa, zi zeño");
                System.out.println("Cuantoooo tikee vah a compraaa?");
                try{
                    int numTickets = sc.nextInt();
                    System.out.println("Dame el dineros en efestivoooo, no bisun");
                    int money = sc.nextInt();
                    ticketMachine.buy(date, money, numTickets);
                }catch(InputMismatchException e){
                    System.out.println("esooo no son numerooo");
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                
            }
        }catch(DateTimeParseException e){
            System.out.println("Esooo no e una feeechiaaaa");
        }
        
    }
    
    /*
        Method to show all tickets sold when you choose it from the main menu
    */
    public static void optionShowTickets(TicketMachine ticketMachine){
        System.out.println("--------------------------------");
        System.out.println(ticketMachine.getAllTicketsSold());
        System.out.println("---------------------------------");
    }
}
