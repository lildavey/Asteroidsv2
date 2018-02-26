package client;

import mayflower.Actor;

public class SpaceActor extends Actor
{
    private double velocity;
    public SpaceActor(String img, int x, int y, int r)
    {
        setImage(img);
        setLocation(x, y);
        setRotation(r);
    }
    public SpaceActor(String img, int x, int y, int r,double velocity)
    {
        setImage(img);
        setLocation(x, y);
        setRotation(r);
        this.velocity = velocity;
    }

    public SpaceActor(String img, int x1, int y1, int r1, int x2, int y2, int r2, double p)
    {
        //interpolate between two points
        double q = 1 - p;
        int x = (int)(x1 * p + x2 * q);
        int y = (int)(y1 * p + y2 * q);
        int r = (int)(r1 * p + r2 * q);

        setImage(img);
        setLocation(x, y);
        setRotation(r);
    }

    public double getVelocity() {
        return velocity;
    }

    public String toString()
    {
        return getImage().toString() + "_" + getX() + "_" + getY() + "_" + getRotation();
    }

    @Override
    public void act() {
        //any obejcts that extend this must call super.act() in their act method()


    }

    public void warp()
    {
        int x = this.getX();
        int y = this.getY();

        if( x < -(this.getImage().getHeight()) )
        {
            this.setLocation(1024, y );

        }
        if( x > 1024 )
        {
            this.setLocation( 0, y );

        }
        if( y < -(this.getImage().getHeight()) )
        {
            this.setLocation( x, 768 );

        }
        if( y > 768 )
        {
            this.setLocation( x, 0);

        }
    }

    public void tick(){
        warp();
    }
}
