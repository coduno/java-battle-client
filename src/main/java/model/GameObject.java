package model;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by vbalan on 10/22/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameObject {
    private String nick;
    private Integer hp;
    private Integer kills;
    private Integer deaths;
    private Position position;
    private DateTime moveTime;
    private Long moveSpeed;
    private DateTime attackTime;
    private List<Spell> spells;
    private Integer level;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public DateTime getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(DateTime moveTime) {
        this.moveTime = moveTime;
    }

    public Long getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(Long moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public DateTime getAttackTime() {
        return attackTime;
    }

    public void setAttackTime(DateTime attackTime) {
        this.attackTime = attackTime;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("(nick %s, hp %s, kills %s, deaths %s, position %s, moveTime %s, moveSpeed %s, attackTime %s, spells %s)",
                nick, hp, kills, deaths, position, moveTime, moveSpeed, attackTime, spells);
    }
}
