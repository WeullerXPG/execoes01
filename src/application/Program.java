package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkin)) {
			//CHECKOUT NÃO É DEPOIS(AFTER) DE CHECKIN
			//TEM O BEFORE(ANTES) TAMBEM
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation room = new Reservation(roomNumber, checkin, checkout);		
			System.out.println(room);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			//PEGA A DATA E O HORARIO ATUAL
			if (checkin.before(now) || checkout.before(now)) {
			//SE CHECKIN OU CHECKOUT SEREM ANTES(BEFORE) DO NOW = DATA E HORARIO ATUAL
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				room.updateDates(checkin, checkout);
				System.out.println(room);
			}
		}
		
		sc.close();
	}

}
