package services;

import models.Patient;
import repositories.InMemoryPatientRepository;
import repositories.PatientRepository;

public class PatientService {
	PatientRepository patientRepository;

	public PatientService() {
		this.patientRepository = InMemoryPatientRepository.getInstance();
	}

	public void registerPatient(String patientName) {
		Patient patient = new Patient(patientName);
		patientRepository.save(patient);
		System.out.println("Registered patient: " + patient.toString());
	}
}
