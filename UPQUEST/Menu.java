import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{

	Image bg, quit, play, upquest;
    int xpos, ypos;
    Music back;
    Sound playgame;
	
	public Menu(int state){
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image("ImpelDown.png");
        upquest = new Image("upquest1.png");
		quit = new Image("quitGame.png");
		play = new Image("playGame.png");
		back = new Music("back.ogg");
		playgame = new Sound("play.ogg");
		back.loop();
		back.setVolume(2.0f);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
        bg.draw(0, 0, 640, 360);
        upquest.draw(125, 3);
		play.draw(350, 200);
		quit.draw(360, 250);

    }

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		if((xpos > 370 && xpos < 585) && (ypos > 110 && ypos < 140)){
            if(Mouse.isButtonDown(0)) {
            	playgame.play();
                sbg.enterState(1);
            }
        }
        if((xpos > 380 && xpos < 585) && (ypos > 60 && ypos < 90)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
	}

	@Override
	public int getID() {
		return 0;
	}
	

}