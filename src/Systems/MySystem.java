package Systems;


import Main.GameObject;

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

	public MySystem() {
		
	}
	/**
	 * 在组件层中定义，具体组件的方法【因为Java重载机制的一些问题，首字母没有大写】
	 */
	protected abstract void function();
}
