/*
 * Program Name: MmowgliDB.java
 * Author: Youssef Rizk
 * Date Created: 3/20/15
 * Date Last Modified: 4/28/15
 * 
 * This class manages all of the calls for the mmowgli proof of concept design
 * calls to the database. It contains methods that create, delete, and retrieve entries 
 * in the database. Calls return Card, CardList, TagList, and Player objects. They may
 * also return int or boolean values to test whether or not the method completed its task.
 * 
 */

package com.example.mmowgli_backend;

import java.sql.*;
import java.util.Properties;

import com.example.mmowgli_explore.CardView;
import com.example.mmowgli_updates.BaseCardView;


public class MmowgliDB 
{	
	/**
	 * *********************** PRIVATE CLASS VARIABLES BELOW ***********************
	 */
	
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final static String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final static String password = "root";

	/** The name of the computer running MySQL */
	private final static String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final static int portNumber = 3306;

	/** The name of the database */
	private final static String dbName = "mmowgli";
	
	/** The number of top card results to return */
	private static int topCards = 5;
	
	/** The number of top tag results to return */
	private static int topTags = 15;
	
	
	
	/**
	 * *********************** HELPER METHODS BELOW ***********************
	 */
	
	/**
	 * openConnection - Helper method that establishes a connection to the database.
	 * It takes the parameter of a specific connection and the query that goes
	 * with that function call for error tracking.
	 */

	private static Connection openConnection(Connection conn, String query)
	{
		try {
			
			/** The properties of the connection are established using the 
			 * private variables set in the header of the class.
			 */
			Properties connectionProps = new Properties();
			connectionProps.put("user", userName);
			connectionProps.put("password", password);
			
			/** The connection to the database is established by forming the
			 * url address using the private variables set in the header of the class.
			 */
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://"
					+ serverName + ":" + portNumber + "/" + dbName,
					connectionProps);
		}
		catch (Exception e) 
		{
			/** If the connection fails, the query is printed along with a trace. */
			System.out.println(query);
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * closeConnection - Helper method that closes the connection to the database.
	 */
	private static void closeConnection(Connection conn)
	{
		try
		{
			conn.close();
			conn = null;
		}
		catch (Exception e) 
		{

		}
	}
	
	/**
	 * getCardResults - a helper method that takes in a result set as a parameter
	 * and returns a Card object containing one set of results.
	 */
	private static Card getCardResults(ResultSet results) throws SQLException
	{
		/** The Card is initialized with the values from the result set */
		Card tempCard = new Card(results.getInt(1), results.getInt(2), results.getString(3), 
				results.getString(4), results.getInt(5), results.getInt(6), results.getTimestamp(7));
		
		return tempCard;
	}
	
	/**
	 * getTagResults - a helper method that takes in a result set as a parameter
	 * and returns a String containing one set of tag results.
	 */
	private static String getTagResults(ResultSet results) throws SQLException
	{
		/** The Card is initialized with the values from the result set */
		String tag = results.getString(1);
		
		return tag;
	}
	
	/**
	 * getPlayerResults - a helper method that takes in a result set as a parameter
	 * and returns a Player object containing one set of results.
	 */
	private static Player getPlayerResults(ResultSet results) throws SQLException
	{
		/** The Card is initialized with the values from the result set */
		Player tempPlayer = new Player(results.getInt(1), results.getString(2), results.getInt(3), 
				results.getInt(4), results.getInt(5), results.getInt(6), results.getInt(7), 
				results.getInt(8), results.getInt(9));
		
		return tempPlayer;
	}
	
	
	/**
	 * *********************** RESULT QUERIES BELOW ***********************
	 */
	
	/**
	 * oneCardQuery - Returns the top X cards in the database according to rating.
	 * X is designated by the private variable: topCards in the header of the class;
	 */
	public static Card oneCardQuery(int idNum) throws SQLException 
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the top rated cards in the database */
		String query = ""
				+ "select CardID, PlayerID, TextUser, CardType, Parent, Votes, Time "
				+ "from card "
				+ "where CardID = " + idNum +"";

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty card list */
		if (!results.next())
		{
			/** The connection is closed before returning a blank Card */
			closeConnection(conn);
			Card blankCard = new Card();
			return blankCard;
		}
		else 
		{
			/** A card object is created and set to the values of the query results */
			Card singleCard = getCardResults(results);
			/** The connection is closed before returning the card */
			closeConnection(conn);
				
			return singleCard;
		}
	}
	
	/**
	 * topCardsQuery - Returns the top X cards in the database according to rating.
	 * X is designated by the private variable: topCards in the header of the class;
	 */
	public static CardList topCardsQuery() throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the top rated cards in the database */
		String query = ""
				+ "select CardID, PlayerID, TextUser, CardType, Parent, Votes, Time "
				+ "from card "
				+ "order by Votes desc "
				+ "limit " + topCards +"";
		
		/** A new Card Object linked list is initialized */ 
		CardList cards = new CardList();

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty card list */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return cards;
		}
		else 
		{
			/** The do-while loop gets the first set of results using the helper
			 * method: getResults(). It then passes the returned Card object into
			 * the cards linked list. This repeats until each set of results 
			 * is added to the linked card list.
			 */
			do
			{	
				/** The returned card with a set of results is added to the card object linked list */
				cards.addCard(getCardResults(results));
			}
			while (results.next());		//Continues so long as there are results
		}
			
		/** The connection is closed before returning the cardList */
		closeConnection(conn);
			
		return cards;
	}
	
	/**
	 * topTagsQuery - Returns the top X tags in the database according to popularty.
	 * X is designated by the private variable: topTags in the header of the class;
	 */
	public static TagList topTagsQuery() throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the top most-used tags in the database */
		String query = ""
				+ "select tag, Count(*) as count "
				+ "from tags "
				+ "group by tag "
				+ "order by count desc "
				+ "limit " + topTags +"";
		
		/** A new Tag linked list is initialized */ 
		TagList tags = new TagList();

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty tag list */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return tags;
		}
		else 
		{
			/** The do-while loop gets the first set of results using the helper
			 * method: getResults(). It then passes the returned String into
			 * the cards linked list. This repeats until each set of results 
			 * is added to the linked tag list.
			 */
			do
			{	
				/** The returned tag String is added to the tag linked list */
				tags.addTag(getTagResults(results));
			}
			while (results.next());		//Continues so long as there are results
		}
			
		/** The connection is closed before returning the tag list */
		closeConnection(conn);
			
		return tags;
	}
	
	/**
	 * oneCardTagsQuery - Returns all of the tags for a single card. The card id is
	 * taken as a parameter.  
	 */
	public static TagList oneCardTagsQuery(int cardId) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the top most-used tags in the database */
		String query = ""
				+ "select tag "
				+ "from tags "
				+ "where CardId = " + cardId + "";
		
		/** A new Tag linked list is initialized */ 
		TagList tags = new TagList();

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty tag list */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return tags;
		}
		else 
		{
			/** The do-while loop gets the first set of results using the helper
			 * method: getResults(). It then passes the returned String into
			 * the cards linked list. This repeats until each set of results 
			 * is added to the linked tag list.
			 */
			do
			{	
				/** The returned tag String is added to the tag linked list */
				tags.addTag(getTagResults(results));
			}
			while (results.next());		//Continues so long as there are results
		}
			
		/** The connection is closed before returning the tag list */
		closeConnection(conn);
			
		return tags;
	}
	
	/**
	 * parentCardQuery - Returns the immediate parent of a card. The card id is
	 * taken as a parameter. 
	 */
	public static Card parentCardQuery(int idNum) throws SQLException
	{
		
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the parent ID of the parameter card */
		String query = ""
				+ "select Parent "
				+ "from card "
				+ "where CardID = " + idNum +"";

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return null;
		}
		else
		{
			/** A variable is set to hold the results of the query */
			int parentCardId = results.getInt(1);
			
			/** If the parent card Id is 0, then this is an idea card that has no parent */
			if (parentCardId == 0)
			{
				return null;
			}
			
			/** The parent card is obtained and then returned*/
			Card singleCard = oneCardQuery(parentCardId);	
			
			/** The connection is closed before returning the card */
			closeConnection(conn);
					
			return singleCard;
		}
	}

	/**
	 * allParentQuery - Returns all of the parents of a card until a root card. The card id is
	 * taken as a parameter. This method uses other methods to generate the list of 
	 * parents and does not run any of its own queries.
	 */
	public static CardList allParentQuery(int idNum) throws SQLException
	{
		/** sets a local variable to hold the initial card's id */
		int tempId = idNum;
		
		/** Creates a card list to hold all of the parent cards generated */
		CardList allParents = new CardList();
		
		/** Creates a card object to hold the value of the returned current card */
		Card currentCard = oneCardQuery(idNum);
		

		/** If there is no parent because the passed in card is an Idea card
		 * then the function simply returns an empty list.
		 */
		if(currentCard.parent == 0)
		{
			return allParents;
		}
		else
		{
			/** The while loop continues until a root card is found */
			while(!(currentCard.parent == 0))
			{
				/** A card object is set to hold the value of the parent */
				Card parentCard = parentCardQuery(tempId);
				/** The parent card is added to the list */
				allParents.addCard(parentCard);
				/** The tempId is set to the ID of the parent card for the next loop */
				tempId = parentCard.cardId;
				/** Current card is set to the parent card */
				currentCard = parentCard;
			}
		}
		/** Returns the list of all parent cards */
		return allParents;
	}
	
	/**
	 * allSiblingsQuery - Returns all of the siblings of a card in a list. The card ID is
	 * taken as a parameter.
	 */
	public static CardList allSiblingQuery(int idNum) throws SQLException
	{
		
		/**Connection object created */
		Connection conn = null;
		
		/** Card object holds the value of the card returned from the id */
		Card tempCard = oneCardQuery(idNum);
		
		/** parentId holds the value of the card's parent */ 
		int parentId = tempCard.parent;
		
		String query = null;
		
		/** Checks to see if a card is a root card. If so, it returns only cards
		 * of the same root origin type.
		 */
		if(tempCard.cardType.equals("Root1"))
		{
			/**Hard-coded query - returns ONLY all of the siblings of a card */
			query = ""
					+ "select CardID, PlayerID, TextUser, CardType, Parent, Votes, Time "
					+ "from card "
					+ "where CardType = 'Root1'";
		}
		
		/** Checks to see if a card is a root card. If so, it returns only cards
		 * of the same root origin type.
		 */
		else if(tempCard.cardType.equals("Root2"))
		{
			/**Hard-coded query - returns ONLY all of the siblings of a card */
			query = ""
					+ "select CardID, PlayerID, TextUser, CardType, Parent, Votes, Time "
					+ "from card "
					+ "where CardType = 'Root2'";
		}
		else
		{
			/**Hard-coded query - returns ONLY all of the siblings of a card */
			query = ""
					+ "select CardID, PlayerID, TextUser, CardType, Parent, Votes, Time "
					+ "from card "
					+ "where Parent = " + parentId + "";
		}
		
		/** A new Card Object linked list is initialized */ 
		CardList cards = new CardList();

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty card list */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return cards;
		}
		else 
		{
			/** The do-while loop gets the first set of results using the helper
			 * method: getResults(). It then passes the returned Card object into
			 * the cards linked list. This repeats until each set of results 
			 * is added to the linked card list.
			 */
			do
			{	
				/** The returned card with a set of results is added to the card object linked list */
				cards.addCard(getCardResults(results));
			}
			while (results.next());		//Continues so long as there are results
		}
			
		/** The connection is closed before returning the cardList */
		closeConnection(conn);
			
		return cards;
	}
	
	/**
	 * allChildrenQuery - Returns all of the direct children of a card in a list. The card ID is
	 * taken as a parameter.
	 */
	public static CardList allChildrenQuery(int idNum) throws SQLException
	{
		
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns all of the direct children of a card */
		String query = ""
				+ "select CardID, PlayerID, TextUser, CardType, Parent, Votes, Time "
				+ "from card "
				+ "where Parent = " + idNum + " "
				+ "order by Votes asc ";
		
		/** A new Card Object linked list is initialized */ 
		CardList cards = new CardList();

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty card list */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return cards;
		}
		else 
		{
			/** The do-while loop gets the first set of results using the helper
			 * method: getResults(). It then passes the returned Card object into
			 * the cards linked list. This repeats until each set of results 
			 * is added to the linked card list.
			 */
			do
			{	
				/** The returned card with a set of results is added to the card object linked list */
				cards.addCard(getCardResults(results));
			}
			while (results.next());		//Continues so long as there are results
		}
			
		/** The connection is closed before returning the cardList */
		closeConnection(conn);
			
		return cards;
	}
	
	/**
	 * recentCardsQuery - Returns the most recent X cards played as denoted by the private variable topCards.
	 */
	public static CardList recentCardsQuery() throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the most recent cards entered in the database up to topCards */
		String query = ""
				+ "select CardID, PlayerID, TextUser, CardType, Parent, Votes, Time "
				+ "from card "
				+ "order by Time desc "
				+ "limit " + topCards +"";
		
		/** A new Card Object linked list is initialized */ 
		CardList cards = new CardList();

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty card list */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return cards;
		}
		else 
		{
			/** The do-while loop gets the first set of results using the helper
			 * method: getResults(). It then passes the returned Card object into
			 * the cards linked list. This repeats until each set of results 
			 * is added to the linked card list.
			 */
			do
			{	
				/** The returned card with a set of results is added to the card object linked list */
				cards.addCard(getCardResults(results));
			}
			while (results.next());		//Continues so long as there are results
		}
			
		/** The connection is closed before returning the cardList */
		closeConnection(conn);
			
		return cards;
	}
	
	/**
	 * trendingCardsQuery - Returns the top X cards as denoted by the private variable topCards,
	 * sorted by vote, and within a specific time frame between "current time" and X hours ago.
	 */
	public static CardList trendingCardsQuery(int timePeriod) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the most recent cards entered in the database up to topCards */
		String query = ""
				+ "select CardID, PlayerID, TextUser, CardType, Parent, Votes, Time "
				+ "from card "
				+ "where Time between date_sub(now(), interval " + timePeriod + " hour) and now() "
				+ "order by Votes desc "
				+ "limit " + topCards +"";
		
		/** A new Card Object linked list is initialized */ 
		CardList cards = new CardList();

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty card list */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return cards;
		}
		else 
		{
			/** The do-while loop gets the first set of results using the helper
			 * method: getResults(). It then passes the returned Card object into
			 * the cards linked list. This repeats until each set of results 
			 * is added to the linked card list.
			 */
			do
			{	
				/** The returned card with a set of results is added to the card object linked list */
				cards.addCard(getCardResults(results));
			}
			while (results.next());		//Continues so long as there are results
		}
			
		/** The connection is closed before returning the cardList */
		closeConnection(conn);
			
		return cards;
	}
	
	/**
	 * trendingTagsQuery - Returns the top X tags as denoted by the private variable topTags and
	 * ordered by the most used tags within a specific time frame between "current time" and X hours ago.
	 */
	public static TagList trendingTagsQuery(int timePeriod) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the most used tags entered in the database up to topCards
		 * and between the time period of current time and current time minus X hours (param)
		 */
		String query = ""
				+ "select tag, Count(*) as count "
				+ "from tags "
				+ "where Time between date_sub(now(), interval " + timePeriod + " hour) and now() "
				+ "group by tag "
				+ "order by count desc "
				+ "limit " + topTags +"";
		
		/** A new Tag Object linked list is initialized */ 
		TagList tags = new TagList();

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty card list */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return tags;
		}
		else 
		{
			/** The do-while loop gets the first set of results using the helper
			 * method: getResults(). It then passes the returned Card object into
			 * the cards linked list. This repeats until each set of results 
			 * is added to the linked card list.
			 */
			do
			{	
				/** The returned tag String is added to the tag linked list */
				tags.addTag(getTagResults(results));
			}
			while (results.next());		//Continues so long as there are results
		}
			
		/** The connection is closed before returning the tag list */
		closeConnection(conn);
			
		return tags;
	}
	
	/**
	 * playerQuery - Returns the data stored for a single player and takes the player ID as a parameter.
	 */
	public static Player playerQuery(int idNum) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the top rated cards in the database */
		String query = ""
				+ "select PlayerID, PlayerName, Points, History1, History2, History3, History4, History5, Hindex "
				+ "from player "
				+ "where PlayerID = " + idNum +"";

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns null */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return null;
		}
		else 
		{
			/** A player object is created and set to the values of the query results */
			Player player = getPlayerResults(results);
			
			/** The connection is closed before returning the player */
			closeConnection(conn);
				
			return player;
		}
	}
	
	/**
	 * taggedCardsQuery - Returns all the cards that have the same tag an takes the tag as a parameter.
	 */
	public static CardList taggedCardsQuery(String tag) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns all the cards with the same tag */
		String query = ""
				+ "select card.CardID, card.PlayerID, card.TextUser, card.CardType, card.Parent, card.Votes, card.Time "
				+ "from card JOIN tags on card.CardID = tags.CardID "
				+ "where tag = '" + tag + "'";
		
		/** A new Card Object linked list is initialized */ 
		CardList cards = new CardList();

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty card list */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return cards;
		}
		else 
		{
			/** The do-while loop gets the first set of results using the helper
			 * method: getResults(). It then passes the returned Card object into
			 * the cards linked list. This repeats until each set of results 
			 * is added to the linked card list.
			 */
			do
			{	
				/** The returned card with a set of results is added to the card object linked list */
				cards.addCard(getCardResults(results));
			}
			while (results.next());		//Continues so long as there are results
		}
			
		/** The connection is closed before returning the cardList */
		closeConnection(conn);
			
		return cards;
	}
	
	/**
	 * checkVoteQuery - Checks the status of a player's vote. The function takes the player ID
	 * and the card ID as parameters and then returns the value of the player's vote. If the player
	 * has never voted on the card, the function returns an integer value of "100," otherwise, 
	 * it returns the value of the player's vote, which will be 1, -1, or 0 once the player
	 * has voted.
	 */
	public static int checkVoteQuery(int playerId, int cardId) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		int vote;
		
		/**Hard-coded query - returns the top rated cards in the database */
		String query = ""
				+ "select vote "
				+ "from voting "
				+ "where PlayerID = " + playerId + " and CardID = " + cardId + "";

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the vote count as 0 */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			
			/** returns 100 as an "impossible" vote value to show that no vote exists */
			return vote = 100;
		}
		else 
		{
			/** A card object is created and set to the values of the query results */
			vote = results.getInt(1);
			
			/** The connection is closed before returning the card */
			closeConnection(conn);
				
			return vote;
		}
	}
	
	/**
	 * checkFavoriteQuery - Returns a boolean value of true or false if the card is a favorite
	 * of the user and it is an entry in the database.
	 */
	public static boolean checkFavoriteQuery(int cardId, int playerId) throws SQLException 
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the top rated cards in the database */
		String query = ""
				+ "select CardID, PlayerID "
				+ "from favorites "
				+ "where CardID = " + cardId + " and PlayerID = " + playerId + "";

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns false is the entry does not exist */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			
			return false;
		}
		else 
		{
			/** The connection is closed before returning true */
			closeConnection(conn);
				
			return true;
		}
	}
	
	/**
	 * playerFavoriteQuery - Returns all cards that a player has added as a favorite in the form of a list.
	 * It takes the player ID as a parameter.
	 */
	public static CardList playerFavoriteQuery(int playerId) throws SQLException 
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the top rated cards in the database */
		String query = ""
				+ "select card.CardID, card.PlayerID, card.TextUser, card.CardType, card.Parent, card.Votes, card.Time "
				+ "from card JOIN favorites on card.CardID = favorites.CardID "
				+ "where favorites.PlayerID = " + playerId + "";

		/** The connection to the database is opened */
		conn = openConnection(conn, query);
		
		/** A new Card Object linked list is initialized */ 
		CardList cards = new CardList();

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns the empty card list */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return cards;
		}
		else 
		{
			/** The do-while loop gets the first set of results using the helper
			 * method: getResults(). It then passes the returned Card object into
			 * the cards linked list. This repeats until each set of results 
			 * is added to the linked card list.
			 */
			do
			{	
				/** The returned card with a set of results is added to the card object linked list */
				cards.addCard(getCardResults(results));
			}
			while (results.next());		//Continues so long as there are results
		}
			
		/** The connection is closed before returning the cardList */
		closeConnection(conn);
			
		return cards;
	}
	
	/**
	 * playerHistoryQuery - Returns up to 5 cards that a player has recently viewed in the form of a list.
	 * It takes the player ID as a parameter.
	 */
	public static CardList playerHistoryQuery(int playerId) throws SQLException 
	{
		Player player = playerQuery(playerId);
		
		/** An array is created to hold the card ID's in the player's history in order */
		int [] cardArray = new int [] {player.history1, player.history2, player.history3, player.history4, player.history5};

		
		/** A new Card Object linked list is initialized */ 
		CardList cards = new CardList();
		
		/** The loop passes in each card Id from the history in the order of the 
		 * history and then adds each card to a Card List. If the history has an empty
		 * slot, that query for that slot is not executed.
		 */
		for(int i = 0; i < 5; i++)
		{
			if(cardArray[i] == 0)
			{
				continue;
			}
			else
			{
				Card historyCard = oneCardQuery(cardArray[i]);
				
				cards.addCard(historyCard);
			}
		}
		
		return cards;
	}
	
	/**
	 * lastCardQuery - Returns the ID of the last card played 
	 */
	public static int lastCardQuery() throws SQLException
	{

        int lastCardId = 0;	/**To hold the ID of the last card played */

		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - returns the last card ID entered in the database */
		String query = ""
				+ "select CardID "
				+ "from card "
				+ "order by CardID desc "
				+ "limit 1 ";

		/** The connection to the database is opened */
		conn = openConnection(conn, query);

		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The Result Set is initialized and set to receive the returned query results */
		ResultSet results = stmnt.executeQuery(query);
		
		/**Checks if the result set is empty and returns 0 */
		if (!results.next())
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return lastCardId;
		}
		else 
		{
			/** Assigns the cardID of the last card in the database to the variable */
			lastCardId = results.getInt(1);
		}
			
		/** The connection is closed before returning the id of the last card */
		closeConnection(conn);
			
		return lastCardId;
	}
	
	/**
	 * *********************** INSERTION QUERIES BELOW ***********************
	 */
	
	/**
	 * addCardQuery - Adds a single card to the database.
	 */
	public static boolean addCardQuery(Card card) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Checks first to see if the card is a valid type */
		if(card.cardType.equals("Idea1") || card.cardType.equals("Idea2") ||card.cardType.equals("Root1") || card.cardType.equals("Root2") || card.cardType.equals("Expand") || card.cardType.equals("Adapt") || card.cardType.equals("Counter") || card.cardType.equals("Explore"))
		{
			
			/**Hard-coded query - to insert the new card into the database */
			String query = ""
					+ "insert into card (CardID, PlayerID, TextUser, CardType, Parent, Votes, Time) "
					+ "values (" + card.cardId + ", " + card.playerId + ", '" + card.textUser + "', '" 
					+ card.cardType + "', " + card.parent + ", " + card.votes + ", '" + card.time + "') ";
			
			/** The connection to the database is opened */
			conn = openConnection(conn, query);
			
			/** A statement object is initialized from the connection to execute the query */
			Statement stmnt = conn.createStatement();
			
			/** The query is executed to add the card */
			stmnt.executeUpdate(query);
			stmnt.close();
			stmnt = null;
			
			/** The connection is closed before returning */
			closeConnection(conn);
			return true;
		}
		else //insertion failed
		{
			/** The connection is closed before returning */
			closeConnection(conn);
			return false;
		}
		
	}
	
	/**
	 * addTagsQuery - adds all of input tags to a card. 
	 */
	public static boolean addTagsQuery(TagList tags, int cardId, Timestamp time) throws SQLException
	{
		if(tags.isEmpty())
		{
			return false;
		}
		
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - to insert the new card into the database */
		String query = null;
		
		/** The connection to the database is opened */
		conn = openConnection(conn, query);
		
		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** A variable to test if the statement executes */
		int update = 0;
		
		while(!tags.isEmpty())
		{
			String tempTag = tags.getTag();
			
			query = "insert into tags (tag, CardID, time)"
					+ "values ('" + tempTag + "', " + cardId + ", '" + time + "')";
			
			/** The Result Set is initialized and set to receive the returned query results */
			update = stmnt.executeUpdate(query);
		}
		stmnt.close();
		stmnt = null;
		
		/** The connection is closed before returning */
		closeConnection(conn);

		/** a 1 means the query execution was successful */
		if(update == 1)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * addCardAndTagsQuery - adds a card and tags for that card at the same time
	 * by calling on the individual methods for each. 
	 */
	public static boolean addCardAndTagsQuery(Card card, TagList tags) throws SQLException
	{
		/** Adds the card to the database and assigns the true/false success or failure */
		boolean cardSuccess = addCardQuery(card);
		
		/** Adds the tags to the database and assigns the true/false success or failure */
		boolean tagSuccess = addTagsQuery(tags, card.cardId, card.time);
		
		/** If both table insertions succeeded then the function returns true */
		if(cardSuccess && tagSuccess)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * addPlayerQuery - adds a player to the database and takes 3 parameters:
	 * player ID, player name, and points. The rest of the parameters are initialized automatically.
	 */
	public static boolean addPlayerQuery(int playerId, String playerName, int points) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - to insert the new player into the database */
		String query = ""
				+ "insert into player (PlayerID, PlayerName, Points, History1, History2, History3, History4, History5, Hindex)"
				+ "values (" + playerId + ", '" + playerName + "', " + points + ", 0, 0, 0, 0, 0, 0)";
		
		/** The connection to the database is opened */
		conn = openConnection(conn, query);
		
		
		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The function first checks if this player already exists */
		Player testPlayer = playerQuery(playerId);
		
		/** If the player already exists, the player is not added and the query is never made */
		if(testPlayer != null)
		{
			return false;
		}
		
		/** The query is executed */
		int update = stmnt.executeUpdate(query);
		
		/** The connection is closed before returning */
		closeConnection(conn);

		/** a 1 means the query execution was successful */
		if(update == 1)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * addVoteQuery - adds a new entry into the voting table for new votes or updates the voting table.
	 * The function always updates the total card votes in the card table when any vote is entered.
	 * The function takes the player ID, card ID, and the Vote value between -1 and 1
	 */
	public static boolean addVoteQuery(int playerId, int cardId, int vote) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/** Blank String variables to hold the two different queries*/
		String query1 = null;	//Holds the query that updates the vote table
		String query2 = null;	//Holds the query that updates the card table
		
		/** The connection to the database is opened */
		conn = openConnection(conn, query1);
		
		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The function first checks if this player already voted on a certain card */
		int previousVote = checkVoteQuery(playerId, cardId);
		
		/** Checks if the player has entered in the same vote and makes sure that
		 * any vote entered is a -1, 0, or 1, otherwise the function does not update anything.
		 */
		if(previousVote == vote || vote > 1 || vote < -1)
		{
			return false;
		}
		/** 100 signals that the player is voting on a card for the first time.
		 * If the value of the player's previous vote is not 100, then the player has voted before
		 */
		if(previousVote != 100)
		{
			/**Hard-coded query - updates the player's vote in the vote table to whatever was entered*/
			query1 = ""
					+ "update voting "
					+ "set vote = " + vote + ", time = now()"
					+ "where PlayerID = " + playerId + " and CardID = " + cardId + "";
			
			/**If the player entered a 0, then the card total vote needs to be calculated
			 * by subtracting the previous vote. This "resets" the card's vote to what it 
			 * was prior to the player voting.
			 */
			if(vote == 0)
			{
				System.out.println("First Query 2\n");
				query2 = ""
						+ "update card "
						+ "set votes = votes - " + previousVote + " "
						+ "where CardID = " + cardId + "";
			}
			/** If the player previously voted a -1 and then voted a 1, the card's total
			 * needs to get updated by + 2
			 */
			else if(vote == 1 && previousVote == -1)
			{
				query2 = ""
						+ "update card "
						+ "set votes = votes + 2 "
						+ "where CardID = " + cardId + "";
			}
			/** If the player previously voted a 1 and then voted a -1, the card's total
			 * needs to get updated by - 2
			 */
			else if(vote == -1 && previousVote == 1)
			{
				query2 = ""
						+ "update card "
						+ "set votes = votes - 2 "
						+ "where CardID = " + cardId + "";
			}
			/** This clause acts as a catchall just in case the previous vote was a 0 
			 * and the new vote is a 1 or -1. It just adds the new vote to the card total.
			 */
			else
			{
				query2 = ""
						+ "update card "
						+ "set votes = votes + " + vote + " "
						+ "where CardID = " + cardId + "";
			}
		}
		/** If the player is voting for the first time, then a new entry goes into the database*/
		else 
		{
			/**Hard-coded query - adds a vote in for a player on a specific card to the voting table */
			query1 = ""
					+ "insert into voting (CardID, PlayerID, Vote, Time) "
					+ "values (" + cardId + ", " + playerId + ", " + vote + ", now())";
			
			/**Hard-coded query - updates the total vote in the card table */
			query2 = ""
					+ "update card "
					+ "set votes = votes + " + vote + " "
					+ "where CardID = " + cardId + "";
		}
		
		/** The first query is executed */
		int update1 = stmnt.executeUpdate(query1);
		
		/** The second query is executed */
		int update2 = stmnt.executeUpdate(query2);
		
		/** The connection is closed before returning */
		closeConnection(conn);

		/** a 1 means the query execution was successful */
		if(update1 == 1 && update2 == 1)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * addFavoriteQuery - Adds a card as a favorite for a specific player and returns true
	 * if successful. Takes a card ID and Player ID as paramaters.
	 */
	public static boolean addFavoriteQuery(int cardId, int playerId) throws SQLException
	{
		/**Checks whether an entry exists in the favorite table for this player and the card. 
		 * If the card exists in the table, then the method returns false */
		if(checkFavoriteQuery(cardId, playerId) == true)
		{
			return false;
		}
		else
		{
			/**Connection object created */
			Connection conn = null;
			
			/**Hard-coded query - to insert the new card into the database */
			String query = ""
					+ "insert into favorites (CardID, PlayerID, time) "
					+ "values (" + cardId + ", " + playerId + ", now())";
			
			/** The connection to the database is opened */
			conn = openConnection(conn, query);
			
			/** A statement object is initialized from the connection to execute the query */
			Statement stmnt = conn.createStatement();
			
			/** The query is executed */
			int update = stmnt.executeUpdate(query);
			
			/** The connection is closed before returning */
			closeConnection(conn);

			/** a 1 means the query execution was successful */
			if(update == 1)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		
	}
	
	/**
	 * addPlayerHistoryQuery - Adds a card to the player's history. Takes the player Id and card Id
	 * as parameters.
	 */
	public static boolean addPlayerHistoryQuery(int cardId, int playerId) throws SQLException
	{
		/** Returns the player object from the id passed in as a parameter*/
		Player player = playerQuery(playerId);
		
		/** Each card ID in the history is assigned to an integer */
		int card1 = player.history1;
		int card2 = player.history2;
		int card3 = player.history3;
		int card4 = player.history4;
		int card5 = player.history5;
		int index = player.hIndex;
		
		String query = null;
		
		/** Checks to see if the card is already in the player history. If so, the function returns true
		 * as if it was successful.
		 */
		if(cardId == card1 || cardId == card2 || cardId == card3 || cardId == card4 || cardId == card5)
		{
			return true;
		}
		
		/** Checks the status of the index, which must be a value between 1 and 5. If the index is
		 * 5, then the card histories shift up in position (e.g. history2 becomes history1) and
		 * the last history slot (#5) is replaced with the new card. This creates a cycle in the history
		 * so that the newest card is always last and the oldest card is first (up to 5 cards).
		 */
		else if (index == 5)
		{
			query = ""
					+ "update player "
					+ "set History1 = " + card2 + ", History2 = " + card3 + ", History3 = " + card4 + ", History4 = " + card5 + ", History5 = " + cardId + " "
					+ "where PlayerID = " + playerId + "";
		}
		/** If the index is not yet 5, then it should increase by 1 before placing a card in the history */
		else
		{
			index++;
			
			query = ""
					+ "update player "
					+ "set Hindex = " + index + ", History" + index + " = " + cardId + " "
					+ "where PlayerID = " + playerId + "";
		}
		
		/**Connection object created */
		Connection conn = null;
			
		/** The connection to the database is opened */
		conn = openConnection(conn, query);
			
		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
			
		/** The query is executed */
		int update = stmnt.executeUpdate(query);
		
		/** The connection is closed before returning */
		closeConnection(conn);

		/** a 1 means the query execution was successful */
		if(update == 1)
		{
				return true;
		}
		else 
		{
				return false;
		}
	}
	
	
	
	/**
	 * *********************** DELETE QUERIES BELOW ***********************
	 */
	
	/** 
	 * deleteCard - Deletes a card and all of its data, minus the tags
	 */
	public static boolean deleteCard(int cardId) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - deletes a specific card from the database */
		String query = "delete from card "
				+ "where CardID = " + cardId + " ";
		
		/** The connection to the database is opened */
		conn = openConnection(conn, query);
		
		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The query is executed to delete the card */
		int update = stmnt.executeUpdate(query);
		
		/** The connection is closed before returning */
		closeConnection(conn);
		
		if(update == 0 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/** 
	 * deleteTags - Deletes all of the tags associated with a card ID, but not the card itself
	 */
	public static boolean deleteTags(int cardId) throws SQLException
	{
		
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - to delete all tags for a specific card */
		String query = "delete from tags "
				+ "where CardID = " + cardId + " ";
		
		/** The connection to the database is opened */
		conn = openConnection(conn, query);
		
		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The query is executed to delete the tags from a certain card */
		int update = stmnt.executeUpdate(query);
		
		/** The connection is closed before returning */
		closeConnection(conn);
		
		if(update == 0 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/** 
	 * deletePlayer - Deletes a player from the database
	 */
	public static boolean deletePlayer(int playerId) throws SQLException
	{
		
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - to delete a specific player from the database */
		String query = "delete from player "
				+ "where PlayerID = " + playerId + " ";
		
		/** The connection to the database is opened */
		conn = openConnection(conn, query);
		
		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The query is executed */
		int update = stmnt.executeUpdate(query);
		
		/** The connection is closed before returning */
		closeConnection(conn);
		
		/** a 0 means the query execution was successful */
		if(update == 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	/** 
	 * deleteFavorite - Deletes a card id and player id from the favorites table to indicate
	 * that a card is no longer a favorite.
	 */
	public static boolean deleteFavorite(int cardId, int playerId) throws SQLException
	{
		/**Checks whether an entry exists in the favorite table for this player and the card. 
		 * If the card does not exist in the table, then the method returns true
		 * as if the card was deleted because it was not in the database */
		if(checkFavoriteQuery(cardId, playerId) == false)
		{
			return true;
		}
		/** The entry does exist in the table and so it should be deleted */
		else
		{
			/**Connection object created */
			Connection conn = null;
			
			/**Hard-coded query - to delete a specific player from the database */
			String query = "delete from favorites "
					+ "where PlayerID = " + playerId + " and CardID = " + cardId + "";
			
			/** The connection to the database is opened */
			conn = openConnection(conn, query);
			
			/** A statement object is initialized from the connection to execute the query */
			Statement stmnt = conn.createStatement();
			
			/** The query is executed */
			int update = stmnt.executeUpdate(query);
			
			/** The connection is closed before returning */
			closeConnection(conn);
			
			/** a 0 means the query execution was successful */
			if(update == 0)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
	}

	/** 
	 * deletePlayerHistory - Deletes the plyaer's history and takes the player ID as a paramater.
	 */
	public static boolean deletePlayerHistory(int playerId) throws SQLException
	{
		/**Connection object created */
		Connection conn = null;
		
		/**Hard-coded query - to set the player's history to 0's as if blank */
		String query = ""
				+ "update player "
				+ "set History1 = 0, History2 = 0, History3 = 0, History4 = 0, History5 = 0, HIndex = 0 "
				+ "where PlayerID = " + playerId + "";
		
		/** The connection to the database is opened */
		conn = openConnection(conn, query);
		
		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
		
		/** The query is executed */
		int update = stmnt.executeUpdate(query);
		
		/** The connection is closed before returning */
		closeConnection(conn);
		
		/** a 0 means the query execution was successful */
		if(update == 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/** 
	 * deleteDatabase - Deletes the entire database.
	 */
	public static boolean deleteDatabase() throws SQLException
	{
		
		/**Connection object created */
		Connection conn = null;
			
		/**Hard-coded query - to delete all cards from the database */
		String query1 = "truncate table card ";
		
		/**Hard-coded query - to delete all favorites from the database */
		String query2 = "truncate table favorites ";
		
		/**Hard-coded query - to delete all players from the database */
		String query3 = "truncate table player ";
		
		/**Hard-coded query - to delete all tags from the database */
		String query4 = "truncate table tags ";
		
		/**Hard-coded query - to delete all votes from the database */
		String query5 = "truncate table voting ";
		
			
		/** The connection to the database is opened */
		conn = openConnection(conn, query1);
			
		/** A statement object is initialized from the connection to execute the query */
		Statement stmnt = conn.createStatement();
			
		/** The queries are executed and all table rows are deleted from all tables */
		int update1 = stmnt.executeUpdate(query1);
		int update2 = stmnt.executeUpdate(query2);
		int update3 = stmnt.executeUpdate(query3);
		int update4 = stmnt.executeUpdate(query4);
		int update5 = stmnt.executeUpdate(query5);
		
		/** The connection is closed before returning */
		closeConnection(conn);
			
		/** a 1 means the query execution was successful */
		if(update1 == 0 && update2 == 0 && update3 == 0 && update4 == 0 && update5 == 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

}

