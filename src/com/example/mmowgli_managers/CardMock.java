package com.example.mmowgli_managers;

/**
 * 
 * @author Eric Henry
 * 
 * This Class will be used to store, manage, and get a card's information
 *
 */
public class CardMock {
	
	//Base Card Attributes
	//private enum cardType;
	private String author;				//Store who created the card
	private String id;					//The unique identifier of the card
	private String type;				//Store the card type: Expand, Explore, Adapt, Counter
	private String score;				//The number of votes the card has
	private String dateCreated;			//When the card was created
	private String text;				//The content of the card / what the user wrote *Cannot be greater than 140 Characters*
	private String[] cardTags;			//The set of all tags associated with the card
	private boolean upvoted;			//Did the current user upvote this card
	private boolean downvoted;			//Did the current user downvote this card.
	
	
	//Constructors
	public CardMock(){
		
	}
	
	//Set-Get Author
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	//Set-Get Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//Set-Get Type
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	//Set-Get Score
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	//Set-Get Date
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	//Set-Get Body Text
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//Set-Get Tag List
	public String[] getCardTags() {
		return cardTags;
	}
	public void setCardTags(String[] cardTags) {
		this.cardTags = cardTags;
	}
	
	//Set-Get Upvote
	public boolean isUpvoted() {
		return upvoted;
	}
	public void setUpvoted(boolean upvoted) {
		this.upvoted = upvoted;
	}
	
	//Set-Get Downvote
	public boolean isDownvoted() {
		return downvoted;
	}
	public void setDownvoted(boolean downvoted) {
		this.downvoted = downvoted;
	}
	
	
	
	
}
