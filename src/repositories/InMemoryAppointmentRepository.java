package repositories;

import models.Appointment;
import models.Doctor;
import models.Patient;
import models.Slot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryAppointmentRepository implements AppointmentRepository {
	HashMap<Doctor, List<Appointment>> appointment;
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
		appointment.forEach((doctor, appointments) -> {
			appointments.forEach((entry) -> {
				if(entry.getPatient().getName() == patient.getName())
					appointmentList.add(entry);
			});
		});
		return appointmentList == null ? List.of() : appointmentList;
	}

	@Override
	public List<Appointment> getForDoctor(Doctor doctor) {
		List<Appointment> appointmentList = appointment.get(doctor);
		return appointmentList == null ? List.of() : appointmentList;
	}

	@Override
	public void save(Appointment appointmentToBeSaved) {
		Doctor doctor = appointmentToBeSaved.getSlot().getDoctor();
		Slot slot = appointmentToBeSaved.getSlot();
		Patient patient = appointmentToBeSaved.getPatient();
		List<Appointment> doctorAppointments = this.getForDoctor(doctor);
		List<Appointment> patientAppointments = this.getForPatient(patient);
		patientAppointments.forEach((entry) -> {
			if(Math.abs(entry.getSlot().getStartTimestamp() - appointmentToBeSaved.getSlot().getStartTimestamp()) < 30) {
				System.out.println("You already have an appointment scheduled in that slot");
				return;
			}
		});
		doctorAppointments.forEach((entry) -> {
			if(Math.abs(entry.getSlot().getStartTimestamp() - appointmentToBeSaved.getSlot().getStartTimestamp()) == 0) {
				// waitlist logic
				return;
			}
			else if(Math.abs(entry.getSlot().getStartTimestamp() - appointmentToBeSaved.getSlot().getStartTimestamp()) < 30) {
				System.out.println("You already have an appointment scheduled in that slot");
				return;
			}
		});
		doctorAppointments.add(appointmentToBeSaved);
		this.appointment.put(doctor, doctorAppointments);
	}

	public void delete(Appointment appointment) {

	}
}
