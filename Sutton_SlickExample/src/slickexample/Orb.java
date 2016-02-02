/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickexample;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author dustor7689
 */
public class Orb {
    private  int X, y, width, height;
    private int dmg, hitboxX, hitboxY;
    private boolean isVisiable;
    public Image orbpic;
    private Shape hitbox;
    private final boolean isVisible;

    public Orb(int a,int b) throws SlickExcpetion, SlickException{
        this.X = a;
        this.y = b;
        this.isVisible = false;
        this.orbpic = new Image ("res/orbs/Ninja_12.png");
        this.hitbox = new Rectangle (a, b, 32, 32);
        
    }

    public Image getOrbpic() {
        return orbpic;
    }

    public Shape getHitbox() {
        return hitbox;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDmg() {
        return dmg;
    }

    public int getHitboxX() {
        return hitboxX;
    }

    public int getHitboxY() {
        return hitboxY;
    }

    public boolean isIsVisiable() {
        return isVisiable;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    private static class SlickExcpetion extends Exception {

        public SlickExcpetion() {
        }
    }
    /**
     * Getters and setters are common concept in Java. 
     * A design guideline in Java, and object oriented programming in general,
     * is to encapsulate/isolate values as much as possible.
     * Getters - are methods used to query the values of instance variables.
     * this.getlocationX();
     * Setters - methods that set values for instance variables. 
     * orb1.setLocation(Player.x, Player.y);
     */

}
