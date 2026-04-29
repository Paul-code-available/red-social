package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.SocialNetwork;
import util.Componentes;

public class GrafoView extends JPanel {
	
	private JButton btnAgregarUsuario;
	private JButton btnAgregarAmistad;
	
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
		panelAcciones.setPreferredSize(new Dimension(180, 0));
		panelAcciones.setBorder(BorderFactory.createEmptyBorder(40, 10, 20, 10));
		panelAcciones.setBackground(Color.decode("#DFE1E0"));
		
		JLabel title = new JLabel("Acciones");		
		title.setForeground(Color.decode("#3673DF"));
		title.setFont(new Font("Arial", Font.BOLD, 16));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelAcciones.add(title);
		
		panelAcciones.add(Box.createVerticalStrut(20));
		
		btnAgregarUsuario = Componentes.crearBtnAccion("Agregar Usuario");
		btnAgregarUsuario.setIcon(Componentes.cargarIcono("/asset/img/agregar-usuario.png", 24, 24));
		panelAcciones.add(btnAgregarUsuario);
		
		panelAcciones.add(Box.createVerticalStrut(15));
		
		btnAgregarAmistad = Componentes.crearBtnAccion("Agregar Amistad");
		btnAgregarAmistad.setIcon(Componentes.cargarIcono("/asset/img/amigos.png", 24, 24));
		panelAcciones.add(btnAgregarAmistad);
		
		panelAcciones.add(Box.createVerticalStrut(15));
		
		JButton btnInformacion = Componentes.crearBtnInformacion("<html> Selecciona un usuario en el grafo para ver su información. </html>");
		btnInformacion.setIcon(Componentes.cargarIcono("/asset/img/atencion.png", 24, 24));
		panelAcciones.add(btnInformacion);
		
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
