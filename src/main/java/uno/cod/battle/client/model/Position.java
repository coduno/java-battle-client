package uno.cod.battle.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by vbalan on 10/22/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {
    private Integer x;
    private Integer y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(x %s, y %s)", x, y);
    }
}
