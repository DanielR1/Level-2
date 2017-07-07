package EvilShapes;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{  
Timer timer;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;
Font titleFont;
Font titleFont2;
public static BufferedImage SpikeImg;
public static BufferedImage SlimeImg;
public static BufferedImage CircleImg;
public static BufferedImage PlayerImg;
SongPlayer play;
Square square = new Square(375,365,50,50);
ObjectManager manager = new ObjectManager();
int millis = 0;

public GamePanel(){
	timer = new Timer(1000/60, this);
	manager.millis=millis;
titleFont=new Font("Arial",Font.PLAIN, 48);
titleFont2 =new Font("Arial",Font.PLAIN, 30);
manager.addObject(square); 
try {
	SpikeImg = ImageIO.read(this.getClass().getResourceAsStream("spike.png"));
	SlimeImg = ImageIO.read(this.getClass().getResourceAsStream("slimeball.png"));
	CircleImg = ImageIO.read(this.getClass().getResourceAsStream("circle.png"));
	PlayerImg = ImageIO.read(this.getClass().getResourceAsStream("player.png"));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
void startGame(){
	play = new SongPlayer("Theme.mp3");
	play.play();
	timer.start();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	repaint();
	if(currentState == MENU_STATE){
		updateMenuState();
	}else if(currentState == GAME_STATE){
		millis+=200;
		updateGameState();
	}else if(currentState == END_STATE){
		updateEndState();
	}


}
public void paintComponent(Graphics g){
	if(currentState == MENU_STATE){
		drawMenuState(g);
	}else if(currentState == GAME_STATE){
		drawGameState(g);
	}else if(currentState == END_STATE){
		drawEndState(g);
	}

}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub

}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
		if(currentState==MENU_STATE){
		int quit=	JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
		if (quit==0){
			System.exit(0);
		}
		}
	}
	if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
		if(currentState == END_STATE){
			currentState = MENU_STATE;
			playSound("Startup.wav");

		}
	
	}
if(e.getKeyCode()==KeyEvent.VK_ENTER){
	if(currentState == MENU_STATE){
		currentState+=1;
		playSound("Click.wav");
	}
	
}
if(e.getKeyCode()==KeyEvent.VK_SPACE){
	if(currentState==MENU_STATE){
		JOptionPane.showMessageDialog(null, "You are the Square. Move with arrow keys. Spike balls kill you, slimeballs stick you to them, red balls reflect off of you and kill spike balls");
	}
}
if(currentState==GAME_STATE){
	if(e.getKeyCode()==KeyEvent.VK_LEFT){
		square.left = true;
	}
	if(e.getKeyCode()==KeyEvent.VK_RIGHT){
		square.right=true;
	}
	if(e.getKeyCode()==KeyEvent.VK_UP){
		square.up=true;
	}
	if(e.getKeyCode()==KeyEvent.VK_DOWN){
		square.down=true;
	}
}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	if(currentState==GAME_STATE){
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			square.left = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			square.right=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			square.up=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			square.down=false;
		}
	}

}
void updateMenuState(){
	manager.round=1;
	
	millis=0;
}
void updateGameState(){
	
manager.update();
manager.manageEnemies();
manager.checkCollision();
if(millis%50000==0){
	manager.round+=1;
	playSound("round.wav");
}
if(square.x<=0){
	square.isAlive=false;
}
if(square.x>=750){
	square.isAlive=false;
}
if(square.y<=0){
	square.isAlive=false;
}
if(square.y>=750){
	square.isAlive=false;
}
if(square.isAlive==false){
	playSound("Die.wav");
	currentState=END_STATE;
	manager.getScore();
	manager.reset();
	
	square=new Square(375,365,50,50);
	manager.addObject(square);
	
}
}
void updateEndState(){
	
}
void drawMenuState(Graphics g){
	g.setColor(new Color(0, 148, 206));
	g.fillRect(0, 0, EvilShapes.width, EvilShapes.height); 
	g.setFont(titleFont); 
	g.setColor(Color.black);
	g.drawString("Evil Circles", 280, 120);
	g.setFont(titleFont2);
	g.drawString("Press ENTER to start",250, 250);
	g.drawString("Press SPACE for instructions", 200, 400);
	g.drawString("Press ESC to quit", 280, 550);
}
void drawGameState(Graphics g){
	
	
	if(manager.round==1){
		g.setColor(new Color(0, 206, 68));
	}
	if(manager.round==2){
		g.setColor(new Color(0, 206, 20));
	}
	if(manager.round==3){
		g.setColor(new Color(28, 206, 0));
	}
	if(manager.round==4){
		g.setColor(new Color(76, 206, 0));
	}
	if(manager.round==5){
		g.setColor(new Color(124, 206, 0));
	}
	if(manager.round==6){
		g.setColor(new Color(172, 206, 0));
	}
	if(manager.round==7){
		g.setColor(new Color(206, 192, 0));
	}
	if(manager.round==8){
		g.setColor(new Color(206, 144, 0));
	}
	if(manager.round==9){
		g.setColor(new Color(206, 96, 0));
	}
	if(manager.round==10){
		g.setColor(new Color(206, 48, 0));
	}
	if(manager.round>=11){
		g.setColor(new Color(206, 0, 0));
	}
	g.fillRect(0, 0, EvilShapes.width, EvilShapes.height);
	manager.draw(g);
	g.setFont(titleFont2);
	g.setColor(Color.BLACK);
	g.drawString("Round "+manager.round, 100, 100);
}
void drawEndState(Graphics g){
	g.setColor(new Color(196, 16, 16));
	g.fillRect(0, 0, EvilShapes.width, EvilShapes.height);
	g.setFont(titleFont);
	g.setColor(Color.black);
	g.drawString("GAME OVER", 260, 120);
	g.setFont(titleFont2);
	g.drawString("You lasted "+manager.round+" rounds", 265, 250);
	g.drawString("Press BACKSPACE to go again", 200, 400);
}
private void playSound(String fileName) {
	AudioClip sound = JApplet
			.newAudioClip(getClass().getResource(fileName));
	sound.play();
}

}
