package EvilShapes;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	
	private int score = 0;
	
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
		
		purgeObjects();	
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void manageEnemies(){
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
	//		addObject(new Triangle(new Random().nextInt(EvilShapes.WIDTH), 0, 50, 50));
		int s = new Random().nextInt(4)+1;
			if(s==1){
				addObject(new Circle(0, Circle.pos+40, 40, 40));
			}
			if(s==2){
				addObject(new Circle(Circle.pos+40,0 , 40, 40));
			}
			if(s==3){
				addObject(new Circle(800, Circle.pos+40, 40, 40));
			}
			if(s==4){
				addObject(new Circle(Circle.pos+40,800 , 40, 40));
		}
			enemyTimer = System.currentTimeMillis();
		}
	}
 
	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
			GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
//				
//				if(o1.collisionBox.intersects(o2.collisionBox)){
//					if((o1 instanceof Triangle && o2 instanceof Circle) ||
//					   (o2 instanceof Triangle && o1 instanceof Circle)){
//						score++;
//						System.out.println(score);
//						o1.isAlive = false;
//						o2.isAlive = false;
//					}
//					else if((o1 instanceof Triangle && o2 instanceof Square) ||
//							(o2 instanceof Triangle && o1 instanceof Square)){
//						o1.isAlive = false;
//						o2.isAlive = false;
//					}
//	
//				}
		}
		}
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
	public void reset(){
		objects.clear();
	}
}
