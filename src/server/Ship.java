package server;

import mayflower.Actor;

public class Ship extends SpaceActor{

    private spaceshipActor pilot;
    private GunnerActor gunner;

    public Ship() {

    }


    public spaceshipActor getPilot() {
        return pilot;
    }

    public void setPilot(SpaceActor pilot) {
        this.pilot = (spaceshipActor) pilot;
    }

    public GunnerActor getGunner() {
        return gunner;
    }

    public void setGunner(SpaceActor gunner) {
        this.gunner = (GunnerActor) gunner;
    }


    @Override
    public void act() {

    }
}
