package Components;

import Main.*;
import Systems.InputSystem;

public class ControllerComponent extends InputSystem {

    private float speed = 0;

    public ControllerComponent() {
        this.speed = 1;
    }

    public ControllerComponent(float speed) {
        this.speed = speed;
    }

    @Override
    protected void start() {

    }

    @Override
    protected void function() {
        float x = 0,y = 0;
        if(Input.GetKey(KeyCode.Left) && gameObject.x >= -25) {
            x-=1;
        }
        if(Input.GetKey(KeyCode.Right) && gameObject.x <= 650) {
            x+=1;
        }
        if(Input.GetKey(KeyCode.Up) && gameObject.y >= -40) {
            y-=1;
        }
        if(Input.GetKey(KeyCode.Down) && gameObject.y <= 450) {
            y+=1;
        }

        gameObject.x += x * this.speed;
        gameObject.y += y * this.speed;
    }
}
