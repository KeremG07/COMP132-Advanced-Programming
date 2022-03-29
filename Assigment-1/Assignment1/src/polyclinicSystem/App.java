/* *********** Pledge of Honor ************************************************

*

* I hereby certify that I have completed this online lab assignment on my own

* without any help from anyone else. I understand that the only sources of authorized

* information in this online lab assignment are (1) the course textbook, (2) the

* materials  posted at the course website and (3) any study notes handwritten by myself.

*

* I have not used, accessed or received any information from any other unauthorized

* source in taking this online lab assignment. The effort in the assignment thus belongs

* completely to me.

*

*  READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID

*  SIGNATURE:   <Kerem GIRENES,    0069671>

* 

********************************************************************************/

package polyclinicSystem;

import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clinicPackage.*;
import doctorPackage.Doctor;
import drugPackage.Drug;
import patientPackage.Patient;

public class App extends JFrame {
	// GENERATE CLINICS
	Opthalmology ophthalmology = new Opthalmology("Ophthalmology", new TreeSet<Doctor>(), new TreeSet<Patient>(), 0.08);
	Orthopedics orthopedics = new Orthopedics("Orthopedics", new TreeSet<Doctor>(), new TreeSet<Patient>(), 0.12);
	Psychiatry psychiatry = new Psychiatry("Psychiatry", new TreeSet<Doctor>(), new TreeSet<Patient>(), 0.16);
	Urology urology = new Urology("Urology", new TreeSet<Doctor>(), new TreeSet<Patient>(), 0.04);
	
	// GENERATE DOCTORS
	public TreeSet<Doctor> allDoctors = new TreeSet<Doctor>();
	Doctor sethGrayson = new Doctor("Seth Grayson", 101, ophthalmology, new TreeMap<String, Patient>(), 250.0, 0.60);
	Doctor jackieSharp = new Doctor("Jackie Sharp", 102, ophthalmology, new TreeMap<String, Patient>(), 300.0, 0.50);
	Doctor remyDanton = new Doctor("Remy Danton", 103, ophthalmology, new TreeMap<String, Patient>(), 400.0, 0.80);
	
	Doctor kateBaldwin = new Doctor("Kate Baldwin", 104, orthopedics, new TreeMap<String, Patient>(), 200.0, 0.80);
	Doctor edwardMeechum = new Doctor("Edward Meechum", 105, orthopedics, new TreeMap<String, Patient>(), 250.0, 0.85);
	
	Doctor dougStamper = new Doctor("Doug Stamper", 106, psychiatry, new TreeMap<String, Patient>(), 300.0, 0.70);
	
	Doctor raymondTusk = new Doctor("Raymond Tusk", 107, urology, new TreeMap<String, Patient>(), 500.0, 0.80);
	Doctor janeDavis = new Doctor("Jane Davis", 108, urology, new TreeMap<String, Patient>(), 400.0, 0.90);
	Doctor willConway = new Doctor("Will Conway", 109, urology, new TreeMap<String, Patient>(), 300.0, 0.65);
	Doctor garrettWalker = new Doctor("Garrett Walker", 110, urology, new TreeMap<String, Patient>(), 250.0, 0.90);
	Doctor leannHarvey = new Doctor("LeAnn Harvey", 111, urology, new TreeMap<String, Patient>(), 200.0, 0.85);
	
	// GENERATE PATIENTS
	public TreeSet<Patient> allPatients = new TreeSet<Patient>();
	Patient michaelScott = new Patient("Michael Scott", 12345, 44, "Male", new TreeSet<Drug>(), new TreeSet<Drug>(), "Chest Cold, Common Cold", new TreeSet<Examination>());
	Patient pamBeesly = new Patient("Pam Beesly", 23254, 27, "Female", new TreeSet<Drug>(), new TreeSet<Drug>(), "Ear Infection, Sore Throat", new TreeSet<Examination>());
	Patient jimHalpert = new Patient("Jim Halpert", 44537, 33, "Male", new TreeSet<Drug>(), new TreeSet<Drug>(), "Sinus Infection", new TreeSet<Examination>());
	
	// RESERVATIONS SET
	public TreeSet<Reservation> allReservations = new TreeSet<Reservation>();
	
	// GENERATE DRUGS
	public TreeSet<Drug> allDrugs = new TreeSet<Drug>();
	Drug dipyrone = new Drug("Dipyrone", 18.50, new TreeSet<Drug>());
	Drug morphine = new Drug("Morphine", 7.50, new TreeSet<Drug>());
	Drug fentanyl = new Drug("Fentanyl", 30.00, new TreeSet<Drug>());
	Drug haloperidol = new Drug("Haloperidol", 22.50, new TreeSet<Drug>());
	Drug dexamethasone = new Drug("Dexamethasone", 41.00, new TreeSet<Drug>());
	Drug metoclopramide = new Drug("Metoclopramide", 55.00, new TreeSet<Drug>());
	Drug pantoprazol = new Drug("Pantoprazol", 17.50, new TreeSet<Drug>());
	Drug macrogol = new Drug("Macrogol", 31.50, new TreeSet<Drug>());
	Drug furosemide = new Drug("Furosemide", 5.50, new TreeSet<Drug>());
	Drug omeprazole = new Drug("Omeprazole", 12.00, new TreeSet<Drug>());
	
	
	// GUI BLOCKS
	public JPanel centerPanel;
	public JScrollPane scroll;
	public JTextArea brief;
	public JPanel westPanel;
	public JButton addNewPatient;
	public JButton makeReservationButton;
	public JButton examinePatientButton;
	public JButton viewPatientRecordsButton;
	public JButton displayPatientsInClinic;
	public JButton profitOfAClinic;
	public JButton incomeOfADoctor;
	public JButton printSchedulesButton;
	
	// CONSTRUCTOR
	public App() {
		
		super("KU Health App");
		addNewPatient = new JButton("Add New Patient");
		makeReservationButton = new JButton("Make Reservation");
		examinePatientButton = new JButton("Examine Patient");
		viewPatientRecordsButton = new JButton("View Patient Records");
		displayPatientsInClinic = new JButton("Display Patients in Clinic");
		profitOfAClinic = new JButton("Show Profit of Clinic");
		incomeOfADoctor = new JButton("Income of a Doctor");
		printSchedulesButton= new JButton("Print Schedules");
		
		westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(8, 1));
		westPanel.add(addNewPatient);
		westPanel.add(makeReservationButton);
		westPanel.add(examinePatientButton);
		westPanel.add(viewPatientRecordsButton);
		westPanel.add(displayPatientsInClinic);
		westPanel.add(profitOfAClinic);
		westPanel.add(incomeOfADoctor);
		westPanel.add(printSchedulesButton);

		
		// ADD DOCTORS TO CLINICS
		ophthalmology.addDoctor(sethGrayson, ophthalmology);
		ophthalmology.addDoctor(jackieSharp, ophthalmology);
		ophthalmology.addDoctor(remyDanton, ophthalmology);
		orthopedics.addDoctor(kateBaldwin, orthopedics);
		orthopedics.addDoctor(edwardMeechum, orthopedics);
		psychiatry.addDoctor(dougStamper, psychiatry);
		urology.addDoctor(raymondTusk, urology);
		urology.addDoctor(janeDavis, urology);
		urology.addDoctor(willConway, urology);
		urology.addDoctor(garrettWalker, urology);
		urology.addDoctor(leannHarvey, urology);
		
		allDoctors.add(sethGrayson);
		allDoctors.add(jackieSharp);
		allDoctors.add(remyDanton);
		allDoctors.add(kateBaldwin);
		allDoctors.add(edwardMeechum);
		allDoctors.add(dougStamper);
		allDoctors.add(raymondTusk);
		allDoctors.add(janeDavis);
		allDoctors.add(willConway);
		allDoctors.add(garrettWalker);
		allDoctors.add(leannHarvey);


		// PATIENTS HARD_CODED STUFF
		allPatients.add(michaelScott);
		allPatients.add(pamBeesly);
		allPatients.add(jimHalpert);
		michaelScott.historyOfDrugs.add(dipyrone);
		michaelScott.historyOfDrugs.add(fentanyl);
		michaelScott.historyOfDrugs.add(macrogol);
		pamBeesly.historyOfDrugs.add(omeprazole);
		pamBeesly.historyOfDrugs.add(furosemide);
		pamBeesly.historyOfDrugs.add(haloperidol);
		jimHalpert.historyOfDrugs.add(morphine);
		jimHalpert.historyOfDrugs.add(dexamethasone);
		jimHalpert.historyOfDrugs.add(metoclopramide);
		
		ophthalmology.addPatient(michaelScott);
		ophthalmology.addPatient(jimHalpert);
		orthopedics.addPatient(michaelScott);
		orthopedics.addPatient(pamBeesly);
		psychiatry.addPatient(michaelScott);
		urology.addPatient(jimHalpert);
		urology.addPatient(pamBeesly);
		
		// ADD DRUGS TO SET AND SET CONFLICTING DRUGS
		allDrugs.add(dipyrone);
		allDrugs.add(morphine);
		allDrugs.add(fentanyl);
		allDrugs.add(haloperidol);
		allDrugs.add(dexamethasone);
		allDrugs.add(metoclopramide);
		allDrugs.add(pantoprazol);
		allDrugs.add(macrogol);
		allDrugs.add(furosemide);
		allDrugs.add(omeprazole);

		dipyrone.addConflictingDrug(haloperidol);
		haloperidol.addConflictingDrug(dipyrone);
		dipyrone.addConflictingDrug(pantoprazol);
		pantoprazol.addConflictingDrug(dipyrone);
		morphine.addConflictingDrug(dexamethasone);
		dexamethasone.addConflictingDrug(morphine);
		morphine.addConflictingDrug(metoclopramide);
		metoclopramide.addConflictingDrug(morphine);
		fentanyl.addConflictingDrug(furosemide);
		furosemide.addConflictingDrug(fentanyl);
		fentanyl.addConflictingDrug(haloperidol);
		haloperidol.addConflictingDrug(fentanyl);
		haloperidol.addConflictingDrug(macrogol);
		macrogol.addConflictingDrug(haloperidol);
		haloperidol.addConflictingDrug(furosemide);
		furosemide.addConflictingDrug(haloperidol);
		dexamethasone.addConflictingDrug(omeprazole);
		omeprazole.addConflictingDrug(dexamethasone);
		dexamethasone.addConflictingDrug(pantoprazol);
		pantoprazol.addConflictingDrug(dexamethasone);

		setLayout(new BorderLayout());
		setSize(800, 500);;
		
		brief = new JTextArea();
		brief.setEditable(false);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		scroll = new JScrollPane(brief);
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		centerPanel.add(scroll, BorderLayout.CENTER);
		add(centerPanel, BorderLayout.CENTER);
		add(westPanel, BorderLayout.WEST);
		
		brief.append("Welcome to KU Clinic App. \n\n");
		
		// ADD NEW PATIENT
		addNewPatient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Patient p = new Patient("", 99999, 22, "Male", new TreeSet<Drug>(), new TreeSet<Drug>(), "", new TreeSet<Examination>());
				JFrame anp = new JFrame("Add New Patient");
				JTextArea nameTA = new JTextArea("Patient Name");
				nameTA.setEditable(false);
				JTextField nameTF = new JTextField();
				JTextArea idTA = new JTextArea("Patient ID (10000-99999)");
				idTA.setEditable(false);
				JTextField idTF = new JTextField();
				JTextArea ageTA = new JTextArea("Patient Age");
				ageTA.setEditable(false);
				JTextField ageTF = new JTextField();
				JTextArea genderTA = new JTextArea("Patient Gender");
				genderTA.setEditable(false);
				JComboBox<String> genderCB = new JComboBox<String>();
				genderCB.addItem("Male");
				genderCB.addItem("Female");
				
				// HISTORY OF DRUGS
				JTextArea hodTA = new JTextArea("History of Drugs");
				hodTA.setEditable(false);
				JCheckBox dipyroneBox = new JCheckBox("Dipyrone", false);
				JCheckBox morphineBox = new JCheckBox("Morphine", false);
				JCheckBox fentanylBox = new JCheckBox("Fentanyl", false);
				JCheckBox haloperidolBox = new JCheckBox("Haloperidol", false);
				JCheckBox dexamethasoneBox = new JCheckBox("Dexamethasone", false);
				JCheckBox metoclopramideBox = new JCheckBox("Metoclopramide", false);
				JCheckBox pantoprazolBox = new JCheckBox("Pantoprazol", false);
				JCheckBox macrogolBox = new JCheckBox("Macrogol", false);
				JCheckBox furosemideBox = new JCheckBox("Furosemide", false);
				JCheckBox omeprazoleBox = new JCheckBox("Omeprazole", false);
				
				JTextArea biTA = new JTextArea("Background Illnesses");
				biTA.setEditable(false);
				JTextField biTF = new JTextField();
				
				JButton addnew = new JButton("Add New Patient");
				
				anp.setSize(400,500);
				anp.setLayout(new BorderLayout());
				
				JPanel anpwest = new JPanel();
				anpwest.setLayout(new BoxLayout(anpwest, BoxLayout.Y_AXIS));
				
				anpwest.add(nameTA);
				anpwest.add(nameTF);
				anpwest.add(idTA);
				anpwest.add(idTF);
				anpwest.add(ageTA);
				anpwest.add(ageTF);
				anpwest.add(genderTA);
				anpwest.add(genderCB);
				anpwest.add(hodTA);
				anpwest.add(dipyroneBox);
				anpwest.add(morphineBox);
				anpwest.add(fentanylBox);
				anpwest.add(haloperidolBox);
				anpwest.add(dexamethasoneBox);
				anpwest.add(metoclopramideBox);
				anpwest.add(pantoprazolBox);
				anpwest.add(macrogolBox);
				anpwest.add(furosemideBox);
				anpwest.add(omeprazoleBox);
				anpwest.add(biTA);
				anpwest.add(biTF);
				anp.add(anpwest, BorderLayout.CENTER);
				anp.add(addnew, BorderLayout.EAST);
				
				anp.setVisible(true);
				
				addnew.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						boolean eligible = true;
						
						p.setName(nameTF.getText());
						
						// This checks if id is between borders and if it is in use
						int tempid = Integer.parseInt(idTF.getText());
						if (tempid <= 99999 && tempid >= 10000) {
							for(Patient tp : allPatients) {
								if(tp.getID() == tempid) {
									eligible = false;
									break;
								} else {
									p.setID(tempid);
								}
							}
						} else {
							eligible = false;
						}
						
						// This checks if input is a reasonable age
						int tempage = (Integer.parseInt(ageTF.getText()));
						if(tempage <= 120 && tempage >= 0) {
							p.setAge(tempage);
						} else {
							eligible = false;
						}
						
						p.setGender((String) genderCB.getSelectedItem());
						
						if(dipyroneBox.isSelected()) p.historyOfDrugs.add(dipyrone);
						if(morphineBox.isSelected()) p.historyOfDrugs.add(morphine);
						if(fentanylBox.isSelected()) p.historyOfDrugs.add(fentanyl);
						if(haloperidolBox.isSelected()) p.historyOfDrugs.add(haloperidol);
						if(dexamethasoneBox.isSelected()) p.historyOfDrugs.add(dexamethasone);
						if(metoclopramideBox.isSelected()) p.historyOfDrugs.add(metoclopramide);
						if(pantoprazolBox.isSelected()) p.historyOfDrugs.add(pantoprazol);
						if(macrogolBox.isSelected()) p.historyOfDrugs.add(macrogol);
						if(furosemideBox.isSelected()) p.historyOfDrugs.add(furosemide);
						if(omeprazoleBox.isSelected()) p.historyOfDrugs.add(omeprazole);
						
						p.backgroundIllnesses = biTF.getText();
						
						if(eligible) {
							allPatients.add(p);
							brief.append(p.getName() + " was successfully added to the records. \n\n");
							anp.dispose();
						} else {
							anp.dispose();
							
							brief.append("Some inputs were not eligible.\n"
									+ "Patient Record Terminated.\n\n");
						}
					}
				});
				}
			
		} );
		
		// MAKE RESERVATION
		makeReservationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TreeSet<String> hourSet = new TreeSet<String>();
				hourSet.add("09:00");
				hourSet.add("09:30");
				hourSet.add("10:00");
				hourSet.add("10:30");
				hourSet.add("11:00");
				hourSet.add("11:30");
				hourSet.add("13:30");
				hourSet.add("14:00");
				hourSet.add("14:30");
				hourSet.add("15:00");
				hourSet.add("15:30");
				hourSet.add("16:00");
				hourSet.add("16:30");
				
				JFrame reservationFrame = new JFrame("Reservation System");
				JComboBox<Patient> patientsBox = new JComboBox<Patient>();
				for(Patient patient : allPatients) {
					patientsBox.addItem(patient);
				}
				JComboBox<Clinic> clinicsBox = new JComboBox<Clinic>();
				clinicsBox.addItem(ophthalmology);
				clinicsBox.addItem(orthopedics);
				clinicsBox.addItem(psychiatry);
				clinicsBox.addItem(urology);
				JComboBox<String> hourBox = new JComboBox<String>();
				for(String hour : hourSet) {
					hourBox.addItem(hour);
				}
				JButton reserve = new JButton("Make Reservation");
				
				reservationFrame.setSize(800, 500);
				reservationFrame.setLayout(new BorderLayout());
				
				JPanel rPanel = new JPanel();
				rPanel.setLayout(new BoxLayout(rPanel, BoxLayout.Y_AXIS));
				
				rPanel.add(patientsBox);
				rPanel.add(clinicsBox);
				rPanel.add(hourBox);
				rPanel.add(reserve);
				reservationFrame.add(rPanel, BorderLayout.CENTER);

				
				reservationFrame.setVisible(true);
				
				reserve.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Patient p = ((Patient) patientsBox.getSelectedItem());
						Clinic c = ((Clinic) clinicsBox.getSelectedItem());
						String h = ((String) hourBox.getSelectedItem());
						Doctor d = null;
						
						boolean available = false;
						for(Doctor tempd : c.doctors) {
							if(!tempd.schedule.containsKey(h)) {
								available = true;
								d = tempd;
								break;
							}
						}
						if(available) {
							Reservation r = new Reservation(p, d, h);
							allReservations.add(r);
							brief.append("Reservation Successful. \n"
									+ "Reservation Details: \n"
									+ r.toString() + "\n\n");
						} else {
							brief.append("Reservation Unsuccessful. \n"
									+ "No Doctors available in the clinic. \n\n");
						}
						reservationFrame.dispose();
					}
				});
			}			
		} );
		
		// EXAMINE PATIENT
		examinePatientButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame examinationFrame = new JFrame("Examination System");
				JTextArea resHeader = new JTextArea("Select a reservation from the box below.");
				resHeader.setEditable(false);
				JComboBox<Reservation> reservationsBox = new JComboBox<Reservation>();
				for(Reservation r : allReservations) {
					reservationsBox.addItem(r);
				}
				JButton examButton = new JButton("Perform Examination");
				
				examinationFrame.setSize(600, 120);
				examinationFrame.setLayout(new BorderLayout());				
				
				JPanel ePanel = new JPanel();
				ePanel.setLayout(new BoxLayout(ePanel, BoxLayout.Y_AXIS));
				
				ePanel.add(resHeader);
				ePanel.add(reservationsBox);
				ePanel.add(examButton);
				examinationFrame.add(ePanel, BorderLayout.CENTER);
				
				examinationFrame.setVisible(true);
				
				examButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Reservation cr = ((Reservation) reservationsBox.getSelectedItem());
						JFrame drugFrame = new JFrame("Select Drug to be Prescribed");
						JComboBox<Drug> drugsBox = new JComboBox<Drug>();
						for(Drug d : allDrugs) {
							drugsBox.addItem(d);
						}
						JButton prescribeButton = new JButton("Prescribe Drug");
						
						drugFrame.setSize(300, 200);
						drugFrame.setLayout(new BorderLayout());
						
						JPanel drugPanel = new JPanel();
						drugPanel.setLayout(new BoxLayout(drugPanel, BoxLayout.Y_AXIS));
						
						drugPanel.add(drugsBox);
						drugPanel.add(prescribeButton);
						drugFrame.add(drugPanel, BorderLayout.CENTER);
						
						drugFrame.setVisible(true);
						
						prescribeButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								Drug prescribedDrug = ((Drug) drugsBox.getSelectedItem());
								
								// This checks if the Prescribed Drug conflicts a drug in patient's history
								boolean conflicts = false;
								for(Drug hod : cr.p.historyOfDrugs) {
									for(Drug cd : prescribedDrug.conflictingDrugs) {
										if(hod == cd) conflicts = true;
									}
								}
								if(conflicts) {
									drugFrame.dispose();
									examinationFrame.dispose();
									
									brief.append("Conflicting Drug Prescribed.\n"
											+ "Examination Terminated.\n\n");
								} else {
								Examination e = new Examination(cr.p, cr.d, cr.hour, prescribedDrug);
								e.prescribeDrug(prescribedDrug, cr.p);
								cr.p.treatmentHistory.add(e);
								cr.d.getClinic().addPatient(cr.p);
								allReservations.remove(cr);
								
								JFrame prescriptionFrame = new JFrame("Prescription");
								JTextArea ask = new JTextArea("Generate Prescription for the Patient?");
								JButton yes = new JButton("Yes");
								JButton no = new JButton("No");
								
								prescriptionFrame.setSize(300, 200);
								prescriptionFrame.setLayout(new BorderLayout());
								
								JPanel presPanel = new JPanel();
								presPanel.setLayout(new BoxLayout(presPanel, BoxLayout.Y_AXIS));
								
								presPanel.add(ask);
								presPanel.add(yes);
								presPanel.add(no);
								prescriptionFrame.add(presPanel, BorderLayout.CENTER);
								
								prescriptionFrame.setVisible(true);
								
								yes.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent arg0) {
										brief.append("Examination Performed. \n");
										brief.append(e.toString());
										prescriptionFrame.dispose();
										drugFrame.dispose();
										examinationFrame.dispose();
										brief.append("\n\n");
									}
								} );
								no.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent arg0) {
										brief.append("Examination Performed. \n"
												+ "No Prescription Given. \n\n\n");
										prescriptionFrame.dispose();
										drugFrame.dispose();
										examinationFrame.dispose();
									}
								} );
								}
							}
						} );
						
					}
				} );
				
			}			
		} );
		
		// VIEW PATIENT RECORDS
		viewPatientRecordsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame records = new JFrame("Patients Database");
				JComboBox<Patient> patientsBox = new JComboBox<Patient>();
				for(Patient patient : allPatients) {
					patientsBox.addItem(patient);
				}
				JButton viewButton = new JButton("View Patient Records");
				
				records.setSize(500, 500);
				records.setLayout(new BorderLayout());
				
				JPanel recPanel = new JPanel();
				recPanel.setLayout(new BoxLayout(recPanel, BoxLayout.Y_AXIS));
				
				recPanel.add(patientsBox);
				recPanel.add(viewButton);
				records.add(recPanel, BorderLayout.CENTER);
				
				records.setVisible(true);
				
				viewButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						brief.append(((Patient) patientsBox.getSelectedItem()).details() + "\n\n");
						records.dispose();
					}
				});
			}			
		} );
		
		// DISPLAY PATIENTS IN A CLINIC
		displayPatientsInClinic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame display = new JFrame("Select A Clinic");
				JComboBox<Clinic> clinicsBox = new JComboBox<Clinic>();
				clinicsBox.addItem(ophthalmology);
				clinicsBox.addItem(orthopedics);
				clinicsBox.addItem(psychiatry);
				clinicsBox.addItem(urology);
				JButton confirm = new JButton("Select Clinic");
				
				display.setSize(400, 300);
				display.setLayout(new BorderLayout());
				
				JPanel patPanel = new JPanel();
				patPanel.setLayout(new BoxLayout(patPanel, BoxLayout.Y_AXIS));
				
				patPanel.add(clinicsBox);
				patPanel.add(confirm);
				display.add(patPanel, BorderLayout.CENTER);
				
				display.setVisible(true);
				
				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Clinic c = ((Clinic) clinicsBox.getSelectedItem());
						brief.append(c.displayPatients() + "\n\n");
						display.dispose();
					}
				});
			}
		} );
		
		// PROFIT OF A CLINIC
		profitOfAClinic.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame display = new JFrame("Select A Clinic");
				JComboBox<Clinic> clinicsBox = new JComboBox<Clinic>();
				clinicsBox.addItem(ophthalmology);
				clinicsBox.addItem(orthopedics);
				clinicsBox.addItem(psychiatry);
				clinicsBox.addItem(urology);
				JButton confirm = new JButton("Select Clinic");
				
				display.setSize(400, 300);
				display.setLayout(new BorderLayout());
				
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				
				panel.add(clinicsBox);
				panel.add(confirm);
				display.add(panel, BorderLayout.CENTER);
				
				display.setVisible(true);
				
				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Clinic c = ((Clinic) clinicsBox.getSelectedItem());
						brief.append("Total Profit Of The Selected Clinic: " + c.totalProfit + "\n"
								+ "Visit Profit Of The Selected Clinic: " + c.visitProfit + "\n"
								+ "Drug Profit Of The Selected Clinic: " + c.drugProfit + "\n\n");
						display.dispose();
					}
				});
			}
		} );
		
		// INCOME OF A DOCTOR
		incomeOfADoctor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame display = new JFrame("Select A Doctor");
				JComboBox<Doctor> doctorsBox = new JComboBox<Doctor>();
				for (Doctor d : allDoctors) {
					doctorsBox.addItem(d);
				}
				JButton confirm = new JButton("Select Doctor");
				
				display.setSize(400, 300);
				display.setLayout(new BorderLayout());
				
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				
				panel.add(doctorsBox);
				panel.add(confirm);
				display.add(panel, BorderLayout.CENTER);
				
				display.setVisible(true);
				
				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Doctor d = ((Doctor) doctorsBox.getSelectedItem());
						brief.append("Income Of The Selected Doctor: " + d.income + "\n\n");
						display.dispose();
					}
				});
			}
		} );
		
		printSchedulesButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame display = new JFrame("Select A Clinic");
				JComboBox<Clinic> clinicsBox = new JComboBox<Clinic>();
				clinicsBox.addItem(ophthalmology);
				clinicsBox.addItem(orthopedics);
				clinicsBox.addItem(psychiatry);
				clinicsBox.addItem(urology);
				JButton confirm = new JButton("Select Clinic");
				
				display.setSize(400, 300);
				display.setLayout(new BorderLayout());
				
				JPanel patPanel = new JPanel();
				patPanel.setLayout(new BoxLayout(patPanel, BoxLayout.Y_AXIS));
				
				patPanel.add(clinicsBox);
				patPanel.add(confirm);
				display.add(patPanel, BorderLayout.CENTER);
				
				display.setVisible(true);
				
				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Clinic c = ((Clinic) clinicsBox.getSelectedItem());
						brief.append(c.printSchedules() + "\n\n");
						display.dispose();
					}
				});
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		App KuHealthApp = new App();
		
		KuHealthApp.setVisible(true);
		KuHealthApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
