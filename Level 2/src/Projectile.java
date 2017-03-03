import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	int speed = 10;
public Projectile(int x, int y, int width, int height){
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
}
void update(){
	y-=speed;
	if(y<=0){
		isAlive = false;
	}
}
void draw(Graphics g){
	g.setColor(Color.RED);
	g.fillRect(x, y, width, height);
}
}
