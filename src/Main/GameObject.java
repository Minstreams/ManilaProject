package Main;
import java.lang.String;
import java.util.ArrayList;

import Systems.MySystem;

/**
 * 游戏物体
 * @author 47465
 *
 */
public class GameObject {
	public String name;
	public int x;
	public int y;
	public int layer;
	
	public GameObject parent = null;
	public ArrayList<GameObject> children = new ArrayList<GameObject>();
	
	private ArrayList<MySystem> components = new ArrayList<MySystem>();
	
	public GameObject(String name,int x,int y,int layer){
		this.name = name;
		this.x = x;
		this.y = y;
		this.layer = layer;
	}
	
	public GameObject(String name,int x,int y){
		this.name = name;
		this.x = x;
		this.y = y;
		this.layer = 0;
	}
	
	
	public void AddChild(GameObject child) {
		children.add(child);
		child.parent = this;
	}
	
	public void AddComponent(MySystem component) {
		components.add(component);
		component.gameObject = this;
	}
	
	@SuppressWarnings("unchecked")
	public <T>T GetComponent(Class<T> c) {
		for(int i = 0;i < components.size();i++) {
			Object o = components.get(i);
			if(o.getClass() == c) {
				return (T)o;
			}
		}
		return null;
	}
	
	
}
