package iut.android.iut_carpool;

public class Student {
	
	private String phoneNumber, name, adress, coordinates, hasCar, ridesCar;

	public Student(String phoneNumber, String name, String adress,
			String coordinates, String hasCar, String ridesCar) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.adress = adress;
		this.coordinates = coordinates;
		this.hasCar = hasCar;
		this.ridesCar = ridesCar;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getHasCar() {
		return hasCar;
	}

	public void setHasCar(String hasCar) {
		this.hasCar = hasCar;
	}

	public String getRidesCar() {
		return ridesCar;
	}

	public void setRidesCar(String ridesCar) {
		this.ridesCar = ridesCar;
	}
	
	

}
