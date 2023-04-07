package models;

public class Patient extends BaseModel{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Patient(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Patient{" +
				"name='" + name + '\'' +
				'}';
	}
}
