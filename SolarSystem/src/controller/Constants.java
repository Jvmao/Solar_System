package controller;

public class Constants {
	public final static String titleApp = "SOLAR SYSTEM 1.0";
	public final static String choosePlanet = "Choose a Planet";
	public final static String namePlantet = "PLANET NAME";
	public final static String iconGreen = "src/images/green.png";
	public final static String iconRed = "src/images/red.png";
	public final static String query1 ="SELECT planetName FROM InfoSolarSystem ORDER BY id ASC";
	public final static String queryName = "planetName";
	public final static String errorConnectionDB = "Failed to Connect to Database to show Planet's Name";
	public final static String errorConMessage = "Error Connection";
	public final static String toolTipConnectedDB = "Connected DB";
	public final static String toopTipNoConnectedDB = "No Connected DB";
	public final static String sunImage = "/images/sun.png";
	public final static String earthImage = "/images/earth.jpg";
	public final static String mercuryImage = "/images/mercury.jpg";
	public final static String venusImage = "/images/venus.jpg";
	public final static String marsImage = "/images/mars.jpg";
	public final static String saturnImage = "/images/saturn.jpg";
	public final static String jupyterImage = "/images/jupiter.png";
	public final static String uranusImage = "/images/uranus.jpg";
	public final static String neptuneImage = "/images/neptune.jpg";
	public final static String plutoImage = "/images/pluto.jpg";
	public final static String solarSystemImage = "/images/solarSystem.png";
	public final static String distancetoSunLabel = "Distance to Sun in Millions of KM";
	public final static String revPeriod = "Revolution Period in Years";
	public final static String rotPeriod = "Rotation Period in Days";
	public final static String planetMass = "Planet Mass (10^24 KG)";
	public final static String planetDiameter = "Planet Diameter in KM";
	public final static String averageTemp = "Average Temperature";
	public final static String errorConnectionDBinfo = "Failed to Connect to Database to show Info";
	public final static String query2 ="SELECT ss.id,ss.planetName,ss.distSun,ss.planet_diameter,ss.average_temperature,"
										+ "ss.atmosphere,ss.moons,ss.revolutionPeriod,ss.rotationPeriod,ss.planet_mass "
										+ "FROM InfoSolarSystem ss where ss.planetName = ?";
	public final static String atmos ="Atmosphere (main components)";
	public final static String moons ="Moons";
	public final static String getDist = "distSun";
	public final static String getRev = "revolutionPeriod";
	public final static String getRot = "rotationPeriod";
	public final static String getMass = "planet_mass";
	public final static String getDiameter = "planet_diameter";
	public final static String getTemp = "average_temperature";
	public final static String getAtmos = "atmosphere";
	public final static String getMoons = "moons";
	
	public final static String toolTipExit = "Close Application";
}
