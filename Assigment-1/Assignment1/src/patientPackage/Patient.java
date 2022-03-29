package patientPackage;

import java.util.TreeSet;
import polyclinicSystem.Examination;
import drugPackage.Drug;

public class Patient implements Comparable<Patient> {
	public String name;
	public int ID;
	public int age;
	public String gender;
	public TreeSet<Drug> historyOfDrugs = new TreeSet<Drug>();
	public TreeSet<Drug> newlyPrescribedDrugs = new TreeSet<Drug>();
	public String backgroundIllnesses;
	public TreeSet<Examination> treatmentHistory = new TreeSet<Examination>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Patient(String name, int iD, int age, String gender, TreeSet<Drug> historyOfDrugs,
			TreeSet<Drug> newlyPrescribedDrugs, String backgroundIllnesses, TreeSet<Examination> treatmentHistory) {
		super();
		this.name = name;
		ID = iD;
		this.age = age;
		this.gender = gender;
		this.historyOfDrugs = historyOfDrugs;
		this.newlyPrescribedDrugs = newlyPrescribedDrugs;
		this.backgroundIllnesses = backgroundIllnesses;
		this.treatmentHistory = treatmentHistory;
	}
	
	public String details() {
		return "Patient Name: " + this.getName() + "\n"
				+ "Patient ID: " + this.getID() + "\n"
				+ "Patient Age:	" + this.getAge() + "\n"
				+ "Patient Gender:	" + this.getGender() + "\n"
				+ "History of Drugs: " + this.historyOfDrugs.toString() + "\n"
				+ "Newly Prescribed Drugs: " + this.newlyPrescribedDrugs.toString() + "\n"
				+ "Background Illnesses: " + this.backgroundIllnesses + "\n"
				+ "Treatment History: " + this.treatmentHistory.toString() + "\n";
		
	}
	
	@Override
	public String toString() {
		return getName();
	}
	@Override
	public int compareTo(Patient otherPatient) {
		int comp = 1;
		if(this.getAge() < otherPatient.getAge()) {
			if(getID() != otherPatient.getID()) comp = 1;
		} else if(this.getAge() > otherPatient.getAge()) {
			if(getID() != otherPatient.getID()) comp = -1;
		} else if(this.getAge() == otherPatient.getAge()) {
			if(this.getGender().equals("Female") && otherPatient.getGender().equals("Male")) {
				if(getID() != otherPatient.getID()) comp = 1;
			}
			if(this.getGender().equals("Male") && otherPatient.getGender().equals("Female")) {
				if(getID() != otherPatient.getID()) comp = -1;
			}
		}
		if(getID() == otherPatient.getID()) comp = 0;
		return comp;
	}
	
	
}
