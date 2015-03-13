package com.example.mmowgli_2_0;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.example.vaddin_test.DocEditor;
import com.example.vaddin_test.Vaddin_testUI;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("mmowgli_2_0")
public class Mmowgli_2_0UI extends UI {

//	@WebServlet(value = "/*", asyncSupported = true)
//	@VaadinServletConfiguration(productionMode = false, ui = Mmowgli_2_0UI.class)
//	public static class Servlet extends VaadinServlet {
//	}
//
//	@Override
//	protected void init(VaadinRequest request) {
//		final VerticalLayout layout = new VerticalLayout();
//		layout.setMargin(true);
//		setContent(layout);
//
//		Button button = new Button("Click Me");
//		button.addClickListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//				layout.addComponent(new Label("Thank you for clicking"));
//			}
//		});
//		layout.addComponent(button);
//	}
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Mmowgli_2_0UI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	FilesystemContainer doc = new FilesystemContainer(new File("C:\\Users\\Kilsuf"));
//	ComboBox doclist = new ComboBox("Documents", doc);
	//create a table instead of combobox
	Table doclist = new Table("Documents", doc);
	//Label docView = new Label("", ContentMode.HTML); //replaced with Doceditor
	DocEditor docView = new DocEditor();
	
	
	@Override
	protected void init(VaadinRequest request) {
//		final VerticalLayout layout = new VerticalLayout();
//		layout.setMargin(true);
//		setContent(layout);
//
//		Button button = new Button("Click Me");
//		button.addClickListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//				layout.addComponent(new Label("Thank you for clicking"));
//			}
//		});
//		layout.addComponent(button);
		
		//setContent(doclist); //original way to add doclist to the screen
		
		//Create a Panal that holds components to display on the screen
		HorizontalSplitPanel split = new HorizontalSplitPanel();
		
		//Push split onto the screen
		setContent(split);
		
		//add the doclist and docView as components
		split.addComponent(doclist);
		split.addComponent(docView);
		//tell the doclist to use all the space that the split panel allows for
		doclist.setSizeFull();
		
		//Event Handler
		doclist.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(
					com.vaadin.data.Property.ValueChangeEvent event) {
				// TODO Auto-generated method stub
				//display the data once it is chosen by the doclist
				docView.setPropertyDataSource(new TextFileProperty((File) event.getProperty().getValue()));

			}

		});
		//Send events after choosing the file to show
		doclist.setImmediate(true);
		
		//selection isnt enabled for tables automatically, so we will enable it here
		doclist.setSelectable(true);
		
	}

}