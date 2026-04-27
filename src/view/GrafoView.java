package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.SocialNetwork;

public class GrafoView extends JPanel {
	
	public GrafoView() {
		
		setLayout(new BorderLayout());
		
		panelAcciones();
		panelGrafo();
		panelInformacion();

	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // g.fillOval();

	}
	
	public void panelAcciones() {
		
		JPanel panelAcciones = new JPanel();
		panelAcciones.setLayout(new BoxLayout(panelAcciones, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("Acciones");
		panelAcciones.add(title);
		
		add(panelAcciones, BorderLayout.WEST);
		
	}
	
	public void panelGrafo() {
		
		JPanel panelGrafo = new JPanel();
		panelGrafo.setLayout(new BoxLayout(panelGrafo, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("Grafo de la Red");
		panelGrafo.add(title);
		
		add(panelGrafo, BorderLayout.CENTER);
		
	}
	
	public void panelInformacion() {
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(new BoxLayout(panelInformacion, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("Informacion del Usuario");
		panelInformacion.add(title);
		
		add(panelInformacion, BorderLayout.EAST);
		
	}
	
	


}
