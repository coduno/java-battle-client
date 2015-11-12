package uno.cod.battle.client;

import uno.cod.battle.client.exceptions.BehaviourCode;
import uno.cod.battle.client.exceptions.BehaviourException;
import uno.cod.battle.client.exceptions.CooldownException;
import uno.cod.battle.client.exceptions.InfoException;
import uno.cod.battle.client.model.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by vbalan on 10/22/2015.
 */
public class BattleHelper {
    private final String token;
    private final String serverUrl;
    private ObjectMapper mapper;
    private CloseableHttpClient client;

    public BattleHelper(String token) {
        this(token, "battle.cod.uno");
    }

    public BattleHelper(String token, String serverUrl) {
        this.token = token;
        this.serverUrl = serverUrl;
        this.mapper = new ObjectMapper();
        this.client = HttpClientBuilder.create().build();
    }

    /**
     * Get the state of your player.
     *
     * @return the state of your player
     * @throws Exception
     */
    public GameObject me() throws Exception {
        CloseableHttpResponse response = get("/me");
        GameObject gameObject = mapper.readValue(response.getEntity().getContent(), GameObject.class);
        EntityUtils.consume(response.getEntity());
        response.close();
        return gameObject;
    }

    /**
     * Get the current state of the map.
     *
     * @return the current state of the map.
     * @throws Exception
     */
    public BattleMap map() throws Exception {
        CloseableHttpResponse response = get("/map");
        BattleMap battleMap = mapper.readValue(response.getEntity().getContent(), BattleMap.class);
        EntityUtils.consume(response.getEntity());
        response.close();
        return battleMap;
    }

    /**
     * Join the battle.
     *
     * @param type the desired player type
     * @return your current state
     * @throws Exception
     */
    public GameObject join(PlayerType type) throws Exception {
        CloseableHttpResponse response = post("/join", new JoinParam(type));
        GameObject gameObject = mapper.readValue(response.getEntity().getContent(), GameObject.class);
        EntityUtils.consume(response.getEntity());
        response.close();
        return gameObject;
    }

    /**
     * Issue an attack command in a specific direction
     *
     * @param direction the direction where you want to move
     * @return your current state
     * @throws Exception
     */
    public GameObject move(Direction direction) throws Exception {
        CloseableHttpResponse response = post("/move", new DirectionParam(direction));
        GameObject gameObject = mapper.readValue(response.getEntity().getContent(), GameObject.class);
        EntityUtils.consume(response.getEntity());
        response.close();
        return gameObject;
    }

    /**
     * Issue an attack command in a specific direction
     *
     * @param direction the direction where you want to attack
     * @throws Exception
     */
    public void attack(Direction direction) throws Exception {
        CloseableHttpResponse response = post("/attack", new DirectionParam(direction));
        EntityUtils.consume(response.getEntity());
        response.close();
    }

    /**
     * Cast a spell.
     *
     * @param spell the spell index of the spell you want to use [0-4]
     * @param direction the direction where you want to use the spell
     * @param extra for sudo spell extra represents a move command uppercased(eg "MOVE LEFT")
     *              for chmod extra can be freeze/disarm/silence
     * @throws Exception
     */
    public void spell(int spell, Direction direction, String extra) throws Exception {
        CloseableHttpResponse response = post("/spell", new SpellParams(spell, direction, extra));
        EntityUtils.consume(response.getEntity());
        response.close();
    }

    private CloseableHttpResponse get(String path) throws Exception {
        return go(new HttpGet(serverUrl + path));
    }

    private CloseableHttpResponse post(String path, Object body) throws Exception {
        HttpPost request = new HttpPost(serverUrl + path);
        request.setEntity(new StringEntity(mapper.writeValueAsString(body)));
        return go(request);
    }

    private CloseableHttpResponse go(HttpRequestBase request) throws Exception {
        request.addHeader("Authorization", "Token " + token);

        CloseableHttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() != 200) {
            JsonNode obj = mapper.readTree(response.getEntity().getContent());
            EntityUtils.consume(response.getEntity());
            response.close();
            switch (obj.get("type").asText()) {
                case "CooldownError":
                    throw new CooldownException(obj.get("battleError").get("message").asText(), (long) (obj.get("battleError").get("remaining").asLong() / Math.pow(10, 6)));
                case "InfoError":
                    throw new InfoException(obj.get("battleError").get("message").asText());
                case "BehaviourError":
                    throw new BehaviourException(obj.get("battleError").get("behaviour").asText(),
                            (long) (obj.get("battleError").get("remaining").asLong() / Math.pow(10, 6)),
                            BehaviourCode.valueOf(obj.get("battleError").get("code").asText()));
                default:
                    // TODO encapsulate the received message
                    throw new InfoException("default exception");
            }
        }

        return response;
    }

    private class DirectionParam {
        private Direction direction;

        public DirectionParam(Direction direction) {
            this.direction = direction;
        }

        public Direction getDirection() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }
    }

    private class SpellParams {
        private Integer spell;
        private Direction direction;
        private String extra;

        private SpellParams(Integer spell, Direction direction, String extra) {
            this.spell = spell;
            this.direction = direction;
            this.extra = extra;
        }

        public Integer getSpell() {
            return spell;
        }

        public void setSpell(Integer spell) {
            this.spell = spell;
        }

        public Direction getDirection() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public String getExtra() {
            return extra;
        }

        public void setExtra(String extra) {
            this.extra = extra;
        }
    }

    private class JoinParam {
        private PlayerType type;

        private JoinParam(PlayerType type) {
            this.type = type;
        }

        public PlayerType getType() {
            return type;
        }

        public void setType(PlayerType type) {
            this.type = type;
        }
    }
}

