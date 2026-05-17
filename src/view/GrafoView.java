package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.SocialNetwork;
import model.User;

import util.Componentes;

public class GrafoView extends JPanel {
	
	private JButton btnAgregarUsuario;
	private JButton btnAgregarAmistad;
	private JButton btnUsuarioSeleccionado;
		
	JLabel usuario;
	JLabel amigos;
	JLabel sugerencias;

	private JPanel panelGrafo;

	
	Map<String, int[]> posiciones = new HashMap<>();
	Map<String, List<User>> friends = new HashMap<>();
	
	public GrafoView() {
		
		setLayout(new BorderLayout());
		
		panelAcciones();
		panelGrafo();
		panelInformacion();

		
	}

	public void panelAcciones() {
		
		JPanel panelAcciones = new JPanel();
		panelAcciones.setLayout(new BoxLayout(panelAcciones, BoxLayout.Y_AXIS));
		panelAcciones.setPreferredSize(new Dimension(180, 0));
		panelAcciones.setBorder(BorderFactory.createEmptyBorder(40, 10, 20, 10));
		panelAcciones.setBackground(Color.decode("#DFE1E0"));
		
		JLabel lblTitle = Componentes.crearTitulo("Acciones");		
		panelAcciones.add(lblTitle);
		
		panelAcciones.add(Box.createVerticalStrut(20));
		
		btnAgregarUsuario = Componentes.crearBtnAccion("Agregar Usuario");
		btnAgregarUsuario.setIcon(Componentes.cargarIcono("/asset/img/agregar-usuario.png", 24, 24));
		panelAcciones.add(btnAgregarUsuario);
		
		panelAcciones.add(Box.createVerticalStrut(15));
		
		btnAgregarAmistad = Componentes.crearBtnAccion("Agregar Amistad");
		btnAgregarAmistad.setIcon(Componentes.cargarIcono("/asset/img/amigos.png", 24, 24));
		panelAcciones.add(btnAgregarAmistad);
		
		panelAcciones.add(Box.createVerticalStrut(15));
		
		btnUsuarioSeleccionado = Componentes.crearBtnAccion("<html> Seleccionar usuario </html>");
		btnUsuarioSeleccionado.setIcon(Componentes.cargarIcono("/asset/img/escoger (1).png", 28, 28));
		panelAcciones.add(btnUsuarioSeleccionado);
		
		panelAcciones.add(Box.createVerticalStrut(15));
		
		JButton informacionUtil = Componentes.crearBtnInformacion("<html> Selecciona un usuario en el grafo para ver su información. </html>");
		informacionUtil.setIcon(Componentes.cargarIcono("/asset/img/atencion.png", 24, 24));
		panelAcciones.add(informacionUtil);
		
		add(panelAcciones, BorderLayout.WEST);
		
	}
	
	public void panelGrafo() {
		
		panelGrafo = new JPanel() {
			 @Override
			 protected void paintComponent(Graphics g) {
			     super.paintComponent(g); 
			        
			     g.setColor(Color.decode("#3673DF"));
			        
			     if (!posiciones.isEmpty()) {
			        
			    	 for (String user : posiciones.keySet()) {
			    		 int[] coords = posiciones.get(user); 
			    		 
			    		 g.setColor(Color.decode("#3673DF"));
				    	 for (User amistad : friends.get(user)) {
				    		 int[] coords2 = posiciones.get(amistad.getNombre()); 
				    		 
				    		 if (coords2 != null) {
				    			 g.drawLine(coords[0]+40, coords[1]+40, coords2[0]+40, coords2[1]+40);
 
							}
				    	
				    	 }
				    	 
				    	 if (coords != null) {
				    		 g.fillOval(coords[0], coords[1], 80, 80);
				    		 g.setColor(Color.BLACK);
				    		 g.drawString(user, coords[0]+40, coords[1]+40);
				    		
				    	 }
				    	 
				    	 
				    	 
					}			    	
			     
			     }

			 }
		};
		
		panelGrafo.setLayout(new BoxLayout(panelGrafo, BoxLayout.Y_AXIS));
		JLabel title = new JLabel("Grafo de la Red");
		panelGrafo.add(title);
		add(panelGrafo, BorderLayout.CENTER);
		
	}
	
public void calcularPosiciones(SocialNetwork socialNetwork) {
		
		List<User> usuarios = socialNetwork.getUsers();

		int tamaño = usuarios.size();
	    int centroX = (panelGrafo.getWidth() / 2);
	    int centroY = (panelGrafo.getHeight() / 2);
	    
	    int radio = Math.min(panelGrafo.getWidth(), panelGrafo.getHeight()) / 3; // radio del círculo

	    for (int i = 0; i < tamaño; i++) {
	        // Ángulo para distribuir los nodos 
	        double angulo = 2 * Math.PI * i / tamaño;

	        int x = (int) (centroX + radio * Math.cos(angulo));
	        int y = (int) (centroY + radio * Math.sin(angulo));
	           
	        friends.put(usuarios.get(i).getNombre(), usuarios.get(i).getAmigos());
	        
	        posiciones.put(usuarios.get(i).getNombre(), new int[]{x, y});
	        panelGrafo.repaint();
	    }
	}
	
	public void panelInformacion() {
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(new BoxLayout(panelInformacion, BoxLayout.Y_AXIS));
		panelInformacion.setPreferredSize(new Dimension(220, 0));
		panelInformacion.setBorder(BorderFactory.createEmptyBorder(40, 10, 20, 10));
		panelInformacion.setBackground(Color.decode("#DFE1E0"));
		
		JLabel title = Componentes.crearTitulo("Información del Usuario");
		panelInformacion.add(title);
		
		panelInformacion.add(Box.createVerticalStrut(20));
		
		JLabel titleUsuario = new JLabel("Usuario Seleccionado");
		titleUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInformacion.add(titleUsuario);
		
		panelInformacion.add(Box.createVerticalStrut(5));
		
		JPanel panelUsuario = Componentes.createPanel();
		panelUsuario.setMaximumSize(new Dimension(200, 80));
		
		usuario = new JLabel("");
		panelUsuario.add(usuario);
		
		panelInformacion.add(panelUsuario);
		
		panelInformacion.add(Box.createVerticalStrut(5));
		
		JLabel titleAmigos = new JLabel("Amigos");
		titleAmigos.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInformacion.add(titleAmigos);
		
		panelInformacion.add(Box.createVerticalStrut(5));
		
		JPanel panelAmigos = Componentes.createPanel();
		panelAmigos.setMaximumSize(new Dimension(200, 160));
		panelInformacion.add(panelAmigos);
		
		amigos = new JLabel("");
		panelAmigos.add(amigos);

		panelInformacion.add(Box.createVerticalStrut(5));
		
		JLabel titleSugerencias = new JLabel("Sugerencias");
		titleSugerencias.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInformacion.add(titleSugerencias);
		
		panelInformacion.add(Box.createVerticalStrut(5));
		
		JPanel panelSugerencias = Componentes.createPanel();
		panelSugerencias.setMaximumSize(new Dimension(200, 100));
		panelInformacion.add(panelSugerencias);
		
		sugerencias = new JLabel("");
		panelSugerencias.add(sugerencias);

		add(panelInformacion, BorderLayout.EAST);
		
	}
	
	public JButton getBtnAgregarUsuario() {
		return btnAgregarUsuario;
	}

	public JButton getBtnAgregarAmistad() {
		return btnAgregarAmistad;
	}

	public JButton getBtnUsuarioSeleccionado() {
		return btnUsuarioSeleccionado;
	}

	public JLabel getAmigos() {
		return amigos;
	}

	public JLabel getUsuario() {
		return usuario;
	}

	public JLabel getSugerencias() {
		return sugerencias;
	}
	
	
	
	
	
	
	
	
	
	


}
