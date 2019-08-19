package exercicios.section9.resolvido.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	// GETTERS AND SETTERS
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// OTHER METHODS
	public long duration() {
		// obtendo a diferença entre as datas, convertendo-as em milissegundos(daí a
		// escolha pelo tipo 'long')
		long diff = this.checkOut.getTime() - this.checkIn.getTime();
		// Macete
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {

		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates must be future dates.";
		}
		
		if (!checkOut.after(checkIn)) {
			return "Check-out date mustn't come before check-in.";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Room " + this.roomNumber);
		sb.append(", checkIn: " + sdf.format(getCheckIn()));
		sb.append(", checkOut: " + sdf.format(getCheckOut()));
		sb.append(", " + duration() + " nights.");
		return sb.toString();
	}

}
