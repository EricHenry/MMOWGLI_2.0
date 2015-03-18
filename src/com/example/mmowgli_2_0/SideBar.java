package com.example.mmowgli_2_0;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.NativeButton;

public class SideBar extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private GridLayout mainLayout;
	@AutoGenerated
	private NativeButton nButton_help;
	@AutoGenerated
	private NativeButton nButton_blog;
	@AutoGenerated
	private NativeButton nButton_board;
	@AutoGenerated
	private NativeButton nButton_map;
	@AutoGenerated
	private NativeButton nButton_path;
	@AutoGenerated
	private NativeButton nButton_action;
	@AutoGenerated
	private NativeButton nButton_idea;
	@AutoGenerated
	private NativeButton nButton_search;
	@AutoGenerated
	private NativeButton nButton_notification;
	@AutoGenerated
	private NativeButton nButton_profile;
	@AutoGenerated
	private NativeButton nButton_home;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public SideBar() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		//button_blog.setIcon(new ThemeResource("../../../Images/buttons/gameBlog.png"));
		//set the style name of the buttons allowing you to specifically edit them in CSS
		nButton_home.setStyleName("borderless");
		nButton_profile.setStyleName("borderless");
		nButton_notification.setStyleName("borderless");
		nButton_search.setStyleName("borderless");
		
		//set the icons for each button
		nButton_idea.setStyleName("borderless");
		nButton_idea.setIcon(new ThemeResource("Images/icons/idea.png"));
		
		nButton_action.setStyleName("borderless");
		nButton_action.setIcon(new ThemeResource("Images/icons/action.png"));
		
		nButton_path.setStyleName("borderless");
		nButton_path.setIcon(new ThemeResource("Images/icons/path.png"));
		
		nButton_map.setStyleName("borderless");
		nButton_map.setIcon(new ThemeResource("Images/icons/map.png"));
		
		nButton_board.setStyleName("borderless");
		nButton_board.setIcon(new ThemeResource("Images/icons/board.png"));
		
		nButton_blog.setStyleName("borderless");
		nButton_blog.setIcon(new ThemeResource("Images/icons/blog.png"));
		
		nButton_help.setStyleName("borderless");
		nButton_help.setIcon(new ThemeResource("Images/icons/help.png"));
	}

	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		mainLayout.setRows(11);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// nButton_home
		nButton_home = new NativeButton();
		nButton_home.setCaption("Home");
		nButton_home.setImmediate(true);
		nButton_home.setWidth("100.0%");
		nButton_home.setHeight("100.0%");
		mainLayout.addComponent(nButton_home, 0, 0);
		mainLayout.setComponentAlignment(nButton_home, new Alignment(48));
		
		// nButton_profile
		nButton_profile = new NativeButton();
		nButton_profile.setCaption("Profile");
		nButton_profile.setImmediate(true);
		nButton_profile.setWidth("100.0%");
		nButton_profile.setHeight("100.0%");
		mainLayout.addComponent(nButton_profile, 0, 1);
		mainLayout.setComponentAlignment(nButton_profile, new Alignment(48));
		
		// nButton_notification
		nButton_notification = new NativeButton();
		nButton_notification.setCaption("Notifications");
		nButton_notification.setImmediate(true);
		nButton_notification.setWidth("100.0%");
		nButton_notification.setHeight("100.0%");
		mainLayout.addComponent(nButton_notification, 0, 2);
		mainLayout.setComponentAlignment(nButton_notification,
				new Alignment(48));
		
		// nButton_search
		nButton_search = new NativeButton();
		nButton_search.setCaption("Search");
		nButton_search.setImmediate(true);
		nButton_search.setWidth("100.0%");
		nButton_search.setHeight("100.0%");
		mainLayout.addComponent(nButton_search, 0, 3);
		mainLayout.setComponentAlignment(nButton_search, new Alignment(48));
		
		// nButton_idea
		nButton_idea = new NativeButton();
		nButton_idea.setImmediate(true);
		nButton_idea.setWidth("100.0%");
		nButton_idea.setHeight("100.0%");
		mainLayout.addComponent(nButton_idea, 0, 4);
		mainLayout.setComponentAlignment(nButton_idea, new Alignment(48));
		
		// nButton_action
		nButton_action = new NativeButton();
		nButton_action.setImmediate(true);
		nButton_action.setWidth("100.0%");
		nButton_action.setHeight("100.0%");
		mainLayout.addComponent(nButton_action, 0, 5);
		mainLayout.setComponentAlignment(nButton_action, new Alignment(48));
		
		// nButton_path
		nButton_path = new NativeButton();
		nButton_path.setImmediate(true);
		nButton_path.setWidth("100.0%");
		nButton_path.setHeight("100.0%");
		mainLayout.addComponent(nButton_path, 0, 6);
		mainLayout.setComponentAlignment(nButton_path, new Alignment(48));
		
		// nButton_map
		nButton_map = new NativeButton();
		nButton_map.setImmediate(true);
		nButton_map.setWidth("100.0%");
		nButton_map.setHeight("100.0%");
		mainLayout.addComponent(nButton_map, 0, 7);
		mainLayout.setComponentAlignment(nButton_map, new Alignment(48));
		
		// nButton_board
		nButton_board = new NativeButton();
		nButton_board.setImmediate(true);
		nButton_board.setWidth("100.0%");
		nButton_board.setHeight("100.0%");
		mainLayout.addComponent(nButton_board, 0, 8);
		mainLayout.setComponentAlignment(nButton_board, new Alignment(48));
		
		// nButton_blog
		nButton_blog = new NativeButton();
		nButton_blog.setImmediate(true);
		nButton_blog.setWidth("100.0%");
		nButton_blog.setHeight("100.0%");
		mainLayout.addComponent(nButton_blog, 0, 9);
		mainLayout.setComponentAlignment(nButton_blog, new Alignment(48));
		
		// nButton_help
		nButton_help = new NativeButton();
		nButton_help.setImmediate(true);
		nButton_help.setWidth("100.0%");
		nButton_help.setHeight("100.0%");
		mainLayout.addComponent(nButton_help, 0, 10);
		mainLayout.setComponentAlignment(nButton_help, new Alignment(48));
		
		return mainLayout;
	}

}