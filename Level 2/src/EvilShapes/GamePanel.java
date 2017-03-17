package EvilShapes;
//Pt 7 step 3
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
public GamePanel(){
	timer = new Timer(1000/60, this);
titleFont=new Font("Arial",Font.PLAIN, 48);
titleFont2 =new Font("Arial",Font.PLAIN, 30);}
void startGame(){
	timer.start();
}
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
if(e.getKeyCode()==KeyEvent.VK_ENTER){
	if(currentState == END_STATE){
		currentState = MENU_STATE;
	}
	else{
		currentState+=1;
	}
}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub

}
void updateMenuState(){
	
}
void updateGameState(){
	
}
void updateEndState(){
	
}
void drawMenuState(Graphics g){
	g.setColor(new Color(21, 159, 53));
	g.fillRect(0, 0, EvilShapes.width, EvilShapes.height); 
	g.setFont(titleFont); 
	g.setColor(Color.black);
}
void drawGameState(Graphics g){
	g.setColor(new Color(200, 200,200));
	g.fillRect(0, 0, EvilShapes.width, EvilShapes.height);
}
void drawEndState(Graphics g){
	g.setColor(new Color(196, 16, 16));
	g.fillRect(0, 0, EvilShapes.width, EvilShapes.height);
}
}
