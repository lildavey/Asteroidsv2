package server;



public class Asteroid extends SpaceActor
{
    private double velocity;
    private int x,y,r;

    public Asteroid(int x, int y, int r, double velocity)
    {
        super("img/largeAsteroid.png", x, y, r);
        this.x = x; this.y = y; this.r = r;
        this.velocity = velocity;


    }
    public void tick()
    {
        super.tick();

        this.move(velocity);
        setRotation(r);

    }

    public String toString()
    {
        return "asteroid,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
    }
}
