package iut.android.iut_carpool;

public class Car {
	
	private String licencePlate, brand, model, color;
	private int availableSits, SeatsToken;
	
	public Car(String licencePlate, String brand, String model, String color,
			int availableSits, int seatsToken) {
		super();
		this.licencePlate = licencePlate;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.availableSits = availableSits;
		SeatsToken = seatsToken;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAvailableSits() {
		return availableSits;
	}

	public void setAvailableSits(int availableSits) {
		this.availableSits = availableSits;
	}

	public int getSeatsToken() {
		return SeatsToken;
	}

	public void setSeatsToken(int seatsToken) {
		SeatsToken = seatsToken;
	}
	
	
	
	
}
