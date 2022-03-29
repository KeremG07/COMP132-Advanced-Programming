package polyclinicSystem;

import doctorPackage.*;
import patientPackage.*;
import drugPackage.*;

public class Examination implements prescribe, Comparable<Examination> {
	public Patient patient;
	public Doctor doctor;
	public String hour;
	public Drug prescribedDrug;
	public String examinationID;
	
	public Examination(Patient patient, Doctor doctor, String hour, Drug prescribedDrug) {
		this.patient = patient;
		this.doctor = doctor;
		this.hour = hour;
		this.prescribedDrug = prescribedDrug;
		String idHour = Character.toString(hour.charAt(0))
				+ Character.toString(hour.charAt(1))
				+ Character.toString(hour.charAt(3))
				+ Character.toString(hour.charAt(4));
		examinationID = "" + patient.getID() + doctor.getId() + doctor.getClinic().getClinicID() + idHour;
		doctor.income += doctor.getVisitingCost()*doctor.getCommission();
		doctor.getClinic().drugProfit += prescribedDrug.getPrice()*doctor.getClinic().getDrugCommPercentage();
		doctor.getClinic().visitProfit += doctor.getVisitingCost()*(1-doctor.getCommission());
		doctor.getClinic().totalProfit += doctor.getVisitingCost()*(1-doctor.getCommission()) + prescribedDrug.getPrice()*doctor.getClinic().getDrugCommPercentage();
	}
	
	@Override
	public void prescribeDrug(Drug d, Patient p) {
		p.newlyPrescribedDrugs.add(d);
		p.historyOfDrugs.add(d);
	}
	
	/**
	 * Calculates the fee for the examination
	 * @param p: Patient
	 * @param d: Doctor
	 * @param drug: Drug
	 * @return calculated fee
	 */
	public double fee(Patient p, Doctor d, Drug drug) {
		return doctor.getVisitingCost() + drug.getPrice();
	}

	@Override
	public String toString() {
		// PRESCRIPTION
		return "Patient Name: " + patient.getName() + "\n" +
				"Doctor: " + doctor.getName() + "\n" +
				"Time of Examination: " + hour + "\n" +
				"Prescribed Drug: " + prescribedDrug.toString() + "\n" +	
				"Examination Fee: " + fee(patient, doctor, prescribedDrug) + "\n";
	}

	@Override
	public int compareTo(Examination otherEx) {
		int comp = 0;
		comp = examinationID.compareTo(otherEx.examinationID);
		return comp;
	}
	
	
}
