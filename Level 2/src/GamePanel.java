

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
//I was in part 7 step 6
public class GamePanel extends JPanel implements ActionListener, KeyListener{  
Timer time;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;
Font titleFont;
Font titleFont2;
Font titleFont3; 
Rocketship rocket = new Rocketship(250,700,50,50);
ObjectManager manager = new ObjectManager();
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	repaint();
	if(currentState == MENU_STATE){
		updateMenuState();
	}else if(currentState == GAME_STATE){
		updateGameState();
	}else if(currentState == END_STATE){
		updateEndState();
	}


}
public GamePanel(){
	time = new Timer(1000/60, this);
	titleFont = new Font("Arial",Font.PLAIN,48);
	titleFont2 = new Font("Arial",Font.PLAIN,28);
	manager.addObject(rocket);
	

}
void startGame(){
	time.start();
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
	System.out.println("a");
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("b");
	e.getSource();
	if(e.getKeyCode()==KeyEvent.VK_ENTER){
		if(currentState==END_STATE){
			currentState = MENU_STATE;
		}
		else{
			currentState +=1;
		}
	
	}
	else if(e.getKeyCode()==KeyEvent.VK_SPACE){
		manager.addObject(new Projectile(rocket.x+20, rocket.y+20, 10, 10));
	}
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("c");
	
}
void updateMenuState(){
	
}
void updateGameState(){
	manager.update();
	manager.manageEnemies();
}
void updateEndState(){
	
}
void drawMenuState(Graphics g){
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);  
	g.setFont(titleFont);
	g.setColor(Color.yellow);
	g.drawString("LEAGUE INVADERS", 30, 200);
	g.setFont(titleFont2);
	g.setColor(Color.yellow);
	g.drawString("Press ENTER to start", 110, 300);
	g.drawString("Press SPACE for instructions", 70, 400);
	
}
void drawGameState(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height); 
	manager.draw(g);
	
}
void drawEndState(Graphics g){
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height); 
	g.setFont(titleFont);
	g.setColor(Color.black);
	g.drawString("GAME OVER", 100, 100);
	g.setFont(titleFont2);
	g.setColor(Color.black);
	g.drawString("You killed _ aliens", 130, 300);
	g.drawString("Press BACKSPACE to Restart", 70, 500);
}

}

