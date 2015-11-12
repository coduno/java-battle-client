package uno.cod.battle.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.joda.time.DateTime;

/**
 * Created by vbalan on 10/22/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Spell {
    private String name;
    private Long cooldown;
    private DateTime useTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCooldown() {
        return cooldown;
    }

    public void setCooldown(Long cooldown) {
        this.cooldown = cooldown;
    }

    public DateTime getUseTime() {
        return useTime;
    }

    public void setUseTime(DateTime useTime) {
        this.useTime = useTime;
    }

    @Override
    public String toString() {
        return String.format("(name %s, cooldown %s, useTime %s)", name, cooldown, useTime);
    }
}
