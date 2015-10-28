package model;

import java.util.List;

/**
 * Created by vbalan on 10/27/2015.
 */
public class Map {
    private List<Entity> gameObjects;
    private PositionInfo players, healthFountains;

    public List<Entity> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<Entity> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public PositionInfo getPlayers() {
        return players;
    }

    public void setPlayers(PositionInfo players) {
        this.players = players;
    }

    public PositionInfo getHealthFountains() {
        return healthFountains;
    }

    public void setHealthFountains(PositionInfo healthFountains) {
        this.healthFountains = healthFountains;
    }

    @Override
    public String toString() {
        return String.format("(gameObjects %s)", gameObjects);
    }
}
