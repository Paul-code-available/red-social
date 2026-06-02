package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SocialNetwork {
	
	private Map<String, User> socialNetwork;
	private int size;
	
	public SocialNetwork() {
		socialNetwork = new HashMap<String, User>();
		size = 0;
	}

	public void addUser(User u) {
		
		// falta validar espacios en blanco y null
		
		if (u == null) {
			return;
		}
		
		for (String users : socialNetwork.keySet()) {
			if (users.equalsIgnoreCase(u.getNombre())) {
				return;
			}
		}
		
		u.setNombre(u.getNombre().toLowerCase());
		
		socialNetwork.put(u.getNombre(), u);
		size++;
		System.out.println("Se añadió el usuario " + u.getNombre());
		
	}
	
	public void addFriend(String n1, String n2) {
		
		User u1 = buscarUsuario(n1);
		User u2 = buscarUsuario(n2);
		
		if (u1 == null|| u2 == null) {
			return;
		}
		
		if (!socialNetwork.containsKey(u1.getNombre()) || !socialNetwork.containsKey(u2.getNombre())) {
			return;
		}
		
		for (User u : u1.getAmigos()) {
			if (u.getNombre().equals(u2.getNombre())) {
				return;
			}
		}
		
		u1.addFriend(u2);
		u2.addFriend(u1);
		
		System.out.println(u1.getNombre() + " y " + u2.getNombre() + " ahora son amigos");
		
	}
	
	public User buscarUsuario(String nombre) {
		// falta validar null
		return socialNetwork.get(nombre.toLowerCase());
	}
	
	/*
	public ArrayList<String> verAmigos(User u1) {
		
		ArrayList<String> amigos = new ArrayList<String>();
		
		if (!u1.getAmigos().isEmpty()) {
			
			for (User u : u1.getAmigos()) {
				amigos.add(u.getNombre());
			}
			
		}
		
		return amigos;

	}
	*/
	
	public ArrayList<User> verSugerencias(User u1) {
		
		Queue<User> cola = new LinkedList<User>();
		List<User> visitados = new ArrayList<User>();
		
		ArrayList<User> sugestions = new ArrayList<>();
		
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
							sugestions.add(u);
						}
						
					}
					
				}
				
			}
			
		}

		return sugestions;
	}	
	
	public List<User> getUsers() {
	    return new ArrayList<>(socialNetwork.values());
	}
	public int getSize() {
		return size;
	}
	
}
