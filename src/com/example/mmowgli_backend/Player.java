/*
 * Program Name: Card.java
 * Author: Youssef Rizk
 * Date Modified: 4/03/15
 * 
 * This class creates a Player object that stores variable information
 * contained within and obtained from a database. The primary use of this Player object
 * will involve returning Player information such as points and a history of cards viewed.
 * 
 */


package com.example.mmowgli_backend;

public class Player 
{
	public int playerId;		//Holds the ID number of the player 
	public String playerName;	//The name of the player 
	public int points;			//Tracks the players points
	public int history1;		//Holds a card ID for a card the player viewed
	public int history2;		//Holds a card ID for a card the player viewed
	public int history3;		//Holds a card ID for a card the player viewed
	public int history4;		//Holds a card ID for a card the player viewed
	public int history5;		//Holds a card ID for a card the player viewed
	public int hIndex;			//Holds the index (1 - 5) for the next history slot to use
	
	/*
	 * Player - takes in all of the variables for the object as parameters
	 */
	
	public Player (int pId, String pName, int score, int h1, int h2, int h3, int h4, int h5, int index)
	{
		playerId = pId;		 
		playerName = pName;	 
		points = score;			
		history1 = h1;		
		history2 = h2;		
		history3= h3;		
		history4 = h4;		
		history5 = h5;		
		hIndex = index;		
	}

}