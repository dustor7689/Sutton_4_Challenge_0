/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreedPack;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author dustor7689
 */
public class Ninja {

    static void add(Ninja Matthew) {
    }
    
    

	public int x;
	public int y;
	public boolean isvisible = true;
	Image currentImage;
	Shape hitbox;
	Image ninjaImage = new Image("res/d22_ninja.png");

	Ninja(int a, int b) throws SlickException {
		this.x = a;
		this.y = b;
		this.hitbox = new Rectangle(this.x, this.y, 32, 32);// 64 is the width of the item
		this.currentImage = ninjaImage;

	}
}
