package clinicPackage;

import java.util.TreeSet;
import doctorPackage.*;
import patientPackage.Patient;

public abstract class Clinic implements Comparable<Clinic> {
	public String name;
	public TreeSet<Doctor> doctors = new TreeSet<Doctor>();
	public TreeSet<Patient> patients = new TreeSet<Patient>();
	public double drugCommPercentage;
	public double drugProfit;
	public double visitProfit;
	public double totalProfit;
	public int clinicID;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDrugCommPercentage() {
		return drugCommPercentage;
	}

	public void setDrugCommPercentage(double drugCommPercentage) {
		this.drugCommPercentage = drugCommPercentage;
	}

	public TreeSet<Doctor> getDoctors() {
		return doctors;
	}

	public TreeSet<Patient> getPatients() {
		return patients;
	}
	
	public int getClinicID() {
		return clinicID;
	}
	public double getDrugProfit() {
		return drugProfit;
	}

	public void setDrugProfit(double drugProfit) {
		this.drugProfit = drugProfit;
	}

	public double getVisitProfit() {
		return visitProfit;
	}

	public void setVisitProfit(double visitProfit) {
		this.visitProfit = visitProfit;
	}

	public Clinic(String name, TreeSet<Doctor> doctors, TreeSet<Patient> patients, double drugCommPercentage) {
		this.name = name;
		this.doctors = doctors;
		this.patients = patients;
		this.drugCommPercentage = drugCommPercentage;
	}
	
	/**
	 * Adds doctor to the clinic
	 * @param d: Doctor
	 * @param c: Clinic
	 */
	public abstract void addDoctor(Doctor d, Clinic c);
	/**
	 * Removes doctor from the clinic
	 * @param d: Doctor
	 */
	public abstract void removeDoctor(Doctor d);
	
	/**
	 * Adds patient to the clinics Patient list
	 * @param p: Patient
	 */
	public void addPatient(Patient p) {
		patients.add(p);
	}
	/**
	 * Removes patient to the clinics Patient list
	 * @param p: Patient
	 */
	public void removePatient(Patient p) {
		patients.remove(p);
	}
	
	/**
	 * Displays the patients in the clinic.
	 * @return Patient List of the clinic
	 */
	public String displayPatients() {
		String plist = "";
		for(Patient p : patients) {
			plist = plist + p.getName() + "\n";
		}
		return "Patients in the Clinic: \n" + plist;
	}
	
	/**
	 * Prints schedules of all doctors in the clinic
	 * @return Schedules of all doctors in the clinic
	 */
	public String printSchedules() {
		String slist = "";
		for(Doctor d : doctors) {
			slist = slist + d.getName() + "'s schedule: " + d.schedule.toString() + "\n\n";
		}
		return slist;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
}
