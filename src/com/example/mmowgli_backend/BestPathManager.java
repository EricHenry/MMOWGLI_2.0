package com.example.mmowgli_backend;

import java.sql.SQLException;

public class BestPathManager {
	
	/**
	 * *********************** HELPER METHODS ADDED BY STEPHEN ***********************
	 */
	
//	public static CardList activePath(int idNum, CardList topcards) throws SQLException{
//		
//		CardList templist = new CardList();	//list of current children
//		
//		Card topcard = new Card();	//holds the card with the most votes
//		
//		Card tempcard = new Card(); //used to hold the new card while swapping
//		
//		templist = MmowgliDB.allChildrenQuery(idNum);
//
//		
//		if(templist.isEmpty()){		//End if there are no more children
//
//			return topcards;
//		}
//		else if(templist.size()==1){	//If there is only one child, add it to list and end
//
//			topcards.addCard(templist.getCard());
//			return topcards;
//		}
//		else{		//Finds the card with the most votes, adds it to list then calls the method again
//			topcard = templist.getCard();
//			while(templist.size()>=1){
//				tempcard = templist.getCard();
//
//				if(topcard.votes<tempcard.votes){
//
//					topcard = tempcard;
//				}
//			}
//			
//			topcards.addCard(topcard);
//			return activePath(topcard.cardId, topcards);
//			
//		}
//		
//	}
	
	public static CardList activePath(Card parent, CardList topcards) throws SQLException{
		
		CardList templist = new CardList();	//list of current children
		
		Card topcard = new Card();	//holds the card with the most votes
		
		Card tempcard = new Card(); //used to hold the new card while swapping
		
		templist = MmowgliDB.allChildrenQuery(parent.cardId);

		
		if(templist.isEmpty()){		//End if there are no more children

			return topcards;
		}
		else{		//Finds the card with the most votes, adds it to list then calls the method again
			int topvotes;
			
			topcard = templist.getCard();
			topvotes=sumVotes(topcard.cardId,topcard.votes);//holds the total votes of the top card
			while(templist.size()>=1){
				tempcard = templist.getCard();
				//tempcard = templist.getEndCard();
				int tempvotes;//holds the total votes for the temp card
				if(topvotes<(tempvotes=sumVotes(tempcard.cardId,tempcard.votes))){
					topvotes=tempvotes;
					topcard = tempcard;
				}
			}
			//System.out.println("added card: "+topcard.cardId);
			topcards.addCard(topcard);//adds parent to card list
			return activePath(topcard, topcards);
			
		}
		
	}
	public static int sumVotes(int idNum,int totalvotes) throws SQLException{//Finds the total number of votes for the card and all its children, children's children, etc.
		
		CardList children = new CardList();
		
		Card tempcard = new Card();
		
		children = MmowgliDB.allChildrenQuery(idNum);
		
		if(children.isEmpty()){
			return totalvotes;
		}
		else{
			while(children.size()>=1){
				tempcard = children.getCard();

				totalvotes+=tempcard.votes;
				return totalvotes+=sumVotes(tempcard.cardId,totalvotes);
			}
		}
		
		return totalvotes;
	}
}
