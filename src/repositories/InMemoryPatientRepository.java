package repositories;

import models.Patient;

import java.util.HashMap;

public class InMemoryPatientRepository implements PatientRepository {
	HashMap<String, Patient> patient;
	static InMemoryPatientRepository instance = null;

	public InMemoryPatientRepository() {
		this.patient = new HashMap<>();
	}

	public static InMemoryPatientRepository getInstance() {
		if(instance == null)
			instance = new InMemoryPatientRepository();
		return instance;
	}

	@Override
	public Patient get(String patientName) {
		return patient.get(patientName);
	}

	@Override
	public void save(Patient patient) {
		this.patient.put(patient.getName(), patient);
	}
}
