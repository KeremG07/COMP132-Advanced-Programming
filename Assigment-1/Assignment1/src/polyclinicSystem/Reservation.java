package polyclinicSystem;

import doctorPackage.*;
import patientPackage.*;

public class Reservation implements Comparable<Reservation>{
	public Patient p;
	public Doctor d;
	public String hour;
	public String reservationID;
	
	public Reservation(Patient p, Doctor d, String hour) {
		if(!d.schedule.containsKey(hour)) {
			d.schedule.put(hour, p);
			this.p = p;
			this.d = d;
			this.hour = hour;
			String idHour = Character.toString(hour.charAt(0))
					+ Character.toString(hour.charAt(1))
					+ Character.toString(hour.charAt(3))
					+ Character.toString(hour.charAt(4));
			reservationID = "" + p.getID() + d.getClinic().getClinicID() + d.getId() + idHour;
		}
	}

	@Override
	public String toString() {
		return "Patient: " + p.getName() + "   \n"
				+ "Doctor: " + d.getName() + "   \n"
				+ "Appointment Time: " + hour + "   \n";
	}

	@Override
	public int compareTo(Reservation otherRe) {
		int comp = 1;
		comp = reservationID.compareTo(otherRe.reservationID);
		return comp;
	}
	
	
}
