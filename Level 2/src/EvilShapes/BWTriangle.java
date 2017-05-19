package EvilShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BWTriangle extends GameObject {
int speed = 15;

//int pos = new Random().nextInt(720);
int s;
int xspeed;
int yspeed;
	public BWTriangle(int x, int y, int width, int height, int s){
		super(x,y,width,height);
		this.s=s;
		int k = new Random().nextInt(2) + 1;
		xspeed = new Random().nextInt(15) + 1;
		yspeed = 15 - xspeed;
		if (s == 1) {

			if (k == 1) {
				yspeed = yspeed * (-1);
			}

		}
		if (s == 2) {

			if (k == 1) {
				xspeed += xspeed * (-1);
			}

		}
		if (s == 3) {

			if (k == 1) {
				yspeed += yspeed * (-1);
			}

		}
		if (s == 4) {

			if (k == 1) {
				xspeed += xspeed * (-1);
			}
		}
	}
	void update(){
		super.update();
		if (s == 1) {
			x += xspeed;
			y += yspeed;

		}
		if (s == 2) {
			y += yspeed;
			x += xspeed;

		}
		if (s == 3) {
			//xspeed=xspeed*(-1);
			x -= xspeed;
			y += yspeed;
		}
		if (s == 4) {
			//yspeed=yspeed*(-1);
			y -= yspeed;
			x += xspeed;

		}
	}
	

	void draw(Graphics g){
		g.drawImage(GamePanel.SlimeImg, x, y, width, height, null);
		}
	}

