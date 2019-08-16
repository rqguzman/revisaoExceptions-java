package exercicios.section9.resolvido.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exercicios.section9.resolvido.model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("============ Reservation ============");
		System.out.print("\nEnter room Number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Enter Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Enter Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in Reservation. Check-out date mustn't come before check-in.");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
			System.out.println("\n============ Reservation update ============");

			System.out.print("Enter Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Enter Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();

			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in Reservation. Reservation dates must be future dates.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in Reservation. Check-out date mustn't come before check-in.");
			} else {
				reservation.updateDates(checkIn, checkOut);

			}

		}

		System.out.println("\n########## End. ##########");
		sc.close();
	}

}
