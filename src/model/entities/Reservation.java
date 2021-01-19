package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private int roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(int roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duration() {
		//LONG É UM INT MAIOR
		long  diff = checkout.getTime() - checkin.getTime() ;
		//GETTIME() PEGA A DATA EM MILISSEGUNDOS
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				//VAI PEGAR A DATA EM MILISSEGUNDOS E CONVERTER EM DIAS
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Reservation: Room " + roomNumber 
				+ ", check-in: " + sdf.format(checkin) 
				+ ", check-out: " + sdf.format(checkout)
				+ ", " + duration() + " nights";
	}
}
