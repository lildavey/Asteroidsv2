package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ActorID {
    Map<Integer, SpaceActor> actors = new HashMap<Integer, SpaceActor>();
    Map<Integer, Ship> ships = new HashMap<Integer, Ship>();
    String currPosition = "";

}
