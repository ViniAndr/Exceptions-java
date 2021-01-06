package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = input.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy):");
        Date checkIn = sdf.parse(input.next());
        System.out.println("Check-out date (dd/MM/yyyy):");
        Date checkOut = sdf.parse(input.next());

        if (!checkOut.after(checkIn)) { //esse.after(), é pra testar se a data(checkOut) é dps da data(checkIn). tbm tem o Before. 
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println("");
            System.out.print("Enter data to update the reservation:");
            System.out.println("Check-in date (dd/MM/yyyy):");
            checkIn = sdf.parse(input.next());
            System.out.println("Check-out date (dd/MM/yyyy):");
            checkOut = sdf.parse(input.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println(error);
            } else {
                System.out.println(reservation);
            }
        }
        input.close();
    }

}
