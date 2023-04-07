package repositories;

import models.Doctor;
import models.Speciality;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryDoctorRepository implements DoctorRepository {
	private static InMemoryDoctorRepository instance = null;
	HashMap<String, Doctor> doctor;

	private InMemoryDoctorRepository() {
		this.doctor = new HashMap<>();
	}

	public static InMemoryDoctorRepository getInstance() {
		if(instance == null)
			instance = new InMemoryDoctorRepository();
		return	instance;
	}

	public Doctor get(String doctorName) {
		return doctor.get(doctorName);
	}

	@Override
	public List<Doctor> getBySpeciality(Speciality speciality) {
		List<Doctor> doctorList = new ArrayList<>();
		doctor.forEach((name, doc) -> {
			if(doc.getSpeciality() == speciality)
				doctorList.add(doc);
		});
		return doctorList;
	}

	public void save(Doctor doctorToBeSaved) {
		String doctorName = doctorToBeSaved.getName();
		this.doctor.put(doctorName, doctorToBeSaved);
	}
}
