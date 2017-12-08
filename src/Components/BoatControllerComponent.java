package Components;

import Main.*;
import Systems.ComponentSystem;

/**
 * 控制类组件
 */
public class BoatControllerComponent extends ComponentSystem {

    private float speed = 0;
    private float vx = 0;
    private float vy = 0;

    private boolean highSpeed = false;

    private float timer = 0;

    private AudioClipComponent audio1;

    public BoatControllerComponent() {
        this.speed = 100;
    }

    public BoatControllerComponent(float speed) {
        this.speed = speed;
    }

    @Override
    public void start() {
        audio1 = new AudioClipComponent("Floating.wav", false);
        gameObject.AddComponent(audio1);
    }

    @Override
    protected void function() {
        int x = 0, y = 0;
        if (Input.GetKey(KeyCode.Left) && gameObject.x >= 124) {
            x -= 1;
        }
        if (Input.GetKey(KeyCode.Right) && gameObject.x <= 800) {
            x += 1;
        }
        if (Input.GetKey(KeyCode.Up) && gameObject.y >= -50) {
            y -= 1;
        }
        if (Input.GetKey(KeyCode.Down) && gameObject.y <= 450) {
            y += 1;
        }
        vx += (x - vx) * 0.1f;
        vy += (y - vy) * 0.1f;
        float v = vx * vx + vy * vy;
        if (highSpeed) {
            timer += deltaTime;
            if (timer > 4) {
                AchievementComponent.ShowAchivement("乘风破浪！", "连续高速运行4秒以上");
                timer = 0;
            }
            if (v < 0.5f) {
                highSpeed = false;
                audio1.Stop();
                timer = 0;
            }
        } else if (v > 0.95) {
            highSpeed = true;
            audio1.Play();
        }
        gameObject.x += vx * this.speed * deltaTime;
        gameObject.y += vy * this.speed * deltaTime;
    }
}
