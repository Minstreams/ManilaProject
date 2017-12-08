package Components;

import Systems.ComponentSystem;

public class RockControllerComponent extends ComponentSystem {

    private int speedX;
    private int speedY;

    public RockControllerComponent(int speedX, int speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    protected void function() {
        gameObject.x -= speedX * deltaTime;
        gameObject.y += speedY * deltaTime;
        if (gameObject.x < -50) {
            Destroy(gameObject);
        }

    }

    @Override
    public void start() {


    }
}
