package EvilShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circle extends GameObject {
int speed = 10;
	public Circle(int x, int y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	void update(){
		
	}
	void draw(Graphics g){
		g.setColor(Color.red);
		int pos = new Random().nextInt(720);
		int s = new Random().nextInt(4)
	}
}
