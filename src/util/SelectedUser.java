package util;

import model.User;

public class SelectedUser {
	
	private static User currentUser;

	public static void currentUser(User user) {
		currentUser = user;
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}
	
	public static void logOut() {
		currentUser = null;
	}
	
}
