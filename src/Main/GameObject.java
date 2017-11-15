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
	
	public GameObject parent = null;
	public ArrayList<GameObject> children = new ArrayList<GameObject>();
	
	private ArrayList<MySystem> components = new ArrayList<MySystem>();
	
	public GameObject() {
		
	}
	
	public GameObject(GameObject parent){
		this.parent = parent;
	}
	
	public GameObject(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public GameObject(GameObject parent,int x,int y){
		this.parent = parent;
		this.x = x;
		this.y = y;
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
