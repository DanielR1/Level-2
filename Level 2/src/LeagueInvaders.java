import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel panel;
	final static int height = 800;
	final static int width = 500;
public static void main(String[] args) {
	LeagueInvaders lol = new LeagueInvaders();
}
 public LeagueInvaders(){
	 panel = new GamePanel();
	 frame = new JFrame();
	 setup();
	 
 }
 void setup(){
	 frame.add(panel);
	 frame.setVisible(true);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 panel.startGame();
	 frame.setSize(width, height);
	 frame.addKeyListener(panel);
	 frame.setTitle("League Invaders");
 }
}