/**
 * @author Eric H Correia
 * 
 * This is a manager class provides an API to transform Card Objects to 
 * 	either CardView Objects or BaseCardView Objects 
 * 
 */

package com.example.mmowgli_backend;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.example.mmowgli_explore.CardView;
import com.example.mmowgli_updates.BaseCardView;

public class CardExplorationManager {
	
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
		
		//create a new card view using the card data.
		return new BaseCardView(id, pId, cardText, cardType, date.toString());

	}
	
}
