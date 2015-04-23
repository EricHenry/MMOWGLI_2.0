package com.example.mmowgli_backend;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.example.mmowgli_explore.CardView;
import com.example.mmowgli_updates.BaseCardView;

public class CardExplorationManager {
	
	/**
	 * *********************** HELPER METHODS ADDED BY ERIC ***********************
	 */
	
	/**
	 * This method translates a Card object to a CardView Object
	 * @param cardData	-> Card from database
	 * @return			-> CardView with card Information
	 */
	public static CardView createCardView(Card cardData){
		
		//get the current card data
		String id = Integer.toString(cardData.cardId);
		String pId = Integer.toString(cardData.playerId);
		String cardText = cardData.textUser;
		String cardType = cardData.cardType;
		String parent = Integer.toString(cardData.parent);
		String votes = Integer.toString(cardData.votes);
		
		//convert date 
		Date date = new Date(cardData.time.getTime());
		//System.out.println("CARDVIEW: Date form DB = " + date2.toString());
		
		//String date = new SimpleDateFormat("MM/dd/yyyy").format(cardData.time.getDate());
		
		return new CardView(id, pId, cardText, cardType, parent, votes, date.toString());
		
	}
	
	/**
	 * This method translates a Card object to a BaseCardView Object
	 * @param cardData	-> Card from database
	 * @return			-> BaseCardView with card Information
	 */
	public static BaseCardView createBaseCardView(Card cardData){
		
		//get the current card data
		String id = Integer.toString(cardData.cardId);
		String pId = Integer.toString(cardData.playerId);
		String cardText = cardData.textUser;
		String cardType = cardData.cardType;
		
		//convert date 
		Date date = new Date(cardData.time.getTime());
		//System.out.println("CARDVIEW: Date form DB = " + date2.toString());
				
		//String date = new SimpleDateFormat("MM/dd/yyyy").format(cardData.time.getDate());
		
		//create a new card view using the card data.
		return new BaseCardView(id, pId, cardText, cardType, date.toString());

	}
	
}
