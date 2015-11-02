# java-battle-client

### Commands
###### join
After you registered and received a token you can join the battle. To join you must pass a [player type](https://github.com/coduno/java-battle-client/blob/master/src/main/java/model/PlayerType.java)

```java
  BattleHelper helper = new BattleHelper(TOKEN, SERVER_URL);
  GameObject me = helper.join(PlayerType.GOPHER);
```
###### move
For the move action you must pass a [direction](https://github.com/coduno/java-battle-client/blob/master/src/main/java/model/Direction.java)

```java
  GameObject me = helper.move(Direction.LEFT);
```
###### attack
For the attack action you must pass a [direction](https://github.com/coduno/java-battle-client/blob/master/src/main/java/model/Direction.java)

```java
 helper.attack(Direction.LEFT);
```
###### spell
To use a spell you must pass the spell index, the  [direction](https://github.com/coduno/java-battle-client/blob/master/src/main/java/model/Direction.java), and an extra string(needed just for a few spells).

```java
  helper.spell(1, Direction.LEFT, "");
```

###### me
You can request the your stats at any time.
```java
  GameObject me = helper.me();
```

###### map
You can request the map at any time.
```java
  Map map = helper.map();
```
### Exception info
You can receive multiple types of exceptions.
* Cooldown exception - received when the command you are trying to do is on cooldown. You can also access the remaining time.
* Behaviour exception - received when the command you are trying to do is blocked by a certain event(stun, freeze, disarm, silence, etc). You can also access the remaining time.
* Info exception - it is a simple exception
