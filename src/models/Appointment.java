package models;

import java.util.Queue;

public class Appointment {
	private static Long appointmentsCount = 0L;
	Long id;
	Patient patient;
	Slot slot;
	Queue<Patient> waitlist;

	public Appointment(Patient patient, Slot slot) {
		this.patient = patient;
		this.slot = slot;
		this.id = appointmentsCount++;
	}

	public long getId() {
		return id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Patient removeFromWaitlist() {
		return waitlist.poll();
	}

	public void addToWaitlist(Patient patient) {
		waitlist.add(patient);
	}

	@Override
	public String toString() {
		return "Appointment{" +
				"id=" + id +
				", patient=" + patient +
				", slot=" + slot +
				", waitlist=" + waitlist +
				'}';
	}
}
