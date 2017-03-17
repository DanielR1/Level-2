package EvilShapes;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class EvilShapes {
	JFrame frame;
	GamePanel panel;
	final static int width = 800;
	final static int height = 800;
public static void main(String[] args) {
	EvilShapes main = new EvilShapes();
}
public EvilShapes(){
	frame = new JFrame();
	frame.setSize(width, height);
	panel = new GamePanel();
	frame.addKeyListener(panel);
	
	setup();
}
void setup(){
	frame.add(panel);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.startGame();
}
}
