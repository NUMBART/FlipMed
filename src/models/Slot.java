package models;

import exceptions.NonThirtyMinSlotException;

public class Slot extends BaseModel{
	int startTimestamp;
	int endTimestamp;
	Doctor doctor;

	public Slot(String startTime, String endTime) {
		this.startTimestamp = timeToTimestamp(startTime);
		this.endTimestamp = timeToTimestamp(endTime);
		if(this.endTimestamp - this.startTimestamp != 30)
			throw new NonThirtyMinSlotException();
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(int startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public int getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(int endTimestamp) {
		this.endTimestamp = endTimestamp;
	}



	int timeToTimestamp(String time) {
		return 60*Integer.parseInt(time.split(":")[0]) + Integer.parseInt(time.split(":")[1]);
	}

	String timestampToTime(int time) {
		return String.valueOf(time/60) + ':' + String.valueOf(time%60);
	}

	public String getStartTime() {
		return timestampToTime(this.startTimestamp);
	}

	public void setStartTime(String startTime) {
		this.startTimestamp = timeToTimestamp(startTime);
	}

	public String getEndTime() {
		return timestampToTime(this.endTimestamp);
	}

	public void setEndTime(String endTime) {
		this.endTimestamp = timeToTimestamp(endTime);
	}

	@Override
	public String toString() {
		return "Slot{" +
				"startTime=" + this.getStartTime() +
				", endTime=" + this.getEndTime() +
				", doctor=" + this.doctor.getName() +
				'}';
	}
}
