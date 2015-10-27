package model;

import java.util.List;

/**
 * Created by vbalan on 10/27/2015.
 */
public class Map {
    private List<Entity> gameObjects;
    private Integer left, right, up, down;

    public List<Entity> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<Entity> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    @Override
    public String toString() {
        return String.format("(gameObjects %s, left %s, right %s, up %s, down %s)", gameObjects, left, right ,up, down);
    }
}
