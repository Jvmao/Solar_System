package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import controller.Constants;
import controller.MySQLConnection;
import javax.swing.JTextField;
import java.awt.Color;

public class PlanetsViews {
	//Variables
	JFrame frmSolarSystem;
	private JLabel lbTitle,lbPlanets,lbState,lbPlanetName,lbSunDistance,lbRevolution,lbRotation,lbPlanetMass,
	lbPlanetDiameter,lbAverageTemp,lbAtmos,lbMoons;
	private JTextField tDistance,tRevperiod,tRotPeriod,tPlanetMass,tPlanetDiameter,tAverageTemp,tAtmos,tMoons;
	private JButton btnExit;
	private JComboBox<Object> cbPlanets;
	
	private MySQLConnection mydb;
	public Connection conn;
	private boolean connected = false;	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanetsViews window = new PlanetsViews();
					window.frmSolarSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PlanetsViews() {
		initialize();
	}

	private void initialize() {
		//Frame
		frmSolarSystem = new JFrame();
		frmSolarSystem.setTitle(Constants.titleApp);
		frmSolarSystem.setBounds(100, 100, 850, 600);
		frmSolarSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSolarSystem.getContentPane().setLayout(null);
		
		//ComboBox
		cbPlanets = new JComboBox<Object>();
		cbPlanets.addActionListener(new innerAL());
		cbPlanets.setFont(new Font("Verdana", Font.PLAIN, 12));
		cbPlanets.setBounds(16, 47, 457, 27);
		frmSolarSystem.getContentPane().add(cbPlanets);
		
		//Label Title
		lbTitle = new JLabel(Constants.choosePlanet);
		lbTitle.setFont(new Font("Verdana", Font.PLAIN, 13));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setBounds(16, 19, 457, 16);
		frmSolarSystem.getContentPane().add(lbTitle);
		
		//Label Planets Images
		lbPlanets = new JLabel("");
		lbPlanets.setBounds(16, 86, 457, 404);
		frmSolarSystem.getContentPane().add(lbPlanets);
		
		//Label state connection
		lbState = new JLabel("");
		lbState.setHorizontalAlignment(SwingConstants.CENTER);
		lbState.setBounds(801, 6, 43, 40);
		frmSolarSystem.getContentPane().add(lbState);
		
		//Label Planet Name
		lbPlanetName = new JLabel(Constants.namePlantet);
		lbPlanetName.setForeground(Color.BLUE);
		lbPlanetName.setFont(new Font("Apple Color Emoji", Font.BOLD, 14));
		lbPlanetName.setHorizontalAlignment(SwingConstants.CENTER);
		lbPlanetName.setBounds(517, 15, 210, 26);
		frmSolarSystem.getContentPane().add(lbPlanetName);
		
		//Label Distance
		lbSunDistance = new JLabel(Constants.distancetoSunLabel);
		lbSunDistance.setHorizontalAlignment(SwingConstants.CENTER);
		lbSunDistance.setBounds(485, 46, 276, 26);
		frmSolarSystem.getContentPane().add(lbSunDistance);
		//JText Distance
		tDistance = new JTextField();
		tDistance.setHorizontalAlignment(SwingConstants.CENTER);
		tDistance.setBounds(517, 71, 210, 26);
		frmSolarSystem.getContentPane().add(tDistance);
		tDistance.setColumns(10);
		
		//Label Revolution Period
		lbRevolution = new JLabel(Constants.revPeriod);
		lbRevolution.setHorizontalAlignment(SwingConstants.CENTER);
		lbRevolution.setBounds(517, 109, 210, 16);
		frmSolarSystem.getContentPane().add(lbRevolution);
		//JText Revolution Period
		tRevperiod = new JTextField();
		tRevperiod.setHorizontalAlignment(SwingConstants.CENTER);
		tRevperiod.setBounds(517, 132, 210, 26);
		frmSolarSystem.getContentPane().add(tRevperiod);
		tRevperiod.setColumns(10);
		
		//Label Rotation
		lbRotation = new JLabel(Constants.rotPeriod);
		lbRotation.setHorizontalAlignment(SwingConstants.CENTER);
		lbRotation.setBounds(517, 170, 210, 16);
		frmSolarSystem.getContentPane().add(lbRotation);
		//JText Rotation Period
		tRotPeriod = new JTextField();
		tRotPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		tRotPeriod.setBounds(517, 187, 210, 26);
		frmSolarSystem.getContentPane().add(tRotPeriod);
		tRotPeriod.setColumns(10);
		
		//Label Planet Mass
		lbPlanetMass = new JLabel(Constants.planetMass);
		lbPlanetMass.setHorizontalAlignment(SwingConstants.CENTER);
		lbPlanetMass.setBounds(517, 225, 210, 16);
		frmSolarSystem.getContentPane().add(lbPlanetMass);
		//JText Planet Mass
		tPlanetMass = new JTextField();
		tPlanetMass.setHorizontalAlignment(SwingConstants.CENTER);
		tPlanetMass.setBounds(517, 243, 210, 26);
		frmSolarSystem.getContentPane().add(tPlanetMass);
		tPlanetMass.setColumns(10);
		
		//Label Planet Diameter
		lbPlanetDiameter = new JLabel(Constants.planetDiameter);
		lbPlanetDiameter.setHorizontalAlignment(SwingConstants.CENTER);
		lbPlanetDiameter.setBounds(517, 281, 210, 16);
		frmSolarSystem.getContentPane().add(lbPlanetDiameter);
		//JText Planet Diameter
		tPlanetDiameter = new JTextField();
		tPlanetDiameter.setHorizontalAlignment(SwingConstants.CENTER);
		tPlanetDiameter.setBounds(517, 303, 210, 26);
		frmSolarSystem.getContentPane().add(tPlanetDiameter);
		tPlanetDiameter.setColumns(10);
		
		//Label Average Temperature
		lbAverageTemp = new JLabel(Constants.averageTemp);
		lbAverageTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lbAverageTemp.setBounds(517, 342, 210, 16);
		frmSolarSystem.getContentPane().add(lbAverageTemp);
		//JText Average Temperature
		tAverageTemp = new JTextField();
		tAverageTemp.setHorizontalAlignment(SwingConstants.CENTER);
		tAverageTemp.setBounds(517, 359, 210, 26);
		frmSolarSystem.getContentPane().add(tAverageTemp);
		tAverageTemp.setColumns(10);
		
		//Label Atmosphere
		lbAtmos = new JLabel(Constants.atmos);
		lbAtmos.setHorizontalAlignment(SwingConstants.CENTER);
		lbAtmos.setBounds(517, 391, 210, 16);
		frmSolarSystem.getContentPane().add(lbAtmos);
		//JText Atmosphere
		tAtmos = new JTextField();
		tAtmos.setHorizontalAlignment(SwingConstants.CENTER);
		tAtmos.setBounds(517, 409, 210, 26);
		frmSolarSystem.getContentPane().add(tAtmos);
		tAtmos.setColumns(10);
		
		//Label Moons
		lbMoons = new JLabel(Constants.moons);
		lbMoons.setHorizontalAlignment(SwingConstants.CENTER);
		lbMoons.setBounds(517, 447, 210, 16);
		frmSolarSystem.getContentPane().add(lbMoons);
		//JText Moons
		tMoons = new JTextField();
		tMoons.setHorizontalAlignment(SwingConstants.CENTER);
		tMoons.setBounds(517, 464, 210, 26);
		frmSolarSystem.getContentPane().add(tMoons);
		tMoons.setColumns(10);
		
		//Exit Button
		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(PlanetsViews.class.getResource("/images/iconExit.png")));
		btnExit.setToolTipText(Constants.toolTipExit);
		btnExit.addActionListener(new innerAL());
		btnExit.setBorderPainted(false); //Transparent background for icon
		btnExit.setBounds(780, 513, 64, 47);
		frmSolarSystem.getContentPane().add(btnExit);
		

		//Adding methods to Application
		try {
			getConnection();
			listPlanets();
			dataPlanets();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//Method for Connecting to DB
	public void getConnection() throws ClassNotFoundException {
		mydb = new MySQLConnection();
		connected = mydb.MySQLDB();
		conn = MySQLConnection.getConnection();
		if (connected == false) {
			System.out.println("Connected to MySQL");
			lbState.setIcon(new ImageIcon(Constants.iconGreen));
			lbState.setToolTipText(Constants.toolTipConnectedDB);
		} else {
			System.out.println("No Connected");
			lbState.setIcon(new ImageIcon(Constants.iconRed));
			lbState.setToolTipText(Constants.toopTipNoConnectedDB);
		}
	}
	
	
	//Method to List Planets in comboBox from DB
	public void listPlanets() {
			try {
				conn = MySQLConnection.getConnection();
				Statement st = conn.createStatement();
				
				String query1 = Constants.query1;
				ResultSet rs = st.executeQuery(query1);
				
				while(rs.next()) {
					cbPlanets.addItem(rs.getString(Constants.queryName));
				}
				//conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,Constants.errorConnectionDB,Constants.errorConMessage, JOptionPane.WARNING_MESSAGE); 
			}
	}
	
	//Method to get data from DB
	public void dataPlanets(){
		try {
			conn = MySQLConnection.getConnection();
			String query2 = Constants.query2;
			PreparedStatement pst = conn.prepareStatement(query2);
			
			//Check if combobox is or not empty
			if (cbPlanets.getSelectedItem() != null) {
                pst.setString(1, cbPlanets.getSelectedItem().toString());
            }
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				tDistance.setText(rs.getString(Constants.getDist));
				tRevperiod.setText(rs.getString(Constants.getRev));
				tRotPeriod.setText(rs.getString(Constants.getRot));
				tPlanetMass.setText(rs.getString(Constants.getMass));
				tPlanetDiameter.setText(rs.getString(Constants.getDiameter));
				tAverageTemp.setText(rs.getString(Constants.getTemp));
				tAtmos.setText(rs.getString(Constants.getAtmos));
				tMoons.setText(rs.getString(Constants.getMoons));	
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,Constants.errorConnectionDBinfo,Constants.errorConMessage, JOptionPane.WARNING_MESSAGE); 
		}
	}
	
	
	//Method to show Images from Selected Planet Item on ComboBox
	public void planetImages() {
		int selectPlanet = cbPlanets.getSelectedIndex();
		
		switch (selectPlanet) {
			case 0:
				ImageIcon image1 = new ImageIcon(getClass().getResource(Constants.sunImage));
				Image myImage1 = image1.getImage();
				Image dimage1 = myImage1.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage1 = new ImageIcon(dimage1);
				lbPlanets.setIcon(newImage1);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
			case 1:
				ImageIcon image2 = new ImageIcon(getClass().getResource(Constants.earthImage));
				Image myImage2 = image2.getImage();
				Image dimage2 = myImage2.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage2 = new ImageIcon(dimage2);
				lbPlanets.setIcon(newImage2);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
			case 2:
				ImageIcon image3 = new ImageIcon(getClass().getResource(Constants.mercuryImage));
				Image myImage3 = image3.getImage();
				Image dimage3 = myImage3.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage3 = new ImageIcon(dimage3);
				lbPlanets.setIcon(newImage3);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
			case 3:
				ImageIcon image4 = new ImageIcon(getClass().getResource(Constants.venusImage));
				Image myImage4 = image4.getImage();
				Image dimage4 = myImage4.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage4 = new ImageIcon(dimage4);
				lbPlanets.setIcon(newImage4);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
			case 4:
				ImageIcon image5 = new ImageIcon(getClass().getResource(Constants.marsImage));
				Image myImage5 = image5.getImage();
				Image dimage5 = myImage5.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage5 = new ImageIcon(dimage5);
				lbPlanets.setIcon(newImage5);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
			case 5:
				ImageIcon image6 = new ImageIcon(getClass().getResource(Constants.jupyterImage));
				Image myImage6 = image6.getImage();
				Image dimage6 = myImage6.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage6 = new ImageIcon(dimage6);
				lbPlanets.setIcon(newImage6);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
			case 6:
				ImageIcon image7 = new ImageIcon(getClass().getResource(Constants.saturnImage));
				Image myImage7 = image7.getImage();
				Image dimage7 = myImage7.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage7 = new ImageIcon(dimage7);
				lbPlanets.setIcon(newImage7);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
			case 7:
				ImageIcon image8 = new ImageIcon(getClass().getResource(Constants.uranusImage));
				Image myImage8 = image8.getImage();
				Image dimage8 = myImage8.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage8 = new ImageIcon(dimage8);
				lbPlanets.setIcon(newImage8);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
			case 8:
				ImageIcon image9 = new ImageIcon(getClass().getResource(Constants.neptuneImage));
				Image myImage9 = image9.getImage();
				Image dimage9 = myImage9.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage9 = new ImageIcon(dimage9);
				lbPlanets.setIcon(newImage9);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
			case 9:
				ImageIcon image10 = new ImageIcon(getClass().getResource(Constants.plutoImage));
				Image myImage10 = image10.getImage();
				Image dimage10 = myImage10.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage10 = new ImageIcon(dimage10);
				lbPlanets.setIcon(newImage10);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
			case 10:
				ImageIcon image11 = new ImageIcon(getClass().getResource(Constants.solarSystemImage));
				Image myImage11 = image11.getImage();
				Image dimage11 = myImage11.getScaledInstance(lbPlanets.getWidth(), lbPlanets.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newImage11 = new ImageIcon(dimage11);
				lbPlanets.setIcon(newImage11);
				lbPlanetName.setText(cbPlanets.getSelectedItem().toString());
				break;
		}
		
	}
	
	
	
	//-------------------------------------INNER CLASS-----------------------------------//
	private class innerAL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==cbPlanets) {
				//Adding methods to comboBox
				planetImages();
				dataPlanets();
			}
			
			if(e.getSource()==btnExit){
				System.exit(0); //Close Application
			}
			
		}	
	}
	
	//Info from: https://nssdc.gsfc.nasa.gov/planetary/factsheet/
}
