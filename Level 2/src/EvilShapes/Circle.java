package EvilShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circle extends GameObject {
int speed = 10;

int pos = new Random().nextInt(720);
int s = new Random().nextInt(4)+1;
	public Circle(int x, int y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	void update(){
		
		if(s==1){
			x+=speed;
		}
		if(s==2){
			y-=speed;
		}
		if(s==3){
			x-=speed;
		}
		if(s==4){
			y+=speed;
	}
	}
	void draw(Graphics g){
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
		}
	}

