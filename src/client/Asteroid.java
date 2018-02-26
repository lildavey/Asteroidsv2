package client;

import mayflower.Keyboard;
import mayflower.Mayflower;

public class Asteroid extends SpaceActor
{
    private double velocity;
    public Asteroid(int x, int y, int r, double velocity)
    {
        super("img/largeAsteroid.png", x, y, r);
        this.velocity = velocity;

    }

    public String toString()
    {
        return "asteroid,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
    }
}
