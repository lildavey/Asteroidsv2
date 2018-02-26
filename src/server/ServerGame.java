package server;

import client.Asteroid;
import client.GunnerActor;
import mayflower.*;
import mayflower.net.Server;

import java.util.HashMap;
import java.util.Map;

public class ServerGame extends Mayflower implements ActorID
{


    private ServerWorld world;

    public ServerGame(Server server)
    {
        super("Server", 1024, 768);



        world = new ServerWorld(server);
        this.setWorld(world);
    }

    public void process(int i, String s)
    {
        //System.out.println("actors.get(2) = " + i);

        SpaceActor actor = actors.get(i);

        if(actor != null )
        {
            /*if(actor instanceof spaceshipActor) {*/

                if (s.equals("upPressed")) {
                    actor.setAcceleration(2);
                    actor.setDeceleration(0);
                } else if (!s.equals("upPressed")) {
                    actor.setAcceleration(0);
                    actor.setDeceleration(.05);
                }

                if (s.equals("leftPressed")) actor.turn(-5);
                if (s.equals("rightPressed")) actor.turn(5);
           // }


        }


    }

    public void join(int i)
    {



        if(i%3 == 1) {
            int x = (int) (Math.random() * 700) + 50;
            int y = (int) (Math.random() * 500) + 50;
            Ship ship = new server.Ship();
            ships.put(i,ship);

            SpaceActor pilot = new spaceshipActor(x, y, 0, 0, i);
            world.addObject(pilot, x, y);

            actors.put(i, pilot);
            ships.get(i).setPilot(pilot);
        }
        if(i%3 == 2) {
            SpaceActor gunnerActor = new server.GunnerActor(actors.get(i-1).getX(), actors.get(i-1).getY(), 0, 0, (spaceshipActor) actors.get(i-1));
            world.addObject(gunnerActor, actors.get(i-1).getX(), actors.get(i-1).getY());

            actors.put(i, gunnerActor);
            ships.get(i-1).setGunner(gunnerActor);
        }

        /*SpaceActor asteroidTest = new server.Asteroid(x,y,0,0);
        world.addObject(asteroidTest,x,y);*/
        //actors.put(i, asteroidTest);

    }

    public void leave(int i)
    {
        Actor actor = actors.get(i);
        if(null != actor)
        {
            world.removeObject(actor);
        }
    }

    @Override
    public void init()
    {
    }
}
