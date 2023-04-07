package services;

import exceptions.NonThirtyMinSlotException;
import exceptions.OverlappingSlotException;
import models.Doctor;
import models.Slot;
import repositories.InMemorySlotRepository;
import repositories.SlotRepository;

import java.util.*;

public class SlotService {
	SlotRepository slotRepository;

	public SlotService() {
		this.slotRepository = InMemorySlotRepository.getInstance();
	}

	public List<Slot> getSlotsForDoctor(Doctor doctor) {
		return slotRepository.getDoctorSlots(doctor);
	}

	public void saveSlotsForDoctor(Doctor doctor, List<Slot> slots) { slotRepository.save(doctor, slots);}

	public List<Slot> mergeSlots(List<Slot> list1, List<Slot> list2) throws OverlappingSlotException {
		List<Slot> mergedArray = new ArrayList<>();
		if(list1 != null) mergedArray.addAll(list1);
		if(list2 != null) mergedArray.addAll(list2);
		Collections.sort(mergedArray, Comparator.comparingInt(Slot::getStartTimestamp));
		for(int i = 1; i < mergedArray.size(); ++i)
			if (i != 0 && mergedArray.get(i).getStartTimestamp() - mergedArray.get(i - 1).getStartTimestamp() < 30)
				throw new OverlappingSlotException();
		return mergedArray;
	}
}
