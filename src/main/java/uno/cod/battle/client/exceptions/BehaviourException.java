package uno.cod.battle.client.exceptions;

/**
 * Created by vbalan on 10/26/2015.
 */
public class BehaviourException extends BattleException {
    private final Long remaining;
    private final BehaviourCode code;

    public BehaviourException(String message, Long remaining, BehaviourCode code) {
        super(message);
        this.remaining = remaining;
        this.code = code;
    }

    public Long getRemaining() {
        return remaining;
    }

    public BehaviourCode getCode() {
        return code;
    }
}
