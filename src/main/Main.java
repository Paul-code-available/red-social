package main;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import controller.GrafoController;
import model.SocialNetwork;
import model.User;
import view.GrafoWindow;

public class Main {

	public static void main(String[] args) {
		
		FlatLightLaf.setup();
		
		UIManager.put("TextComponent.arc", 15);
		UIManager.put("Button.arc", 12);
		
		SocialNetwork socialNetwork = new SocialNetwork();
		
		GrafoWindow window = new GrafoWindow();
		new GrafoController(window.getGrafoView(), socialNetwork);
		
	
		
		// Crear usuarios
        User juan = new User("Juan");
        User maria = new User("Maria");
        User pedro = new User("Pedro");
        User ana = new User("Ana");
        User luis = new User("Luis");

        // Agregar usuarios
        socialNetwork.addUser(juan);
        socialNetwork.addUser(maria);
        socialNetwork.addUser(pedro);
        socialNetwork.addUser(ana);
        socialNetwork.addUser(luis);
        socialNetwork.addUser(juan); // duplicado, no debería agregarse

        // Crear amistades
        socialNetwork.addFriend("juan", "maria");
        socialNetwork.addFriend("juan", "pedro");
        socialNetwork.addFriend("maria", "ana");
        socialNetwork.addFriend("pedro", "luis");
        socialNetwork.addFriend("juan", "maria"); // duplicado, no debería agregarse          
		
	}

}
