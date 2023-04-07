package repositories;

import models.Doctor;
import models.Speciality;

import java.util.List;

public interface DoctorRepository {
	Doctor get(String doctorName);
	List<Doctor> getBySpeciality(Speciality speciality);
	void save(Doctor doctor);
}
