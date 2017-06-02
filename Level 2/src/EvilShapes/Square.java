package EvilShapes;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends GameObject {
	int xspeed;
	int yspeed;
	boolean left;
	boolean up;
	boolean down;
	boolean right;
	boolean collision;
public Square(int x, int y, int width, int height){
	super(x,y,width,height);
	left=false;
	up=false;
	down=false;
	right=false;
	collision=false;
	xspeed=0;
	yspeed=0;
}
void update(){
	if(collision){
		
	}
	else{
	super.update();
	if(left){
		xspeed=-5;
	}
	if(right){
		xspeed=5;
	}
	if(up){
		yspeed=-5;
	}
	if(down){
		yspeed=5;
	}
	
	if(!left &&!right){
		xspeed=0;
	}
	if(!up&&!down){
		yspeed=0;
	}
	}
//	if(!up){
//		yspeed=0;
//	}
//	if(!down){
//		yspeed=0;
//	}
	x+=xspeed;
	y+=yspeed;
	
}
void draw(Graphics g){
	g.drawImage(GamePanel.PlayerImg, x, y, width, height, null);
}
}
