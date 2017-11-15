package Systems;
import java.util.ArrayList;

public abstract class ExampleSystem extends MySystem implements ISystem {
	/**
	 * 所有组件表列
	 */
	protected static ArrayList<ExampleSystem> components = new ArrayList<ExampleSystem>();
	
	/**
	 * 遍历调用所有组件function方法
	 */
	public static void Function() {
		//遍历
		for(ExampleSystem s : components) {
			s.function();
		}
	}
	
	
	
	/**
	 * 构造时添加自己到组件表列
	 */
	public ExampleSystem() {
		components.add(this);
		System.out.println("ExampleComponent Added!");
	}
	/**
	 * 析构时将自己从组件表列移除
	 */
	protected void finalize(){
		components.remove(this);
		System.out.println("ExampleComponent Removed!");
	}
}
