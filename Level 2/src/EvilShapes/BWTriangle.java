package EvilShapes;

import java.awt.Color;
import java.awt.Graphics;

public class BWTriangle extends GameObject {
int speed = 15;

//int pos = new Random().nextInt(720);
int s;
	public BWTriangle(int x, int y, int width, int height, int s){
		super(x,y,width,height);
		this.s=s;
	}
	void update(){
		super.update();
		if(s==1){
			x+=speed;
		}
		if(s==2){
			y+=speed;
		}
		if(s==3){
			x-=speed;
		}
		if(s==4){
			y-=speed;
	}
	}
	void draw(Graphics g){
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
		}
	}

