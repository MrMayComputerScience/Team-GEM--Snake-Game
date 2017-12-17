import mayflower.Actor;

import java.util.List;

public interface Mover
{
 public boolean checkDead();
 public void dead();
 public boolean ready();
 public void removeBody();
 public void setCanMove(boolean canMove);
 public List<Mover> isTouchingSA();
}