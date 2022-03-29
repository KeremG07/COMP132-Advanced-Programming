package drugPackage;

import java.util.*;

public class Drug implements Comparable<Drug>{
	public String name;
	public double price;
	public TreeSet<Drug> conflictingDrugs = new TreeSet<Drug>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void addConflictingDrug(Drug d) {
		this.conflictingDrugs.add(d);
	}
	public TreeSet<Drug> getConflictingDrugs() {
		return conflictingDrugs;
	}
	@Override
	public String toString() {
		return name;
	}
	
	public Drug(String name, double price, TreeSet<Drug> conflictingDrugs) {
		super();
		this.name = name;
		this.price = price;
		this.conflictingDrugs = conflictingDrugs;
	}
	
	@Override
	public int compareTo(Drug otherDrug) {
		int comp = 0;
		comp = getName().compareTo(otherDrug.getName());
		return comp;
	}
	
}
