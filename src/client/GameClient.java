package client;

import mayflower.Actor;
import mayflower.net.Client;
import server.ActorID;
import server.GunnerActor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GameClient extends Client implements GameMode, ActorID
{
    private GameWorld world;
    private String tempProcess = "";

    public GameClient()
    {
        this("localhost");
    }

    public GameClient(String ip)
    {
        System.out.println("Connecting");
        this.connect(ip, 1234);
        System.out.println("Connected");
    }

    public void setWorld(GameWorld world)
    {
        this.world = world;
    }

    @Override
    public void process(String s)
    {
        //if(s.equals(tempProcess)) return;
        //System.out.println("Message From Server: " + s);

        List<Actor> actors = new LinkedList<Actor>();
        ArrayList<String> parts =new ArrayList<>(Arrays.asList(s.split(":")));

        for (String part: parts) {
            if (!"".equals(part) ) {
                ArrayList<String> parts2 = new ArrayList<>(Arrays.asList(part.split(",")));
                //if(parts2[0].equals("spaceship")) {
                String img = "img/" + parts2.get(0) + ".png";
                int x = Integer.parseInt(parts2.get(1));
                int y = Integer.parseInt(parts2.get(2));
                int r = Integer.parseInt(parts2.get(3));
                double v = Double.parseDouble(parts2.get(4));
                int ID=0;
                if(parts2.size()>5)
                    ID = Integer.parseInt(parts2.get(5));

                //System.out.println(parts2.get(0));

                switch (parts2.get(0)) {
                    case "spaceship":
                        actors.add(new spaceshipActor(x, y, r, (int) v));
                        break;
                    case "asteroid":
                        actors.add(new Asteroid(x,y,r,(int) v));
                        break;
                    case "gunner":
                        actors.add(new GunnerActor(x,y,r, v,(server.spaceshipActor)ActorID.actors.get(ID)));
                        break;
                }
            }

        }
        if(null != world) {
            world.update(actors);
        }
        tempProcess = s;

    }

    @Override
    public void onDisconnect(String s) {
        System.out.println("Disconnected from server");
    }

    @Override
    public void onConnect() {
        System.out.println("Connected to server!");
    }

    @Override
    public void processPress(String action) {
        System.out.println("Sending Press: " + action+"Pressed");
        send(action+"Pressed");
    }

    @Override
    public void processRelease(String action) {
        //System.out.println("Sending Release: " + action+"Released");
        send(action+"Released");

    }
}
