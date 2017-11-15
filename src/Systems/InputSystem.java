package Systems;

import java.util.ArrayList;

/**
 * 输入时根据鼠标坐标执行指令的系统
 * @author 47465
 *
 */
public abstract class InputSystem extends MySystem {
	/**
	 * 鼠标
	 */
	public static int mouseX = 0;
	public static int mouseY = 0;






//-----------------------------------分割线------------------------------------
//以下的代码没什么好改的。
	/**
	 * 所有组件表列
	 */
	protected static ArrayList<InputSystem> components = new ArrayList<InputSystem>();
	/**
	 * 遍历调用所有组件function方法
	 */
	public static void Function() {
		//遍历
		for(InputSystem s : components) {
			s.function();
		}
	}
	/**
	 * 构造时添加自己到组件表列
	 */
	public InputSystem() {
		components.add(this);
		System.out.println("RenderComponent Added!");
	}
	/**
	 * 析构时将自己从组件表列移除
	 */
	protected void finalize(){
		components.remove(this);
		System.out.println("RenderComponent Removed!");
	}
	
}
