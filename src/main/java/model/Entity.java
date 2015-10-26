package model;

import org.codehaus.jackson.annotate.JsonCreator;

/**
 * Created by vbalan on 10/22/2015.
 */
public class Entity {
    private GameObject gameObject;
    private String type;

    public GameObject getGameObject() {
        return gameObject;
    }

    @JsonCreator
    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("(gameObject %s, type %s", gameObject.toString(), type);
    }
}
