package model;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String nombre;
	private List<User> amigos;
	
	public User(String nombre) {
		this.nombre = nombre;	
		amigos = new ArrayList<User>();
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<User> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<User> amigos) {
		this.amigos = amigos;
	}
	
	
	
	

}
