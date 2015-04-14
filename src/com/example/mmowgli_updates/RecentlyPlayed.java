/**
 * @Author: Eric H Correia
 *
 * This class creates 
 * 
 */

package com.example.mmowgli_updates;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.example.mmowgli_backend.Card;
import com.example.mmowgli_backend.CardList;
import com.example.mmowgli_backend.MmowgliDB;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class RecentlyPlayed extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private GridLayout mainLayout;
	@AutoGenerated
	private Label label_played;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public RecentlyPlayed() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		
		//initRecentCardsList();
		
	}
	
	public GridLayout getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(GridLayout mainLayout) {
		this.mainLayout = mainLayout;
	}

	public Label getLabel_played() {
		return label_played;
	}

	public void setLabel_played(Label label_played) {
		this.label_played = label_played;
	}

	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		mainLayout.setRows(6);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// label_played
		label_played = new Label();
		label_played.setImmediate(false);
		label_played.setWidth("-1px");
		label_played.setHeight("-1px");
		label_played.setValue("Most Recently Played");
		mainLayout.addComponent(label_played, 0, 0);
		mainLayout.setComponentAlignment(label_played, new Alignment(48));
		
		return mainLayout;
	}

}
