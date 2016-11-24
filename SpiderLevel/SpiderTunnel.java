

import java.awt.Rectangle;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class SpiderTunnel extends BasicGameState{

    Animation mm, up, down, left, right, stay;
    Image map, spider1, spider2, spider3, spider4, spider5, spider6, spider7, gameover;
    
    boolean quit = false;
    int[] duration = {200, 200, 200, 200, 200, 200, 200, 200, 200};
    int rightLimit = 620, leftLimit = -30;
    int upLimit = 245, downLimit = 200;
    float shiftX = -10;
    float shiftY = 200;
    int limitspider = 230;
    float web1 = 350, web2 = 251, web3 = -30, web4 = 380, web5 = 300, web6 = -1, web7 = 350;
    float speed1, speed2, speed3, speed4, speed5, speed6, speed7;
    float rectwidth = 0.5f;
    int casesCollide;
    Music back;
	Sound collide, gov;
	boolean gameOver = false;
    public SpiderTunnel(int state){

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        map = new Image("spidback.png");
        spider1 = new Image("spid1.png");
        spider2 = new Image("spid2.png");
        spider3 = new Image("spid3.png");
        spider4 = new Image("spid4.png");
        spider5 = new Image("spid5.png");
        spider6 = new Image("spid6.png");
        spider7 = new Image("spid7.png");
        back = new Music("backtunnel.ogg");
        collide = new Sound("collide.ogg");
        gameover = new Image("GOV.png");
        gov = new Sound("gov.ogg");
        
        Image[] walkUp = {new Image("wu1.png"), new Image("wu2.png"), new Image("wu3.png"), new Image("wu4.png"), new Image("wu5.png"), new Image("wu6.png"), new Image("wu7.png"), new Image("wu8.png"), new Image("wd9.png")};
        Image[] walkDown = {new Image("wd1.png"), new Image("wd2.png"), new Image("wd3.png"), new Image("wd4.png"), new Image("wd5.png"), new Image("wd6.png"), new Image("wd7.png"), new Image("wd8.png"), new Image("wd9.png")};
        Image[] walkLeft = {new Image("wl1.png"), new Image("wl2.png"), new Image("wl3.png"), new Image("wl4.png"), new Image("wl5.png"), new Image("wl6.png"), new Image("wl7.png"), new Image("wl8.png"), new Image("wl9.png")};
        Image[] walkRight = {new Image("wr1.png"), new Image("wr2.png"), new Image("wr3.png"), new Image("wr4.png"), new Image("wr5.png"), new Image("wr6.png"), new Image("wr7.png"), new Image("wr8.png"), new Image("wr9.png")};
        Image[] steady = {new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png")};
        up = new Animation(walkUp, duration, true);
        down = new Animation(walkDown, duration, true);
        left = new Animation(walkLeft, duration, true);
        right = new Animation(walkRight, duration, true);
        stay = new Animation(steady, duration, true);
        
        mm = stay;
        back.loop();
    	back.setVolume(2.0f);
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
    	
        map.draw(0, 0, map.getWidth(), map.getHeight());
        
        
        mm.draw(shiftX, shiftY, mm.getWidth(), mm.getHeight());
        
        
        g.drawRect(leftLimit + 90, 0, rectwidth, web1+10);
        spider1.draw(leftLimit + 68, web1, spider1.getWidth(), spider1.getHeight());
        
        g.drawRect(leftLimit + 170, 0, rectwidth, web2+10);
        spider2.draw(leftLimit + 146, web2, spider2.getWidth(), spider2.getHeight());
        
        g.drawRect(leftLimit + 250, 0, rectwidth, web3+10);
        spider3.draw(leftLimit + 227, web3, spider3.getWidth(), spider3.getHeight());
        
        g.drawRect(leftLimit + 330, 0, rectwidth, web4+10);
        spider4.draw(leftLimit + 310, web4, spider4.getWidth(), spider4.getHeight());
        
        g.drawRect(leftLimit + 410, 0, rectwidth, web5+10);
        spider5.draw(leftLimit + 390, web5, spider5.getWidth(), spider5.getHeight());
        
        g.drawRect(leftLimit + 490, 0, rectwidth, web6+10);
        spider6.draw(leftLimit + 470, web6, spider6.getWidth(), spider6.getHeight());
        
        g.drawRect(leftLimit + 570, 0, rectwidth, web7+10);
        spider7.draw(leftLimit + 545, web7, spider7.getWidth(), spider7.getHeight());
        
        if(gameOver == false){
        	
	        if((shiftX > leftLimit + 45 && shiftX < leftLimit + 100) && (web1 > shiftY - 25)){
	        	collide.play();
	        	gameOver = true;
	        }
	        if((shiftX > leftLimit + 125 && shiftX < leftLimit + 180) && (web2 > shiftY - 25)){
	        	collide.play();
	        	gameOver = true; 
	        }
	        if((shiftX > leftLimit + 205 && shiftX < leftLimit + 260) && (web3 > shiftY - 25)){
	        	collide.play();
	        	gameOver = true;
	        }
	        if((shiftX > leftLimit + 285 && shiftX < leftLimit + 340) && (web4 > shiftY - 25)){
	        	collide.play();
	        	gameOver = true;
	        }
	        if((shiftX > leftLimit + 365 && shiftX < leftLimit + 420) && (web5 > shiftY - 25)){
	        	collide.play();
	        	gameOver = true;
	        }
	        if((shiftX > leftLimit + 445 && shiftX < leftLimit + 500) && (web6 > shiftY - 25)){
	        	collide.play();
	        	gameOver = true;
	        }
	        if((shiftX > leftLimit + 525 && shiftX < leftLimit + 580) && (web7 > shiftY - 25)){
	        	collide.play();
	        	gameOver = true;
	        }
	        
        }
        else{   
    	   gameover.draw(80, 20, 500, 351);	
    	   web1 = (float) (web1 - 1.3);
    	   web2 = (float) (web2 - 1.3);
    	   web3 = (float) (web3 - 1.3);
    	   web4 = (float) (web4 - 1.3);
    	   web5 = (float) (web5 - 1.3);
    	   web6 = (float) (web6 - 1.3);
    	   web7 = (float) (web7 - 1.3);
    	   // TRY AGAIN
       }
        
       if(shiftX > leftLimit + 600 && gameOver == false){
    	   spider7.draw(111, 67, spider7.getWidth(), spider7.getHeight()); // INSERT NEXT LEVEL 
       }
        if(quit == true){
            g.drawString("Resume (R)", 250, 100);
            g.drawString("Main Menu (M)", 250, 150);
            g.drawString("Quit Game (Q)", 250, 200);
            if(quit == false){
                g.clear();
            }
        }
    }

    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        mm = stay;
        
        if(web1 < 0){
        	speed1 = -.35f;
        }
        if(web2 < 0){
        	speed2 = -.35f;
        }
        if(web3 < 0){
        	speed3 = -.35f;
        }
        if(web4 < 0){
        	speed4 = -.35f; 	
        }
        if(web5 < 0){
        	speed5 = -.35f; 	
        }
        if(web6 < 0){
        	speed6 = -.35f; 	
        }
        if(web7 < 0){
        	speed7 = -.35f; 	
        }
        
        if(web1 > limitspider){
        	speed1 = .35f;
        }
        if(web2 > limitspider){
        	speed2 = .35f;
        }
        if(web3 > limitspider){
        	speed3 = .35f;
        }
        if(web4 > limitspider ){
        	speed4 = .35f; 	
        }
        if(web5 > limitspider ){
        	speed5 = .35f; 	
        }
        if(web6 > limitspider ){
        	speed6 = .35f; 	
        }
        if(web7 > limitspider ){
        	speed7 = .35f; 	
        }
        
        
        web1 -= delta * speed1;
        web2 -= delta * speed2;
        web3 -= delta * speed3;
        web4 -= delta * speed4;
        web5 -= delta * speed5;
        web6 -= delta * speed6;
        web7 -= delta * speed7;
      
        if(input.isKeyDown(Input.KEY_UP)){
            mm = up;
            shiftY -= delta * .1f;
            if(shiftY < upLimit){
                shiftY += delta * .1f;
            }
        }
        if(input.isKeyDown(Input.KEY_DOWN)){
            mm = down;
            shiftY += delta * .1f;
            if(shiftY > downLimit){
                shiftY -= delta * .1f;
            }
            if(web1 > downLimit+20){
                web1 -= delta * .1f;
            }
        }
        if(input.isKeyDown(Input.KEY_RIGHT)){
            mm = right;
            shiftX += delta * .1f;
            if(shiftX > rightLimit){
                shiftX -= delta * .1f;
            }
        }
        if(input.isKeyDown(Input.KEY_LEFT)){
            mm = left;
            shiftX -= delta * .1f;
            if(shiftX < leftLimit + 25){
                shiftX += delta * .1f;
            }
        }
        
       
        if(input.isKeyDown(Input.KEY_ESCAPE)){
            quit = true;
        }
        if(quit == true){
            if(input.isKeyDown(Input.KEY_R)){
                quit = false;
            }
            if(input.isKeyDown(Input.KEY_M)){
                sbg.enterState(0);
            }
            if(input.isKeyDown(Input.KEY_Q)){
                System.exit(0);
            }
        }
 
        
    }

    @Override
    public int getID() {
        return 1;
    }
}
