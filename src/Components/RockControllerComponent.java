package Components;

import Systems.InputSystem;

public class RockControllerComponent extends InputSystem {

    private float speedX;
    private float speedY;

    public RockControllerComponent(float speedX, float speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    protected void function() {
        gameObject.x-=speedX;

    }

    @Override
    protected void start() {
        gameObject.x=800;
    }
}
