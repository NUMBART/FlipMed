package services;

import models.Appointment;
import models.Doctor;
import models.Patient;
import models.Slot;
import repositories.AppointmentRepository;
import repositories.InMemoryAppointmentRepository;

import java.util.List;

public class AppointmentService {
	AppointmentRepository appointmentRepository;
	SlotService slotService;

	public AppointmentService() {
		appointmentRepository = InMemoryAppointmentRepository.getInstance();
		slotService = new SlotService();
	}

	public Appointment book(Appointment appointmentToBeSaved) {
		Doctor doctor = appointmentToBeSaved.getSlot().getDoctor();
		Slot slot = appointmentToBeSaved.getSlot();
		Patient patient = appointmentToBeSaved.getPatient();
		List<Slot> doctorSlots = slotService.getSlotsForDoctor(doctor);
		List<Appointment> doctorAppointments = appointmentRepository.getForDoctor(doctor);
		List<Appointment> patientAppointments = appointmentRepository.getForPatient(patient);
		boolean isValidSlot = false;
		for(Slot doctorSlot: doctorSlots) {
			if(slot.getStartTimestamp() == doctorSlot.getStartTimestamp())
				isValidSlot = true;
		}
		if(!isValidSlot) {
			System.out.println("Slot not available for doctor " + doctor.getName());
			return null;
		}

		for (Appointment entry : patientAppointments) {
			if (Math.abs(entry.getSlot().getStartTimestamp() - appointmentToBeSaved.getSlot().getStartTimestamp()) < 30) {
				System.out.println("You already have an appointment scheduled during that time");
				return null;
			}
		}

		for(int i = 0; i < doctorAppointments.size(); ++i) {
			Appointment appointment =  doctorAppointments.get(i);
			if(appointment.getSlot().getStartTimestamp() == appointmentToBeSaved.getSlot().getStartTimestamp()) {
				appointment.addToWaitlist(patient);
				System.out.println("You have been added to waitlist for the slot.");
				appointmentRepository.save(appointment);
				return appointment;
			}
		}
		appointmentRepository.save(appointmentToBeSaved);
		return appointmentToBeSaved;
	}

	public void cancel(long appointmentId) {

	}


}
