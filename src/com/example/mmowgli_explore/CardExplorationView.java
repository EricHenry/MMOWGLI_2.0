package com.example.mmowgli_explore;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class CardExplorationView extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private HorizontalLayout mainLayout;


	@AutoGenerated
	private VerticalLayout verticalLayout_4;


	@AutoGenerated
	private Panel panel_cardChildren;


	@AutoGenerated
	private VerticalLayout verticalLayout_3;


	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;


	@AutoGenerated
	private ComboBox comboBox_1;


	@AutoGenerated
	private Label label_sort;


	@AutoGenerated
	private NativeButton nativeButton_search;


	@AutoGenerated
	private TextField textField_search;


	@AutoGenerated
	private Panel panel_currentCards;


	@AutoGenerated
	private VerticalLayout verticalLayout_2;


	@AutoGenerated
	private Panel panel_tree;


	@AutoGenerated
	private VerticalLayout verticalLayout_1;


	//Attributes
	private String chosenCardId;
	private CardView currentChosenCard = null;						//Keep track of the card view that has been clicked.
	private CardView[] currentlyDisplayedCards;						//Current List of cards listed in the middle panel
	private CardView[] currentlyDisplayedChildren;					//Current List of child cards being displyed
	private CardView[] currentCardHistory;							//Current History List being displayed
	
	//TODO change to updated version
	private CardView[] cardsToAdd	= new CardView[10];
	private CardView[] children		= new CardView[10];
	private CardView[] history		= new CardView[8];
	
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public CardExplorationView() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
//		//how to set the styling for tree links
//		tree_1.setItemStyleGenerator(new Tree.ItemStyleGenerator() {
//			
//			@Override
//			public String getStyle(Tree source, Object itemId) {
//				// TODO Auto-generated method stub
//				
//				//Hold the itemId as a string
//				String cardType = source.getItemCaption(itemId);
//				
//				//check which type of card it is
//				if(cardType.equalsIgnoreCase("Root1"))
//					return "root1";
//				else if(cardType.equalsIgnoreCase("Root2"))
//					return "root2";
//				else if(cardType.equalsIgnoreCase("Expand"))
//					return "expand";
//				else if(cardType.equalsIgnoreCase("Adapt"))
//					return "adapt";
//				else if(cardType.equalsIgnoreCase("Counter"))
//					return "counter";
//				else if(cardType.equalsIgnoreCase("Explore"))
//					return "explore";
//				else
//					return null;
//					
//			}
//		});
//		/* End example data. */
//		tree_1.expandItemsRecursively("Root");
		
		//set different background colors for cards
		initCards();
		initChildCards();
		initHistoryCards();

		//search button
		nativeButton_search.setCaption(null);
		nativeButton_search.setIcon(new ThemeResource("images/icons/sidebar/spyglass25.png"));
		nativeButton_search.setStyleName("cardTextMini");
			
	}
	
	public void initCards(){
		for(int i = 0; i < cardsToAdd.length; i++){
			String id = Integer.toBinaryString(i);
			cardsToAdd[i] = new CardView(id);
			
			//basic card styling
			//cardView_3 = new CardView();
			cardsToAdd[i].setImmediate(false);
			cardsToAdd[i].setWidth("340px");
			cardsToAdd[i].setHeight("-1px");
			verticalLayout_2.addComponent(cardsToAdd[i]);
			verticalLayout_2.setExpandRatio(cardsToAdd[i], 1.0f);
			
			//make transparent
			cardsToAdd[i].addTransparency();
			
			//set the card as inside the main view of the card explorer
			cardsToAdd[i].setInMainView(true);
			
			
			listen(cardsToAdd[i]);
		}

		//set different background colors for cards
		cardsToAdd[0].setCardType("Expand");
		cardsToAdd[1].setCardType("Adapt");
		cardsToAdd[2].setCardType("Explore");
		cardsToAdd[3].setCardType("Counter");
		cardsToAdd[4].setCardType("Counter");
		cardsToAdd[5].setCardType("Adapt");
		cardsToAdd[6].setCardType("Expand");
		cardsToAdd[7].setCardType("Expand");
		cardsToAdd[8].setCardType("Explore");
		cardsToAdd[9].setCardType("Counter");
	}
	
	public void initChildCards(){
		for(int i = 0; i < children.length; i++){
			String id = Integer.toBinaryString(i+50);
			children[i] = new CardView(id);
			
			//basic card styling
			//cardView_3 = new CardView();
			children[i].setImmediate(false);
			children[i].setWidth("340px");
			children[i].setHeight("-1px");
			verticalLayout_3.addComponent(children[i]);
			verticalLayout_3.setExpandRatio(children[i], 1.0f);			
			listen(children[i]);
		
			//set the card as inside the main view of the card explorer
			children[i].setInChildView(true);
		}
		
		//set different background colors for cards
		children[0].setCardType("Counter");
		children[1].setCardType("Explore");
		children[2].setCardType("Adapt");
		children[3].setCardType("Adapt");
		children[4].setCardType("Counter");
		children[5].setCardType("Adapt");
		children[6].setCardType("Expand");
		children[7].setCardType("Expand");
		children[8].setCardType("Explore");
		children[9].setCardType("Adapt");
	}
	
	public void initHistoryCards(){
		for(int i = 0; i < history.length; i++){
			String id = Integer.toBinaryString(i+33);
			history[i] = new CardView(id);
			
			//basic card styling
			//cardView_3 = new CardView();
			history[i].setImmediate(false);
			history[i].setWidth("340px");
			history[i].setHeight("-1px");
			verticalLayout_1.addComponent(history[i]);
			verticalLayout_1.setExpandRatio(history[i], 1.0f);			
			listen(history[i]);
		
			//set the card as inside the main view of the card explorer
			//children[i].setInChildView(true);
		}
		
		//set different background colors for cards
		history[0].setCardType("Adapt");
		history[1].setCardType("Explore");
		history[2].setCardType("Adapt");
		history[3].setCardType("Explore");
		history[4].setCardType("Counter");
		history[5].setCardType("Adapt");
		history[6].setCardType("Expand");
		history[7].setCardType("Counter");
		
	}
	
	/**
	 * Test listener
	 */
	public void listen(CardView clickedCard){
		
		//Listen to the cards text button
		clickedCard.getNativeButton_text().addClickListener(new NativeButton.ClickListener(){
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				//if(cardView_1.get)
				
				//check if the card that is initiating the button click has already been chosen and set as the current card
				//if it is not, then minimize the current card and maximize the new chosen card
				if(!clickedCard.equals(currentChosenCard)){

					//Make sure the current card is not null
					try{
						currentChosenCard.addTransparency();
						currentChosenCard.shrinkCard();
						
						clickedCard.expandCard();
						clickedCard.removeTransparency();
						
					}catch(NullPointerException e){
						clickedCard.expandCard();
						clickedCard.removeTransparency();
					}
					
					//Set the clicked card as the 
					currentChosenCard = new CardView(clickedCard);
				}
			}
			
		});		
	}
	
	@AutoGenerated
	private HorizontalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new HorizontalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("500px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("500px");
		
		// panel_tree
		panel_tree = buildPanel_tree();
		mainLayout.addComponent(panel_tree);
		mainLayout.setExpandRatio(panel_tree, 1.2f);
		
		// panel_currentCards
		panel_currentCards = buildPanel_currentCards();
		mainLayout.addComponent(panel_currentCards);
		mainLayout.setExpandRatio(panel_currentCards, 3.0f);
		
		// verticalLayout_4
		verticalLayout_4 = buildVerticalLayout_4();
		mainLayout.addComponent(verticalLayout_4);
		mainLayout.setExpandRatio(verticalLayout_4, 2.5f);
		
		return mainLayout;
	}

	@AutoGenerated
	private Panel buildPanel_tree() {
		// common part: create layout
		panel_tree = new Panel();
		panel_tree.setImmediate(false);
		panel_tree.setWidth("100.0%");
		panel_tree.setHeight("100.0%");
		
		// verticalLayout_1
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("300px");
		verticalLayout_1.setHeight("-1px");
		verticalLayout_1.setMargin(false);
		verticalLayout_1.setSpacing(true);
		panel_tree.setContent(verticalLayout_1);
		
		return panel_tree;
	}

	@AutoGenerated
	private Panel buildPanel_currentCards() {
		// common part: create layout
		panel_currentCards = new Panel();
		panel_currentCards.setImmediate(false);
		panel_currentCards.setWidth("100.0%");
		panel_currentCards.setHeight("100.0%");
		
		// verticalLayout_2
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("375px");
		verticalLayout_2.setHeight("-1px");
		verticalLayout_2.setMargin(false);
		verticalLayout_2.setSpacing(true);
		panel_currentCards.setContent(verticalLayout_2);
		
		return panel_currentCards;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_4() {
		// common part: create layout
		verticalLayout_4 = new VerticalLayout();
		verticalLayout_4.setImmediate(false);
		verticalLayout_4.setWidth("100.0%");
		verticalLayout_4.setHeight("100.0%");
		verticalLayout_4.setMargin(false);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		verticalLayout_4.addComponent(horizontalLayout_1);
		verticalLayout_4.setExpandRatio(horizontalLayout_1, 0.2f);
		
		// panel_cardChildren
		panel_cardChildren = buildPanel_cardChildren();
		verticalLayout_4.addComponent(panel_cardChildren);
		verticalLayout_4.setExpandRatio(panel_cardChildren, 2.0f);
		
		return verticalLayout_4;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("375px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		
		// textField_search
		textField_search = new TextField();
		textField_search.setImmediate(false);
		textField_search.setWidth("90px");
		textField_search.setHeight("25px");
		horizontalLayout_1.addComponent(textField_search);
		
		// nativeButton_search
		nativeButton_search = new NativeButton();
		nativeButton_search.setCaption("NativeButton");
		nativeButton_search.setImmediate(true);
		nativeButton_search.setWidth("-1px");
		nativeButton_search.setHeight("-1px");
		horizontalLayout_1.addComponent(nativeButton_search);
		
		// label_sort
		label_sort = new Label();
		label_sort.setImmediate(false);
		label_sort.setWidth("-1px");
		label_sort.setHeight("-1px");
		label_sort.setValue("Sort By:");
		horizontalLayout_1.addComponent(label_sort);
		horizontalLayout_1.setComponentAlignment(label_sort, new Alignment(48));
		
		// comboBox_1
		comboBox_1 = new ComboBox();
		comboBox_1.setImmediate(false);
		comboBox_1.setWidth("90px");
		comboBox_1.setHeight("25px");
		horizontalLayout_1.addComponent(comboBox_1);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private Panel buildPanel_cardChildren() {
		// common part: create layout
		panel_cardChildren = new Panel();
		panel_cardChildren.setImmediate(false);
		panel_cardChildren.setWidth("100.0%");
		panel_cardChildren.setHeight("100.0%");
		
		// verticalLayout_3
		verticalLayout_3 = new VerticalLayout();
		verticalLayout_3.setImmediate(false);
		verticalLayout_3.setWidth("375px");
		verticalLayout_3.setHeight("-1px");
		verticalLayout_3.setMargin(false);
		verticalLayout_3.setSpacing(true);
		panel_cardChildren.setContent(verticalLayout_3);
		
		return panel_cardChildren;
	}

}
