package com.example.mmowgli_2_0;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class HomePage extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private HomePageUpdates homePageUpdates_1;
	@AutoGenerated
	private SideBar sideBar_1;
	@AutoGenerated
	private TopBar topBar_1;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public HomePage() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// topBar_1
		topBar_1 = new TopBar();
		topBar_1.setImmediate(false);
		topBar_1.setWidth("100.0%");
		topBar_1.setHeight("100.0%");
		mainLayout.addComponent(topBar_1);
		mainLayout.setExpandRatio(topBar_1, 0.1f);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		mainLayout.addComponent(horizontalLayout_2);
		mainLayout.setExpandRatio(horizontalLayout_2, 1.0f);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("100.0%");
		horizontalLayout_2.setHeight("100.0%");
		horizontalLayout_2.setMargin(false);
		
		// sideBar_1
		sideBar_1 = new SideBar();
		sideBar_1.setImmediate(false);
		sideBar_1.setWidth("100.0%");
		sideBar_1.setHeight("100.0%");
		horizontalLayout_2.addComponent(sideBar_1);
		horizontalLayout_2.setExpandRatio(sideBar_1, 0.13f);
		
		// homePageUpdates_1
		homePageUpdates_1 = new HomePageUpdates();
		homePageUpdates_1.setImmediate(false);
		homePageUpdates_1.setWidth("100.0%");
		homePageUpdates_1.setHeight("100.0%");
		horizontalLayout_2.addComponent(homePageUpdates_1);
		horizontalLayout_2.setExpandRatio(homePageUpdates_1, 1.0f);
		
		return horizontalLayout_2;
	}

}
