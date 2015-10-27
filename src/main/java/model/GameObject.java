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
    private Long attackSpeed;
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

    public Long getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(Long attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        if(nick != null){
            stringBuilder.append(String.format("nick %s,", nick));
        }
        if(hp != null){
            stringBuilder.append(String.format("hp %s,", hp));
        }
        if(kills != null){
            stringBuilder.append(String.format("kills %s,", kills));
        }
        if(deaths != null){
            stringBuilder.append(String.format("deaths %s,", deaths));
        }
        if(position != null){
            stringBuilder.append(String.format("position %s,", position));
        }
        if(moveTime != null){
            stringBuilder.append(String.format("moveTime %s,", moveTime));
        }
        if(moveTime != null){
            stringBuilder.append(String.format("moveTime %s,", moveTime));
        }
        if(moveSpeed != null){
            stringBuilder.append(String.format("moveSpeed %s,", moveSpeed));
        }
        if(attackTime != null){
            stringBuilder.append(String.format("attackTime %s,", attackTime));
        }
        if(attackSpeed != null){
            stringBuilder.append(String.format("attackSpeed %s,", attackSpeed));
        }
        if(spells != null){
            stringBuilder.append(String.format("spells %s,", spells));
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
