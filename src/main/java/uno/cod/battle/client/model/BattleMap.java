package uno.cod.battle.client.model;

import java.util.List;

/**
 * Created by vbalan on 10/27/2015.
 */
public class BattleMap {
    private List<GameObject> gameObjects;
    private PositionInfo players, healthFountains;

    /**
     *
     * @return the game objects that are in range 10 to you.
     */
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
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
