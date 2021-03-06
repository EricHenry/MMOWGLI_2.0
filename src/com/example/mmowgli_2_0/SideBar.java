/**
 * @Author: Eric H Correia
 *
 * This class creates creates the static sidebar to be displayed on every MMOWGLI page 
 * 
 */

package com.example.mmowgli_2_0;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

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
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private NativeButton nativeButton_Search;
	@AutoGenerated
	private TextField textField_search;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_user;
	@AutoGenerated
	private VerticalLayout verticalLayout_profileInfo;
	@AutoGenerated
	private NativeButton nativeButton_signOut;
	@AutoGenerated
	private Label label_info;
	@AutoGenerated
	private VerticalLayout verticalLayout_profile;
	@AutoGenerated
	private Label label_userName;
	@AutoGenerated
	private NativeButton nativeButton_profilePic;
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
		
		//set style
		setSideBarStyling();
	}
	
	/**
	 * This function sets the basic style for the side bar
	 */
	private void setSideBarStyling(){
		//user info
		horizontalLayout_user.setStyleName("userLayout");
		
		nativeButton_profilePic.setStyleName("borderless");
		nativeButton_profilePic.setIcon(new ThemeResource("images/icons/sidebar/profilePic.png"));
		nativeButton_profilePic.setCaption(null);
		
		nativeButton_signOut.setStyleName("borderless");
		nativeButton_signOut.setIcon(new ThemeResource("images/icons/sidebar/signout.png"));
		nativeButton_signOut.setCaption(null);
		
		label_info.setStyleName("borderless");
		label_info.setIcon(new ThemeResource("images/icons/sidebar/info.png"));
		label_info.setValue(null);
		
		nativeButton_Search.setStyleName("borderless");
		nativeButton_Search.setIcon(new ThemeResource("images/icons/sidebar/spyglass25.png"));
		nativeButton_Search.setCaption(null);
		
		//set the icons for each button
		nButton_idea.setStyleName("borderless");
		nButton_idea.setIcon(new ThemeResource("images/icons/sidebar/idea.png"));
		nButton_idea.setCaption(null);
		
		nButton_action.setStyleName("borderless");
		nButton_action.setIcon(new ThemeResource("images/icons/sidebar/action.png"));
		nButton_action.setCaption(null);
		
		nButton_path.setStyleName("borderless");
		nButton_path.setIcon(new ThemeResource("images/icons/sidebar/path.png"));
		nButton_path.setCaption(null);
		
		nButton_map.setStyleName("borderless");
		nButton_map.setIcon(new ThemeResource("images/icons/sidebar/map.png"));
		nButton_map.setCaption(null);
		
		nButton_board.setStyleName("borderless");
		nButton_board.setIcon(new ThemeResource("images/icons/sidebar/board.png"));
		nButton_board.setCaption(null);
		
		nButton_blog.setStyleName("borderless");
		nButton_blog.setIcon(new ThemeResource("images/icons/sidebar/blog.png"));
		nButton_blog.setCaption(null);
		
		nButton_help.setStyleName("borderless");
		nButton_help.setIcon(new ThemeResource("images/icons/sidebar/help.png"));
		nButton_help.setCaption(null);
	}

	public NativeButton getnButton_path() {
		return nButton_path;
	}

	public void setnButton_path(NativeButton nButton_path) {
		this.nButton_path = nButton_path;
	}

	public NativeButton getNativeButton_Search() {
		return nativeButton_Search;
	}

	public void setNativeButton_Search(NativeButton nativeButton_Search) {
		this.nativeButton_Search = nativeButton_Search;
	}

	public TextField getTextField_search() {
		return textField_search;
	}

	public void setTextField_search(TextField textField_search) {
		this.textField_search = textField_search;
	}

	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("165px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		mainLayout.setRows(9);
		
		// top-level component properties
		setWidth("165px");
		setHeight("-1px");
		
		// horizontalLayout_user
		horizontalLayout_user = buildHorizontalLayout_user();
		mainLayout.addComponent(horizontalLayout_user, 0, 0);
		mainLayout.setComponentAlignment(horizontalLayout_user, new Alignment(
				48));
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		mainLayout.addComponent(horizontalLayout_1, 0, 1);
		mainLayout.setComponentAlignment(horizontalLayout_1, new Alignment(48));
		
		// nButton_idea
		nButton_idea = new NativeButton();
		nButton_idea.setCaption("NativeButton");
		nButton_idea.setImmediate(true);
		nButton_idea.setWidth("100.0%");
		nButton_idea.setHeight("100.0%");
		mainLayout.addComponent(nButton_idea, 0, 2);
		mainLayout.setComponentAlignment(nButton_idea, new Alignment(48));
		
		// nButton_action
		nButton_action = new NativeButton();
		nButton_action.setCaption("NativeButton");
		nButton_action.setImmediate(true);
		nButton_action.setWidth("100.0%");
		nButton_action.setHeight("100.0%");
		mainLayout.addComponent(nButton_action, 0, 3);
		mainLayout.setComponentAlignment(nButton_action, new Alignment(48));
		
		// nButton_path
		nButton_path = new NativeButton();
		nButton_path.setCaption("NativeButton");
		nButton_path.setImmediate(true);
		nButton_path.setWidth("100.0%");
		nButton_path.setHeight("100.0%");
		mainLayout.addComponent(nButton_path, 0, 4);
		mainLayout.setComponentAlignment(nButton_path, new Alignment(48));
		
		// nButton_map
		nButton_map = new NativeButton();
		nButton_map.setCaption("NativeButton");
		nButton_map.setImmediate(true);
		nButton_map.setWidth("100.0%");
		nButton_map.setHeight("100.0%");
		mainLayout.addComponent(nButton_map, 0, 5);
		mainLayout.setComponentAlignment(nButton_map, new Alignment(48));
		
		// nButton_board
		nButton_board = new NativeButton();
		nButton_board.setCaption("NativeButton");
		nButton_board.setImmediate(true);
		nButton_board.setWidth("100.0%");
		nButton_board.setHeight("100.0%");
		mainLayout.addComponent(nButton_board, 0, 6);
		mainLayout.setComponentAlignment(nButton_board, new Alignment(48));
		
		// nButton_blog
		nButton_blog = new NativeButton();
		nButton_blog.setCaption("NativeButton");
		nButton_blog.setImmediate(true);
		nButton_blog.setWidth("100.0%");
		nButton_blog.setHeight("100.0%");
		mainLayout.addComponent(nButton_blog, 0, 7);
		mainLayout.setComponentAlignment(nButton_blog, new Alignment(48));
		
		// nButton_help
		nButton_help = new NativeButton();
		nButton_help.setCaption("NativeButton");
		nButton_help.setImmediate(true);
		nButton_help.setWidth("100.0%");
		nButton_help.setHeight("100.0%");
		mainLayout.addComponent(nButton_help, 0, 8);
		mainLayout.setComponentAlignment(nButton_help, new Alignment(48));
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_user() {
		// common part: create layout
		horizontalLayout_user = new HorizontalLayout();
		horizontalLayout_user.setImmediate(false);
		horizontalLayout_user.setWidth("100.0%");
		horizontalLayout_user.setHeight("130px");
		horizontalLayout_user.setMargin(false);
		
		// verticalLayout_profile
		verticalLayout_profile = buildVerticalLayout_profile();
		horizontalLayout_user.addComponent(verticalLayout_profile);
		
		// verticalLayout_profileInfo
		verticalLayout_profileInfo = buildVerticalLayout_profileInfo();
		horizontalLayout_user.addComponent(verticalLayout_profileInfo);
		
		return horizontalLayout_user;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_profile() {
		// common part: create layout
		verticalLayout_profile = new VerticalLayout();
		verticalLayout_profile.setImmediate(false);
		verticalLayout_profile.setWidth("-1px");
		verticalLayout_profile.setHeight("-1px");
		verticalLayout_profile.setMargin(false);
		
		// nativeButton_profilePic
		nativeButton_profilePic = new NativeButton();
		nativeButton_profilePic.setCaption("NativeButton");
		nativeButton_profilePic.setImmediate(true);
		nativeButton_profilePic.setWidth("-1px");
		nativeButton_profilePic.setHeight("-1px");
		verticalLayout_profile.addComponent(nativeButton_profilePic);
		
		// label_userName
		label_userName = new Label();
		label_userName.setImmediate(false);
		label_userName.setWidth("-1px");
		label_userName.setHeight("-1px");
		label_userName.setValue("Kilsuf");
		verticalLayout_profile.addComponent(label_userName);
		verticalLayout_profile.setComponentAlignment(label_userName,
				new Alignment(48));
		
		return verticalLayout_profile;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_profileInfo() {
		// common part: create layout
		verticalLayout_profileInfo = new VerticalLayout();
		verticalLayout_profileInfo.setImmediate(false);
		verticalLayout_profileInfo.setWidth("-1px");
		verticalLayout_profileInfo.setHeight("-1px");
		verticalLayout_profileInfo.setMargin(false);
		
		// label_info
		label_info = new Label();
		label_info.setImmediate(false);
		label_info.setWidth("-1px");
		label_info.setHeight("-1px");
		label_info.setValue("Label");
		verticalLayout_profileInfo.addComponent(label_info);
		
		// nativeButton_signOut
		nativeButton_signOut = new NativeButton();
		nativeButton_signOut.setCaption("NativeButton");
		nativeButton_signOut.setImmediate(true);
		nativeButton_signOut.setWidth("-1px");
		nativeButton_signOut.setHeight("-1px");
		verticalLayout_profileInfo.addComponent(nativeButton_signOut);
		
		return verticalLayout_profileInfo;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("100.0%");
		horizontalLayout_1.setHeight("100.0%");
		horizontalLayout_1.setMargin(false);
		
		// textField_search
		textField_search = new TextField();
		textField_search.setImmediate(false);
		textField_search.setWidth("100.0%");
		textField_search.setHeight("100.0%");
		horizontalLayout_1.addComponent(textField_search);
		horizontalLayout_1.setExpandRatio(textField_search, 1.0f);
		horizontalLayout_1.setComponentAlignment(textField_search,
				new Alignment(48));
		
		// nativeButton_Search
		nativeButton_Search = new NativeButton();
		nativeButton_Search.setCaption("NativeButton");
		nativeButton_Search.setImmediate(true);
		nativeButton_Search.setWidth("100.0%");
		nativeButton_Search.setHeight("100.0%");
		horizontalLayout_1.addComponent(nativeButton_Search);
		horizontalLayout_1.setExpandRatio(nativeButton_Search, 0.25f);
		horizontalLayout_1.setComponentAlignment(nativeButton_Search,
				new Alignment(48));
		
		return horizontalLayout_1;
	}

}
