package com.example.mmowgli_explore;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class RootCardCreator extends CustomComponent{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private TabSheet tabSheet;
	@AutoGenerated
	private VerticalLayout verticalLayout_Root2;
	@AutoGenerated
	private TextArea textArea_Root2;
	@AutoGenerated
	private VerticalLayout verticalLayout_Root1;
	@AutoGenerated
	private TextArea textArea_Root1;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public RootCardCreator() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		textArea_Root2.addShortcutListener(new ShortcutListener("Shortcut Name", ShortcutAction.KeyCode.ENTER, null) {
			@Override
			public void handleAction(Object sender, Object target) {
				// your code here
				
			}
			});
		
		tabSheet.getTab(verticalLayout_Root1).setStyleName("Root1");
		tabSheet.getTab(verticalLayout_Root2).setStyleName("Root2");
		
	}
	


	public TabSheet getTabSheet() {
		return tabSheet;
	}



	public void setTabSheet(TabSheet tabSheet) {
		this.tabSheet = tabSheet;
	}



	public VerticalLayout getVerticalLayout_Root2() {
		return verticalLayout_Root2;
	}



	public void setVerticalLayout_Root2(VerticalLayout verticalLayout_Root2) {
		this.verticalLayout_Root2 = verticalLayout_Root2;
	}



	public VerticalLayout getVerticalLayout_Root1() {
		return verticalLayout_Root1;
	}



	public void setVerticalLayout_Root1(VerticalLayout verticalLayout_Root1) {
		this.verticalLayout_Root1 = verticalLayout_Root1;
	}



	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("263px");
		mainLayout.setHeight("150px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("263px");
		setHeight("150px");
		
		// tabSheet
		tabSheet = buildTabSheet();
		mainLayout.addComponent(tabSheet);
		
		return mainLayout;
	}

	@AutoGenerated
	private TabSheet buildTabSheet() {
		// common part: create layout
		tabSheet = new TabSheet();
		tabSheet.setImmediate(true);
		tabSheet.setWidth("100.0%");
		tabSheet.setHeight("100.0%");
		
		// verticalLayout_Root1
		verticalLayout_Root1 = buildVerticalLayout_Root1();
		tabSheet.addTab(verticalLayout_Root1, "Root1", null);
		
		// verticalLayout_Root2
		verticalLayout_Root2 = buildVerticalLayout_Root2();
		tabSheet.addTab(verticalLayout_Root2, "Root2", null);
		
		return tabSheet;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_Root1() {
		// common part: create layout
		verticalLayout_Root1 = new VerticalLayout();
		verticalLayout_Root1.setImmediate(false);
		verticalLayout_Root1.setWidth("100.0%");
		verticalLayout_Root1.setHeight("100.0%");
		verticalLayout_Root1.setMargin(false);
		
		// textArea_Root1
		textArea_Root1 = new TextArea();
		textArea_Root1.setImmediate(false);
		textArea_Root1.setWidth("100.0%");
		textArea_Root1.setHeight("100.0%");
		textArea_Root1.setInputPrompt("Share your thoughts");
		textArea_Root1.setMaxLength(150);
		verticalLayout_Root1.addComponent(textArea_Root1);
		
		return verticalLayout_Root1;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_Root2() {
		// common part: create layout
		verticalLayout_Root2 = new VerticalLayout();
		verticalLayout_Root2.setImmediate(false);
		verticalLayout_Root2.setWidth("100.0%");
		verticalLayout_Root2.setHeight("100.0%");
		verticalLayout_Root2.setMargin(false);
		
		// textArea_Root2
		textArea_Root2 = new TextArea();
		textArea_Root2.setImmediate(false);
		textArea_Root2.setWidth("100.0%");
		textArea_Root2.setHeight("100.0%");
		textArea_Root2.setInputPrompt("Share your thoughts");
		textArea_Root2.setMaxLength(150);
		verticalLayout_Root2.addComponent(textArea_Root2);
		
		return verticalLayout_Root2;
	}

}
