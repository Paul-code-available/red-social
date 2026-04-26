package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SocialNetwork {
	
	private Map<String, User> socialNetwork;
	
	public SocialNetwork() {
		socialNetwork = new HashMap<String, User>();
	}

	public void addUser(User u) {
		
		if (!socialNetwork.containsKey(u.getNombre())) {
			socialNetwork.put(u.getNombre(), u);
			System.out.println("Se añadió el usuario " + u.getNombre());
		}
		
	}
	
	public void addFriend(User u1, User u2) {
		
		for (User u : u1.getAmigos()) {
			if (u.equals(u2)) {
				return;
			}
		}
		
		u1.getAmigos().add(u2);
		u2.getAmigos().add(u1);
		
		System.out.println(u1.getNombre() + " y " + u2.getNombre() + " ahora son amigos");
		
	}
	
	public void verAmigos(User u1) {
		
		if (u1.getAmigos().isEmpty()) {
			return;
		}
		
		for (User u : u1.getAmigos()) {
			System.out.println(u.getNombre());
		}
		
	}
	
	public void verSugerencias(User u1) {
		
		Queue<User> cola = new LinkedList<User>();
		List<User> visitados = new ArrayList<User>();
		
		cola.add(u1);
		visitados.add(u1);
		
		while (!cola.isEmpty()) {
			
			User actual = cola.poll();
			
			if (actual != null) {
				
				for (User u : actual.getAmigos()) {
					
					if (!visitados.contains(u)) {
						cola.add(u);
						visitados.add(u);
						
						if (!u1.getAmigos().contains(u)) {
							System.out.println(u.getNombre());
						}
						
					}
					
				}
				
			}
			
		}
		
	}

}
