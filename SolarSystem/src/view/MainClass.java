package view;

import javax.swing.JFrame;

public class MainClass extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public MainClass() {}

	public static void main(String[] args) {
		PlanetsViews pw = new PlanetsViews();
		pw.frmSolarSystem.setVisible(true);
		System.out.println("Project Solar System 1.0!!!!");
		
	}

}
