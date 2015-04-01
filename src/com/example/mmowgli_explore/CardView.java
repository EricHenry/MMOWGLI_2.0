package com.example.mmowgli_explore;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.VerticalLayout;

public class CardView extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_cardLinks;

	@AutoGenerated
	private NativeButton nativeButton_addCard;

	@AutoGenerated
	private HorizontalLayout horizontalLayout_cardText;

	@AutoGenerated
	private NativeButton nativeButton_text;

	@AutoGenerated
	private GridLayout gridLayout_cardInfo;

	@AutoGenerated
	private NativeButton nativeButton_favorite;

	@AutoGenerated
	private VerticalLayout voteContainer;

	@AutoGenerated
	private NativeButton nativeButton_downvote;

	@AutoGenerated
	private NativeButton nativeButton_upvote;

	@AutoGenerated
	private Label voteCount;

	@AutoGenerated
	private Label date;

	@AutoGenerated
	private Link user;

	@AutoGenerated
	private Label cardType;

	//Attributes
	private String cardId;
	private boolean isMini = true;
	private String parent;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public CardView() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		initCardStyling();
		
		shrinkCardView();
	}

	/**
	 * Construct a card object with a specified unique identifier
	 * 
	 * @param id -> unique identifier of the card
	 */
	public CardView(String id) {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		
		//set the unique identifier of this card.
		this.cardId = id;
		
		initCardStyling();
		
		shrinkCardView();
	}
	
	/**
	 * Constructor with specified card data.
	 * 
	 * @param id			-> The unique card ID
	 * @param playerId		-> The unique player who created this card
	 * @param cardText		-> Text written by the player
	 * @param cardType		-> The one of 6 card types the card can be 
	 * @param parent		-> The ID of this card's parent
	 * @param vote			-> The number of votes that the card has acquired
	 * @param date			-> When the card was created
	 */
	public CardView(String id, String playerId, String cardText, String cardType, String parent, String vote, String date) {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		
		//set the values form the parameters.
		this.cardId = id;
		this.user.setCaption(playerId);
		this.nativeButton_text.setCaption(cardText);
		setCardType(cardType);
		this.parent = parent;
		this.voteCount.setValue(vote);
		this.date.setValue(date);
		
		initCardStyling();
		
		shrinkCardView();
	}
	
	/**
	 * Copy Constructor
	 */
	public CardView(CardView copy){
		this.cardId = copy.getCardId();
		this.nativeButton_downvote = copy.getNativeButton_downvote();
		this.nativeButton_favorite = copy.getNativeButton_favorite();
		this.nativeButton_upvote = copy.getNativeButton_upvote();
		this.gridLayout_cardInfo = copy.getGridLayout_cardInfo();
		this.horizontalLayout_cardLinks = copy.getHorizontalLayout_cardLinks();
		this.horizontalLayout_cardText = copy.getHorizontalLayout_cardText();
		this.isMini = copy.isMini();
		this.cardType = copy.getCardType();
		this.date = copy.getDate();
		this.voteCount = copy.getVoteCount();
		this.user = copy.getUser();
		this.mainLayout = copy.getMainLayout();
		this.nativeButton_addCard = copy.getNativeButton_addCard();
		this.nativeButton_text = copy.getNativeButton_text();
		this.voteContainer = copy.getVoteContainer();
		this.parent = copy.getCardParent();
	}
	
	/**
	 * Test initStyling class
	 */
	public void initCardStyling(){
		//set topbar label & link styling
		cardType.setStyleName("center");
		user.setStyleName("center");
		date.setStyleName("center");
		voteCount.setStyleName("center");
				
				
		//card upvote / downvote
		nativeButton_upvote.setCaption(null);
		nativeButton_upvote.setIcon(new ThemeResource("images/icons/cards/upArrrow.png"));
		nativeButton_upvote.setStyleName("cardButtons");
				
		nativeButton_downvote.setCaption(null);
		nativeButton_downvote.setIcon(new ThemeResource("images/icons/cards/downArrow.png"));
		nativeButton_downvote.setStyleName("cardButtons");
				
		//vote number styling
		//label_voteCount.setStyleName("cardVotes");
				
		//card favorite
		nativeButton_favorite.setCaption(null);
		nativeButton_favorite.setIcon(new ThemeResource("images/icons/cards/star.png"));
		nativeButton_favorite.setStyleName("cardTextMini");
				
		//card text
		//nativeButton_text.setCaption("Lorem ipsum dolor sit amet, consectetur adipiscing elit Cras sodales eros ut ipsum ultricies eleifend. Vivamus justo ipsum, rutrum vel orciv vel orciv"); //150 characters
				
		//add card
		nativeButton_addCard.setCaption(null);
		nativeButton_addCard.setIcon(new ThemeResource("images/icons/cards/plus.png"));
				
		horizontalLayout_cardText.setStyleName("cardText");
		horizontalLayout_cardLinks.setStyleName("cardBottom");
		

	}
	
	
	public void setAddCardButtonListener(){
		
		
	}
	
	public void setFavoriteButtonListener(){
		
	}

	public void setUpVoteButtonListener(){
		
	}
	
	public void setDownVoteButtonListener(){
		
	}
	
	/**
	 * Sets a card's background of the top bar
	 * @param cardType - specifies which of the four types a card should be
	 */
	public void setCardColor(String cardType){
		
		gridLayout_cardInfo.setStyleName("cardType" + cardType);	
	}
	
	/**
	 * Sets the card type, This changes the card's label to reflect the type.
	 * 	e.g. cardType = Adapt -> will change the label of the card to reflect the type.
	 * 
	 * TODO -> have this method call SetCardColor to automatically change the styling when the type is set.
	 * 
	 * @param cardType -> Specifies what type of card
	 */
	public void setCardType(String newCardType){
		
		this.cardType.setValue(newCardType);
		setCardColor(newCardType);
		
	}
	
	/**
	 * Set the styling of the card to a shrunken view
	 */
	public void shrinkCardView(){
		//cardView_1.getNativeButton_text().setCaption("POOP");
		nativeButton_text.setStyleName("cardTextMini");
		nativeButton_addCard.setStyleName("cardTextMini");
		
		horizontalLayout_cardText.setHeight("-1");
		mainLayout.setExpandRatio(horizontalLayout_cardLinks, 1.0f);
		mainLayout.setHeight("100px");
		isMini = true;
	}
	
	/**
	 * Set the styling of the card to the full view
	 */
	public void expandCardView(){
		nativeButton_text.setStyleName("cardButtons");
		nativeButton_addCard.setStyleName("cardButtons");
		
		horizontalLayout_cardText.setHeight("100%");
		mainLayout.setExpandRatio(horizontalLayout_cardLinks, 0.1f);
		mainLayout.setHeight("200px");
		isMini = false;
	}
	
	/**
	 * Add opacity to the card, making the card appear more transparent / faded
	 */
	public void addTransparency(){
		mainLayout.setStyleName("transparent");
	}
	
	/**
	 * Remove the card's opacity. This takes away the faded effect of the card.
	 */
	public void removeTransparency(){
		mainLayout.removeStyleName("transparent");
	}
	
	/**
	 * 
	 * @param card -> The CardView to test against
	 * @return
	 * 		- True if the card ids are equal
	 */
	public boolean equals(CardView card){
		
		//catch if the current card is null
		try{
			if(this.cardId != card.getCardId())
				return false;
			else 
				return true;
		}catch(NullPointerException e){
			return false;
		}
		
	}

	//Getters and Setters
	public GridLayout getGridLayout_cardInfo() {
		return gridLayout_cardInfo;
	}

	public void setGridLayout_cardInfo(GridLayout gridLayout_cardInfo) {
		this.gridLayout_cardInfo = gridLayout_cardInfo;
	}

	public NativeButton getNativeButton_favorite() {
		return nativeButton_favorite;
	}

	public void setNativeButton_favorite(NativeButton nativeButton_favorite) {
		this.nativeButton_favorite = nativeButton_favorite;
	}

	public VerticalLayout getVoteContainer() {
		return voteContainer;
	}

	public void setVoteContainer(VerticalLayout voteContainer) {
		this.voteContainer = voteContainer;
	}

	public NativeButton getNativeButton_downvote() {
		return nativeButton_downvote;
	}

	public void setNativeButton_downvote(NativeButton nativeButton_downvote) {
		this.nativeButton_downvote = nativeButton_downvote;
	}

	public NativeButton getNativeButton_upvote() {
		return nativeButton_upvote;
	}

	public void setNativeButton_upvote(NativeButton nativeButton_upvote) {
		this.nativeButton_upvote = nativeButton_upvote;
	}

	public Label getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Label voteCount) {
		this.voteCount = voteCount;
	}

	public Label getDate() {
		return date;
	}

	public void setDate(Label date) {
		this.date = date;
	}

	public Link getUser() {
		return user;
	}

	public void setUser(Link user) {
		this.user = user;
	}

	public Label getCardType() {
		return cardType;
	}

	public void setCardType(Label cardType) {
		this.cardType = cardType;
	}
	public boolean isMini() {
		return isMini;
	}

	public void setMini(boolean isMini) {
		this.isMini = isMini;
	}
	
	public VerticalLayout getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(VerticalLayout mainLayout) {
		this.mainLayout = mainLayout;
	}
	
	public HorizontalLayout getHorizontalLayout_cardLinks() {
		return horizontalLayout_cardLinks;
	}

	public void setHorizontalLayout_cardLinks(
			HorizontalLayout horizontalLayout_cardLinks) {
		this.horizontalLayout_cardLinks = horizontalLayout_cardLinks;
	}

	public NativeButton getNativeButton_addCard() {
		return nativeButton_addCard;
	}

	public void setNativeButton_addCard(NativeButton nativeButton_addCard) {
		this.nativeButton_addCard = nativeButton_addCard;
	}

	public HorizontalLayout getHorizontalLayout_cardText() {
		return horizontalLayout_cardText;
	}

	public void setHorizontalLayout_cardText(
			HorizontalLayout horizontalLayout_cardText) {
		this.horizontalLayout_cardText = horizontalLayout_cardText;
	}

	public NativeButton getNativeButton_text() {
		return nativeButton_text;
	}

	public void setNativeButton_text(NativeButton nativeButton_text) {
		this.nativeButton_text = nativeButton_text;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("340px");
		mainLayout.setHeight("200px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("340px");
		setHeight("200px");
		
		// gridLayout_cardInfo
		gridLayout_cardInfo = buildGridLayout_cardInfo();
		mainLayout.addComponent(gridLayout_cardInfo);
		
		// horizontalLayout_cardText
		horizontalLayout_cardText = buildHorizontalLayout_cardText();
		mainLayout.addComponent(horizontalLayout_cardText);
		mainLayout.setExpandRatio(horizontalLayout_cardText, 1.0f);
		
		// horizontalLayout_cardLinks
		horizontalLayout_cardLinks = buildHorizontalLayout_cardLinks();
		mainLayout.addComponent(horizontalLayout_cardLinks);
		mainLayout.setExpandRatio(horizontalLayout_cardLinks, 0.1f);
		mainLayout.setComponentAlignment(horizontalLayout_cardLinks,
				new Alignment(24));
		
		return mainLayout;
	}

	@AutoGenerated
	private GridLayout buildGridLayout_cardInfo() {
		// common part: create layout
		gridLayout_cardInfo = new GridLayout();
		gridLayout_cardInfo.setImmediate(false);
		gridLayout_cardInfo.setWidth("340px");
		gridLayout_cardInfo.setHeight("35px");
		gridLayout_cardInfo.setMargin(false);
		gridLayout_cardInfo.setColumns(6);
		
		// cardType
		cardType = new Label();
		cardType.setImmediate(false);
		cardType.setWidth("-1px");
		cardType.setHeight("-1px");
		gridLayout_cardInfo.addComponent(cardType, 0, 0);
		gridLayout_cardInfo.setComponentAlignment(cardType, new Alignment(48));
		
		// user
		user = new Link();
		user.setImmediate(false);
		user.setWidth("-1px");
		user.setHeight("-1px");
		gridLayout_cardInfo.addComponent(user, 1, 0);
		gridLayout_cardInfo.setComponentAlignment(user, new Alignment(48));
		
		// date
		date = new Label();
		date.setImmediate(false);
		date.setWidth("-1px");
		date.setHeight("-1px");
		gridLayout_cardInfo.addComponent(date, 2, 0);
		gridLayout_cardInfo.setComponentAlignment(date, new Alignment(34));
		
		// voteCount
		voteCount = new Label();
		voteCount.setImmediate(false);
		voteCount.setWidth("-1px");
		voteCount.setHeight("-1px");
		gridLayout_cardInfo.addComponent(voteCount, 3, 0);
		gridLayout_cardInfo.setComponentAlignment(voteCount, new Alignment(34));
		
		// voteContainer
		voteContainer = buildVoteContainer();
		gridLayout_cardInfo.addComponent(voteContainer, 4, 0);
		gridLayout_cardInfo.setComponentAlignment(voteContainer, new Alignment(
				48));
		
		// nativeButton_favorite
		nativeButton_favorite = new NativeButton();
		nativeButton_favorite.setCaption("NativeButton");
		nativeButton_favorite.setImmediate(true);
		nativeButton_favorite.setWidth("35px");
		nativeButton_favorite.setHeight("35px");
		gridLayout_cardInfo.addComponent(nativeButton_favorite, 5, 0);
		gridLayout_cardInfo.setComponentAlignment(nativeButton_favorite,
				new Alignment(33));
		
		return gridLayout_cardInfo;
	}

	@AutoGenerated
	private VerticalLayout buildVoteContainer() {
		// common part: create layout
		voteContainer = new VerticalLayout();
		voteContainer.setImmediate(false);
		voteContainer.setWidth("25px");
		voteContainer.setHeight("35px");
		voteContainer.setMargin(false);
		
		// nativeButton_upvote
		nativeButton_upvote = new NativeButton();
		nativeButton_upvote.setCaption("NativeButton");
		nativeButton_upvote.setImmediate(true);
		nativeButton_upvote.setWidth("20px");
		nativeButton_upvote.setHeight("15px");
		voteContainer.addComponent(nativeButton_upvote);
		
		// nativeButton_downvote
		nativeButton_downvote = new NativeButton();
		nativeButton_downvote.setCaption("NativeButton");
		nativeButton_downvote.setImmediate(true);
		nativeButton_downvote.setWidth("20px");
		nativeButton_downvote.setHeight("15px");
		voteContainer.addComponent(nativeButton_downvote);
		
		return voteContainer;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_cardText() {
		// common part: create layout
		horizontalLayout_cardText = new HorizontalLayout();
		horizontalLayout_cardText.setImmediate(false);
		horizontalLayout_cardText.setWidth("100.0%");
		horizontalLayout_cardText.setHeight("100.0%");
		horizontalLayout_cardText.setMargin(false);
		
		// nativeButton_text
		nativeButton_text = new NativeButton();
		nativeButton_text.setCaption("NativeButton");
		nativeButton_text.setImmediate(true);
		nativeButton_text.setWidth("100.0%");
		nativeButton_text.setHeight("100.0%");
		horizontalLayout_cardText.addComponent(nativeButton_text);
		
		return horizontalLayout_cardText;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_cardLinks() {
		// common part: create layout
		horizontalLayout_cardLinks = new HorizontalLayout();
		horizontalLayout_cardLinks.setImmediate(false);
		horizontalLayout_cardLinks.setWidth("100.0%");
		horizontalLayout_cardLinks.setHeight("-1px");
		horizontalLayout_cardLinks.setMargin(false);
		
		// nativeButton_addCard
		nativeButton_addCard = new NativeButton();
		nativeButton_addCard.setCaption("NativeButton");
		nativeButton_addCard.setImmediate(true);
		nativeButton_addCard.setWidth("-1px");
		nativeButton_addCard.setHeight("-1px");
		horizontalLayout_cardLinks.addComponent(nativeButton_addCard);
		horizontalLayout_cardLinks.setComponentAlignment(nativeButton_addCard,
				new Alignment(10));
		
		return horizontalLayout_cardLinks;
	}

}
