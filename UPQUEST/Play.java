
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState{

    Animation mm, up, down, left, right, stay, bend;
    Image map;
    Image one, two, three, four, five, six, seven, play;
    
    boolean quit = false;
    int[] duration = {200, 200, 200, 200, 200, 200, 200, 200, 200};
    int rightLimit = 610, leftLimit = -15;
    int upLimit = 70, downLimit = 310;
    float shiftX = 553;
    float shiftY = 150;
    boolean fbat = false, fhat = false, fhandcuff = false, fgun = false, fclock = false, fshoe = false, fbadge = false;
    Sound move, space, win;
    
    
    public Play(int state){

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        map = new Image("back3.jpg");
        one = new Image("bat.png");
        two = new Image("hat.png");
        three = new Image("handcuff.png");
        four = new Image("gun.png");
        five = new Image("clock.png");
        six = new Image("shoe.png");
        seven = new Image("badge.png");
        play = new Image("playagain.png");
        space = new Sound("space.ogg");
        move = new Sound("move.wav");
        win = new Sound("win.ogg");
        
        
        Image[] walkUp = {new Image("wu1.png"), new Image("wu2.png"), new Image("wu3.png"), new Image("wu4.png"), new Image("wu5.png"), new Image("wu6.png"), new Image("wu7.png"), new Image("wu8.png"), new Image("wd9.png")};
        Image[] walkDown = {new Image("wd1.png"), new Image("wd2.png"), new Image("wd3.png"), new Image("wd4.png"), new Image("wd5.png"), new Image("wd6.png"), new Image("wd7.png"), new Image("wd8.png"), new Image("wd9.png")};
        Image[] walkLeft = {new Image("wl1.png"), new Image("wl2.png"), new Image("wl3.png"), new Image("wl4.png"), new Image("wl5.png"), new Image("wl6.png"), new Image("wl7.png"), new Image("wl8.png"), new Image("wl9.png")};
        Image[] walkRight = {new Image("wr1.png"), new Image("wr2.png"), new Image("wr3.png"), new Image("wr4.png"), new Image("wr5.png"), new Image("wr6.png"), new Image("wr7.png"), new Image("wr8.png"), new Image("wr9.png")};
        Image[] steady = {new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png")};
        Image[] bendiffound = {new Image("bend2.png"), new Image("bend2.png"), new Image("bend3.png"), new Image("bend3.png"), new Image("bend4.png"), new Image("bend4.png"), new Image("bend4.png"), new Image("bend2.png"), new Image("bend1.png")};
        up = new Animation(walkUp, duration, true);
        down = new Animation(walkDown, duration, true);
        left = new Animation(walkLeft, duration, true);
        right = new Animation(walkRight, duration, true);
        stay = new Animation(steady, duration, true);
        bend = new Animation(bendiffound, duration, true);
        
        mm = stay;
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
    	
        map.draw(0, 0, map.getWidth(), map.getHeight());
        g.drawString("x " + shiftX + " y " + shiftY, 300, 20);
        if(fbat == false){
        	g.drawString("Bat", 80, 30);
        	one.draw(540, 290, one.getWidth()-344, one.getHeight()-152);
        }
        if(fhat == false){
        	g.drawString("Hat", 20, 30);
        	two.draw(35, 105, two.getWidth()-250, two.getHeight()-182);
        }
        if(fhandcuff == false){
        	g.drawString("Handcuff", 140, 30);
            three.draw(170, 200, three.getWidth()-750, three.getHeight()-326);
        }
        if(fgun == false){
        	g.drawString("Gun", 260, 30);
        	four.draw(320, 325, four.getWidth()-803, four.getHeight()-266);
        }
        if(fclock == false){
        	g.drawString("Clock", 340, 30);
        	five.draw(400, 250, five.getWidth()-305, five.getHeight()-400); 
        }
        if(fshoe == false){
        	g.drawString("Shoe", 450, 30);
        	 six.draw(400, 140, six.getWidth()-335, six.getHeight()-333);
        }
        if(fbadge == false){
        	g.drawString("Badge", 540, 30);
        	seven.draw(30, 320, seven.getWidth()-302, seven.getHeight()-403);
        }
        if(fbat == true && fhat == true && fhandcuff == true && fgun == true && fclock == true && fshoe == true && fbadge == true){
        	play.draw(500, 300, play.getWidth()-141, play.getHeight()-58);
        	win.loop();
        	
        }
        
        mm.draw(shiftX, shiftY, mm.getWidth(), mm.getHeight());
        
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
            if(shiftX < leftLimit){
                shiftX += delta * .1f;
            }
        }
        
        if(input.isKeyDown(Input.KEY_SPACE)){
            mm = bend;
            if((shiftX > 520 && shiftX < 600) && (shiftY < 300 && shiftY > 250)){
            	fbat = true;
            	space.play();
            }
            else if((shiftX > 30 && shiftX < 55) && (shiftY < 120 && shiftY > 50)){
            	fhat = true;
            	space.play();
            }
            
            else if((shiftX > 160 && shiftX < 190) && (shiftY < 230 && shiftY > 160)){
            	fhandcuff = true;
            	space.play();
            }
            
            else if((shiftX > 310 && shiftX < 400) && (shiftY < 320 && shiftY > 290)){
            	fgun = true;
            	space.play();
            }
            
            else if((shiftX > 387 && shiftX < 410) && (shiftY < 255 && shiftY > 215)){
            	fclock = true;
            	space.play();
            }
            
            else if((shiftX > 395 && shiftX < 430) && (shiftY < 140 && shiftY > 105)){
            	fshoe = true;
            	space.play();
            }
            else if((shiftX > 9 && shiftX < 35) && (shiftY < 310 && shiftY > 285)){
            	fbadge = true;
            	space.play();
            }
            else{
            	move.play();
            }
     
            int xpos, ypos;
        	xpos = Mouse.getX();
    		ypos = Mouse.getY();
    		if((xpos > 480 && xpos < 610) && (ypos < 310 && ypos > 260)){
    			move.play();
                if(Mouse.isButtonDown(0)) {
                	sbg.enterState(1);
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
        
    }

    @Override
    public int getID() {
        return 1;
    }


}