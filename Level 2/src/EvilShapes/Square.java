package EvilShapes;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends GameObject {
	int xspeed;
	int yspeed;
public Square(int x, int y, int width, int height){
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	xspeed=0;
	yspeed=0;
}
void update(){
	x+=xspeed;
	y+=yspeed;
}
void draw(Graphics g){
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);

}
}
