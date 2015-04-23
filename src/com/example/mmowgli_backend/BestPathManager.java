package com.example.mmowgli_backend;

import java.sql.SQLException;

public class BestPathManager {
	
	/**
	 * *********************** HELPER METHODS ADDED BY STEPHEN ***********************
	 */
	
	public static CardList activePath(int idNum, CardList topcards) throws SQLException{
		
		CardList templist = new CardList();	//list of current children
		
		Card topcard = new Card();	//holds the card with the most votes
		
		Card tempcard = new Card(); //used to hold the new card while swapping
		
		templist = MmowgliDB.allChildrenQuery(idNum);

		
		if(templist.isEmpty()){		//End if there are no more children

			return topcards;
		}
		else if(templist.size()==1){	//If there is only one child, add it to list and end

			topcards.addCard(templist.getCard());
			return topcards;
		}
		else{		//Finds the card with the most votes, adds it to list then calls the method again
			topcard = templist.getCard();
			while(templist.size()>=1){
				tempcard = templist.getCard();

				if(topcard.votes<tempcard.votes){

					topcard = tempcard;
				}
			}
			
			topcards.addCard(topcard);
			return activePath(topcard.cardId, topcards);
			
		}
		
	}
}
