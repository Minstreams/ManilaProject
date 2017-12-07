package Systems;


import Main.GameObject;
import Main.GameWorld;

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
	protected abstract void start();

	protected GameObject Find(String name){
		return gameWorld.getCurrentScene().Find(name);
	}
}
