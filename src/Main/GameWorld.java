package Main;

import Systems.ComponentSystem;
import Systems.MySystem;
import Systems.RenderSystem;

import java.util.Timer;
import java.util.TimerTask;

/*
游戏世界类，游戏循环，起始均从这里开始
 */
public class GameWorld extends TimerTask {

    private Timer timer = new Timer();

    private int deltaTime = 10;//每帧10ms

    private Scene currentScene = null;

    private long timeMillis;

    public GameWorld(Scene scene) {
        MySystem.gameWorld = this;
        MySystem.deltaTime = deltaTime / 1000.0f;
        timeMillis = System.currentTimeMillis();

        LoadScene(scene);
        //开始游戏循环
        this.timer.schedule(this, 0, deltaTime);
    }

    /**
     * @param toLoad
     */
    public void LoadScene(Scene toLoad) {
        if (currentScene != null) {
            currentScene.OnDestroy();
        }
        currentScene = toLoad;
        currentScene.LoadScene();
        //ComponentSystem.Start();
    }

    /**
     * 延迟阻塞s秒
     *
     * @param s
     */
    public static void delaySeconds(float s) {
        long o = System.currentTimeMillis();
        long delta = (long) s * 1000;
        while (System.currentTimeMillis() - o <= delta) {

        }
    }

    /**
     * 游戏循环，每deltaTime毫秒调用
     */
    private void GameLoop() {
        long tempTimeMillis = System.currentTimeMillis();
        MySystem.deltaTime = (tempTimeMillis - timeMillis) / 1000.0f;
        timeMillis = tempTimeMillis;
        RenderSystem.Function();
        ComponentSystem.Function();
    }

    @Override
    public void run() {
        GameLoop();
    }

    public Scene getCurrentScene() {
        return currentScene;
    }
}
