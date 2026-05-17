package controller;

import javax.swing.JOptionPane;

import model.SocialNetwork;
import model.User;
import view.GrafoView;

public class GrafoController {
	
	private GrafoView grafoView;
	private SocialNetwork socialNetwork;

	public GrafoController(GrafoView grafoView, SocialNetwork socialNetwork) {
		this.grafoView = grafoView;
		this.socialNetwork = socialNetwork;

		acciones();
		
	}
	
	public void acciones() {
		
		grafoView.getBtnAgregarUsuario().addActionListener(e -> {
			socialNetwork.addUser(new User(JOptionPane.showInputDialog("Ingresa el nombre: ")));
			
			grafoView.calcularPosiciones(socialNetwork);
			
			grafoView.repaint();

		});
		
		grafoView.getBtnAgregarAmistad().addActionListener(e -> {
			
			socialNetwork.addFriend(JOptionPane.showInputDialog("Usuario 1:"), 
									JOptionPane.showInputDialog("Usuario 2:"));
			
			grafoView.repaint();
			
		});
		
		grafoView.getBtnUsuarioSeleccionado().addActionListener(e -> {
			
			User user = socialNetwork.buscarUsuario(JOptionPane.showInputDialog("Ingresa el nombre: "));
			
			grafoView.getUsuario().setText(user.getNombre());
			
			grafoView.getAmigos().setText(socialNetwork.verAmigos(user));			
			
			grafoView.getSugerencias().setText(socialNetwork.verSugerencias(user));
			
			
		});
		
	}
	

}
