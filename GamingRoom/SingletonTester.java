package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		/*
		 * The purpose of the singleton pattern is to make sure only one instance of a class. This is used in this 
		 * Assignment to insure that only one game service is running although there can be many game instances.
		 */
		
		System.out.println("\nAbout to test the singleton...");
		
		// Replace null with GameService.getService which will test to make sure there is only one instance up.
		GameService service = GameService.getInstance(); // replace null with ???
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}
