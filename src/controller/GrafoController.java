package controller;

import javax.swing.JOptionPane;

import model.SocialNetwork;
import model.User;
import view.GrafoView;
import util.SelectedUser;

public class GrafoController {
	
	private GrafoView grafoView;
	private SocialNetwork socialNetwork;
	private int numberOfUsersSelected = 0;

	public GrafoController(GrafoView grafoView, SocialNetwork socialNetwork) {
		this.grafoView = grafoView;
		this.socialNetwork = socialNetwork;
		
		
		acciones();
		
	}
	
	public void acciones() {
		
		grafoView.getBtnAgregarUsuario().addActionListener(e -> {
			
			String usuario = JOptionPane.showInputDialog("Ingresa el nombre: ");
		
			if (usuario == null) {
				return;
			}
			
			User user = new User(usuario);
			
			socialNetwork.addUser(user);
			
			grafoView.calcularPosiciones(socialNetwork);
			
			grafoView.repaint();

		});
		
		grafoView.getBtnAgregarAmistad().addActionListener(e -> {
			
			String user1 = JOptionPane.showInputDialog("Usuario 1:");
			String user2 = JOptionPane.showInputDialog("Usuario 2:");
			
			if (user1 == null || user2 == null) {
				return;
			}
					
			socialNetwork.addFriend(user1, user2);
			
			grafoView.repaint();
			
		});
		
		grafoView.getBtnUsuarioSeleccionado().addActionListener(e -> {
			
			String nombreUsuario = JOptionPane.showInputDialog("Ingresa el nombre: ");
			
			if (nombreUsuario == null) {
				return;
			}
			
			User user = socialNetwork.buscarUsuario(nombreUsuario);
			
			if (user != SelectedUser.getCurrentUser()) {
				grafoView.getPanelAmigos().removeAll();
				grafoView.repaint();
			}
			
			SelectedUser.currentUser(user);
			
			grafoView.getLblUser().setText(user.getNombre());
			
			grafoView.showFriends();
			
			grafoView.showSugestions(socialNetwork.verSugerencias(user));
	
		});
		
	}
	
	

	

	
	

}
