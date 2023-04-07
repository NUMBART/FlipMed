import controllers.DoctorController;
import models.Doctor;
import models.Slot;
import models.Speciality;
import services.DoctorService;
import services.PatientService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipMed {
	public static void main(String[] args) throws Exception {
		DoctorController doctorController = new DoctorController();
		doctorController.registerDoctor("Curious", Speciality.Cardiologist);
		doctorController.markDoctorAvailable("Curious", new ArrayList<Slot>(
				Arrays.asList(new Slot("9:00", "9:30"), new Slot("10:00", "10:30"), new Slot("11:00", "11:30"))));
		DoctorService doctorService = new DoctorService();
		List<Slot> availableSlots = doctorService.getSlotsForSpeciality(Speciality.Cardiologist);
		System.out.println("Available slots:");
		availableSlots.forEach((slot) -> System.out.println(slot.toString()));
		PatientService patientService = new PatientService();
		patientService.registerPatient("PatientA");

	}
}
