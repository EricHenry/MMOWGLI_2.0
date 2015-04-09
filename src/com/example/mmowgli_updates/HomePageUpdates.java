/**
 * @Author: Eric H Correia
 *
 * This class creates 
 * 
 */

package com.example.mmowgli_updates;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class HomePageUpdates extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private GridLayout mainLayout;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_bottomContainer;

	@AutoGenerated
	private PopularCards popularCards_2;

	@AutoGenerated
	private PopularTags popularTags_2;

	@AutoGenerated
	private PopularCards popularCards_1;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_middleContainer;

	@AutoGenerated
	private Label label_3;

	@AutoGenerated
	private Label label_2;

	@AutoGenerated
	private Label label_1;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_topContainer;

	@AutoGenerated
	private RecentlyPlayed recentlyPlayed_1;

	@AutoGenerated
	private TrendingTags trendingTags_2;

	@AutoGenerated
	private TrendingCards trendingCards_1;

	private PopularTags popularTagList;
	private TrendingTags trendingTagList;
	
	private boolean showRootCards = true;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public HomePageUpdates() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here

		//set CSS styling
		trendingCards_1.setStyleName("updateBorders");
		trendingTags_2.setStyleName("updateBorders");
		popularCards_1.setStyleName("updateBorders");
		popularTags_2.setStyleName("updateBorders");
		label_1.setStyleName("updateBorders");
		label_2.setStyleName("updateBorders");
		//horizontal container stylings
		horizontalLayout_topContainer.setStyleName("updaterTopContainer");
		horizontalLayout_middleContainer.setStyleName("updaterMiddleContainer");
		horizontalLayout_bottomContainer.setStyleName("updaterBottomContainer");
		
		
		//labels
		label_1.setValue(null);
		label_2.setValue(null);
		label_3.setValue(null);
		
		//add separater icons
		label_1.setIcon(new ThemeResource("images/icons/updates/horizLine.png"));
		label_2.setIcon(new ThemeResource("images/icons/updates/horizLine.png"));
		label_3.setIcon(new ThemeResource("images/icons/updates/horizLine.png"));
		
		//label_4.setIcon(new ThemeResource("images/icons/updates/vertLine.png"));
		//label_5.setIcon(new ThemeResource("images/icons/updates/vertLine.png"));
		//label_6.setIcon(new ThemeResource("images/icons/updates/vertLine.png"));
		//label_7.setIcon(new ThemeResource("images/icons/updates/vertLine.png"));
		
		//root cards formatting
		//root_button1.setStyleName("root1");
		//root_button2.setStyleName("root2");
		
		//verticalLayout_3.setStyleName("center");
		//verticalLayout_root.setStyleName("white");
		//panel_1.setStyleName("borderless");
		
	}

	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("780px");
		mainLayout.setMargin(false);
		mainLayout.setRows(3);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("780px");
		
		// horizontalLayout_topContainer
		horizontalLayout_topContainer = buildHorizontalLayout_topContainer();
		mainLayout.addComponent(horizontalLayout_topContainer, 0, 0);
		
		// horizontalLayout_middleContainer
		horizontalLayout_middleContainer = buildHorizontalLayout_middleContainer();
		mainLayout.addComponent(horizontalLayout_middleContainer, 0, 1);
		
		// horizontalLayout_bottomContainer
		horizontalLayout_bottomContainer = buildHorizontalLayout_bottomContainer();
		mainLayout.addComponent(horizontalLayout_bottomContainer, 0, 2);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_topContainer() {
		// common part: create layout
		horizontalLayout_topContainer = new HorizontalLayout();
		horizontalLayout_topContainer.setImmediate(false);
		horizontalLayout_topContainer.setWidth("100.0%");
		horizontalLayout_topContainer.setHeight("400px");
		horizontalLayout_topContainer.setMargin(false);
		
		// trendingCards_1
		trendingCards_1 = new TrendingCards();
		trendingCards_1.setImmediate(false);
		trendingCards_1.setWidth("100.0%");
		trendingCards_1.setHeight("350px");
		horizontalLayout_topContainer.addComponent(trendingCards_1);
		horizontalLayout_topContainer.setComponentAlignment(trendingCards_1,
				new Alignment(48));
		
		// trendingTags_2
		trendingTags_2 = new TrendingTags();
		trendingTags_2.setImmediate(false);
		trendingTags_2.setWidth("100.0%");
		trendingTags_2.setHeight("350px");
		horizontalLayout_topContainer.addComponent(trendingTags_2);
		horizontalLayout_topContainer.setComponentAlignment(trendingTags_2,
				new Alignment(48));
		
		// recentlyPlayed_1
		recentlyPlayed_1 = new RecentlyPlayed();
		recentlyPlayed_1.setImmediate(false);
		recentlyPlayed_1.setWidth("100.0%");
		recentlyPlayed_1.setHeight("350px");
		horizontalLayout_topContainer.addComponent(recentlyPlayed_1);
		horizontalLayout_topContainer.setComponentAlignment(recentlyPlayed_1,
				new Alignment(48));
		
		return horizontalLayout_topContainer;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_middleContainer() {
		// common part: create layout
		horizontalLayout_middleContainer = new HorizontalLayout();
		horizontalLayout_middleContainer.setImmediate(false);
		horizontalLayout_middleContainer.setWidth("100.0%");
		horizontalLayout_middleContainer.setHeight("-1px");
		horizontalLayout_middleContainer.setMargin(false);
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("2px");
		label_1.setValue("Label");
		horizontalLayout_middleContainer.addComponent(label_1);
		horizontalLayout_middleContainer.setComponentAlignment(label_1,
				new Alignment(24));
		
		// label_2
		label_2 = new Label();
		label_2.setImmediate(false);
		label_2.setWidth("-1px");
		label_2.setHeight("-1px");
		label_2.setValue("Label");
		horizontalLayout_middleContainer.addComponent(label_2);
		horizontalLayout_middleContainer.setComponentAlignment(label_2,
				new Alignment(24));
		
		// label_3
		label_3 = new Label();
		label_3.setImmediate(false);
		label_3.setWidth("-1px");
		label_3.setHeight("-1px");
		label_3.setValue("Label");
		horizontalLayout_middleContainer.addComponent(label_3);
		horizontalLayout_middleContainer.setComponentAlignment(label_3,
				new Alignment(24));
		
		return horizontalLayout_middleContainer;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_bottomContainer() {
		// common part: create layout
		horizontalLayout_bottomContainer = new HorizontalLayout();
		horizontalLayout_bottomContainer.setImmediate(false);
		horizontalLayout_bottomContainer.setWidth("100.0%");
		horizontalLayout_bottomContainer.setHeight("400px");
		horizontalLayout_bottomContainer.setMargin(false);
		
		// popularCards_1
		popularCards_1 = new PopularCards();
		popularCards_1.setImmediate(false);
		popularCards_1.setWidth("100.0%");
		popularCards_1.setHeight("350px");
		horizontalLayout_bottomContainer.addComponent(popularCards_1);
		horizontalLayout_bottomContainer.setComponentAlignment(popularCards_1,
				new Alignment(48));
		
		// popularTags_2
		popularTags_2 = new PopularTags();
		popularTags_2.setImmediate(false);
		popularTags_2.setWidth("100.0%");
		popularTags_2.setHeight("350px");
		horizontalLayout_bottomContainer.addComponent(popularTags_2);
		horizontalLayout_bottomContainer.setComponentAlignment(popularTags_2,
				new Alignment(48));
		
		// popularCards_2
		popularCards_2 = new PopularCards();
		popularCards_2.setImmediate(false);
		popularCards_2.setWidth("100.0%");
		popularCards_2.setHeight("350px");
		horizontalLayout_bottomContainer.addComponent(popularCards_2);
		horizontalLayout_bottomContainer.setComponentAlignment(popularCards_2,
				new Alignment(48));
		
		return horizontalLayout_bottomContainer;
	}

}
