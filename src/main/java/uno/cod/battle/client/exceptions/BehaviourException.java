package uno.cod.battle.client.exceptions;

/**
 * Created by vbalan on 10/26/2015.
 */
public class BehaviourException extends BattleException {
    private final Long remaining;

    public BehaviourException(String message, Long remaining) {
        super(message);
        this.remaining = remaining;
    }

    public Long getRemaining() {
        return remaining;
    }
}
