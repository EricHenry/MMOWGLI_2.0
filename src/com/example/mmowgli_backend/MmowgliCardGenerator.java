/*
 * Program Name: Mmowgli2CardGenerator
 * Author: Ben Clough
 * Date Modified: 4/6/15
 *
 * Generates random cards for example Mmowgli2 games.
 *
 * Requires two text files - one for card text, the other for a tags list.
 *
 * Allows the user to specify the number of cards to generate.
 */

package com.example.mmowgli_backend;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MmowgliCardGenerator {
	public static void main(String[] args) {
		RandomCardFrame randomCardFrame = new RandomCardFrame();
		randomCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		randomCardFrame.setSize(250, 200);
		randomCardFrame.setResizable(false);
		randomCardFrame.setVisible(true);
	}

	/* Populates the database with randomly generated, example cards. */
	public static void GenerateCards(int nCards, int nRoots, int nPlayers, int maxVotes, 
		File textFile, File tagsFile)
	{
		String cardTypes[] = { "Explore", "Adapt", "Counter", "Expand" }; // array of card types
		String cardTags[] = null; // array of tags
		String cardText[] = null; // array of card text
		Random rand = new Random(); // need a random number generator
		int noTags = 0; // number of tags defaults to 0, actually number in the file
		BufferedReader br = null; // for reading the card text input
		Scanner sc = null; // for reading in the tags list

		/* Values for random timestamp generation, kinda arbitrary. */
		long offset = Timestamp.valueOf("2015-01-01 00:00:00").getTime();
		long end = Timestamp.valueOf("2015-04-01 00:00:00").getTime();
		long diff = end - offset + 1;

		/* Useful for debugging really. */
		System.out.println("Generating " + nCards + " cards with " + nRoots + 
			" root cards and " + nPlayers + " players, and a maximum of " + maxVotes + " votes per card.");

		/* First, clear the database of previous entries. */
		try {
			MmowgliDB.deleteDatabase();
		} catch (Exception sqlException) {
			System.out.println("Something went wrong with the database.");
			System.exit(1);
		}

		/* Add a number of players. */
		for (int i=0; i < nPlayers; i++) {
			try {
				MmowgliDB.addPlayerQuery(i, "user" + i, 0);
			} catch (Exception sqlException) {
				System.out.println("Something went wrong with the database.");
				System.exit(1);
			}
		}

		/* Read the tags from the file. */
		try { sc = new Scanner(tagsFile); } catch (Exception e) { }
		while (sc.hasNextLine() ) {		// count number of tags in file
			noTags++;
			sc.nextLine();
		}
		cardTags = new String[noTags];	// string array of tags
		try { sc = new Scanner(tagsFile); } catch (Exception e) { }
		for (int z = 0; z < noTags; z++)
			cardTags[z] = sc.nextLine(); // each line is a tag

		/* Read the card text from the file. */
		cardText = new String[nCards];
		try {
			br = new BufferedReader(new FileReader(textFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int n = 0; n < nCards; n++) {
			StringBuilder str = new StringBuilder("");
			int c = 0;

			/* Read next 150 characters, loop to beginning if file ends */
			for (int o = 0; (o < 150); o++) {
				/* Read a single character from file. */
				try { c = br.read(); } catch (Exception e) { }
				if (c==' ' || c=='\n')
					str.append(" ");
				else if (Character.isLetter(c))
					str.append((char) c); // append the character to the string

				if (c == -1)
					try {
						br = new BufferedReader(new FileReader(textFile));
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
			cardText[n] = str.toString();
			 System.out.println();
			System.out.println(cardText[n]);
		}

		/* Add root cards. */
		for (int j = 0; j < nRoots; j++)
		{
			/* First generate a card. */
			Card rootCard = new Card(
				j, // cardId is whatever iteration we are on
				rand.nextInt(nPlayers), // card playerId is set to random player
				cardText[j], // String textUser
				"Root" + j, // all root cards are cardType "root"
				0, // all root cards have parent 0
				0, // no votes set as of yet
				new Timestamp(offset + (long)(Math.random() * diff)) // Timestamp
			);

			/* Generate a tag list. */
			TagList rootTagList = new TagList();
			for (int l = 0; l < rand.nextInt(5); l++) // random number of tags 1-5
				rootTagList.addTag(cardTags[rand.nextInt(cardTags.length)]); // add a random tag

			/* Call the database manager to add the root card. */
			// MmowgliDB.addCardAndTagsQuery(rootCard, rootTagList);
		}

		/* Add example cards. */
		for (int k = nRoots; k < nCards; k++)
		{
			/* First generate a card. */
			Card exampleCard = new Card(
				k, // cardId is whatever iteration we are on
				rand.nextInt(nPlayers), // card playerId is set to random player
				cardText[k], // String textUser
				cardTypes[rand.nextInt(cardTypes.length)], // random card type
				rand.nextInt(1+(k-1)), // parent card must be a previously added card id 
				0, // no votes as of yet
				new Timestamp(offset + (long)(Math.random() * diff)) // Timestamp
			);

			/* Generate a tag list. */
			TagList exampleTagList = new TagList();
			for (int m = 0; m < rand.nextInt(5); m++) // random number of tags 1-5
				exampleTagList.addTag(cardTags[rand.nextInt(cardTags.length)]); // add a random tag

			/* Call the database manager to add the card. */
			// MmowgliDB.addCardAndtAgsQuery(exampleCard, exampleTagList);
		}


	}

	/* Allows for editing default values for random card generation. */
	static class RandomCardFrame extends JFrame
	{
		/* Variables for card generation. */
		int numberCards = 100; // number of cards to generate
		int numberPlayers = 10; // number of players to generate
		int numberRoots = 10; // number of "root" cards
		int maxVotes = 100; // upper limit for number of votes for a card
		File textFile = null; // user text input read from file
		File tagsFile = null; // card tags read from file

		/* GUI components. */
		JLabel nCardsLabel;
		JLabel nPlayersLabel;
		JLabel nRootsLabel;
		JLabel maxVotesLabel;
		JLabel textFileLabel;
		JLabel tagsFileLabel;
		JTextField nCardsField;
		JTextField nPlayersField;
		JTextField nRootsField;
		JTextField maxVotesField;
		JButton textFileButton;
		JButton tagsFileButton;
		JButton generateButton;
		JButton cancelButton;

		/* Allows the user to edit default values for random generation and select text. */
		private RandomCardFrame()
		{
			setLayout(new FlowLayout() );

			/* Initialize label components. */
			JLabel nCardsLabel = new JLabel("Number of cards:");
			JLabel nPlayersLabel = new JLabel("Number of players:");
			JLabel nRootsLabel = new JLabel("Number of root cards:");
			JLabel maxVotesLabel = new JLabel("Maximum votes:");
			JLabel textFileLabel = new JLabel("Select card text:");
			JLabel tagsFileLabel = new JLabel("Select tags:");

			/*Initialize textfield components. */
			nCardsField = new JTextField(String.format("" + numberCards + ""), 5);
			nPlayersField = new JTextField(String.format("" + numberPlayers + ""), 5);
			nRootsField = new JTextField(String.format("" + numberRoots + ""), 5);
			maxVotesField = new JTextField(String.format("" + maxVotes + ""), 5);

			/* Initialize button components. */
			textFileButton = new JButton("File");
			tagsFileButton = new JButton("File");
			generateButton = new JButton("Generate");
			cancelButton = new JButton("Cancel");

			/* File and button handlers. */
			FileChooserHandler fileChooserHandler = new FileChooserHandler();
			textFileButton.addActionListener(fileChooserHandler);
			tagsFileButton.addActionListener(fileChooserHandler);
			GenerateButtonHandler generateButtonHandler = new GenerateButtonHandler();
			generateButton.addActionListener(generateButtonHandler);
			CancelButtonHandler cancelButtonHandler = new CancelButtonHandler();
			cancelButton.addActionListener(cancelButtonHandler);

			/* Add all GUI components to the frame. */
			add(nCardsLabel);
			add(nCardsField);
			add(nRootsLabel);
			add(nRootsField);
			add(nPlayersLabel);
			add(nPlayersField);
			add(maxVotesLabel);
			add(maxVotesField);
			add(textFileLabel);
			add(textFileButton);
			add(tagsFileLabel);
			add(tagsFileButton);
			add(generateButton);
			add(cancelButton);
		}

		/* Handles picking files for inputting card text and tags. */
		private class FileChooserHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				JFileChooser fileChooser = new JFileChooser();

				int returnValue = fileChooser.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (event.getSource() == textFileButton)
						textFile = fileChooser.getSelectedFile();
					else if (event.getSource() == tagsFileButton)
						tagsFile = fileChooser.getSelectedFile();
				}
			}

		}

		/* Handles the generate button being pressed - generates the example cards. */
		private class GenerateButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				FileReader cardTextStream = null;
				FileReader cardTagsStream = null;

				/* Try to open the selected text file for reading into the example card text. */
				try {
					cardTextStream = new FileReader(textFile);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "No file selected for card text.", "Error",
						JOptionPane.ERROR_MESSAGE);
					return;
				}
				/* Try to open selected text file for reading into the card tags. */
				try {
					cardTagsStream = new FileReader(tagsFile);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "No file selected for card tags.", "Error",
						JOptionPane.ERROR_MESSAGE);
					return;
				}
				/* Close the file streams. */
				try {
					cardTextStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					cardTagsStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				/* Call GenerateCards to populate the database with the example cards -
				 * pass the values as they are given in the text fields and file chooser. */
				GenerateCards(
					Integer.parseInt(nCardsField.getText() ), // number of example cards
					Integer.parseInt(nRootsField.getText() ), // number of root cards
					Integer.parseInt(nPlayersField.getText() ), // number of players
					Integer.parseInt(maxVotesField.getText() ), // upper limit on votes
					textFile, // filestream for user text
					tagsFile  // file for tags
				);

				JOptionPane.showMessageDialog(null, "Added " + nCardsField.getText() + " cards to the database.");

				System.exit(0);
			}
		}

		/* Handles the cancel button being pressed - exits program. */
		private class CancelButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		}
	}
}