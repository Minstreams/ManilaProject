package Components;

import Main.GameObject;
import Systems.ComponentSystem;

import java.util.Random;

/**
 * 在该组件里面给物体产生子物体 即炸弹
 */
public class RocksCreatAndDestoryComponent extends ComponentSystem {

    private float rockCreateTime;
    private String rockName1;
    private String rockName2;
    private String rockName3;
    private int speedX;
    private int speedY;

    private float timeLoop = 0;
    private int randomPositionY;
    private Random random = new Random();

    public RocksCreatAndDestoryComponent(float rockCreateTime, String rockName1, String rockName2, String rockName3, int speedX, int speedY) {
        this.rockCreateTime = rockCreateTime;
        this.rockName1 = rockName1;
        this.rockName2 = rockName2;
        this.rockName3 = rockName3;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    protected void function() {
        if (timeLoop >= rockCreateTime) {
            timeLoop = 0;
            randomPositionY = random.nextInt(550);
            CreatOneRock(959, randomPositionY);
        } else {
            timeLoop += deltaTime;
        }
    }

    @Override
    public void start() {

    }

    private void CreatOneRock(int xPosition, int yPosition) {
        String rockName;
        switch (random.nextInt(3)) {
            case 0:
                rockName = rockName1;
                break;
            case 1:
                rockName = rockName2;
                break;
            default:
                rockName = rockName3;
                break;
        }
        GameObject g = gameObject.AddChild(new GameObject("RockChild", xPosition, yPosition, gameObject.layer));
        g.AddComponent(new RenderComponent(rockName));
        g.AddComponent(new MovingComponent(speedX, speedY > 0 ? random.nextInt(speedY * 2) - speedY : 0));
    }
}
