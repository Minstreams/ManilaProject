package Components;

import Main.GameObject;
import Main.Input;
import Main.KeyCode;
import Systems.ComponentSystem;

import java.util.ArrayList;

public class FireComponent extends ComponentSystem {

    private GameObject rocks = null;
    private float fireColdTime = 1;
    private float timer = 0;
    private float shellSpeed = 8;

    private AudioClipComponent audio1;
    private AudioClipComponent audio2;

    public FireComponent(GameObject rocks) {
        this.rocks = rocks;
    }

    @Override
    public void start() {
        audio1 = new AudioClipComponent("Launch.wav", false);
        gameObject.AddComponent(audio1);
        audio2 = new AudioClipComponent("HitRock.wav", false);
        gameObject.AddComponent(audio2);
    }

    @Override
    protected void function() {
        if (timer < 3) {
            timer += deltaTime;
        }

        //生成子弹
        if (Input.GetKey(KeyCode.Z) && timer > fireColdTime) {
            GameObject g = gameObject.AddChild(new GameObject("shell", gameObject.x + 150, gameObject.y + 92, 2));
            g.AddComponent(new RenderComponent("shell.png"));
            audio1.Play();
            timer = 0;
        }

        //控制子弹行为
        for (int i = 0; i < gameObject.children.size(); i++) {
            GameObject s = gameObject.children.get(i);
            if (s == null) {
                continue;
            }
            MoveShell(s);
            ScanRocks(s);
        }
    }

    private void MoveShell(GameObject shell) {
        shell.x += shellSpeed;
        if (shell.x > 800) {
            Destroy(shell);
        }
    }

    private void ScanRocks(GameObject shell) {
        for (GameObject r : rocks.children) {
            if (r == null) {
                continue;
            }

            float deltaX = r.x - shell.x + 20;
            float deltaY = r.y - shell.y + 23;
            //如果撞到
            if (deltaX <= 30 && deltaX >= -30 && deltaY <= 27 && deltaY >= -27) {
                Destroy(r);
                gameObject.GetComponent(PointCountComponent.class).AddPoint(50);
                audio2.Play();
                Destroy(shell);
                return;
            }
        }
    }
}
