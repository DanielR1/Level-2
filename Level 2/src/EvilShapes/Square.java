package EvilShapes;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends GameObject {
	int xspeed;
	int yspeed;
public Square(int x, int y, int width, int height){
	super(x,y,width,height);
	
	xspeed=0;
	yspeed=0;
}
void update(){
	super.update();
	x+=xspeed;
	y+=yspeed;
	
}
void draw(Graphics g){
	g.drawImage(GamePanel.PlayerImg, x, y, width, height, null);
}
}
