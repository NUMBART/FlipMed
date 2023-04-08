package repositories;

import models.Appointment;
import models.Doctor;
import models.Patient;
import models.Slot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryAppointmentRepository implements AppointmentRepository {
	HashMap<Long, Appointment> appointment;
	static InMemoryAppointmentRepository instance;

	private InMemoryAppointmentRepository() {
		this.appointment = new HashMap<>();
	}

	public static InMemoryAppointmentRepository getInstance() {
		if(instance == null)
			instance = new InMemoryAppointmentRepository();
		return instance;
	}

	@Override
	public List<Appointment> getForPatient(Patient patient) {
		List<Appointment> appointmentList = new ArrayList<>();
		appointment.forEach((id, appointment) -> {
			if(appointment.getPatient().getName() == patient.getName())
				appointmentList.add(appointment);
		});
		return appointmentList == null ? List.of() : appointmentList;
	}

	@Override
	public List<Appointment> getForDoctor(Doctor doctor) {
		List<Appointment> appointmentList = new ArrayList<>();
		appointment.forEach((id, appointment) -> {
			if(appointment.getSlot().getDoctor().getName() == doctor.getName())
				appointmentList.add(appointment);
		});
		return appointmentList == null ? List.of() : appointmentList;
	}

	@Override
	public void save(Appointment appointmentToBeSaved) {
		appointment.put(appointmentToBeSaved.getId(), appointmentToBeSaved);
	}

	public void delete(Appointment appointment) {

	}
}
