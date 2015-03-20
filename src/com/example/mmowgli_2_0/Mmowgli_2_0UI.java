package com.example.mmowgli_2_0;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
@Theme("mmowgli_2_0")
public class Mmowgli_2_0UI extends UI {
	
	private FilesystemContainer doc = new FilesystemContainer(new File("C:\\Users\\Kilsuf"));
//	ComboBox doclist = new ComboBox("Documents", doc);
	//create a table instead of combobox
	private Table doclist = new Table("Documents", doc);
	//Label docView = new Label("", ContentMode.HTML); //replaced with Doceditor
	private DocEditor docView = new DocEditor();
	private SideBar staticbar = new SideBar();
	private HomePageUpdates hpUpdates = new HomePageUpdates();
	private HomePage home = new HomePage();
	
	//Windows
	//private Window mainWindow = new Window();
	private HorizontalLayout content = new HorizontalLayout();
	private AbsoluteLayout holder = new AbsoluteLayout();
	private Panel main = new Panel();
	private Window mainWindow = new Window("My Application");
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Mmowgli_2_0UI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	
	@Override
	protected void init(VaadinRequest request) {
		

		main.setContent(content);
		
		content.addComponent(home);
		//content.setWidth("1366px");
		//content.setHeight("800px");

	
		//setContent(main);
		content.setSizeFull();
		setContent(content);
		
		//set the aspect ratio
		//split.setExpandRatio(staticbar, 0.1f);
		//split.setExpandRatio(homePage, 1.0f);
		
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
		//doclist.setImmediate(true);
		
		//selection isnt enabled for tables automatically, so we will enable it here
		//doclist.setSelectable(true);
		
	}

}