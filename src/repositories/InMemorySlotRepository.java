package repositories;

import models.Doctor;
import models.Slot;

import java.util.HashMap;
import java.util.List;

public class InMemorySlotRepository implements SlotRepository {
	HashMap<String, List<Slot>>  slot;
	static InMemorySlotRepository instance = null;

	private InMemorySlotRepository() {
		this.slot = new HashMap<>();
	}

	public static InMemorySlotRepository getInstance() {
		if(instance == null)
			instance = new InMemorySlotRepository();
		return instance;
	}


	@Override
	public List<Slot> getDoctorSlots(Doctor doctor) {
		List<Slot> slots = slot.get(doctor.getName());
		return slots == null ? List.of() : slots;
	}

	@Override
	public void save(Doctor doctor, List<Slot> slots) {
		slot.put(doctor.getName(), slots);
	}
}
