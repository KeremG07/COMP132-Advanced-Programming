package clinicPackage;

import java.util.TreeSet;
import doctorPackage.Doctor;
import patientPackage.Patient;

public class Opthalmology extends Clinic {
	
	@Override
	public void addDoctor(Doctor d, Clinic c) {
		if(doctors.size() < 5) {
			doctors.add(d);
			d.setClinic(c);
		} else {
			System.out.println("No more doctors can be added to this clinic.");
		}
	}
	@Override
	public void removeDoctor(Doctor d) {
		if(doctors.size() > 0) {
			doctors.remove(d);
			d.setClinic(null);
		} else {
			System.out.println("No doctors exist in this clinic.");
		}
	}
	
	// Constructor
	public Opthalmology(String name, TreeSet<Doctor> doctors, TreeSet<Patient> patients, double drugCommPercentage) {
		super(name, doctors, patients, drugCommPercentage);
		clinicID = 01;
	}
	
	@Override
	public int compareTo(Clinic otherClinic) {
		int comp = 0;
		if(getClinicID() < otherClinic.getClinicID()) comp = -1;
		if(getClinicID() > otherClinic.getClinicID()) comp = 1;
		if(getClinicID() == otherClinic.getClinicID()) comp = 0;
		return comp;
	}	
}
