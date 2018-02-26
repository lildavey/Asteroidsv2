package server;

import mayflower.Actor;

public class BoxActor extends Actor
{
    public BoxActor()
    {
        setImage("rsrc/box.png");
    }

    @Override
    public void act() {

    }

    public String toString()
    {
        return "box,"+getX()+","+getY()+","+getRotation();
    }
}
