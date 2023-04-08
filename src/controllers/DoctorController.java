package controllers;

import models.Doctor;
import models.Slot;
import models.Speciality;
import services.DoctorService;
import services.SlotService;

import java.util.List;

public class DoctorController {
	DoctorService doctorService;
	SlotService slotService;

	public DoctorController() {
		this.doctorService = new DoctorService();
		this.slotService = new SlotService();
	}

	public Doctor registerDoctor(String doctorName, Speciality speciality) {
		Doctor doctor = new Doctor(doctorName, speciality);
		doctorService.save(doctor);
		System.out.println(doctor.toString());
		return doctor;
	}

	public void markDoctorAvailable(String doctorName, List<Slot> newSlots) throws Exception {
		Doctor doctor = doctorService.get(doctorName);
		List<Slot> currentSlots = slotService.getSlotsForDoctor(doctor);
		List<Slot> updatedSlots = slotService.mergeSlots(currentSlots, newSlots);
		for(Slot slot: updatedSlots) slot.setDoctor(doctor);
		slotService.saveSlotsForDoctor(doctor, updatedSlots);
		System.out.println("Slots saved for Doctor" + doctor.toString() + "\n" + updatedSlots.toString());
	}
}
