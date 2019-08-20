package exercicios.section9.resolvido.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exercicios.section9.resolvido.model.entities.Reservation;
import exercicios.section9.resolvido.model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("============ Reservation ============");
		try {
			System.out.print("\nEnter room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Enter Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Enter Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());

			System.out.println("\n============ Reservation update ============");
			System.out.print("Enter Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Enter Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Updated reservation: " + reservation.toString());
		} catch (ParseException e) {
			System.out.println("ERROR: Invalid date format.");
		} catch (DomainException e) {
			System.out.println("ERROR in reservation. " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}

		System.out.println("\n########## End. ##########");
		sc.close();
	}

}
