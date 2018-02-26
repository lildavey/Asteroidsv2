package client;

import mayflower.Actor;
import mayflower.World;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameWorld extends World
{
    private InputManager im;
    private Queue<List<Actor>> updates;

    public GameWorld(InputManager im)
    {
        this.im = im;
        setBackground("img/background.png");
        updates = new LinkedList<List<Actor>>();
    }

    public void update(List<Actor> actors)
    {
        updates.add(actors);

    }
    private void redraw()
    {
        if(updates.isEmpty())
            return;
        List<Actor> actors = updates.remove();
        //remove all SpaceActor objects
        this.removeObjects(this.getObjects(Actor.class));

        //add new objects
        for(Actor actor : actors)
        {
            this.addObject(actor, actor.getX(), actor.getY());
        }


    }


    @Override
    public void act()
    {
        im.scan();
        redraw();
    }
}
