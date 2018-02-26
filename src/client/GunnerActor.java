package client;

public class GunnerActor extends SpaceActor {
    private server.spaceshipActor ship;

    public GunnerActor(int x, int y, int r, double v, server.spaceshipActor ship) {
        super("img/laserCannon.png", x, y, r);
        this.ship = ship;

    }
}
