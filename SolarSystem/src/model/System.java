package model;

import java.io.Serializable;

public class System implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Variables
	int id;
	String planetName;
	String distSun;
	Double planetMass;
	String planetDiameter;
	String avTemp;
	String atmos;
	int moons;
	Double revolutionPeriod;
	Double rotationPeriod;
	
	//Empty Constructor
	public System(){}

	//Constructor with Fields
	public System(int id, String planetName, String distSun, Double planetMass, String planetDiameter, String avTemp,
			String atmos, int moons, Double revolutionPeriod, Double rotationPeriod) {
		super();
		this.id = id;
		this.planetName = planetName;
		this.distSun = distSun;
		this.planetMass = planetMass;
		this.planetDiameter = planetDiameter;
		this.avTemp = avTemp;
		this.atmos = atmos;
		this.moons = moons;
		this.revolutionPeriod = revolutionPeriod;
		this.rotationPeriod = rotationPeriod;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public String getDistSun() {
		return distSun;
	}

	public void setDistSun(String distSun) {
		this.distSun = distSun;
	}

	public Double getPlanetMass() {
		return planetMass;
	}

	public void setPlanetMass(Double planetMass) {
		this.planetMass = planetMass;
	}

	public String getPlanetDiameter() {
		return planetDiameter;
	}

	public void setPlanetDiameter(String planetDiameter) {
		this.planetDiameter = planetDiameter;
	}

	public String getAvTemp() {
		return avTemp;
	}

	public void setAvTemp(String avTemp) {
		this.avTemp = avTemp;
	}

	public String getAtmos() {
		return atmos;
	}

	public void setAtmos(String atmos) {
		this.atmos = atmos;
	}

	public int getMoons() {
		return moons;
	}

	public void setMoons(int moons) {
		this.moons = moons;
	}

	public Double getRevolutionPeriod() {
		return revolutionPeriod;
	}

	public void setRevolutionPeriod(Double revolutionPeriod) {
		this.revolutionPeriod = revolutionPeriod;
	}

	public Double getRotationPeriod() {
		return rotationPeriod;
	}

	public void setRotationPeriod(Double rotationPeriod) {
		this.rotationPeriod = rotationPeriod;
	}

	//Generate to String
	@Override
	public String toString() {
		return "System [id=" + id + ", planetName=" + planetName + ", distSun=" + distSun + ", planetMass=" + planetMass
				+ ", planetDiameter=" + planetDiameter + ", avTemp=" + avTemp + ", atmos=" + atmos + ", moons=" + moons
				+ ", revolutionPeriod=" + revolutionPeriod + ", rotationPeriod=" + rotationPeriod + "]";
	}
	
	
	

}
