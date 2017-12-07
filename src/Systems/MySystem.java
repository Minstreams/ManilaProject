package Systems;


import Main.GameObject;
import Main.GameWorld;
import Main.Scene;

/**
 * System的父类
 * @author Minstreams
 *
 */
public abstract class MySystem implements ISystem{
	/**
	 * 关联的GameObject
	 */
	public GameObject gameObject = null;
	
	public static GameWorld gameWorld;

	/**
	 * 每帧时间
	 */
	public static float deltaTime;

	public MySystem() {

	}
	/**
	 * 在组件层中定义，具体组件的方法【因为Java重载机制的一些问题，首字母没有大写】
	 */
	protected abstract void function();

	/**
	 * 组件层中定义，用于初始化
	 */
	public abstract void start();

	protected GameObject Find(String name){
		return gameObject.scene.Find(name);
	}

	/**
	 * 摧毁游戏物体
	 * @param gameObject
	 */
	protected void Destroy(GameObject gameObject){
		if(gameObject == null){
			System.out.println("no GameObject to Destroy!");
			return;
		}
		gameObject.OnDestroy();
		gameObject.scene.getGameObjects().remove(gameObject);
	}

	protected void Destroy(MySystem component){
		component.OnDestroy();
		component.gameObject.getComponents().remove(component);
	}

	protected void LoadScene(Scene toLoad){
		gameWorld.LoadScene(toLoad);
	}

	public abstract void OnDestroy();
}
