package com.gamingroom;

/*
 *  The Entity class is the parent class of game, team, and player.
 *  This class is responsible for getting the id and names passed through the constructos called.
 */

public class Entity {

	// id variable and name variables used for child classes
	private long id;
	private String name;
	
	
	//Private constructs ensure only one entity can exist
	private Entity() {}
	
	//overloaded constructor used to pass values through
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}
	
}
