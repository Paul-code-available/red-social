package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import util.SelectedUser;

public class GrafoView extends JPanel {
	
	private JButton btnAgregarUsuario;
	private JButton btnAgregarAmistad;
	private JButton btnUsuarioSeleccionado;
		
	JLabel lblUser;
	JLabel lblFriends;
	JLabel lblSugestions;

	private JPanel panelGrafo;
	private JPanel panelAmigos;
	private JPanel panelSugerencias;
	
	JLabel titleAmigos;

	
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
		panelAcciones.setBackground(Color.decode("#141F2D"));
		
		JLabel lblTitle = Componentes.crearTitulo("ACCIONES");		
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
		
		btnUsuarioSeleccionado = Componentes.crearBtnAccion("Buscar usuario");
		btnUsuarioSeleccionado.setIcon(Componentes.cargarIcono("/asset/img/escoger (1).png", 28, 28));
		panelAcciones.add(btnUsuarioSeleccionado);
		
		panelAcciones.add(Box.createVerticalStrut(15));
		
		/*
		JButton informacionUtil = Componentes.crearBtnInformacion("<html> Selecciona un usuario en el grafo para ver su información. </html>");
		informacionUtil.setIcon(Componentes.cargarIcono("/asset/img/atencion.png", 24, 24));
		panelAcciones.add(informacionUtil);
		*/
		add(panelAcciones, BorderLayout.WEST);
		
	}
	
	public void panelGrafo() {
		
		panelGrafo = new JPanel() {
			 @Override
			 protected void paintComponent(Graphics g) {
			     super.paintComponent(g); 
			     
			     Graphics2D g2d = (Graphics2D) g; 
			     g2d.setStroke(new BasicStroke(
			    		 2f,
			    		 BasicStroke.CAP_ROUND,   // extremos redondeados
			    		 BasicStroke.JOIN_ROUND   // uniones redondeadas
			    		 )); 
			        
			     g2d.setRenderingHint(
			    		    RenderingHints.KEY_ANTIALIASING,
			    		    RenderingHints.VALUE_ANTIALIAS_ON
			    		);

			    		g2d.setRenderingHint(
			    		    RenderingHints.KEY_TEXT_ANTIALIASING,
			    		    RenderingHints.VALUE_TEXT_ANTIALIAS_ON
			    		);
			    		
			    g2d.setColor(Color.decode("#4F7CA8"));
			        
			     if (!posiciones.isEmpty()) {
			        
			    	 for (String user : posiciones.keySet()) {
			    		 int[] coords = posiciones.get(user); 
			    		 
			    		
				    	 for (User amistad : friends.get(user)) {
				    		 int[] coords2 = posiciones.get(amistad.getNombre()); 
				    		 
				    		 if (coords2 != null) {
				    			 g2d.drawLine(coords[0]+40, coords[1]+40, coords2[0]+40, coords2[1]+40);
 
							}
				    	
				    	 }
			    	 }
			    	 
			    	
			    	 for (String user : posiciones.keySet()) {
			    		 int[] coords = posiciones.get(user); 
			    		 g2d.setColor(Color.decode("#16374E"));
				    	 if (coords != null) {
				    		 g2d.fillOval(coords[0], coords[1], 80, 80);
				    		 
				    		 
				    		 g2d.setColor(Color.decode("#00E5FF"));
				    		 
				    		 FontMetrics fm = g2d.getFontMetrics();
			                 int anchoTexto = fm.stringWidth(user);
			                 int xCentrado = coords[0] + (80 - anchoTexto) / 2;
			                 int yArriba = coords[1] + 45; 
			                 g2d.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			                 g2d.drawString(user, xCentrado, yArriba);
				    		 
				    		
				    	 }
				    	 
				    	 
				    	 
					}			    	
			     
			     }

			 }
		};
		
		panelGrafo.setLayout(new BoxLayout(panelGrafo, BoxLayout.Y_AXIS));
		panelGrafo.setBackground(Color.decode("#FFFFFF"));
		panelGrafo.add(Box.createVerticalStrut(40));
		JLabel title = Componentes.crearTitulo("CONEXIONES");
		panelGrafo.add(title);
		add(panelGrafo, BorderLayout.CENTER);
		
	}
	
public void calcularPosiciones(SocialNetwork socialNetwork) {
		
		List<User> usuarios = socialNetwork.getUsers();

		int tamaño = usuarios.size();
	    int centroX = (panelGrafo.getWidth() / 2 - 40);
	    int centroY = (panelGrafo.getHeight() / 2 - 40);
	    
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
		panelInformacion.setBackground(Color.decode("#E6E6E9"));
		
		JLabel title = Componentes.crearTitulo("INFORMACIÓN DEL USUARIO");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInformacion.add(title);
		
		panelInformacion.add(Box.createVerticalStrut(20));
		
		JPanel panelUsuario = Componentes.createPanel();
		panelUsuario.setMaximumSize(new Dimension(200, 90));
		
		JLabel titleUsuario = new JLabel("USUARIO");

		titleUsuario.setPreferredSize(new Dimension(180, 20));
		titleUsuario.setForeground(Color.decode("#2462C8"));
		titleUsuario.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelUsuario.add(titleUsuario);
		
		lblUser = new JLabel();
		lblUser.setPreferredSize(new Dimension(180, 40));
		lblUser.setIcon(Componentes.cargarIcono("/asset/img/usuario (1).png", 30, 30));
		lblUser.setVerticalAlignment(JLabel.CENTER);
		lblUser.setIconTextGap(10);
		lblUser.setForeground(Color.GRAY);
		lblUser.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelUsuario.add(lblUser);
		
		panelInformacion.add(panelUsuario);
		
		panelInformacion.add(Box.createVerticalStrut(10));
		
		panelAmigos = Componentes.createPanel();
		panelAmigos.setMaximumSize(new Dimension(200, 160));
		panelInformacion.add(panelAmigos);

		titleAmigos = new JLabel("AMIGOS (0)");
		titleAmigos.setPreferredSize(new Dimension(180, 20));
		titleAmigos.setForeground(Color.decode("#2462C8"));
		titleAmigos.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelAmigos.add(titleAmigos);
	
		panelInformacion.add(Box.createVerticalStrut(10));
		
		panelSugerencias = Componentes.createPanel();
		panelSugerencias.setMaximumSize(new Dimension(200, 100));
		panelInformacion.add(panelSugerencias);
		
		JLabel titleSugerencias = new JLabel("SUGERENCIAS DE AMISTAD");
		titleSugerencias.setPreferredSize(new Dimension(180, 20));
		titleSugerencias.setForeground(Color.decode("#2462C8"));
		titleSugerencias.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelSugerencias.add(titleSugerencias);

		add(panelInformacion, BorderLayout.EAST);
		
	}
	
	public void showSugestions(ArrayList<User> sugestions) {
		
		for (User user : sugestions) {
			
			panelSugerencias.add(Componentes.createLblUsers(user.getNombre()));
			
		}
		
	}
	
	public void showFriends() {
		
		User selectedUser = SelectedUser.getCurrentUser();
		
		panelAmigos.add(getTitleAmigos());
		
		setTitleAmigos("AMIGOS (" + selectedUser.getAmigos().size() + ")");
		
		for (User user : selectedUser.getAmigos()) {
			
			panelAmigos.add(Componentes.createLblUsers(user.getNombre()));
		
		}
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

	public JLabel getLblFriends() {
		return lblFriends;
	}

	public JLabel getLblUser() {
		return lblUser;
	}

	public JLabel getLblSugestions() {
		return lblSugestions;
	}

	public JLabel getTitleAmigos() {
		return titleAmigos;
	}

	public void setTitleAmigos(String titulo) {
		titleAmigos.setText(titulo);
	}

	public JPanel getPanelAmigos() {
		return panelAmigos;
	}

	public void setPanelAmigos(JPanel panelAmigos) {
		this.panelAmigos = panelAmigos;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	


}
