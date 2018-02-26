package client;

import mayflower.Mayflower;
import mayflower.net.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputManager
{
    private GameMode mode;
    private Map<Integer, String> keyMap;
    private Client client;
    private Integer lastKey=-1;

    public InputManager()
    {
        keyMap = new HashMap<Integer, String>();
        this.client = client;
    }

    public InputManager(GameMode mode)
    {
        this();
        setGameMode(mode);
    }

    public void setGameMode(GameMode mode)
    {
        this.mode = mode;
    }

    public void setKeyMap(Map<Integer, String> map)
    {
        this.keyMap = map;
    }

    public void scan()
    {
        if(null == mode)
            return;

        //read input from user
        //convert key-->action
        //pass action to game mode
        Set<Integer> keys = keyMap.keySet();
        for(Integer key : keys)
        {
            if(Mayflower.isKeyDown(key))
            {
                System.out.println("Key Pressed: " + key);
                lastKey =key;
                mode.processPress(keyMap.get(key));
                //System.out.println("lastKey = " + lastKey);
                
            }
            else if(!Mayflower.isKeyDown(lastKey))
            {

                //System.out.println("Key Released: " + lastKey);
                mode.processRelease(keyMap.get(lastKey));

            }
            //System.out.println("Mayflower.isKeyDown(lastKey) = " + Mayflower.isKeyDown(lastKey));
        }
    }

}
