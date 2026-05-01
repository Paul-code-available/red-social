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
				
		});
		
		grafoView.getBtnAgregarAmistad().addActionListener(e -> {
			
			socialNetwork.addFriend(socialNetwork.buscarUsuario(JOptionPane.showInputDialog("Usuario 1:")), 
									socialNetwork.buscarUsuario(JOptionPane.showInputDialog("Usuario 2:")));
			
		});
		
	}
	

}
