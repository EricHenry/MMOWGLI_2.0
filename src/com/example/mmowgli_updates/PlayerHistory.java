/**
 * @Author: Eric H Correia
 *
 * This class creates a container to hold the last 5 cards that the user has clicked on.
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

public class PlayerHistory extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private GridLayout mainLayout;
	@AutoGenerated
	private Label label_History;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PlayerHistory() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		
	}

	public GridLayout getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(GridLayout mainLayout) {
		this.mainLayout = mainLayout;
	}

	public Label getLabel_History() {
		return label_History;
	}

	public void setLabel_History(Label label_History) {
		this.label_History = label_History;
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
		
		// label_History
		label_History = new Label();
		label_History.setStyleName("title");
		label_History.setImmediate(false);
		label_History.setWidth("-1px");
		label_History.setHeight("-1px");
		label_History.setValue("Player History");
		mainLayout.addComponent(label_History, 0, 0);
		mainLayout.setComponentAlignment(label_History, new Alignment(48));
		
		return mainLayout;
	}


}
