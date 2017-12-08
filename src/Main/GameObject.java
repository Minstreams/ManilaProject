package Main;

import java.lang.String;
import java.util.ArrayList;

import Systems.MySystem;

/**
 * 游戏物体
 *
 * @author 47465
 */
public class GameObject {
    public String name;//名称
    public float x;//横坐标
    public float y;//纵坐标
    public int layer;//图层

    public Scene scene;//关联的场景

    public GameObject parent = null;//父物体
    public ArrayList<GameObject> children = new ArrayList<GameObject>();//子物体表列

    private ArrayList<MySystem> components = new ArrayList<MySystem>();//组件表列

    public GameObject(String name, float x, float y, int layer) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.layer = layer;
    }

    public GameObject(String name, float x, float y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.layer = 0;
    }

    /**
     * 添加子物体
     *
     * @param child
     * @return
     */
    public GameObject AddChild(GameObject child) {
        scene.AddGameObject(child);
        children.add(child);
        child.parent = this;
        return child;
    }

    /**
     * 添加组件
     *
     * @param component
     */
    public MySystem AddComponent(MySystem component) {
        components.add(component);
        component.gameObject = this;
        component.start();
        return component;
    }

    /**
     * 根据类型获取组件
     *
     * @param c
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T GetComponent(Class<T> c) {
        for (int i = 0; i < components.size(); i++) {
            Object o = components.get(i);
            if (o.getClass() == c) {
                return (T) o;
            }
        }
        return null;
    }

    /**
     * 摧毁时调用
     */
    public void OnDestroy() {
        for (int i = 0; i < children.size(); i++) {
            GameObject child = children.get(i);
            if (child != null) {
                child.OnDestroy();
            }
        }
        for (int i = 0; i < components.size(); i++) {
            MySystem com = components.get(i);
            if (com != null) {
                com.OnDestroy();
            }
        }
        components.clear();
        if (parent != null) {
            parent.children.remove(this);
        }
    }

    public ArrayList<MySystem> getComponents() {
        return components;
    }
}
