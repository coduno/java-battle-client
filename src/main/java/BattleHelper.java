import exceptions.BehaviourException;
import exceptions.CooldownException;
import exceptions.InfoException;
import model.Direction;
import model.Entity;
import model.GameObject;
import model.PlayerType;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.List;

/**
 * Created by vbalan on 10/22/2015.
 */
public class BattleHelper {
    private final String token;
    private final String serverUrl;
    private ObjectMapper mapper;
    private HttpClient client;

    public BattleHelper(String token, String serverUrl) {
        this.token = token;
        this.serverUrl = serverUrl;
        this.mapper = new ObjectMapper();
        this.client = HttpClientBuilder.create().build();
    }

    public GameObject me() throws Exception {
        HttpResponse response = get("/me");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getEntity().getContent(), GameObject.class);
    }

    public List<Entity> map() throws Exception {
        HttpResponse response = get("/map");

        return mapper.readValue(response.getEntity().getContent(), mapper.getTypeFactory().constructCollectionType(List.class, Entity.class));
    }

    public GameObject join(String nick, PlayerType type) throws Exception {
        HttpResponse response = post("/join", new NickParam(nick, type));
        return mapper.readValue(response.getEntity().getContent(), GameObject.class);
    }

    public GameObject move(Direction direction) throws Exception {
        HttpResponse response = post("/move", new DirectionParam(direction));
        return mapper.readValue(response.getEntity().getContent(), GameObject.class);
    }

    public void attack(Direction direction) throws Exception {
        post("/attack", new DirectionParam(direction));
    }

    public void spell(int spell, Direction direction, String extra) throws Exception {
        post("/spell", new SpellParams(spell, direction, extra));
    }

    private HttpResponse get(String path) throws Exception {
        return go(new HttpGet(serverUrl + path));
    }

    private HttpResponse post(String path, Object body) throws Exception {
        HttpPost request = new HttpPost(serverUrl + path);
        request.setEntity(new StringEntity(mapper.writeValueAsString(body)));
        return go(request);
    }

    private HttpResponse go(HttpRequestBase request) throws Exception {
        request.addHeader("Authorization", "Token " + token);

        HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() != 200) {
            JsonNode obj = mapper.readTree(response.getEntity().getContent());
            switch (obj.get("type").asText()) {
                case "CooldownError":
                    throw new CooldownException(obj.get("battleError").get("message").asText(), (long) (obj.get("BattleError").get("remaining").asLong() / Math.pow(10, 6)));
                case "InfoError":
                    throw new InfoException(obj.get("battleError").get("message").asText());
                case "BehaviourError":
                    throw new CooldownException(obj.get("battleError").get("behaviour").asText(), (long) (obj.get("BattleError").get("remaining").asLong() / Math.pow(10, 6)));
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

    private class NickParam {
        private String nick;
        private PlayerType type;

        private NickParam(String nick, PlayerType type) {
            this.nick = nick;
            this.type = type;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public PlayerType getType() {
            return type;
        }

        public void setType(PlayerType type) {
            this.type = type;
        }
    }
}

