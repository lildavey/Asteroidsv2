package server;


import mayflower.Keyboard;
import mayflower.net.Server;

import java.util.HashMap;
import java.util.Map;

public class MultiplayerServer extends Server
{
    private ServerGame lobby;

    public MultiplayerServer()
    {
        super(1234);

        lobby = new ServerGame(this);

        System.out.println("Server started.");



        //server.InputManager im = new InputManager();

        Map<Integer, String> keys = new HashMap<Integer, String>();
        keys.put(Keyboard.KEY_UP, "up");
        keys.put(Keyboard.KEY_LEFT, "left");
        keys.put(Keyboard.KEY_DOWN, "down");
        keys.put(Keyboard.KEY_RIGHT, "right");
        keys.put(Keyboard.KEY_SPACE, "shoot");
        //im.setKeyMap(keys);
    }

    @Override
    public void process(int i, String s)
    {
        lobby.process(i, s);
    }

    @Override
    public void onJoin(int i)
    {
        System.out.println("Joined: " + i);
        lobby.join(i);

    }

    @Override
    public void onExit(int i) {
        lobby.leave(i);

        System.out.println("Left: " + i);

    }
}
