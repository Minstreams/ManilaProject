package Components;

import Systems.ComponentSystem;

public class MovingComponent extends ComponentSystem {

    private int speedX;
    private int speedY;

    public MovingComponent(int speedX, int speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    protected void function() {
        gameObject.x -= speedX * deltaTime;
        gameObject.y += speedY * deltaTime;
        if (gameObject.x < 100) {
            Destroy(gameObject);
        }

    }

    @Override
    public void start() {


    }
}
