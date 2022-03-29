package doctorPackage;

import java.util.*;
import clinicPackage.Clinic;
import patientPackage.*;

public class Doctor implements Comparable<Doctor>{
	public String name;
	public int id;
	public Clinic clinic;
	public TreeMap<String, Patient> schedule = new TreeMap<String, Patient>();
	public double visitingCost;
	public double commission;
	public double income;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getVisitingCost() {
		return visitingCost;
	}
	public void setVisitingCost(double visitingCost) {
		this.visitingCost = visitingCost;
	}
	public Clinic getClinic() {
		return clinic;
	}
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	public TreeMap<String, Patient> getSchedule() {
		return schedule;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	public Doctor(String name, int id, Clinic clinic, TreeMap<String, Patient> schedule, double visitingCost, double commission) {
		this.name = name;
		this.id = id;
		this.clinic = clinic;
		this.schedule = schedule;
		this.visitingCost = visitingCost;
		this.commission = commission;
	}
	
	@Override
	public int compareTo(Doctor otherDoctor) {
		int comp = 0;
		if(getId() > otherDoctor.getId()) comp = 1;
		if(getId() < otherDoctor.getId()) comp = -1;
		if(getId() == otherDoctor.getId()) comp = 0;
		return comp;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	
}
