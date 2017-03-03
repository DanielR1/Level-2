import java.awt.Color;
import java.awt.Graphics;
//Pt 11 challenge
public class Alien extends GameObject {
	int m;
public Alien(int x, int y, int width, int height){
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	
}
void update(){
	for (int i = 0; i < 3; i++) {
	y+=1;
	x+=30;
	}
	for (int i = 0; i < 3; i++) {
	y+=1;
	x-=30;
	}
}
void draw(Graphics g){
	g.setColor(Color.YELLOW);
	g.fillRect(x, y, width, height);
	
}
}
