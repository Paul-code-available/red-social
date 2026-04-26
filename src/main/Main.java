package main;

import model.SocialNetwork;
import model.User;

public class Main {

	public static void main(String[] args) {
		
		SocialNetwork socialNetwork = new SocialNetwork();

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
        socialNetwork.addFriend(juan, maria);
        socialNetwork.addFriend(juan, pedro);
        socialNetwork.addFriend(maria, ana);
        socialNetwork.addFriend(pedro, luis);
        socialNetwork.addFriend(juan, maria); // duplicado, no debería agregarse

        // Ver amigos de Juan
        System.out.println("\nAmigos de Juan:");
        socialNetwork.verAmigos(juan);

        // Sugerencias para Juan (debería mostrar Ana y Luis)
        System.out.println("\nSugerencias para Juan:");
        socialNetwork.verSugerencias(juan);
		
		
	}

}
