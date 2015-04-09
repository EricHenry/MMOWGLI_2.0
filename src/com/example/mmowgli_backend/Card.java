/*
 * Program Name: Card.java
 * Author: Youssef Rizk
 * Date Modified: 3/24/15
 * 
 * This class creates a Card object that stores variable information
 * contained within and obtained from a database. The primary use of this card object
 * will involve holding data within linked lists created after making
 * query calls to the database.
 * 
 */



package com.example.mmowgli_backend;

import java.sql.Timestamp;

public class Card 
{
	
	public int cardId;			//Holds the card's unique ID number
	public int playerId;		//Holds the ID of the player that created the card
	public String textUser;		//The custom text input by the user
	public String cardType;		//The type of card (explore, adapt, counter, expand)
	public int parent;			//Holds the ID of the card's parent
	public int votes;			//Holds the card's total number of votes
	public Timestamp time; 		//The date and time the card was created
	
	//NEED TO KNOW IF THE CARD IS FAVORITED BY USER
	//IF IT HAS BEEN FAVORTIED THEN FAVORITE == 1  ??
	public int favorite; 
	
	/*
	 * Card - takes in all of the variables for the object as parameters
	 */
	
	public Card (int cId, int pId, String tUser, String cType, int par, int vote, Timestamp t)
	{
		cardId = cId;
	    playerId = pId;
	    textUser = tUser;
	    cardType = cType;
	    parent = par;
	    votes = vote;
	    time = t;
	}
	
	/*
	 * Card - this alternate constructor method creates a blank card object.
	 */
	public Card ()
	{
		java.util.Date now = new java.util.Date();
		Timestamp timeNow = new java.sql.Timestamp(now.getTime());
		
		cardId = 0;
	    playerId = 0;
	    textUser = "";
	    cardType = "Blank";
	    parent = 0;
	    votes = 0;
	    time = timeNow;
	}

}
