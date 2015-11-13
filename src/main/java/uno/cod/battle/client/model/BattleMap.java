package uno.cod.battle.client.model;

import java.util.List;

/**
 * Created by vbalan on 10/27/2015.
 */
public class BattleMap {
    private PositionInfo playersInfo, healthFountainsInfo;
    private List<Player> players;
    private List<HealthFountain> healthFountains;
    private List<Obstacle> obstacles;

    /**
     *
     * @return the game objects that are in range 10 to you.
     */
    public PositionInfo getPlayersInfo() {
        return playersInfo;
    }

    public void setPlayersInfo(PositionInfo playersInfo) {
        this.playersInfo = playersInfo;
    }

    public PositionInfo getHealthFountainsInfo() {
        return healthFountainsInfo;
    }

    public void setHealthFountainsInfo(PositionInfo healthFountainsInfo) {
        this.healthFountainsInfo = healthFountainsInfo;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<HealthFountain> getHealthFountains() {
        return healthFountains;
    }

    public void setHealthFountains(List<HealthFountain> healthFountains) {
        this.healthFountains = healthFountains;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }
}
