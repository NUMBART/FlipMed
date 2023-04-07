package repositories;

import models.Patient;

public interface PatientRepository {
	Patient get(String patientName);
	void save(Patient patient);
}
