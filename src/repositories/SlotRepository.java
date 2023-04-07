package repositories;

import models.Doctor;
import models.Slot;
import java.util.List;

public interface SlotRepository {
	public List<Slot> getDoctorSlots(Doctor doctor);
	public void save(Doctor doctor, List<Slot> slots);
}
