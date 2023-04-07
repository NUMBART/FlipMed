package services;

import models.Doctor;
import models.Slot;
import models.Speciality;
import repositories.DoctorRepository;
import repositories.InMemoryDoctorRepository;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
	DoctorRepository doctorRepository;
	SlotService slotService;

	public DoctorService() {
		this.doctorRepository = InMemoryDoctorRepository.getInstance();
		this.slotService = new SlotService();
	}

	public Doctor get(String doctorName) {
		return doctorRepository.get(doctorName);
	}

	public void save(Doctor doctor) {
		doctorRepository.save(doctor);
	}

	public List<Slot> getSlotsForSpeciality(Speciality speciality) {
		List<Doctor> doctorList = doctorRepository.getBySpeciality(speciality);
		List<Slot> availableSlots = new ArrayList<>();
		doctorList.forEach((doc) -> {
			availableSlots.addAll(slotService.getSlotsForDoctor(doc));
		});
		return availableSlots;
	}

}
