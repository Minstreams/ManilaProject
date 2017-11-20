package Main;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene {
    List<GameObject> gameObjects = new ArrayList<GameObject>();

    public Scene() {
        LoadScene();
    }

    /**
     * 载入场景时加载的内容
     */
    protected abstract void LoadScene();

    /**
     * 添加游戏物体
     * @param gameObject
     * @return
     */
    protected GameObject AddGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
        return gameObject;
    }

    /**
     * 根据名字找到游戏物体
     *
     * @param name
     * @return
     */
    protected GameObject Find(String name) {
        for (GameObject g : gameObjects) {
            if (g.name.equals(name)) {
                return g;
            }
        }
        return null;
    }
}
