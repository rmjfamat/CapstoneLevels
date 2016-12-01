


import java.util.Random;

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

public class PlayThree extends BasicGameState{

    Animation map, mm, up, down, left, right, stay, flyleft, flyright, bird, fromtunnel, danger;
    Image tunnel, gameover, levelComp;
    Music background;
    Sound bubbles, fall, GOV;
    boolean quit = false;
    int[] duration = {200, 200, 200, 200, 200, 200, 200, 200, 200};
    int[] durationBird = {80, 80, 80, 80, 80, 80, 80, 80, 80};
    int[] durationLava = {300, 300, 300, 300, 300, 300, 300, 300, 300};
    int rightLimit = 620, leftLimit = -30;
    int upLimit = 140, downLimit = 216;
    float shiftX = 300;
    float shiftY = -50;
    float birdPosY;
    float birdPosX = -400;
    float speedBirdx, speedBirdy, leftlimitBird = -13, rightlimitBird = 600;
    boolean onGround = false, dangerZone = false, win = false;
    boolean startgame = false;
    Random Y;
    
    public PlayThree(int state){
    
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    	tunnel = new Image("tunnel.png");
    	background = new Music("musicPlayThree.ogg");
    	bubbles = new Sound("bub.ogg");
    	fall = new Sound("fall.wav");
    	gameover = new Image("GOV.png");
    	GOV = new Sound("gov.ogg");
    	levelComp = new Image("gstar.png");
        Image[] back = {new Image("back1.png"), new Image("back2.png"), new Image("back3.png"), new Image("back4.png"), new Image("back1.png"), new Image("back2.png"), new Image("back3.png"), new Image("back4.png"), new Image("back1.png")};
        Image[] walkDown = {new Image("wd1.png"), new Image("wd2.png"), new Image("wd3.png"), new Image("wd4.png"), new Image("wd5.png"), new Image("wd6.png"), new Image("wd7.png"), new Image("wd8.png"), new Image("wd9.png")};
        Image[] walkLeft = {new Image("wl1.png"), new Image("wl2.png"), new Image("wl3.png"), new Image("wl4.png"), new Image("wl5.png"), new Image("wl6.png"), new Image("wl7.png"), new Image("wl8.png"), new Image("wl9.png")};
        Image[] walkRight = {new Image("wr1.png"), new Image("wr2.png"), new Image("wr3.png"), new Image("wr4.png"), new Image("wr5.png"), new Image("wr6.png"), new Image("wr7.png"), new Image("wr8.png"), new Image("wr9.png")};
        Image[] steady = {new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png"), new Image("s3.png")};
        Image[] fall = {new Image("s1.png"), new Image("s2.png"), new Image("s3.png"), new Image("s4.png"), new Image("s5.png"), new Image("s6.png"), new Image("s1.png"), new Image("s2.png"), new Image("s3.png")};
        Image[] LEFT = {new Image("fl1.png"), new Image("fl2.png"), new Image("fl3.png"), new Image("fl4.png"), new Image("fl5.png"), new Image("fl6.png"), new Image("fl7.png"), new Image("fl8.png"), new Image("fl8.png")};
        Image[] RIGHT = {new Image("fr1.png"), new Image("fr2.png"), new Image("fr3.png"), new Image("fr4.png"), new Image("fr5.png"), new Image("fr6.png"), new Image("fr7.png"), new Image("fr8.png"), new Image("fr8.png")};
        Image[] dangerZone = {new Image("dangerZone.png"), new Image("dangerZone1.png"), new Image("dangerZone2.png"), new Image("dangerZone3.png"), new Image("dangerZone4.png"), new Image("dangerZone.png"), new Image("dangerZone1.png"), new Image("dangerZone2.png"), new Image("dangerZone3.png")};

        map = new Animation(back, durationLava, true);
        down = new Animation(walkDown, duration, true);
        left = new Animation(walkLeft, duration, true);
        right = new Animation(walkRight, duration, true);
        stay = new Animation(steady, duration, true);
        flyleft = new Animation (LEFT, durationBird, true);
        flyright = new Animation (RIGHT, durationBird, true);
        fromtunnel = new Animation (fall, duration, true);
        danger = new Animation (dangerZone, duration, true);
        mm = stay;
        background.loop();
        background.setVolume(1.5f);
        Y = new Random();
        birdPosY = Y.nextInt(10) + -30;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
    	if(startgame == false){
    		//draw kato instuctions
    	}
        map.draw(0, 0, map.getWidth(), map.getHeight());
        mm.draw(shiftX, shiftY, mm.getWidth(), mm.getHeight());
        tunnel.draw(265, 0, 100, 80);
       if(onGround == true){
        bird.draw(birdPosX, birdPosY, bird.getWidth() - 10, bird.getHeight() - 9);
       }
       
        if(dangerZone == true && shiftY > 215){
        	GOV.loop();
        	map.stop();
        	background.stop();
        	bubbles.stop();
        	danger.draw(50,100);
        	shiftY += 0.1f;
        }
        else{
        	bubbles.play(0.4f, 0.2f);
        }
        if(onGround == false){
        	fall.play();
        	
        }
        if(win == true){
        	if(bird == flyleft){
        		rightlimitBird = -1000;
        	}
        	else{
        		leftlimitBird = 2000;
        	}
        	shiftX = birdPosX +5;
        	shiftY = birdPosY - 10;
        	dangerZone = false;
        }
        
        bubbles.play(0.4f, 0.2f);
        
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
        
        if(){
        	//////// mousepressed blah blah
        	startgame = true;
        	
        }
        if(birdPosX < leftlimitBird){
        	speedBirdx = -.2f;
        	bird = flyleft;
        }
        if(birdPosX > rightlimitBird){
        	speedBirdx = .2f;
        	bird = flyright;
        }
        
        birdPosX -= delta * speedBirdx;
        
        if(birdPosY < 35){
        	speedBirdy = -.2f;
        }
        if(birdPosY > 170){
        	speedBirdy = .2f;
        }
        
        birdPosY -= delta * speedBirdy;
        
        if(shiftY < downLimit){
        	mm = fromtunnel;
            shiftY += delta * .3f;
            if(shiftY + 10 > downLimit){
            	onGround = true;
            }
        }
       
        if(((birdPosX - shiftX > 0 && birdPosX - shiftX < 30) || (birdPosX - shiftX < -10 && birdPosX - shiftX > -30))  && (birdPosY - shiftY < -10 && birdPosY - shiftY > -15)){
        	win = true;
        }
        
        if(shiftX < 165 || shiftX > 420){
        	dangerZone = true;
        }
      
        if(input.isKeyDown(Input.KEY_UP)){
        	
        	 mm = fromtunnel;
        	 if(shiftY > upLimit){
        		 shiftY -= delta * 1.0f;
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
