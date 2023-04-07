package models;

import java.util.List;

public class Doctor extends BaseModel {
	String name;
	Speciality speciality;
	int rating;
	List<Slot> slots;

	public Doctor(String name, Speciality speciality) {
		this.name = name;
		this.speciality = speciality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public void addSlots(List<Slot> slots) {
		this.slots.addAll(slots);
	}

	@Override
	public String toString() {
		return "Doctor{" +
				"name='" + name + '\'' +
				", speciality=" + speciality +
				", rating=" + rating +
				", slots=" + slots +
				'}';
	}
}
