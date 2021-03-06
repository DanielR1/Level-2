package EvilShapes;

import java.applet.AudioClip;
import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;


import javax.swing.JApplet;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ObjectManager {
	ArrayList<GameObject> objects;

	public int millis;

	public int getMillis() {
		return millis;
	}

	public void setMillis(int millis) {
		this.millis = millis;
	}
	private int score = 0;
	int round = 1;
	long enemyTimer = 0;
	long enemySpawnTime = Math.round(500 /(round*(1.7)));
long lastCollision;
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
		long tick= System.currentTimeMillis();
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
			GameObject o = objects.get(i);
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
			
			else if(o.x<=-20){
				objects.remove(i);
			}
			else if(o.x>=820){
				objects.remove(i);
			}
			else if(o.y<=-20){
				objects.remove(i);
			}
			else if(o.y>=820){
				objects.remove(i);
			}
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			// addObject(new Triangle(new Random().nextInt(EvilShapes.WIDTH), 0,
			// 50, 50));
			int s = new Random().nextInt(4) + 1;
			int t = new Random().nextInt(3) + 1;
			
			int pos = new Random().nextInt(720);
			if (t == 1) {
				if (s == 1) {
					addObject(new Circle(0, pos + 40, 40, 40, s));
					t = new Random().nextInt(3) + 1;
				}
				if (s == 2) {
					addObject(new Circle(pos + 40, 0, 40, 40, s));
					t = new Random().nextInt(3) + 1;
				}
				if (s == 3) {
					addObject(new Circle(800, pos + 40, 40, 40, s));
					t = new Random().nextInt(3) + 1;
				}
				if (s == 4) {
					addObject(new Circle(pos + 40, 800, 40, 40, s));
					t = new Random().nextInt(3) + 1;
				}
			}
			if (t == 2) {
				if (s == 1) {
					addObject(new Triangle(0, pos + 40, 60, 60, s));
					t = new Random().nextInt(3) + 1;
				}
				if (s == 2) {
					addObject(new Triangle(pos + 40, 0, 60, 60, s));
					t = new Random().nextInt(3) + 1;
				}
				if (s == 3) {
					addObject(new Triangle(800, pos + 40, 60, 60, s));
					t = new Random().nextInt(3) + 1;
				}
				if (s == 4) {
					addObject(new Triangle(pos + 40, 800, 60, 60, s));
					t = new Random().nextInt(3) + 1;
				}
			}
			if (t == 3) {
				if (s == 1) {
					addObject(new BWTriangle(0, pos + 40, 40, 40, s));
					t = new Random().nextInt(3) + 1;
				}
				if (s == 2) {
					addObject(new BWTriangle(pos + 40, 0, 40, 40, s));
					t = new Random().nextInt(3) + 1;
				}
				if (s == 3) {
					addObject(new BWTriangle(800, pos + 40, 40, 40, s));
					t = new Random().nextInt(3) + 1;
				}
				if (s == 4) {
					addObject(new BWTriangle(pos + 40, 800, 40, 40, s));
					t = new Random().nextInt(3) + 1;
				}
			}
			enemyTimer = System.currentTimeMillis();
		}
	}

	public void checkCollision() {
		boolean squarecollide=false;
		Square t=null;
		System.out.println(millis);
		long currentTime=System.currentTimeMillis();
		if(currentTime-lastCollision<400){
			System.out.println("skipped collision");
			return;
		}
		for (int i = 0; i < objects.size(); i++) {
			GameObject o1 = objects.get(i);
			if(o1 instanceof Square){
				t=(Square) o1;
			}
			for (int j = i + 1; j < objects.size(); j++) {
				
				GameObject o2 = objects.get(j);

				if (o1.collisionBox.intersects(o2.collisionBox)) {

					if ((o1 instanceof Triangle && o2 instanceof Circle)) {
					
						score++;
						System.out.println(score);
						o1.isAlive = false;
					}
						if ((o1 instanceof Circle && o2 instanceof Triangle)) {
						
							score++;
							System.out.println(score);
							o2.isAlive = false;
						}
						if ((o1 instanceof BWTriangle && o2 instanceof Circle)) {
						
							score++;
							System.out.println(score);
							o1.isAlive = false;
						}
							if ((o1 instanceof Circle && o2 instanceof BWTriangle)) {
				
								score++;
								System.out.println(score);
								o2.isAlive = false;
							}
					
					if ((o1 instanceof Triangle && o2 instanceof Square)
							|| (o2 instanceof Triangle && o1 instanceof Square)) {
						System.out.println("lprint");
						o1.isAlive = false;
						o2.isAlive = false;

					}
					if ((o1 instanceof Circle && o2 instanceof Square)
							|| (o2 instanceof Circle && o1 instanceof Square)) {
playSound("CircleCollide.wav");
						Circle bounce = (o1 instanceof Circle) ? (Circle) o1 : (Circle) o2;
						if (!bounce.bounced) {
							if (bounce.s == 1) {
								bounce.xspeed = bounce.xspeed * (-1);
								bounce.x-=bounce.xspeed*-2;

							}
							if (bounce.s == 2) {
								bounce.yspeed = bounce.yspeed * (-1);
								bounce.y-=bounce.yspeed*-2;
							}
							if (bounce.s == 3) {
								bounce.xspeed = bounce.xspeed * (-1);
								bounce.x+=bounce.xspeed*-2;
							}
							if (bounce.s == 4) {
								bounce.yspeed = bounce.yspeed * (-1);
								bounce.y+=bounce.yspeed*-2;
							}
							bounce.bounced = true;
						}
						lastCollision=currentTime;
					}
					if ((o1 instanceof BWTriangle && o2 instanceof Square)
							|| (o2 instanceof BWTriangle && o1 instanceof Square)) {
						Square bounce = (o1 instanceof Square) ? (Square) o1 : (Square) o2;
						BWTriangle bounce1 = (o1 instanceof BWTriangle) ? (BWTriangle) o1 : (BWTriangle) o2;
						squarecollide=true;
						if (bounce1.s == 1) {
							System.out.println("1");
							bounce.xspeed = bounce1.xspeed;
							bounce.yspeed = bounce1.yspeed;

						}
						if (bounce1.s == 2) {
System.out.println("2");
							bounce.xspeed = bounce1.xspeed;
							bounce.yspeed = bounce1.yspeed;

						}
						if (bounce1.s == 3) {
System.out.println("3");
							bounce.xspeed = bounce1.xspeed * (-1);
							bounce.yspeed = bounce1.yspeed;
						}
						if (bounce1.s == 4) {
System.out.println("4");
							bounce.xspeed = bounce1.xspeed;
							bounce.yspeed = bounce1.yspeed * (-1);
						}

					}

				}
			}
		}
t.collision=squarecollide;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void reset() {
		objects.clear();

	}
	private void playSound(String fileName) {
		AudioClip sound = JApplet
				.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

}
