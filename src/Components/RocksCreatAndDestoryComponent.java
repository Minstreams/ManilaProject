package Components;

import Main.GameObject;
import Systems.ComponentSystem;

import java.util.Collections;
import java.util.Random;

public class RocksCreatAndDestoryComponent extends ComponentSystem {

    private float rockCreateTime;
    private String rockName;
    private float speedX;
    private float speedY;

    private float timeLoop = 0;
    private int randomPositionY;
    private Random random = new Random();

    public RocksCreatAndDestoryComponent(float rockCreateTime, String rockName, float speedX, float speedY) {
        this.rockCreateTime = rockCreateTime;
        this.rockName = rockName;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    protected void function() {
        if (timeLoop >= rockCreateTime) {
            timeLoop = 0;
            randomPositionY = random.nextInt(550);
            CreatOneRock(800, randomPositionY);
        } else {
            timeLoop += deltaTime;
        }
    }

    @Override
    public void start() {

    }

    private void CreatOneRock(int xPosition, int yPosition) {
        System.out.println("x:" + xPosition + ";y:" + yPosition);
        GameObject g = gameObject.AddChild(new GameObject("RockChild", xPosition, yPosition, gameObject.layer));
        g.AddComponent(new RenderComponent(rockName));
        g.AddComponent(new RockControllerComponent(speedX, speedY));
    }
}
