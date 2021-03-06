/**
 * @Author: Eric H Correia
 *
 * This class creates a container to hold the top 5 most trending cards played in a certain amount of time
 * 
 * The cards are displayed as BaseCardView Components
 * 
 */

package com.example.mmowgli_updates;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class TrendingCards extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private GridLayout mainLayout;
	@AutoGenerated
	private Label label_trending;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public TrendingCards() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
	}
	
	public GridLayout getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(GridLayout mainLayout) {
		this.mainLayout = mainLayout;
	}

	public Label getLabel_trending() {
		return label_trending;
	}

	public void setLabel_trending(Label label_trending) {
		this.label_trending = label_trending;
	}

	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		mainLayout.setRows(6);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// label_trending
		label_trending = new Label();
		label_trending.setStyleName("title");
		label_trending.setImmediate(false);
		label_trending.setWidth("-1px");
		label_trending.setHeight("-1px");
		label_trending.setValue("Trending Cards");
		mainLayout.addComponent(label_trending, 0, 0);
		mainLayout.setComponentAlignment(label_trending, new Alignment(48));
		
		return mainLayout;
	}

}
