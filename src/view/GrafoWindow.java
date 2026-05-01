package view;

import javax.swing.JFrame;

import controller.GrafoController;

public class GrafoWindow extends JFrame {
	
	private GrafoView grafoView;
	
	public GrafoWindow() {
		
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setTitle("Red Social");
        
        grafoView = new GrafoView();
        add(grafoView);
        setVisible(true);
        
		
	}

	public GrafoView getGrafoView() {
		return grafoView;
	}

	
	

}
