package uno.cod.battle.client.exceptions;

/**
 * Created by vbalan on 10/23/2015.
 */
public class CooldownException extends BattleException {
    private final Long cooldown;

    public CooldownException(String message, Long cooldown) {
        super(message);
        this.cooldown = cooldown;
    }

    /**
     *
     * @return the remaining cooldown in milliseconds
     */
    public Long getCooldown() {
        return cooldown;
    }
}
