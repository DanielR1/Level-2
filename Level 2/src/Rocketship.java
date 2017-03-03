import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
public Rocketship(int x, int y, int width, int height){
	this.height = height;
	this.width=width;
	this.x=x;
	this.y=y;
	speed=5;
}
void update(){

}
void draw(Graphics g){
g.setColor(Color.BLUE);
g.fillRect(x, y, width, height);
}
}
