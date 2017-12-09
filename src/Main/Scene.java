package Main;

import java.util.ArrayList;
import java.util.List;

import Systems.MySystem;

/**
 * 任意一个场景继承这个
 */
public abstract class Scene {
    List<GameObject> gameObjects = new ArrayList<GameObject>();

    static GameObject currentGameObject = null;

    public Scene() {
        System.out.println("Scene Loaded!");
    }

    /**
     * 载入场景时加载的内容
     */
    protected abstract void LoadScene();

    /**
     * 向场景里添加游戏物体
     *
     * @param gameObject
     * @return
     */
    public GameObject AddGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
        gameObject.scene = this;
        currentGameObject = gameObject;
        return gameObject;
    }

    protected void AddComponent(MySystem component) {
        if (currentGameObject != null) {
            currentGameObject.AddComponent(component);
        }
    }

    /**
     * 根据名字找到游戏物体
     *
     * @param name
     * @return
     */
    public GameObject Find(String name) {
        for (GameObject g : gameObjects) {
            if (g.name.equals(name)) {
                return g;
            }
        }
        return null;
    }

    /**
     * 根据物体序号找到物体
     *
     * @param index
     * @return
     */
    public GameObject Find(int index) {
        if (gameObjects.size() > index) {
            return gameObjects.get(index);
        }
        return null;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void OnDestroy() {
        for(int i = 0 ;i<gameObjects.size();i++){
            gameObjects.get(i).OnDestroy();
        }
        gameObjects.clear();
        System.out.println("Scene Destroyed!");
    }

    public static void setCurrentGameObject(GameObject currentGameObject) {
        Scene.currentGameObject = currentGameObject;
    }
}
