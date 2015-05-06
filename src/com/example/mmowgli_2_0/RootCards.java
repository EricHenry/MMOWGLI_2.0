/**
 * @Author: Eric H Correia
 *
 * This class creates a idea card that is clickable. If the idea card is clicked, 
 * 	a popup box appears to create a new root card
 * 
 */

package com.example.mmowgli_2_0;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.example.mmowgli_backend.Card;
import com.example.mmowgli_backend.MmowgliDB;
import com.example.mmowgli_backend.TagList;
import com.example.mmowgli_explore.RootCardCreator;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;

public class RootCards extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private GridLayout mainLayout;

	@AutoGenerated
	private VerticalLayout verticalLayout_idea2;

	@AutoGenerated
	private NativeButton root_button2;

	@AutoGenerated
	private Label label_idea2;

	@AutoGenerated
	private VerticalLayout verticalLayout_idea1;

	@AutoGenerated
	private NativeButton root_button1;

	@AutoGenerated
	private Label label_idea1;

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public RootCards() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		//Set Styling
		
		//root cards formatting
		root_button1.setStyleName("Root1");
		root_button2.setStyleName("Root2");
		
		//verticalLayout_3.setStyleName("center");
		mainLayout.setStyleName("ideaCards");
		//panel_1.setStyleName("borderless");
		
		verticalLayout_idea1.setStyleName("idea1");
		verticalLayout_idea2.setStyleName("idea2");
		
		label_idea1.setStyleName("boldBlack");
		label_idea2.setStyleName("boldBlack");
		
		//Popup stuff
		initPopupView();
		
	}
	
	/**
	 *  Depending on the type of root card created, this function creates the appropriate type of card creator
	 */
	private void initPopupView(){
		PopupView pop1;		
		
		RootCardCreator creator1 = new RootCardCreator();
		creator1.getTabSheet().removeTab(creator1.getTabSheet().getTab(creator1.getVerticalLayout_Root2()));
		
		pop1 = new PopupView(new PopupView.Content(){

			@Override
			public String getMinimizedValueAsHTML() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Component getPopupComponent() {
				// TODO Auto-generated method stub
				return creator1;
			}
					
		});
				
		mainLayout.addComponent(pop1);
		setAddCardButtonListener(pop1, root_button1);
		
		//set submit card listener
		setSubmitNewRootCardButtonListener(creator1, "-1");
		
		
		//second popview
		PopupView pop2;		
		
		RootCardCreator creator2 = new RootCardCreator();
		creator2.getTabSheet().removeTab(creator2.getTabSheet().getTab(creator2.getVerticalLayout_Root1()));
		creator2.getTabSheet().getTab(creator2.getVerticalLayout_Root2()).setStyleName("Root2Main");
		
		pop2 = new PopupView(new PopupView.Content(){

			@Override
			public String getMinimizedValueAsHTML() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Component getPopupComponent() {
				// TODO Auto-generated method stub
				return creator2;
			}
					
		});
				
		mainLayout.addComponent(pop2);
		setAddCardButtonListener(pop2, root_button2);
		setSubmitNewRootCardButtonListener(creator2, "-2");
		
	}
	
	/**
	 * Add Default Click Listener for the Add Card Button
	 */
	private void setAddCardButtonListener(PopupView popup, NativeButton root_button){
		root_button.addClickListener(new NativeButton.ClickListener(){
			
			@Override
			public void buttonClick(ClickEvent event){
				//TODO add a popup window to add a card.
				popup.setPopupVisible(true);
			}
			
		});
		
	}
	
	/**
	 * Sets the listener for the Idea Card Buttons to be able to create new cards.
	 * 
	 * @param creator - Component that appears in the popup box to create a new card
	 * @param id	  - The id of the card that is creating a new card
	 */
	private void setSubmitNewRootCardButtonListener(RootCardCreator creator, String id){
		creator.getNativeButton_submit().addClickListener(new NativeButton.ClickListener(){
			
			@Override
			public void buttonClick(ClickEvent event){
				Card newCard = new Card();
				String newCardType = creator.getTabSheet().getSelectedTab().getCaption();
				String newCardText;
				//String tags;
				
				//System.out.println(newCardTypeString);
				if (newCardType.equalsIgnoreCase("Root1")){
					newCardText = creator.getTextArea_Root1().getValue();
					
					//clear the input
					creator.getTextArea_Root1().setValue("");
					//System.out.println(newCardText);
				} else {
					newCardText = creator.getTextArea_Root2().getValue();
					//System.out.println(newCardText);
					//clear the input
					creator.getTextArea_Root2().setValue("");
				}
				
				//if the card text is not null continue creating the card
				if(!newCardText.equalsIgnoreCase(null) && !newCardText.equalsIgnoreCase("\n") && !newCardText.equalsIgnoreCase("") && !newCardText.equalsIgnoreCase(" ")){
					
					//set an id
					try {
						newCard.cardId = MmowgliDB.lastCardQuery() + 1;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//set the player id -> our test player's id is 0
					newCard.playerId = 0;
					
					//set the card's text
					newCard.textUser = newCardText;
					
					//set the type of card being created.
					newCard.cardType = newCardType;
					
					//set parent's id
					newCard.parent = Integer.parseInt(id);
					
					//add this new card to the DB
					try {
						MmowgliDB.addCardQuery(newCard);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					String tagsList = creator.getTextArea_tags().getValue();
					
					//check to see if there are tags
					if(!tagsList.equalsIgnoreCase("") && !tagsList.equalsIgnoreCase(null) && !tagsList.equalsIgnoreCase("\n")){
						//split the string into idividual tags
						String tags[] = tagsList.split(" ");
						
						//get the time stamp
						java.util.Date now = new java.util.Date();
						Timestamp timeNow = new java.sql.Timestamp(now.getTime());
						
						TagList convertedTags = new TagList();
						
						for(String currentTag : tags){
							//System.out.println("TAG - " + currentTag);
							convertedTags.addTag(currentTag);
						}
						
						//put tag info in Database
						try {
							MmowgliDB.addTagsQuery(convertedTags, newCard.cardId, timeNow);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						creator.getTextArea_tags().setValue("");
					}
					
				}else {
					//tell the user that the field is empty
				}
					
			}
		});
		
	}

	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("150px");
		mainLayout.setMargin(false);
		mainLayout.setColumns(2);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("150px");
		
		// verticalLayout_idea1
		verticalLayout_idea1 = buildVerticalLayout_idea1();
		mainLayout.addComponent(verticalLayout_idea1, 0, 0);
		mainLayout.setComponentAlignment(verticalLayout_idea1,
				new Alignment(48));
		
		// verticalLayout_idea2
		verticalLayout_idea2 = buildVerticalLayout_idea2();
		mainLayout.addComponent(verticalLayout_idea2, 1, 0);
		mainLayout.setComponentAlignment(verticalLayout_idea2,
				new Alignment(48));
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_idea1() {
		// common part: create layout
		verticalLayout_idea1 = new VerticalLayout();
		verticalLayout_idea1.setImmediate(false);
		verticalLayout_idea1.setWidth("-1px");
		verticalLayout_idea1.setHeight("-1px");
		verticalLayout_idea1.setMargin(false);
		
		// label_idea1
		label_idea1 = new Label();
		label_idea1.setImmediate(false);
		label_idea1.setWidth("-1px");
		label_idea1.setHeight("-1px");
		label_idea1.setValue("Idea 1");
		verticalLayout_idea1.addComponent(label_idea1);
		verticalLayout_idea1.setComponentAlignment(label_idea1, new Alignment(
				48));
		
		// root_button1
		root_button1 = new NativeButton();
		root_button1
				.setCaption("Project Gutenbergs The Time Machine by H. G. Herbert George Wells  This eBook is for the use of anyone anywhere at no cost and with almost no ");
		root_button1.setImmediate(true);
		root_button1.setWidth("399px");
		root_button1.setHeight("134px");
		verticalLayout_idea1.addComponent(root_button1);
		
		return verticalLayout_idea1;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_idea2() {
		// common part: create layout
		verticalLayout_idea2 = new VerticalLayout();
		verticalLayout_idea2.setImmediate(false);
		verticalLayout_idea2.setWidth("-1px");
		verticalLayout_idea2.setHeight("-1px");
		verticalLayout_idea2.setMargin(false);
		
		// label_idea2
		label_idea2 = new Label();
		label_idea2.setImmediate(false);
		label_idea2.setWidth("-1px");
		label_idea2.setHeight("-1px");
		label_idea2.setValue("Idea 2");
		verticalLayout_idea2.addComponent(label_idea2);
		verticalLayout_idea2.setComponentAlignment(label_idea2, new Alignment(
				20));
		
		// root_button2
		root_button2 = new NativeButton();
		root_button2
				.setCaption("restrictions whatsoever.  You may copy it give it away or reuse it under the terms of the Project Gutenberg License included with this eBook or on");
		root_button2.setImmediate(true);
		root_button2.setWidth("399px");
		root_button2.setHeight("134px");
		verticalLayout_idea2.addComponent(root_button2);
		
		return verticalLayout_idea2;
	}

}
