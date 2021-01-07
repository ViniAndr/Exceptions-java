package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    //usa o static, porque quando a class reservation, for chamada, ela não criar varios simpleDateFormat
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
        if (checkOut.before(checkIn)) {
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getChekIn() {
        return checkIn;
    }

    public void setChekIn(Date chekIn) {
        this.checkIn = chekIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime(); //get.time() pega o valor em mileSegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //o TimeUnit converte para dias os valores em milisegundos.
    }

    public void updateDates(Date checkIn, Date checkOut){
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) { //esse.after(), é pra testar se a data(checkOut) é dps da data(checkIn). tbm tem o Before. 
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
        }
        if (checkOut.before(checkIn)) {
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservation: "
                + "roomNumber= "
                + roomNumber
                + ", checkIn= "
                + sdf.format(checkIn) // ficar com a mascara feita la no SimpleDateFormat.
                + ", checkOut= "
                + sdf.format(checkOut)// ficar com a mascara feita la no SimpleDateFormat.
                + ", "
                + duration()
                + " nights";
    }

}
