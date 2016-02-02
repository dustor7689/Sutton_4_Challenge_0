package GreedPack;


import slickexample.Orb;
import java.util.ArrayList;


import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;

import org.newdawn.slick.AppGameContainer;


import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;

import org.newdawn.slick.Image;

import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.SpriteSheet;


import org.newdawn.slick.geom.Rectangle;

import org.newdawn.slick.geom.Shape;

import org.newdawn.slick.state.BasicGameState;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import org.newdawn.slick.tiled.TiledMap;

class blocked {

	public static boolean[][] blocked;

	public static boolean[][] getblocked() {

		return blocked;

	}

};


class item1 {
	public int x;
	public int y;
	public boolean isvisible = true;
	Image currentImage;
	Shape hitbox;
	Image healthpotion = new Image("res/coin25.png");

	item1(int a, int b) throws SlickException {
		this.x = a;
		this.y = b;
		this.hitbox = new Rectangle(a, b, 32, 32);// 64 is the width of the item
		this.currentImage = healthpotion;

	}

}

class itemwin {
	public int x;
	public int y;
	public static boolean isvisible = true;
	Image currentImage;
	Shape hitbox;
	Image antidote = new Image("res/Treasure.png");

	itemwin (int a, int b) throws SlickException {
		this.x = a;
		this.y = b;
		this.hitbox = new Rectangle(a, b, 32, 32);// 64 is the width of the item
		this.currentImage = antidote;

	}

}

class player {

	public static float x = 96f;

	public static float y = 228f;

	public static int health = 100000;
	
	public static float speed = .5f;

	static float hitboxX = x + 8f;

	static float hitboxY = y + 8f;

	private static int startX, startY, width = 30, height = 42;

	public static Shape rect = new Rectangle(getplayershitboxX(),
			getplayershitboxY(), width, height);

	public static float pdelta;

	public static Animation playeranime;

	public static void setpdelta(float somenum) {

		pdelta = somenum;

	}

	public static float getpdelta() {

		return pdelta;

	}

	public static float getplayersX() {

		return x;

	}

	public static float getplayersY() {

		return y;

	}

	public static float getplayershitboxX() {

		return x + 18f;

	}

	public static float getplayershitboxY() {

		return y + 18f;

	}

	public static void setplayershitboxX() {

		hitboxX = getplayershitboxX();

	}

	public static void setplayershitboxY() {

		hitboxY = getplayershitboxY();

	}

}

public class Greed extends BasicGameState {

	
	public Item healthpotion, healthpotion1;
	public item1 speedpotion, speedpotion1;
	public itemwin antidote;
      //  public Ninja Matthew;
        //public Ninja Gerber;
        public Enemy numberone;
        
       public Orb theBestOrbEver;
        
        //public ArrayList<Orb> orbList = new ArrayList();
                
	public ArrayList<Item> stuff = new ArrayList();

	public ArrayList<item1> stuff1 = new ArrayList();
        
        public ArrayList<Enemy> skeltonz = new ArrayList();
	
	public ArrayList<itemwin> stuffwin = new ArrayList();
        

        
        //public ArrayList<Ninja> ninjaz = new ArrayList();

	private boolean[][] hostiles;

	private static TiledMap grassMap;

	private static AppGameContainer app;

	private static Camera camera;
	
	public static int counter = 0;

	// Player stuff

	private Animation sprite, up, down, left, right, wait;

	/**
	 * 
	 * The collision map indicating which tiles block movement - generated based
	 * 
	 * on tile properties
	 */

	// changed to match size of sprites & map

	private static final int SIZE = 64;

	// screen width and height won't change

	private static final int SCREEN_WIDTH = 1000;

	private static final int SCREEN_HEIGHT = 750;

	public Greed(int xSize, int ySize) {

	}

	public void init(GameContainer gc, StateBasedGame sbg)

	throws SlickException {
		
		 gc.setTargetFrameRate(60);

		gc.setShowFPS(false);

		// *******************

		// Scenerey Stuff

		// ****************

		grassMap = new TiledMap("res/Wavering.tmx");

		// Ongoing checks are useful

		System.out.println("Tile map is this wide: " + grassMap.getWidth());

		camera = new Camera(gc, grassMap);

		// *********************************************************************************

		// Player stuff --- these things should probably be chunked into methods
		// and classes

		// *********************************************************************************



		// *****************************************************************

		// Obstacles etc.

		// build a collision map based on tile properties in the TileD map

		blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];

		// System.out.println("Map height:" + grassMap.getHeight());

		// System.out.println("Map width:" + grassMap.getWidth());

		// There can be more than 1 layer. You'll check whatever layer has the
		// obstacles.

		// You could also use this for planning traps, etc.

		// System.out.println("Number of tile layers: "
		// +grassMap.getLayerCount());

		System.out.println("The grassmap is " + grassMap.getWidth() + "by "
				+ grassMap.getHeight());

		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {

			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {

				// int tileID = grassMap.getTileId(xAxis, yAxis, 0);

				// Why was this changed?

				// It's a Different Layer.

				// You should read the TMX file. It's xml, i.e.,human-readable
				// for a reason

				int tileID = grassMap.getTileId(xAxis, yAxis, 0);

				String value = grassMap.getTileProperty(tileID,

				"blocked", "false");

				if ("true".equals(value)) {

					System.out.println("The tile at x " + xAxis + " andy axis "
							+ yAxis + " is blocked.");

					blocked.blocked[xAxis][yAxis] = true;

				}

			}

		}

		System.out.println("Array length" + blocked.blocked[0].length);

		// A remarkably similar process for finding hostiles

		hostiles = new boolean[grassMap.getWidth()][grassMap.getHeight()];

		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
				int xBlock = (int) xAxis;
				int yBlock = (int) yAxis;
				if (!blocked.blocked[xBlock][yBlock]) {
					if (yBlock % 7 == 0 && xBlock % 15 == 0 ) {
						Item i = new Item(xAxis * SIZE, yAxis * SIZE);
						stuff.add(i);
						//stuff1.add(h);
						hostiles[xAxis][yAxis] = true;
					}
				}
			}
		}
		
		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
				int xBlock = (int) xAxis;
				int yBlock = (int) yAxis;
				if (!blocked.blocked[xBlock][yBlock]) {
					if (xBlock % 9 == 0	&& yBlock % 25 == 0) {
						item1 h = new item1(xAxis * SIZE, yAxis * SIZE);
					//	stuff.add(i);
						stuff1.add(h);
						hostiles[xAxis][yAxis] = true;
					}
				}
			}
		}

		healthpotion = new Item(100, 100);
		healthpotion1 = new Item(450, 400);
                //Matthew = new Ninja (450, 400);
               // Gerber= new Ninja (450, 400);
               // numberone = new Enemy (300, 300);
		stuff.add(healthpotion);
		stuff.add(healthpotion1);
                
		
                //Ninja.add(Matthew);
               // Ninja.add(Gerber);
                
		speedpotion = new item1(100,150);
		speedpotion1 = new item1(450,100);	
		stuff1.add(speedpotion);
		stuff1.add(speedpotion1);
		
		antidote = new itemwin(3004,92);
		stuffwin.add(antidote);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)

	throws SlickException {

		camera.centerOn((int) player.x, (int) player.y);

		camera.drawMap();

		camera.translateGraphics();

		// it helps to add status reports to see what's going on

		// but it gets old quickly

		// System.out.println("Current X: " +player.x + " \n Current Y: "+ y);

		sprite.draw((int) player.x, (int) player.y);
		
		//g.drawString("x: " + (int)player.x + "y: " +(int)player.y , player.x, player.y - 10);

		g.drawString("Health: " + player.health/1000, camera.cameraX + 10,
				camera.cameraY + 10);
		
		g.drawString("speed: " + (int)(player.speed *10), camera.cameraX + 10,
				camera.cameraY + 25);

		//g.draw(player.rect);

		g.drawString("time passed: " +counter/1000, camera.cameraX +600,camera.cameraY );
		// moveenemies();
                
           //     Matthew.currentImage.draw(Matthew.x, Matthew.y);
             //   Gerber.currentImage.draw(Gerber.x, Gerber.y);
                if(theBestOrbEver.isIsVisiable()){
                    theBestOrbEver.orbpic.draw(theBestOrbEver.getX(), theBestOrbEver.getY());
                }

		for (Item i : stuff) {
			if (i.isvisible) {
				i.currentImage.draw(i.x, i.y);
				// draw the hitbox
				g.draw(i.hitbox);

			}
		}
		
		
		for (item1 h : stuff1) {
			if (h.isvisible) {
				h.currentImage.draw(h.x, h.y);
				// draw the hitbox
				g.draw(h.hitbox);

			}
		}
		
		for (itemwin w: stuffwin) {
			if (w.isvisible) {
				w.currentImage.draw(w.x, w.y);
				// draw the hitbox
				g.draw(w.hitbox);

			}
		}

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)

	throws SlickException {
		
		counter += delta;

		Input input = gc.getInput();

		float fdelta = delta * player.speed;

		player.setpdelta(fdelta);

		double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);

		// System.out.println("Right limit: " + rightlimit);

		float projectedright = player.x + fdelta + SIZE;

		boolean cangoright = projectedright < rightlimit;

		// there are two types of fixes. A kludge and a hack. This is a kludge.

		if (input.isKeyDown(Input.KEY_UP)) {

			sprite = up;

			float fdsc = (float) (fdelta - (SIZE * .15));

			if (!(isBlocked(player.x, player.y - fdelta) || isBlocked(
					(float) (player.x + SIZE + 1.5), player.y - fdelta))) {

				sprite.update(delta);

				// The lower the delta the slower the sprite will animate.

				player.y -= fdelta;

			}

		} else if (input.isKeyDown(Input.KEY_DOWN)) {

			sprite = down;

			if (!isBlocked(player.x, player.y + SIZE + fdelta)

			|| !isBlocked(player.x + SIZE - 1, player.y + SIZE + fdelta)) {

				sprite.update(delta);

				player.y += fdelta;

			}

		} else if (input.isKeyDown(Input.KEY_LEFT)) {

			sprite = left;

			if (!(isBlocked(player.x - fdelta, player.y) || isBlocked(player.x

			- fdelta, player.y + SIZE - 1))) {

				sprite.update(delta);

				player.x -= fdelta;

			}

		} else if (input.isKeyDown(Input.KEY_RIGHT)) {

			sprite = right;

			// the boolean-kludge-implementation

			if (cangoright
					&& (!(isBlocked(player.x + SIZE + fdelta,

					player.y) || isBlocked(player.x + SIZE + fdelta, player.y
							+ SIZE - 1)))) {

				sprite.update(delta);

				player.x += fdelta;

			} // else { System.out.println("Right limit reached: " +
				// rightlimit);}

		} else if (input.isKeyDown(Input.KEY_SPACE)){
                    
                }

		player.rect.setLocation(player.getplayershitboxX(),
				player.getplayershitboxY());

		/*for (Ninja n : ninjaz) {

			if (player.rect.intersects(n.hitbox)) {
				//System.out.println("yay");
				if (n.isvisible) {

					player.health -= 10000;
					n.isvisible = false;
				}

			}
		}*/
		/*for (Enemy e: skeltonz) {
	
			if (e.rect.intersects(e.hitbox)) {
				//System.out.println("yay");
				if (e.isvisible) {

					player.health -= 10000;
					e.isvisible = false;
				}

			}
		}*/
		for (item1 h : stuff1) {

			if (player.rect.intersects(h.hitbox)) {
				//System.out.println("yay");
				if (h.isvisible) {

					player.speed += .1f;
					h.isvisible = false;
				}

			}
		}
		
		for (itemwin w : stuffwin) {

			if (player.rect.intersects(w.hitbox)) {
				//System.out.println("yay");
				if (w.isvisible) {
					w.isvisible = false;
					makevisible();
					sbg.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
					
				}

			}
		}
		 
		player.health -= counter/1000;
		if(player.health <= 0){
			makevisible();
			sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		}

	}

	public int getID() {

		return 1;

	}

	public void makevisible(){
		for (item1 h : stuff1) {
			
		h.isvisible = true;}
		
		for (Item i : stuff) {
			
			i.isvisible = true;}
		}
	
	private boolean isBlocked(float tx, float ty) {

		int xBlock = (int) tx / SIZE;

		int yBlock = (int) ty / SIZE;

		return blocked.blocked[xBlock][yBlock];

		// this could make a better kludge

	}

}
