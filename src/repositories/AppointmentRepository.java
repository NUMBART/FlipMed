package repositories;

import models.Appointment;
import models.Doctor;
import models.Patient;
import models.Slot;

import java.util.List;

public interface AppointmentRepository {
	List<Appointment> getForPatient(Patient patient);
	List<Appointment> getForDoctor(Doctor doctor);
	void save(Appointment appointment);
}
