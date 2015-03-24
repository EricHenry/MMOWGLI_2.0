package com.example.mmowgli_explore;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
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
	private CardViewMini cardViewMini_5;
	@AutoGenerated
	private CardViewMini cardViewMini_4;
	@AutoGenerated
	private CardViewMini cardViewMini_3;
	@AutoGenerated
	private CardViewMini cardViewMini_2;
	@AutoGenerated
	private CardViewMini cardViewMini_1;
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
	private CardView cardView_2;
	@AutoGenerated
	private CardView cardView_10;
	@AutoGenerated
	private CardView cardView_9;
	@AutoGenerated
	private CardView cardView_8;
	@AutoGenerated
	private CardView cardView_7;
	@AutoGenerated
	private CardView cardView_6;
	@AutoGenerated
	private CardView cardView_5;
	@AutoGenerated
	private CardView cardView_4;
	@AutoGenerated
	private CardView cardView_3;
	@AutoGenerated
	private CardView cardView_1;
	@AutoGenerated
	private Panel panel_tree;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private Tree tree_1;
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
		/* Add example data to the card tree. */
		tree_1.addItem("1");							//add item by unique id
		tree_1.setItemCaption("1", "Root1");			//Set the caption for that unique id
		
		tree_1.addItem("2");
		tree_1.setItemCaption("2", "Expand");	
		tree_1.addItem("3");
		tree_1.setItemCaption("3", "Expand");	
		tree_1.addItem("4");
		tree_1.setItemCaption("4", "Expand");	
		tree_1.addItem("5");
		tree_1.setItemCaption("5", "Counter");	
		tree_1.addItem("6");
		tree_1.setItemCaption("6", "Explore");	
		tree_1.addItem("7");
		tree_1.setItemCaption("7", "Adapt");	
		tree_1.setParent("2","1");
		tree_1.setParent("3", "1");
		tree_1.setParent("4","2");
		tree_1.setParent("5","2");
		tree_1.setParent("6","2");
		tree_1.setParent("7","2");
		tree_1.setChildrenAllowed("4", false);
		tree_1.setChildrenAllowed("5", false);
		tree_1.setChildrenAllowed("6", false);
		tree_1.setChildrenAllowed("7", false);
		
		
		//how to set the styling for tree links
		tree_1.setItemStyleGenerator(new Tree.ItemStyleGenerator() {
			
			@Override
			public String getStyle(Tree source, Object itemId) {
				// TODO Auto-generated method stub
				
				//Hold the itemId as a string
				String cardType = source.getItemCaption(itemId);
				
				//check which type of card it is
				if(cardType.equalsIgnoreCase("Root1"))
					return "root1";
				else if(cardType.equalsIgnoreCase("Root2"))
					return "root2";
				else if(cardType.equalsIgnoreCase("Expand"))
					return "expand";
				else if(cardType.equalsIgnoreCase("Adapt"))
					return "adapt";
				else if(cardType.equalsIgnoreCase("Counter"))
					return "counter";
				else if(cardType.equalsIgnoreCase("Explore"))
					return "explore";
				else
					return null;
					
			}
		});
		/* End example data. */
		tree_1.expandItemsRecursively("Root");
		
		/* Set up the main/center card table. */
		/*************************************************/
		/* Change CardComponent in the following line    */
		/* to the name of your Card class for the table. */
		/*************************************************/
		//cardTable.addContainerProperty("Selected Card", CardComponent.class, null);
		//cardTable.setColumnHeaderMode(Table.COLUMN_HEADER_MODE_HIDDEN);
		
		/* Add some example cards - real data to be added here. */
		/*************************************************/
		/* Change CardComponent in the following 2 lines */
		/* to the name of your Card class for the table. */
		/*************************************************/
		//cardTable.addItem(new Object[]{new CardComponent()}, 0);
		//cardTable.addItem(new Object[]{new CardComponent()}, 1);
		/* End example data. */
		
		/* Set up the table containing the leaf cards. */
		/*************************************************/
		/* Change CardComponent in the following line    */
		/* to the name of your Card class for the table. */
		/*************************************************/
		//leafTable.addContainerProperty("Leaf Cards", CardComponent.class, null);
		//leafTable.setColumnHeaderMode(Table.COLUMN_HEADER_MODE_HIDDEN);
		
		/* Add some example cards - real data to be added here. */
		/*************************************************/
		/* Change CardComponent in the following line    */
		/* to the name of your Card class for the table. */
		/*************************************************/
		//for (int i=0; i<10; i++)
		//	leafTable.addItem(new Object[]{new CardComponent()}, i);
		/* End example data. */
		
		//set different background colors for cards
		cardView_2.setCardType("Expand");
		cardView_1.setCardType("Adapt");
		cardView_3.setCardType("Explore");
		cardView_4.setCardType("Counter");
		cardView_5.setCardType("Counter");
		cardView_6.setCardType("Adapt");
		cardView_7.setCardType("Expand");
		cardView_8.setCardType("Expand");
		cardView_9.setCardType("Explore");
		cardView_10.setCardType("Counter");
		
		//set different backgrounds colors for mini cards
		cardViewMini_1.setCardType("Counter");
		cardViewMini_2.setCardType("Adapt");
		cardViewMini_3.setCardType("Expand");
		cardViewMini_4.setCardType("Expand");
		cardViewMini_5.setCardType("Explore");
		
		//search button
		nativeButton_search.setCaption(null);
		nativeButton_search.setIcon(new ThemeResource("images/icons/sidebar/spyglass25.png"));
		nativeButton_search.setStyleName("cardTextMini");
		
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
		mainLayout.setExpandRatio(panel_tree, 1.0f);
		
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
		verticalLayout_1 = buildVerticalLayout_1();
		panel_tree.setContent(verticalLayout_1);
		
		return panel_tree;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("100.0%");
		verticalLayout_1.setHeight("100.0%");
		verticalLayout_1.setMargin(false);
		
		// tree_1
		tree_1 = new Tree();
		tree_1.setImmediate(false);
		tree_1.setWidth("-1px");
		tree_1.setHeight("-1px");
		verticalLayout_1.addComponent(tree_1);
		
		return verticalLayout_1;
	}

	@AutoGenerated
	private Panel buildPanel_currentCards() {
		// common part: create layout
		panel_currentCards = new Panel();
		panel_currentCards.setImmediate(false);
		panel_currentCards.setWidth("100.0%");
		panel_currentCards.setHeight("100.0%");
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		panel_currentCards.setContent(verticalLayout_2);
		
		return panel_currentCards;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("375px");
		verticalLayout_2.setHeight("-1px");
		verticalLayout_2.setMargin(false);
		verticalLayout_2.setSpacing(true);
		
		// cardView_1
		cardView_1 = new CardView();
		cardView_1.setImmediate(false);
		cardView_1.setWidth("340px");
		cardView_1.setHeight("-1px");
		verticalLayout_2.addComponent(cardView_1);
		verticalLayout_2.setExpandRatio(cardView_1, 1.0f);
		
		// cardView_3
		cardView_3 = new CardView();
		cardView_3.setImmediate(false);
		cardView_3.setWidth("340px");
		cardView_3.setHeight("-1px");
		verticalLayout_2.addComponent(cardView_3);
		verticalLayout_2.setExpandRatio(cardView_3, 1.0f);
		
		// cardView_4
		cardView_4 = new CardView();
		cardView_4.setImmediate(false);
		cardView_4.setWidth("340px");
		cardView_4.setHeight("-1px");
		verticalLayout_2.addComponent(cardView_4);
		verticalLayout_2.setExpandRatio(cardView_4, 1.0f);
		
		// cardView_5
		cardView_5 = new CardView();
		cardView_5.setImmediate(false);
		cardView_5.setWidth("340px");
		cardView_5.setHeight("-1px");
		verticalLayout_2.addComponent(cardView_5);
		verticalLayout_2.setExpandRatio(cardView_5, 1.0f);
		
		// cardView_6
		cardView_6 = new CardView();
		cardView_6.setImmediate(false);
		cardView_6.setWidth("340px");
		cardView_6.setHeight("-1px");
		verticalLayout_2.addComponent(cardView_6);
		verticalLayout_2.setExpandRatio(cardView_6, 1.0f);
		
		// cardView_7
		cardView_7 = new CardView();
		cardView_7.setImmediate(false);
		cardView_7.setWidth("340px");
		cardView_7.setHeight("-1px");
		verticalLayout_2.addComponent(cardView_7);
		verticalLayout_2.setExpandRatio(cardView_7, 1.0f);
		
		// cardView_8
		cardView_8 = new CardView();
		cardView_8.setImmediate(false);
		cardView_8.setWidth("340px");
		cardView_8.setHeight("-1px");
		verticalLayout_2.addComponent(cardView_8);
		verticalLayout_2.setExpandRatio(cardView_8, 1.0f);
		
		// cardView_9
		cardView_9 = new CardView();
		cardView_9.setImmediate(false);
		cardView_9.setWidth("340px");
		cardView_9.setHeight("-1px");
		verticalLayout_2.addComponent(cardView_9);
		verticalLayout_2.setExpandRatio(cardView_9, 1.0f);
		
		// cardView_10
		cardView_10 = new CardView();
		cardView_10.setImmediate(false);
		cardView_10.setWidth("340px");
		cardView_10.setHeight("-1px");
		verticalLayout_2.addComponent(cardView_10);
		verticalLayout_2.setExpandRatio(cardView_10, 1.0f);
		
		// cardView_2
		cardView_2 = new CardView();
		cardView_2.setImmediate(false);
		cardView_2.setWidth("340px");
		cardView_2.setHeight("-1px");
		verticalLayout_2.addComponent(cardView_2);
		
		return verticalLayout_2;
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
		verticalLayout_3 = buildVerticalLayout_3();
		panel_cardChildren.setContent(verticalLayout_3);
		
		return panel_cardChildren;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_3() {
		// common part: create layout
		verticalLayout_3 = new VerticalLayout();
		verticalLayout_3.setImmediate(false);
		verticalLayout_3.setWidth("375px");
		verticalLayout_3.setHeight("-1px");
		verticalLayout_3.setMargin(false);
		verticalLayout_3.setSpacing(true);
		
		// cardViewMini_1
		cardViewMini_1 = new CardViewMini();
		cardViewMini_1.setImmediate(false);
		cardViewMini_1.setWidth("340px");
		cardViewMini_1.setHeight("-1px");
		verticalLayout_3.addComponent(cardViewMini_1);
		verticalLayout_3.setExpandRatio(cardViewMini_1, 1.0f);
		
		// cardViewMini_2
		cardViewMini_2 = new CardViewMini();
		cardViewMini_2.setImmediate(false);
		cardViewMini_2.setWidth("340px");
		cardViewMini_2.setHeight("-1px");
		verticalLayout_3.addComponent(cardViewMini_2);
		verticalLayout_3.setExpandRatio(cardViewMini_2, 1.0f);
		
		// cardViewMini_3
		cardViewMini_3 = new CardViewMini();
		cardViewMini_3.setImmediate(false);
		cardViewMini_3.setWidth("340px");
		cardViewMini_3.setHeight("-1px");
		verticalLayout_3.addComponent(cardViewMini_3);
		verticalLayout_3.setExpandRatio(cardViewMini_3, 1.0f);
		
		// cardViewMini_4
		cardViewMini_4 = new CardViewMini();
		cardViewMini_4.setImmediate(false);
		cardViewMini_4.setWidth("340px");
		cardViewMini_4.setHeight("-1px");
		verticalLayout_3.addComponent(cardViewMini_4);
		verticalLayout_3.setExpandRatio(cardViewMini_4, 1.0f);
		
		// cardViewMini_5
		cardViewMini_5 = new CardViewMini();
		cardViewMini_5.setImmediate(false);
		cardViewMini_5.setWidth("340px");
		cardViewMini_5.setHeight("-1px");
		verticalLayout_3.addComponent(cardViewMini_5);
		verticalLayout_3.setExpandRatio(cardViewMini_5, 1.0f);
		
		return verticalLayout_3;
	}

}
