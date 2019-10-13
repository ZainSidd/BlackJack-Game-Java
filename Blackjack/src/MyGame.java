import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.Random;

public class MyGame extends Game {
	private SpriteBatch batch;
	//sprites
	private Sprite background;
	private Sprite deck;

	//sprites of cards
	private Sprite twoHearts;
	private Sprite threeHearts;
	private Sprite fourHearts;
	private Sprite fiveHearts;
	private Sprite sixHearts;
	private Sprite sevenHearts;
	private Sprite eightHearts;
	private Sprite nineHearts;
	private Sprite tenHearts;
	private Sprite jackHearts;
	private Sprite queenHearts;
	private Sprite kingHearts;
	private Sprite aceHearts;

	private Sprite twoClubs;
	private Sprite threeClubs;
	private Sprite fourClubs;
	private Sprite fiveClubs;
	private Sprite sixClubs;
	private Sprite sevenClubs;
	private Sprite eightClubs;
	private Sprite nineClubs;
	private Sprite tenClubs;
	private Sprite jackClubs;
	private Sprite queenClubs;
	private Sprite kingClubs;
	private Sprite aceClubs;

	private Sprite twoSpades;
	private Sprite threeSpades;
	private Sprite fourSpades;
	private Sprite fiveSpades;
	private Sprite sixSpades;
	private Sprite sevenSpades;
	private Sprite eightSpades;
	private Sprite nineSpades;
	private Sprite tenSpades;
	private Sprite jackSpades;
	private Sprite queenSpades;
	private Sprite kingSpades;
	private Sprite aceSpades;

	private Sprite twoDiamonds;
	private Sprite threeDiamonds;
	private Sprite fourDiamonds;
	private Sprite fiveDiamonds;
	private Sprite sixDiamonds;
	private Sprite sevenDiamonds;
	private Sprite eightDiamonds;
	private Sprite nineDiamonds;
	private Sprite tenDiamonds;
	private Sprite jackDiamonds;
	private Sprite queenDiamonds;
	private Sprite kingDiamonds;
	private Sprite aceDiamonds;
	
	//sprites of chips
	private Sprite chip25;
	private Sprite chip50;
	private Sprite chip100;
	private Sprite chip250;
	
	//sprites of hit and stand buttons
	private Sprite hit;
	private Sprite stand;
	
	// middle pot of gold sprite
	private Sprite potOfGold;
	
	// text sprites
	private Sprite welcome;
	private Sprite play;
	private Sprite instructions;
	private Sprite help;

	Random random = new Random();

	//strings for cards
	String ace = "ace";
	String king = "king";
	String queen = "queen";
	String jack= "jack";
	String two = "two";
	String three = "three";
	String four=  "four";
	String five = "five";
	String six = "six";
	String seven = "seven";
	String eight = "eight";
	String nine = "nine";
	String ten = "ten";
	
	String chipType;

	//user and dealer card array lists
	Cards userHand = new Cards();
	Cards dealerHand = new Cards();


	// card position for the users cards
	int userCardPosX = 420;
	int userCardPosY = 150;
	
	//Hit button position
	int hitButtonPosX = 900;
	int hitButtonPosY = 250;
	
	//Stand button Position
	int standButtonPosX = 900;
	int standbuttonPosY = 150;
	
	//button sizes
	int buttonWidth = 100;
	int buttonHeight = 85;
	
	//chip positions
	int chip25PosX = 200;
	int chip25PosY= 45;
	
	int chip50PosX = 375;
	int chip50PosY= 33;
	
	int chip100PosX = 550;
	int chip100PosY= 30;
	
	int chip250PosX = 725;
	int chip250PosY= 35;
	
	//pot position
	int potPosX= 450;
	int potPosY= 305;
	
	// money
	int money =500;
	String yourMoney;
	
	int pot = 0;
	String potMoney;
	
	// card sum
	int userSum = 0;
	String showUserSum= "";
	
	int dealerSum;
	String showDealerSum = "";
	
	
	//chips Sizes (width and length same so one variable used)
	int chipSize = 75;
	
	//booleans
	boolean bets = true;
	boolean userTurn = true;
	boolean dealerTurn = false;
	boolean restart = false;
	boolean mainMenu = true;
	boolean instructionsScreen = false;
	boolean playerStand = false;
	boolean userBusted = false;
	boolean dealerBusted = false;
	
	// button variables
	Stage stage;
	TextButton playButton;
	TextButton instructionsButton;
    TextButton hitButton;
    TextButton standButton;
    TextButton chip25Button;
    TextButton chip50Button;
    TextButton chip100Button;
    TextButton chip250Button;;
    TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
	

	public void create() {
		batch = new SpriteBatch();

		//all the card images being created
		aceHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/AceHearts.png")));
		twoHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/2Hearts.png")));
		threeHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/3Hearts.png")));
		fourHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/4Hearts.png")));
		fiveHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/5Hearts.png")));
		sixHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/6Hearts.png")));
		sevenHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/7Hearts.png")));
		eightHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/8Hearts.png")));
		nineHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/9Hearts.png")));
		tenHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/10Hearts.png")));
		jackHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/JackHearts.png")));
		queenHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/QueenHearts.png")));
		kingHearts = new Sprite(new Texture(
				Gdx.files.internal("assets/Hearts/KingHearts.png")));

		aceDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/AceDiamonds.png")));
		twoDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/2Diamonds.png")));
		threeDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/3Diamonds.png")));
		fourDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/4Diamonds.png")));
		fiveDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/5Diamonds.png")));
		sixDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/6Diamonds.png")));
		sevenDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/7Diamonds.png")));
		eightDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/8Diamonds.png")));
		nineDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/9Diamonds.png")));
		tenDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/10Diamonds.png")));
		jackDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/JackDiamonds.png")));
		queenDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/QueenDiamonds.png")));
		kingDiamonds = new Sprite(new Texture(
				Gdx.files.internal("assets/Diamonds/KingDiamonds.png")));

		aceClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/AceClubs.png")));
		twoClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/2Clubs.png")));
		threeClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/3Clubs.png")));
		fourClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/4Clubs.png")));
		fiveClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/5Clubs.png")));
		sixClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/6Clubs.png")));
		sevenClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/7Clubs.png")));
		eightClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/8Clubs.png")));
		nineClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/9Clubs.png")));
		tenClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/10Clubs.png")));
		jackClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/JackClubs.png")));
		queenClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/QueenClubs.png")));
		kingClubs = new Sprite(new Texture(
				Gdx.files.internal("assets/Clubs/KingClubs.png")));

		aceSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/AceSpades.png")));
		twoSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/2Spades.png")));
		threeSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/3Spades.png")));
		fourSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/4Spades.png")));
		fiveSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/5Spades.png")));
		sixSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/6Spades.png")));
		sevenSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/7Spades.png")));
		eightSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/8Spades.png")));
		nineSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/9Spades.png")));
		tenSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/10Spades.png")));
		jackSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/JackSpades.png")));
		queenSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/QueenSpades.png")));
		kingSpades = new Sprite(new Texture(
				Gdx.files.internal("assets/Spades/KingSpades.png")));
		
		// word images
		welcome = new Sprite(new Texture(Gdx.files.internal("assets/welcome.png")));
		welcome.setPosition (200, 300);
		
		play = new Sprite(new Texture(Gdx.files.internal("assets/play.png")));
		play.setPosition (100, 140);
		
		instructions = new Sprite(new Texture(Gdx.files.internal("assets/instructions.png")));
		instructions.setPosition (500, 100);
		
		help = new Sprite(new Texture(Gdx.files.internal("assets/help.png")));
		help.setPosition (350, 130);
		help.setSize (700,500);
        
		// pot of gold image
        potOfGold = new Sprite(new Texture(Gdx.files.internal("assets/potOfGold.png")));
        potOfGold.setPosition(potPosX, potPosY);
        potOfGold.setSize(200, 150);
		
        //chip images
		chip25 = new Sprite(new Texture(Gdx.files.internal("assets/25chip.png")));
		chip25.setPosition(chip25PosX, chip25PosY);
		chip25.setSize(chipSize, chipSize);
		
		chip50 = new Sprite(new Texture(Gdx.files.internal("assets/50chip.png")));
		chip50.setPosition(chip50PosX, chip50PosY);
		chip50.setSize(chipSize,chipSize);
		
		chip100 = new Sprite(new Texture(Gdx.files.internal("assets/100chip.png")));
		chip100.setPosition(chip100PosX, chip100PosY);
		chip100.setSize(chipSize,chipSize);
		
		chip250 = new Sprite(new Texture(Gdx.files.internal("assets/250chip.png")));
		chip250.setPosition(chip250PosX, chip250PosY);
		chip250.setSize(chipSize,chipSize);
		
		
		
		// creates the background and adds a deck to the top right corner
		background = new Sprite(new Texture(Gdx.files.internal("assets/background.png")));
		deck = new Sprite(new Texture(Gdx.files.internal("assets/deck.png")));
		deck.setPosition(890, 450);
		
		// hit/stand button pictures
		hit = new Sprite(new Texture(Gdx.files.internal("assets/Hit.png")));
		hit.setPosition(hitButtonPosX,hitButtonPosY);
		hit.setSize(buttonWidth, buttonHeight);
		
		stand = new Sprite(new Texture(Gdx.files.internal("assets/Stand.png")));
		stand.setPosition(standButtonPosX, standbuttonPosY);
		stand.setSize(buttonWidth, buttonHeight);
		
		// calls the pickcard method and starts you off with the 2 starting cards
		final int firstUserCard = random.nextInt(52) + 1;
		final int seconUserdCard = random.nextInt(52) + 1;
		
		pickUserCard(firstUserCard);
		pickUserCard(seconUserdCard);		
		
		stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("assets/test-me!.pack"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
                      
               
	}

	public void render() {
		
		//starts the game at the main menu
		if (mainMenu == true){ 
			// creates the play button
			 playButton = new TextButton("", textButtonStyle);
		     playButton.setPosition(100, 140);
		     playButton.setSize(264, 138);
		     playButton.addListener(new ClickListener() {
		            public void clicked(InputEvent event, float x, float y) {
		            	mainMenu = false;// if pplay is pressed the game starts
		            	instructionsScreen = false;
		             }
		        });
		        stage.addActor(playButton);
		        
		        //instructions button created
		        instructionsButton = new TextButton("", textButtonStyle);
		        instructionsButton.setPosition(500, 100);
		        instructionsButton.setSize(600, 182);
		        instructionsButton.addListener(new ClickListener() {
		            public void clicked(InputEvent event, float x, float y) {
		            	mainMenu = false;
		            	instructionsScreen = true;// instructions screen opened and menu closed
		             }
		        });
		        stage.addActor(instructionsButton);
		        
		    // starts off with background and text drawn
    		batch.begin();
	        background.draw(batch);
	        welcome.draw(batch);
	        play.draw(batch);
	        instructions.draw(batch);
	        batch.end();
		}
		
		if (instructionsScreen == true){ // if instructions button pressed 
    		batch.begin();
	        background.draw(batch);
	        play.draw(batch);
	        help.draw(batch);
	        batch.end();
	        
	        // play button after reading instrctions
	        playButton = new TextButton("", textButtonStyle);
	        playButton.setPosition(100, 140);
	        playButton.setSize(264, 138);
	        playButton.addListener(new ClickListener() {
	            public void clicked(InputEvent event, float x, float y) {
	            	mainMenu = false;// starts game and closes instructions
	            	instructionsScreen = false;
	             }
	        });
	        stage.addActor(playButton);
		}
		if (mainMenu == false && instructionsScreen == false){// game start
			
			// ask for card button created
			hitButton = new TextButton("Hit", textButtonStyle);
	        hitButton.setPosition(hitButtonPosX, hitButtonPosY);
	        hitButton.setSize(buttonWidth, buttonHeight);
	        hitButton.addListener(new ClickListener() {
	            public void clicked(InputEvent event, float x, float y) {
	            	// if button pressed then a random card from 1-52 is created
	            	// by calling pickUserCard method
	            	final int userCard = random.nextInt(52) + 1;
	            	//makes sure it is the users turn and he has not busted
	                if (userTurn==true && userBusted == false){
	                	pickUserCard(userCard);
	                }
	                bets = false;// can no longer place bets after asking for first card
    
	             }
	        });
	        stage.addActor(hitButton);
	        
	        // stand button created
	        standButton = new TextButton ("Stand", textButtonStyle);
	        standButton.setPosition(standButtonPosX, standbuttonPosY);
	        standButton.setSize(buttonWidth, buttonHeight);
	        standButton.addListener(new ClickListener() {
	        	// if stand is pressed then the users turn is over and it is now the dealers turn
	            public void clicked(InputEvent event, float x, float y) {
	            	userTurn =false;
	                bets = false;
	                dealerTurn = true;  
	                playerStand = true;
	             }
	        });
	        stage.addActor(standButton); 
			
	        //chip buttons
			 chip25Button = new TextButton("", textButtonStyle);
		        chip25Button.setPosition(chip25PosX, chip25PosY);
		        chip25Button.setSize(chipSize, chipSize);
		        chip25Button.addListener(new ClickListener() {
		            public void clicked(InputEvent event, float x, float y) {
		            	if (money>=25 && bets == true){
		            		// if chip pressed then the character loses specific amount of money
		            		money -= 25; 
		            		// adds double to the pot for reward
		            		pot += 50;
		            	}
		            	//displays updated amount of money and pot
		            	yourMoney = "Money: $" + money;
		            	potMoney = "$" + pot;
		            	
		             }
		        });
		        stage.addActor(chip25Button);
		        
		        
		        chip50Button = new TextButton("", textButtonStyle);
		        chip50Button.setPosition(chip50PosX, chip50PosY);
		        chip50Button.setSize(chipSize, chipSize);
		        chip50Button.addListener(new ClickListener() {
		            public void clicked(InputEvent event, float x, float y) {
		            	if (money >=50 && bets == true){
		            		money -= 50; 
		            		pot += 100;
		            	}
		            	yourMoney = "Money: $" + money;
		            	potMoney = "$" + pot;
		            	
		             }
		        });
		        stage.addActor(chip50Button);
		        
		        chip100Button = new TextButton("", textButtonStyle);
		        chip100Button.setPosition(chip100PosX, chip100PosY);
		        chip100Button.setSize(chipSize, chipSize);
		        chip100Button.addListener(new ClickListener() {
		            public void clicked(InputEvent event, float x, float y) {
		            	if (money>=100 && bets == true){
		            		money -= 100;   
		            		pot += 200;
		            	}
		            	yourMoney = "Money: $" + money;
		            	potMoney = "$" + pot;
		            	
		             }
		        });
		        stage.addActor(chip100Button);
		        
		        chip250Button = new TextButton("", textButtonStyle);
		        chip250Button.setPosition(chip250PosX, chip250PosY);
		        chip250Button.setSize(chipSize, chipSize);
		        chip250Button.addListener(new ClickListener() {
		            public void clicked(InputEvent event, float x, float y) {
		            	if (money>=250 && bets == true){
		            		money -= 250;     
		            		pot += 500;
		            	}
		            	yourMoney = "Money: $" + money;
		            	potMoney = "$" + pot;
		             }
		        });
		        stage.addActor(chip250Button);
			
		        // if user gets blackjack, user has instantly won
			if (userSum == 21){
				dealerTurn = false;
				userTurn = false;
	        	money += pot;
	        	pot = 0;
	        }
			
			
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);				
		
		yourMoney = ("Money: $" + money);
        potMoney = ("$"+ pot);
		
		batch.begin();
		background.draw(batch);// draws background
		deck.draw(batch);// draws deck
		
		// draws buttons and chips
		hit.draw(batch);
		stand.draw(batch);
		
		chip25.draw(batch);
		chip50.draw(batch);
		chip100.draw(batch);
		chip250.draw(batch);
		
		potOfGold.draw(batch);
		
		font.draw(batch,yourMoney, 25, 100);
		font.draw(batch,potMoney, 525, 380);
		
		// draws users cards
			for (int i = 0; i < userHand.numberOfCards(); i++) {// draws the card
				Card c = userHand.getCard(i);// gets card from array list
				// gets values of cards
				c.setValue();
				if (c.valueAdded == false){
					userSum += c.getValue();// the sum of the cards is added to by the value of card recieved
					c.valueAdded = true;
				}
				batch.draw(c.cardImage, userCardPosX + (i * 15), userCardPosY, 75, 125);					
				showUserSum = (userSum + "");// shows sum of your cards
			}
			font.draw(batch, showUserSum, 300, 200);
			
				// if the user has stopped and pressed stand it is now the dealers turn
				if (playerStand == true){
					if (dealerTurn == true && dealerSum <=16){
						// the dealer will only draw cards when it is his turn and can only draw while his sum of his cards are 17
						final int dealerCard = random.nextInt(52) + 1;
						pickDealerCard(dealerCard);
					}
					for (int x = 0; x < dealerHand.numberOfCards(); x++) {// draws the card
						Card b = dealerHand.getCard(x);
						batch.draw(b.cardImage, 420 + (x * 15), 500, 75, 125);
						b.setValue();
						if (b.valueAdded == false){
							dealerSum += b.getValue();
							b.valueAdded = true;
						}
					}
						showDealerSum = (dealerSum + "");			
			}
			font.draw(batch, showDealerSum, 300, 500);
			
			if (userSum > 21){// if the user has more than 21 as a sum he has lost
				userBusted = true;
				pot = 0;
			}
			if (dealerSum > 21 && userSum <=21){// if the dealer has busted while the user has not the dealer has busted
				dealerBusted = true;
				money+=pot;// user won so he gets pot money
				pot = 0;// pot emptied
			}
			if (userTurn == false && dealerTurn == true && userSum == dealerSum){// if both have same sum then money returned
				money += (pot/2);
				pot=0;
			}
			
			// if the user has a lower sum than the dealer he has lost
			if (userTurn == false && dealerTurn == true && dealerHand.numberOfCards() > 2 && userSum < dealerSum){
				pot=0;
			}
			
			// if the user has a higher sum than the dealer he has won
			if (userTurn == false && dealerTurn == true && dealerHand.numberOfCards() > 2 &&  userSum > dealerSum){
				money+=pot;
				pot = 0;
			}
			
		batch.end();
		
		super.render();
        stage.draw();
		}
	
	}
	
	public void pickUserCard(int whichCard) {// where the card is picked if a use
		// chooses to pick up a card

		if (whichCard == 1) {// if the number 1 is chosen from the earlier random generator it will choose a ace of hearts
		Card aceOfHearts = new Card(ace, aceHearts, false);
		userHand.addCard(aceOfHearts);// adds the card to the array list
		} else if (whichCard == 2) {
		Card twoOfHearts = new Card(two, twoHearts, false);
		userHand.addCard(twoOfHearts);
		} else if (whichCard == 3) {
		Card threeOfHearts = new Card(three, threeHearts, false);
		userHand.addCard(threeOfHearts);
		} else if (whichCard == 4) {
		Card fourOfHearts = new Card(four, fourHearts, false);
		userHand.addCard(fourOfHearts);
		} else if (whichCard == 5) {
		Card fiveOfHearts = new Card(five, fiveHearts, false);
		userHand.addCard(fiveOfHearts);
		} else if (whichCard == 6) {
		Card sixOfHearts = new Card(six, sixHearts, false);
		userHand.addCard(sixOfHearts);
		} else if (whichCard == 7) {
		Card sevenOfHearts = new Card(seven, sevenHearts, false);
		userHand.addCard(sevenOfHearts);
		} else if (whichCard == 8) {
		Card eightOfHearts = new Card(eight, eightHearts, false);
		userHand.addCard(eightOfHearts);
		} else if (whichCard == 9) {
		Card nineOfHearts = new Card(nine, nineHearts, false);
		userHand.addCard(nineOfHearts);
		} else if (whichCard == 10) {
		Card tenOfHearts = new Card(ten, tenHearts, false);
		userHand.addCard(tenOfHearts);
		} else if (whichCard == 11) {
		Card jackOfHearts = new Card(jack, jackHearts, false);
		userHand.addCard(jackOfHearts);
		} else if (whichCard == 12) {
		Card queenOfHearts = new Card(queen, queenHearts, false);
		userHand.addCard(queenOfHearts);
		} else if (whichCard == 13) {
		Card kingOfHearts = new Card(king, kingHearts, false);
		userHand.addCard(kingOfHearts);
		
		} else if (whichCard == 14) {
		Card aceOfDiamonds = new Card(ace, aceDiamonds, false);
		userHand.addCard(aceOfDiamonds);
		} else if (whichCard == 15) {
		Card twoOfDiamonds = new Card(two, twoDiamonds, false);
		userHand.addCard(twoOfDiamonds);
		} else if (whichCard == 16) {
		Card threeOfDiamonds = new Card(three, threeDiamonds, false);
		userHand.addCard(threeOfDiamonds);
		} else if (whichCard == 17) {
		Card fourOfDiamonds = new Card(four, fourDiamonds, false);
		userHand.addCard(fourOfDiamonds);
		} else if (whichCard == 18) {
		Card fiveOfDiamonds = new Card(five, fiveDiamonds, false);
		userHand.addCard(fiveOfDiamonds);
		} else if (whichCard == 19) {
		Card sixOfDiamonds = new Card(six, sixDiamonds, false);
		userHand.addCard(sixOfDiamonds);
		} else if (whichCard == 20) {
		Card sevenOfDiamonds = new Card(seven, sevenDiamonds, false);
		userHand.addCard(sevenOfDiamonds);
		} else if (whichCard == 21) {
		Card eightOfDiamonds = new Card(eight, eightDiamonds, false);
		userHand.addCard(eightOfDiamonds);
		} else if (whichCard == 22) {
		Card nineOfDiamonds = new Card(nine, nineDiamonds, false);
		userHand.addCard(nineOfDiamonds);
		} else if (whichCard == 23) {
		Card tenOfDiamonds = new Card(ten, tenDiamonds, false);
		userHand.addCard(tenOfDiamonds);
		} else if (whichCard == 24) {
		Card jackOfDiamonds = new Card(jack, jackDiamonds, false);
		userHand.addCard(jackOfDiamonds);
		} else if (whichCard == 25) {
		Card queenOfDiamonds = new Card(queen, queenDiamonds, false);
		userHand.addCard(queenOfDiamonds);
		} else if (whichCard == 26) {
		Card kingOfDiamonds = new Card(king, kingDiamonds, false);
		userHand.addCard(kingOfDiamonds);
		
		} else if (whichCard == 27) {
		Card aceOfClubs = new Card(ace, aceClubs, false);
		userHand.addCard(aceOfClubs);
		} else if (whichCard == 28) {
		Card twoOfClubs = new Card(two, twoClubs, false);
		userHand.addCard(twoOfClubs);
		} else if (whichCard == 29) {
		Card threeOfClubs = new Card(three, threeClubs, false);
		userHand.addCard(threeOfClubs);
		} else if (whichCard == 30) {
		Card fourOfClubs = new Card(four, fourClubs, false);
		userHand.addCard(fourOfClubs);
		} else if (whichCard == 31) {
		Card fiveOfClubs = new Card(five, fiveClubs, false);
		userHand.addCard(fiveOfClubs);
		} else if (whichCard == 32) {
		Card sixOfClubs = new Card(six, sixClubs, false);
		userHand.addCard(sixOfClubs);
		} else if (whichCard == 33) {
		Card sevenOfClubs = new Card(seven, sevenClubs, false);
		userHand.addCard(sevenOfClubs);
		} else if (whichCard == 34) {
		Card eightOfClubs = new Card(eight, eightClubs, false);
		userHand.addCard(eightOfClubs);
		} else if (whichCard == 35) {
		Card nineOfClubs = new Card(nine, nineClubs, false);
		userHand.addCard(nineOfClubs);
		} else if (whichCard == 36) {
		Card tenOfClubs = new Card(ten, tenClubs, false);
		userHand.addCard(tenOfClubs);
		} else if (whichCard == 37) {
		Card jackOfClubs = new Card(jack, jackClubs, false);
		userHand.addCard(jackOfClubs);
		} else if (whichCard == 38) {
		Card queenOfClubs = new Card(queen, queenClubs, false);
		userHand.addCard(queenOfClubs);
		} else if (whichCard == 39) {
		Card kingOfClubs = new Card(king, kingClubs, false);
		userHand.addCard(kingOfClubs);
		
		} else if (whichCard == 40) {
		Card aceOfSpades = new Card(ace, aceSpades, false);
		userHand.addCard(aceOfSpades);
		} else if (whichCard == 41) {
		Card twoOfSpades = new Card(two, twoSpades, false);
		userHand.addCard(twoOfSpades);
		} else if (whichCard == 42) {
		Card threeOfSpades = new Card(three, threeSpades, false);
		userHand.addCard(threeOfSpades);
		} else if (whichCard == 43) {
		Card fourOfSpades = new Card(four, fourSpades, false);
		userHand.addCard(fourOfSpades);
		} else if (whichCard == 44) {
		Card fiveOfSpades = new Card(five, fiveSpades, false);
		userHand.addCard(fiveOfSpades);
		} else if (whichCard == 45) {
		Card sixOfSpades = new Card(six, sixSpades, false);
		userHand.addCard(sixOfSpades);
		} else if (whichCard == 46) {
		Card sevenOfSpades = new Card(seven, sevenSpades, false);
		userHand.addCard(sevenOfSpades);
		} else if (whichCard == 47) {
		Card eightOfSpades = new Card(eight, eightSpades, false);
		userHand.addCard(eightOfSpades);
		} else if (whichCard == 48) {
		Card nineOfSpades = new Card(nine, nineSpades, false);
		userHand.addCard(nineOfSpades);
		} else if (whichCard == 49) {
		Card tenOfSpades = new Card(ten, tenSpades, false);
		userHand.addCard(tenOfSpades);
		} else if (whichCard == 50) {
		Card jackOfSpades = new Card(jack, jackSpades, false);
		userHand.addCard(jackOfSpades);
		} else if (whichCard == 51) {
		Card queenOfSpades = new Card(queen, queenSpades, false);
		userHand.addCard(queenOfSpades);
		} else if (whichCard == 52) {
		Card kingOfSpades = new Card(king, kingSpades, false);
		userHand.addCard(kingOfSpades);
		}
	
	}
	
	
	public void pickDealerCard(int dCard) {// where the card is picked for the dealer

		if (dCard == 1) {// if the number 1 is chosen from the earlier random generator it will choose a ace of hearts
			Card aceOfHearts = new Card(ace, aceHearts, false);
			dealerHand.addCard(aceOfHearts);// adds the card to the array list
		} else if (dCard == 2) {
			Card twoOfHearts = new Card(two, twoHearts, false);
			dealerHand.addCard(twoOfHearts);
		} else if (dCard == 3) {
			Card threeOfHearts = new Card(three, threeHearts, false);
			dealerHand.addCard(threeOfHearts);
		} else if (dCard == 4) {
			Card fourOfHearts = new Card(four, fourHearts, false);
			dealerHand.addCard(fourOfHearts);
		} else if (dCard == 5) {
			Card fiveOfHearts = new Card(five, fiveHearts, false);
			dealerHand.addCard(fiveOfHearts);
		} else if (dCard == 6) {
			Card sixOfHearts = new Card(six, sixHearts, false);
			dealerHand.addCard(sixOfHearts);
		} else if (dCard == 7) {
			Card sevenOfHearts = new Card(seven, sevenHearts, false);
			dealerHand.addCard(sevenOfHearts);
		} else if (dCard == 8) {
			Card eightOfHearts = new Card(eight, eightHearts, false);
			dealerHand.addCard(eightOfHearts);
		} else if (dCard == 9) {
			Card nineOfHearts = new Card(nine, nineHearts, false);
			dealerHand.addCard(nineOfHearts);
		} else if (dCard == 10) {
			Card tenOfHearts = new Card(ten, tenHearts, false);
			dealerHand.addCard(tenOfHearts);
		} else if (dCard == 11) {
			Card jackOfHearts = new Card(jack, jackHearts, false);
			dealerHand.addCard(jackOfHearts);
		} else if (dCard == 12) {
			Card queenOfHearts = new Card(queen, queenHearts, false);
			dealerHand.addCard(queenOfHearts);
		} else if (dCard == 13) {
			Card kingOfHearts = new Card(king, kingHearts, false);
			dealerHand.addCard(kingOfHearts);
			
		} else if (dCard == 14) {
			Card aceOfDiamonds = new Card(ace, aceDiamonds, false);
			dealerHand.addCard(aceOfDiamonds);
		} else if (dCard == 15) {
			Card twoOfDiamonds = new Card(two, twoDiamonds, false);
			dealerHand.addCard(twoOfDiamonds);
		} else if (dCard == 16) {
			Card threeOfDiamonds = new Card(three, threeDiamonds, false);
			dealerHand.addCard(threeOfDiamonds);
		} else if (dCard == 17) {
			Card fourOfDiamonds = new Card(four, fourDiamonds, false);
			dealerHand.addCard(fourOfDiamonds);
		} else if (dCard == 18) {
			Card fiveOfDiamonds = new Card(five, fiveDiamonds, false);
			dealerHand.addCard(fiveOfDiamonds);
		} else if (dCard == 19) {
			Card sixOfDiamonds = new Card(six, sixDiamonds, false);
			dealerHand.addCard(sixOfDiamonds);
		} else if (dCard == 20) {
			Card sevenOfDiamonds = new Card(seven, sevenDiamonds, false);
			dealerHand.addCard(sevenOfDiamonds);
		} else if (dCard == 21) {
			Card eightOfDiamonds = new Card(eight, eightDiamonds, false);
			dealerHand.addCard(eightOfDiamonds);
		} else if (dCard == 22) {
			Card nineOfDiamonds = new Card(nine, nineDiamonds, false);
			dealerHand.addCard(nineOfDiamonds);
		} else if (dCard == 23) {
			Card tenOfDiamonds = new Card(ten, tenDiamonds, false);
			dealerHand.addCard(tenOfDiamonds);
		} else if (dCard == 24) {
			Card jackOfDiamonds = new Card(jack, jackDiamonds, false);
			dealerHand.addCard(jackOfDiamonds);
		} else if (dCard == 25) {
			Card queenOfDiamonds = new Card(queen, queenDiamonds, false);
			dealerHand.addCard(queenOfDiamonds);
		} else if (dCard == 26) {
			Card kingOfDiamonds = new Card(king, kingDiamonds, false);
			dealerHand.addCard(kingOfDiamonds);
			
		} else if (dCard == 27) {
			Card aceOfClubs = new Card(ace, aceClubs, false);
			dealerHand.addCard(aceOfClubs);
		} else if (dCard == 28) {
			Card twoOfClubs = new Card(two, twoClubs, false);
			dealerHand.addCard(twoOfClubs);
		} else if (dCard == 29) {
			Card threeOfClubs = new Card(three, threeClubs, false);
			dealerHand.addCard(threeOfClubs);
		} else if (dCard == 30) {
			Card fourOfClubs = new Card(four, fourClubs, false);
			dealerHand.addCard(fourOfClubs);
		} else if (dCard == 31) {
			Card fiveOfClubs = new Card(five, fiveClubs, false);
			dealerHand.addCard(fiveOfClubs);
		} else if (dCard == 32) {
			Card sixOfClubs = new Card(six, sixClubs, false);
			dealerHand.addCard(sixOfClubs);
		} else if (dCard == 33) {
			Card sevenOfClubs = new Card(seven, sevenClubs, false);
			dealerHand.addCard(sevenOfClubs);
		} else if (dCard == 34) {
			Card eightOfClubs = new Card(eight, eightClubs, false);
			dealerHand.addCard(eightOfClubs);
		} else if (dCard == 35) {
			Card nineOfClubs = new Card(nine, nineClubs, false);
			dealerHand.addCard(nineOfClubs);
		} else if (dCard == 36) {
			Card tenOfClubs = new Card(ten, tenClubs, false);
			dealerHand.addCard(tenOfClubs);
		} else if (dCard == 37) {
			Card jackOfClubs = new Card(jack, jackClubs, false);
			dealerHand.addCard(jackOfClubs);
		} else if (dCard == 38) {
			Card queenOfClubs = new Card(queen, queenClubs, false);
			dealerHand.addCard(queenOfClubs);
		} else if (dCard == 39) {
			Card kingOfClubs = new Card(king, kingClubs, false);
			dealerHand.addCard(kingOfClubs);
			
		} else if (dCard == 40) {
			Card aceOfSpades = new Card(ace, aceSpades, false);
			dealerHand.addCard(aceOfSpades);
		} else if (dCard == 41) {
			Card twoOfSpades = new Card(two, twoSpades, false);
			dealerHand.addCard(twoOfSpades);
		} else if (dCard == 42) {
			Card threeOfSpades = new Card(three, threeSpades, false);
			dealerHand.addCard(threeOfSpades);
		} else if (dCard == 43) {
			Card fourOfSpades = new Card(four, fourSpades, false);
			dealerHand.addCard(fourOfSpades);
		} else if (dCard == 44) {
			Card fiveOfSpades = new Card(five, fiveSpades, false);
			dealerHand.addCard(fiveOfSpades);
		} else if (dCard == 45) {
			Card sixOfSpades = new Card(six, sixSpades, false);
			dealerHand.addCard(sixOfSpades);
		} else if (dCard == 46) {
			Card sevenOfSpades = new Card(seven, sevenSpades, false);
			dealerHand.addCard(sevenOfSpades);
		} else if (dCard == 47) {
			Card eightOfSpades = new Card(eight, eightSpades, false);
			dealerHand.addCard(eightOfSpades);
		} else if (dCard == 48) {
			Card nineOfSpades = new Card(nine, nineSpades, false);
			dealerHand.addCard(nineOfSpades);
		} else if (dCard == 49) {
			Card tenOfSpades = new Card(ten, tenSpades, false);
			dealerHand.addCard(tenOfSpades);
		} else if (dCard == 50) {
			Card jackOfSpades = new Card(jack, jackSpades, false);
			dealerHand.addCard(jackOfSpades);
		} else if (dCard == 51) {
			Card queenOfSpades = new Card(queen, queenSpades, false);
			dealerHand.addCard(queenOfSpades);
		} else if (dCard == 52) {
			Card kingOfSpades = new Card(king, kingSpades, false);
			dealerHand.addCard(kingOfSpades);
		}

	}

}
