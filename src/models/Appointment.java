package models;

import java.util.Queue;

public class Appointment {
	long id;
	Patient patient;
	Slot slot;
	Queue<Patient> waitlist;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Queue<Patient> getWaitlist() {
		return waitlist;
	}

	public void setWaitlist(Queue<Patient> waitlist) {
		this.waitlist = waitlist;
	}
}
