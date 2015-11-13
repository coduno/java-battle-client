package uno.cod.battle.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by vbalan on 11/13/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthFountain {
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
