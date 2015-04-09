/**
 * @Author: Eric H Correia
 *
 * This class creates 
 * 
 */

package com.example.mmowgli_2_0;

import com.example.mmowgli_updates.PopularTags;
import com.example.mmowgli_updates.TrendingTags;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;

public class Footer extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private GridLayout gridLayout_2;

	@AutoGenerated
	private Link link_video;

	@AutoGenerated
	private Link link_twitter;

	@AutoGenerated
	private Link link_trouble;

	@AutoGenerated
	private Link link_terms;

	@AutoGenerated
	private Link link_report;

	@AutoGenerated
	private Link link_glossary;

	@AutoGenerated
	private Link link_fixes;

	@AutoGenerated
	private Link link_faq;

	@AutoGenerated
	private Link link_credits;

	@AutoGenerated
	private Link link_about;

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
	public Footer() {
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
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// gridLayout_2
		gridLayout_2 = buildGridLayout_2();
		mainLayout.addComponent(gridLayout_2);
		
		return mainLayout;
	}

	@AutoGenerated
	private GridLayout buildGridLayout_2() {
		// common part: create layout
		gridLayout_2 = new GridLayout();
		gridLayout_2.setImmediate(false);
		gridLayout_2.setWidth("100.0%");
		gridLayout_2.setHeight("-1px");
		gridLayout_2.setMargin(false);
		gridLayout_2.setSpacing(true);
		gridLayout_2.setColumns(10);
		
		// link_about
		link_about = new Link();
		link_about.setCaption("About");
		link_about.setImmediate(false);
		link_about.setWidth("-1px");
		link_about.setHeight("-1px");
		gridLayout_2.addComponent(link_about, 0, 0);
		gridLayout_2.setComponentAlignment(link_about, new Alignment(20));
		
		// link_credits
		link_credits = new Link();
		link_credits.setCaption("Credits and Contacts");
		link_credits.setImmediate(false);
		link_credits.setWidth("-1px");
		link_credits.setHeight("-1px");
		gridLayout_2.addComponent(link_credits, 1, 0);
		gridLayout_2.setComponentAlignment(link_credits, new Alignment(20));
		
		// link_faq
		link_faq = new Link();
		link_faq.setCaption("FAQs");
		link_faq.setImmediate(false);
		link_faq.setWidth("-1px");
		link_faq.setHeight("-1px");
		gridLayout_2.addComponent(link_faq, 2, 0);
		gridLayout_2.setComponentAlignment(link_faq, new Alignment(20));
		
		// link_fixes
		link_fixes = new Link();
		link_fixes.setCaption("Fixes");
		link_fixes.setImmediate(false);
		link_fixes.setWidth("-1px");
		link_fixes.setHeight("-1px");
		gridLayout_2.addComponent(link_fixes, 3, 0);
		gridLayout_2.setComponentAlignment(link_fixes, new Alignment(20));
		
		// link_glossary
		link_glossary = new Link();
		link_glossary.setCaption("Glossary");
		link_glossary.setImmediate(false);
		link_glossary.setWidth("-1px");
		link_glossary.setHeight("-1px");
		gridLayout_2.addComponent(link_glossary, 4, 0);
		gridLayout_2.setComponentAlignment(link_glossary, new Alignment(20));
		
		// link_report
		link_report = new Link();
		link_report.setCaption("Reports");
		link_report.setImmediate(false);
		link_report.setWidth("-1px");
		link_report.setHeight("-1px");
		gridLayout_2.addComponent(link_report, 5, 0);
		gridLayout_2.setComponentAlignment(link_report, new Alignment(20));
		
		// link_terms
		link_terms = new Link();
		link_terms.setCaption("Terms and Conditions");
		link_terms.setImmediate(false);
		link_terms.setWidth("-1px");
		link_terms.setHeight("-1px");
		gridLayout_2.addComponent(link_terms, 6, 0);
		gridLayout_2.setComponentAlignment(link_terms, new Alignment(20));
		
		// link_trouble
		link_trouble = new Link();
		link_trouble.setCaption("Trouble Report");
		link_trouble.setImmediate(false);
		link_trouble.setWidth("-1px");
		link_trouble.setHeight("-1px");
		gridLayout_2.addComponent(link_trouble, 7, 0);
		gridLayout_2.setComponentAlignment(link_trouble, new Alignment(20));
		
		// link_twitter
		link_twitter = new Link();
		link_twitter.setCaption("Twitter");
		link_twitter.setImmediate(false);
		link_twitter.setWidth("-1px");
		link_twitter.setHeight("-1px");
		gridLayout_2.addComponent(link_twitter, 8, 0);
		gridLayout_2.setComponentAlignment(link_twitter, new Alignment(20));
		
		// link_video
		link_video = new Link();
		link_video.setCaption("Videos");
		link_video.setImmediate(false);
		link_video.setWidth("-1px");
		link_video.setHeight("-1px");
		gridLayout_2.addComponent(link_video, 9, 0);
		gridLayout_2.setComponentAlignment(link_video, new Alignment(20));
		
		return gridLayout_2;
	}

}
