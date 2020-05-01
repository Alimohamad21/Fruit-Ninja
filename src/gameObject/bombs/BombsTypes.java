package gameObject.bombs;

import java.util.Random;

public enum BombsTypes {
 Fatal,
 Dangerous;
 public BombsTypes bombsTypes;
 public String randomBombsTypes() {
     Random random = new Random();
     return String.valueOf(BombsTypes.values()[random.nextInt(BombsTypes.values().length)]);
 }
}
