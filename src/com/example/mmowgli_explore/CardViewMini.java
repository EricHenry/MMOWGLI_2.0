/**
 * @Author: Eric H Correia
 *
 * This class creates 
 * 
 */

package com.example.mmowgli_explore;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.VerticalLayout;

public class CardViewMini extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private NativeButton nativeButton_text;
	//Attribute
	private String id;
	
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public CardViewMini() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		
		//card text
		nativeButton_text.setCaption("Lorem ipsum dolor sit amet, consectetur adipiscing elit Cras sodales eros ut ipsum ultricies eleifend. Vivamus justo ipsum, rutrum vel orciv"); //140 characters
		//nativeButton_text.setStyleName("cardTextTiny");
		
	}
	
	/**
	 * Sets a card's background of the top bar
	 * @param cardType - specifies which of the four types a card should be
	 */
	public void setCardColor(String cardType){
		
		nativeButton_text.setStyleName("cardType" + cardType + "Tiny");
		
	}
	
	/**
	 * Sets the card type, This changes the card's label to reflect the type.
	 * 	e.g. cardType = Adapt -> will change the label of the card to reflect the type.
	 * 
	 * TODO -> have this method call SetCardColor to automatically change the styling when the type is set.
	 * 
	 * @param cardType -> Specifies what type of card
	 */
	public void setCardType(String cardType){
		
		//label_cardType.setValue(cardType);
		setCardColor(cardType);
		
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("290px");
		mainLayout.setHeight("75px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("290px");
		setHeight("75px");
		
		// nativeButton_text
		nativeButton_text = new NativeButton();
		nativeButton_text.setCaption("NativeButton");
		nativeButton_text.setImmediate(true);
		nativeButton_text.setWidth("100.0%");
		nativeButton_text.setHeight("100.0%");
		mainLayout.addComponent(nativeButton_text);
		
		return mainLayout;
	}
}
