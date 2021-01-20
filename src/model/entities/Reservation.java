package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private int roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(int roomNumber, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {								//PROPAGAR A EXCECAO
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
			//VAI LANCAR UMA INSTANCIACAO DA CLASSE DOMAINEXCEPTION
		}
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
	
	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();							//PROPAGAR A EXCECAO
		//PEGA A DATA E O HORARIO ATUAL
		if (checkin.before(now) || checkout.before(now)) {
		//SE CHECKIN OU CHECKOUT SEREM ANTES(BEFORE) DO NOW = DATA E HORARIO ATUAL
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates") ;
			//VAI LANCAR UMA INSTANCIACAO DA CLASSE DOMAINEXCEPTION
		}
		if (!checkout.after(checkin)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
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
