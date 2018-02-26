package client;

import mayflower.Keyboard;
import mayflower.Mayflower;

import java.util.HashMap;
import java.util.Map;

public class ClientRunner extends Mayflower
{
    public ClientRunner()
    {
        super("Client", 1024, 768);
    }
    @Override
    public void init()
    {
        String ip = Mayflower.ask("Connect to what IP address?");
        if("".equals(ip))
            ip = "localhost";

        GameClient client = new GameClient(ip);
        InputManager im = new InputManager(client);

        Map<Integer, String> keys = new HashMap<Integer, String>();
        keys.put(Keyboard.KEY_UP, "up");
        keys.put(Keyboard.KEY_LEFT, "left");
        keys.put(Keyboard.KEY_DOWN, "down");
        keys.put(Keyboard.KEY_RIGHT, "right");
        keys.put(Keyboard.KEY_SPACE, "shoot");

        keys.put(Keyboard.KEY_A, "gunLeft");
        keys.put(Keyboard.KEY_D, "gunRight");

        im.setKeyMap(keys);

        GameWorld world = new GameWorld(im);
        client.setWorld(world);
        Mayflower.setWorld(world);

    }

    public static void main(String[] args)
    {
        new ClientRunner();
    }
}
