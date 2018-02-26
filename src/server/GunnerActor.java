package server;

public class GunnerActor extends SpaceActor implements ActorID {
    private spaceshipActor ship;
    public GunnerActor(int x, int y, int r, double v, spaceshipActor ship) {
        super("img/laserCannon.png", x, y, r);
        this.ship = ship;

    }

    @Override
    public void tick() {
        super.tick();
        setLocation(ship.getX(),ship.getY());
    }

    public String toString() {
        return "gunner,"+getX()+","+getY()+","+getRotation()+","+getVelocity();
    }
}
