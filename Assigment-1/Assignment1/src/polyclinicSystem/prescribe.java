package polyclinicSystem;

import drugPackage.Drug;
import patientPackage.Patient;

public interface prescribe {
	/**
	 * Prescribe Drug to the specified patient
	 * @param d: Drug
	 * @param p: Patient
	 */
	void prescribeDrug(Drug d, Patient p);
}
