package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = input.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy):");
            Date checkIn = sdf.parse(input.next());
            System.out.print("Check-out date (dd/MM/yyyy):");
            Date checkOut = sdf.parse(input.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("");
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy):");
            checkIn = sdf.parse(input.next());
            System.out.print("Check-out date (dd/MM/yyyy):");
            checkOut = sdf.parse(input.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        } catch (ParseException e) { //corrige o erro que da do compilaodr com entrada de data.
            System.out.println("Invalid date format");
        } catch (DomainException e) {
            System.out.println(e.getMessage()); // mostrar a menssagem de DomainException
        } catch (RuntimeException e) {//tipo de exeção generico, que serve para qualquer erro inesperado
            System.out.println("Erro");
        }
        input.close();
    }

}
