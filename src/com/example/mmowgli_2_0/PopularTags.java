package com.example.mmowgli_2_0;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;

public class PopularTags extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private GridLayout gridLayout_2;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_15;
	@AutoGenerated
	private Link link_12;
	@AutoGenerated
	private Label label_15;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_14;
	@AutoGenerated
	private Link link_11;
	@AutoGenerated
	private Label label_10;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_13;
	@AutoGenerated
	private Link link_10;
	@AutoGenerated
	private Label label_5;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_10;
	@AutoGenerated
	private Link link_8;
	@AutoGenerated
	private Label label_14;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_11;
	@AutoGenerated
	private Link link_9;
	@AutoGenerated
	private Label label_9;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_12;
	@AutoGenerated
	private Link link_7;
	@AutoGenerated
	private Label label_4;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_9;
	@AutoGenerated
	private Link link_6;
	@AutoGenerated
	private Label label_13;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_8;
	@AutoGenerated
	private Link link_5;
	@AutoGenerated
	private Label label_8;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_7;
	@AutoGenerated
	private Link link_4;
	@AutoGenerated
	private Label label_3;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private Link link_3;
	@AutoGenerated
	private Label label_12;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private Link link_2;
	@AutoGenerated
	private Label label_7;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Link link_1;
	@AutoGenerated
	private Label label_2;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_6;
	@AutoGenerated
	private Link link_21;
	@AutoGenerated
	private Label label_11;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Link link_18;
	@AutoGenerated
	private Label label_6;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_5;
	@AutoGenerated
	private Link link_17;
	@AutoGenerated
	private Label label_1;
	@AutoGenerated
	private Label label_title;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PopularTags() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		//gridLayout_2.setRowExpandRatio(rowIndex, ratio);
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// label_title
		label_title = new Label();
		label_title.setImmediate(false);
		label_title.setWidth("-1px");
		label_title.setHeight("-1px");
		label_title.setValue("All Time Most popular Tags");
		mainLayout.addComponent(label_title);
		mainLayout.setExpandRatio(label_title, 0.5f);
		mainLayout.setComponentAlignment(label_title, new Alignment(24));
		
		// gridLayout_2
		gridLayout_2 = buildGridLayout_2();
		mainLayout.addComponent(gridLayout_2);
		mainLayout.setExpandRatio(gridLayout_2, 1.0f);
		mainLayout.setComponentAlignment(gridLayout_2, new Alignment(48));
		
		return mainLayout;
	}

	@AutoGenerated
	private GridLayout buildGridLayout_2() {
		// common part: create layout
		gridLayout_2 = new GridLayout();
		gridLayout_2.setImmediate(false);
		gridLayout_2.setWidth("50.0%");
		gridLayout_2.setHeight("75.0%");
		gridLayout_2.setMargin(false);
		gridLayout_2.setSpacing(true);
		gridLayout_2.setColumns(3);
		gridLayout_2.setRows(5);
		
		// horizontalLayout_5
		horizontalLayout_5 = buildHorizontalLayout_5();
		gridLayout_2.addComponent(horizontalLayout_5, 0, 0);
		gridLayout_2.setComponentAlignment(horizontalLayout_5,
				new Alignment(48));
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		gridLayout_2.addComponent(horizontalLayout_2, 1, 0);
		gridLayout_2.setComponentAlignment(horizontalLayout_2,
				new Alignment(48));
		
		// horizontalLayout_6
		horizontalLayout_6 = buildHorizontalLayout_6();
		gridLayout_2.addComponent(horizontalLayout_6, 2, 0);
		gridLayout_2.setComponentAlignment(horizontalLayout_6,
				new Alignment(48));
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		gridLayout_2.addComponent(horizontalLayout_1, 0, 1);
		gridLayout_2.setComponentAlignment(horizontalLayout_1,
				new Alignment(48));
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		gridLayout_2.addComponent(horizontalLayout_3, 1, 1);
		gridLayout_2.setComponentAlignment(horizontalLayout_3,
				new Alignment(48));
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		gridLayout_2.addComponent(horizontalLayout_4, 2, 1);
		gridLayout_2.setComponentAlignment(horizontalLayout_4,
				new Alignment(48));
		
		// horizontalLayout_7
		horizontalLayout_7 = buildHorizontalLayout_7();
		gridLayout_2.addComponent(horizontalLayout_7, 0, 2);
		gridLayout_2.setComponentAlignment(horizontalLayout_7,
				new Alignment(48));
		
		// horizontalLayout_8
		horizontalLayout_8 = buildHorizontalLayout_8();
		gridLayout_2.addComponent(horizontalLayout_8, 1, 2);
		gridLayout_2.setComponentAlignment(horizontalLayout_8,
				new Alignment(48));
		
		// horizontalLayout_9
		horizontalLayout_9 = buildHorizontalLayout_9();
		gridLayout_2.addComponent(horizontalLayout_9, 2, 2);
		gridLayout_2.setComponentAlignment(horizontalLayout_9,
				new Alignment(48));
		
		// horizontalLayout_12
		horizontalLayout_12 = buildHorizontalLayout_12();
		gridLayout_2.addComponent(horizontalLayout_12, 0, 3);
		gridLayout_2.setComponentAlignment(horizontalLayout_12, new Alignment(
				48));
		
		// horizontalLayout_11
		horizontalLayout_11 = buildHorizontalLayout_11();
		gridLayout_2.addComponent(horizontalLayout_11, 1, 3);
		gridLayout_2.setComponentAlignment(horizontalLayout_11, new Alignment(
				48));
		
		// horizontalLayout_10
		horizontalLayout_10 = buildHorizontalLayout_10();
		gridLayout_2.addComponent(horizontalLayout_10, 2, 3);
		gridLayout_2.setComponentAlignment(horizontalLayout_10, new Alignment(
				48));
		
		// horizontalLayout_13
		horizontalLayout_13 = buildHorizontalLayout_13();
		gridLayout_2.addComponent(horizontalLayout_13, 0, 4);
		gridLayout_2.setComponentAlignment(horizontalLayout_13, new Alignment(
				48));
		
		// horizontalLayout_14
		horizontalLayout_14 = buildHorizontalLayout_14();
		gridLayout_2.addComponent(horizontalLayout_14, 1, 4);
		gridLayout_2.setComponentAlignment(horizontalLayout_14, new Alignment(
				48));
		
		// horizontalLayout_15
		horizontalLayout_15 = buildHorizontalLayout_15();
		gridLayout_2.addComponent(horizontalLayout_15, 2, 4);
		gridLayout_2.setComponentAlignment(horizontalLayout_15, new Alignment(
				48));
		
		return gridLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_5() {
		// common part: create layout
		horizontalLayout_5 = new HorizontalLayout();
		horizontalLayout_5.setImmediate(false);
		horizontalLayout_5.setWidth("-1px");
		horizontalLayout_5.setHeight("-1px");
		horizontalLayout_5.setMargin(false);
		horizontalLayout_5.setSpacing(true);
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		label_1.setValue("1.)");
		horizontalLayout_5.addComponent(label_1);
		
		// link_17
		link_17 = new Link();
		link_17.setCaption("Link");
		link_17.setImmediate(false);
		link_17.setWidth("-1px");
		link_17.setHeight("-1px");
		horizontalLayout_5.addComponent(link_17);
		
		return horizontalLayout_5;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("-1px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		horizontalLayout_2.setSpacing(true);
		
		// label_6
		label_6 = new Label();
		label_6.setImmediate(false);
		label_6.setWidth("-1px");
		label_6.setHeight("-1px");
		label_6.setValue("6.)");
		horizontalLayout_2.addComponent(label_6);
		
		// link_18
		link_18 = new Link();
		link_18.setCaption("Link");
		link_18.setImmediate(false);
		link_18.setWidth("-1px");
		link_18.setHeight("-1px");
		horizontalLayout_2.addComponent(link_18);
		
		return horizontalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_6() {
		// common part: create layout
		horizontalLayout_6 = new HorizontalLayout();
		horizontalLayout_6.setImmediate(false);
		horizontalLayout_6.setWidth("-1px");
		horizontalLayout_6.setHeight("-1px");
		horizontalLayout_6.setMargin(false);
		horizontalLayout_6.setSpacing(true);
		
		// label_11
		label_11 = new Label();
		label_11.setImmediate(false);
		label_11.setWidth("-1px");
		label_11.setHeight("-1px");
		label_11.setValue("11.)");
		horizontalLayout_6.addComponent(label_11);
		
		// link_21
		link_21 = new Link();
		link_21.setCaption("Link");
		link_21.setImmediate(false);
		link_21.setWidth("-1px");
		link_21.setHeight("-1px");
		horizontalLayout_6.addComponent(link_21);
		
		return horizontalLayout_6;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("-1px");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		horizontalLayout_1.setSpacing(true);
		
		// label_2
		label_2 = new Label();
		label_2.setImmediate(false);
		label_2.setWidth("-1px");
		label_2.setHeight("-1px");
		label_2.setValue("2.)");
		horizontalLayout_1.addComponent(label_2);
		
		// link_1
		link_1 = new Link();
		link_1.setCaption("Link");
		link_1.setImmediate(false);
		link_1.setWidth("-1px");
		link_1.setHeight("-1px");
		horizontalLayout_1.addComponent(link_1);
		
		return horizontalLayout_1;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_3() {
		// common part: create layout
		horizontalLayout_3 = new HorizontalLayout();
		horizontalLayout_3.setImmediate(false);
		horizontalLayout_3.setWidth("-1px");
		horizontalLayout_3.setHeight("-1px");
		horizontalLayout_3.setMargin(false);
		horizontalLayout_3.setSpacing(true);
		
		// label_7
		label_7 = new Label();
		label_7.setImmediate(false);
		label_7.setWidth("-1px");
		label_7.setHeight("-1px");
		label_7.setValue("7.)");
		horizontalLayout_3.addComponent(label_7);
		
		// link_2
		link_2 = new Link();
		link_2.setCaption("Link");
		link_2.setImmediate(false);
		link_2.setWidth("-1px");
		link_2.setHeight("-1px");
		horizontalLayout_3.addComponent(link_2);
		
		return horizontalLayout_3;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_4() {
		// common part: create layout
		horizontalLayout_4 = new HorizontalLayout();
		horizontalLayout_4.setImmediate(false);
		horizontalLayout_4.setWidth("-1px");
		horizontalLayout_4.setHeight("-1px");
		horizontalLayout_4.setMargin(false);
		horizontalLayout_4.setSpacing(true);
		
		// label_12
		label_12 = new Label();
		label_12.setImmediate(false);
		label_12.setWidth("-1px");
		label_12.setHeight("-1px");
		label_12.setValue("12.)");
		horizontalLayout_4.addComponent(label_12);
		
		// link_3
		link_3 = new Link();
		link_3.setCaption("Link");
		link_3.setImmediate(false);
		link_3.setWidth("-1px");
		link_3.setHeight("-1px");
		horizontalLayout_4.addComponent(link_3);
		
		return horizontalLayout_4;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_7() {
		// common part: create layout
		horizontalLayout_7 = new HorizontalLayout();
		horizontalLayout_7.setImmediate(false);
		horizontalLayout_7.setWidth("-1px");
		horizontalLayout_7.setHeight("-1px");
		horizontalLayout_7.setMargin(false);
		horizontalLayout_7.setSpacing(true);
		
		// label_3
		label_3 = new Label();
		label_3.setImmediate(false);
		label_3.setWidth("-1px");
		label_3.setHeight("-1px");
		label_3.setValue("3.)");
		horizontalLayout_7.addComponent(label_3);
		
		// link_4
		link_4 = new Link();
		link_4.setCaption("Link");
		link_4.setImmediate(false);
		link_4.setWidth("-1px");
		link_4.setHeight("-1px");
		horizontalLayout_7.addComponent(link_4);
		
		return horizontalLayout_7;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_8() {
		// common part: create layout
		horizontalLayout_8 = new HorizontalLayout();
		horizontalLayout_8.setImmediate(false);
		horizontalLayout_8.setWidth("-1px");
		horizontalLayout_8.setHeight("-1px");
		horizontalLayout_8.setMargin(false);
		horizontalLayout_8.setSpacing(true);
		
		// label_8
		label_8 = new Label();
		label_8.setImmediate(false);
		label_8.setWidth("-1px");
		label_8.setHeight("-1px");
		label_8.setValue("8.)");
		horizontalLayout_8.addComponent(label_8);
		
		// link_5
		link_5 = new Link();
		link_5.setCaption("Link");
		link_5.setImmediate(false);
		link_5.setWidth("-1px");
		link_5.setHeight("-1px");
		horizontalLayout_8.addComponent(link_5);
		
		return horizontalLayout_8;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_9() {
		// common part: create layout
		horizontalLayout_9 = new HorizontalLayout();
		horizontalLayout_9.setImmediate(false);
		horizontalLayout_9.setWidth("-1px");
		horizontalLayout_9.setHeight("-1px");
		horizontalLayout_9.setMargin(false);
		horizontalLayout_9.setSpacing(true);
		
		// label_13
		label_13 = new Label();
		label_13.setImmediate(false);
		label_13.setWidth("-1px");
		label_13.setHeight("-1px");
		label_13.setValue("13.)");
		horizontalLayout_9.addComponent(label_13);
		
		// link_6
		link_6 = new Link();
		link_6.setCaption("Link");
		link_6.setImmediate(false);
		link_6.setWidth("-1px");
		link_6.setHeight("-1px");
		horizontalLayout_9.addComponent(link_6);
		
		return horizontalLayout_9;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_12() {
		// common part: create layout
		horizontalLayout_12 = new HorizontalLayout();
		horizontalLayout_12.setImmediate(false);
		horizontalLayout_12.setWidth("-1px");
		horizontalLayout_12.setHeight("-1px");
		horizontalLayout_12.setMargin(false);
		horizontalLayout_12.setSpacing(true);
		
		// label_4
		label_4 = new Label();
		label_4.setImmediate(false);
		label_4.setWidth("-1px");
		label_4.setHeight("-1px");
		label_4.setValue("4.)");
		horizontalLayout_12.addComponent(label_4);
		
		// link_7
		link_7 = new Link();
		link_7.setCaption("Link");
		link_7.setImmediate(false);
		link_7.setWidth("-1px");
		link_7.setHeight("-1px");
		horizontalLayout_12.addComponent(link_7);
		
		return horizontalLayout_12;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_11() {
		// common part: create layout
		horizontalLayout_11 = new HorizontalLayout();
		horizontalLayout_11.setImmediate(false);
		horizontalLayout_11.setWidth("-1px");
		horizontalLayout_11.setHeight("-1px");
		horizontalLayout_11.setMargin(false);
		horizontalLayout_11.setSpacing(true);
		
		// label_9
		label_9 = new Label();
		label_9.setImmediate(false);
		label_9.setWidth("-1px");
		label_9.setHeight("-1px");
		label_9.setValue("9.)");
		horizontalLayout_11.addComponent(label_9);
		
		// link_9
		link_9 = new Link();
		link_9.setCaption("Link");
		link_9.setImmediate(false);
		link_9.setWidth("-1px");
		link_9.setHeight("-1px");
		horizontalLayout_11.addComponent(link_9);
		
		return horizontalLayout_11;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_10() {
		// common part: create layout
		horizontalLayout_10 = new HorizontalLayout();
		horizontalLayout_10.setImmediate(false);
		horizontalLayout_10.setWidth("-1px");
		horizontalLayout_10.setHeight("-1px");
		horizontalLayout_10.setMargin(false);
		horizontalLayout_10.setSpacing(true);
		
		// label_14
		label_14 = new Label();
		label_14.setImmediate(false);
		label_14.setWidth("-1px");
		label_14.setHeight("-1px");
		label_14.setValue("14.)");
		horizontalLayout_10.addComponent(label_14);
		
		// link_8
		link_8 = new Link();
		link_8.setCaption("Link");
		link_8.setImmediate(false);
		link_8.setWidth("-1px");
		link_8.setHeight("-1px");
		horizontalLayout_10.addComponent(link_8);
		
		return horizontalLayout_10;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_13() {
		// common part: create layout
		horizontalLayout_13 = new HorizontalLayout();
		horizontalLayout_13.setImmediate(false);
		horizontalLayout_13.setWidth("-1px");
		horizontalLayout_13.setHeight("-1px");
		horizontalLayout_13.setMargin(false);
		horizontalLayout_13.setSpacing(true);
		
		// label_5
		label_5 = new Label();
		label_5.setImmediate(false);
		label_5.setWidth("-1px");
		label_5.setHeight("-1px");
		label_5.setValue("5.)");
		horizontalLayout_13.addComponent(label_5);
		
		// link_10
		link_10 = new Link();
		link_10.setCaption("Link");
		link_10.setImmediate(false);
		link_10.setWidth("-1px");
		link_10.setHeight("-1px");
		horizontalLayout_13.addComponent(link_10);
		
		return horizontalLayout_13;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_14() {
		// common part: create layout
		horizontalLayout_14 = new HorizontalLayout();
		horizontalLayout_14.setImmediate(false);
		horizontalLayout_14.setWidth("-1px");
		horizontalLayout_14.setHeight("-1px");
		horizontalLayout_14.setMargin(false);
		horizontalLayout_14.setSpacing(true);
		
		// label_10
		label_10 = new Label();
		label_10.setImmediate(false);
		label_10.setWidth("-1px");
		label_10.setHeight("-1px");
		label_10.setValue("10.)");
		horizontalLayout_14.addComponent(label_10);
		
		// link_11
		link_11 = new Link();
		link_11.setCaption("Link");
		link_11.setImmediate(false);
		link_11.setWidth("-1px");
		link_11.setHeight("-1px");
		horizontalLayout_14.addComponent(link_11);
		
		return horizontalLayout_14;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_15() {
		// common part: create layout
		horizontalLayout_15 = new HorizontalLayout();
		horizontalLayout_15.setImmediate(false);
		horizontalLayout_15.setWidth("-1px");
		horizontalLayout_15.setHeight("-1px");
		horizontalLayout_15.setMargin(false);
		horizontalLayout_15.setSpacing(true);
		
		// label_15
		label_15 = new Label();
		label_15.setImmediate(false);
		label_15.setWidth("-1px");
		label_15.setHeight("-1px");
		label_15.setValue("15.)");
		horizontalLayout_15.addComponent(label_15);
		
		// link_12
		link_12 = new Link();
		link_12.setCaption("Link");
		link_12.setImmediate(false);
		link_12.setWidth("-1px");
		link_12.setHeight("-1px");
		horizontalLayout_15.addComponent(link_12);
		
		return horizontalLayout_15;
	}

}
