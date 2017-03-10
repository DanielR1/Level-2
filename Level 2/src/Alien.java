import java.awt.Color;
import java.awt.Graphics;
public class Alien extends GameObject {
	int m;

	public Alien(int x, int y, int width, int height){
	super(x,y,width,height);
	
}
int counter = 0;
void update(){
	super.update();
	y+=5;
	if(counter%10==0)
	{x+=10;}
	else if(counter%5==0){
		x-=10;
	}
	
	counter+=1;
}
void draw(Graphics g){
	g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	
}
}
