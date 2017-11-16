package Systems;

import java.util.ArrayList;

import Main.GameObject;

/**
 * 渲染系统，所有渲染组件的父类
 *
 * @author 47465
 */
public abstract class RenderSystem extends MySystem {
	

//-----------------------------------分割线------------------------------------
//以下的代码没什么好改的。
    /**
     * 所有组件表列
     */
    protected static ArrayList<RenderSystem> components = new ArrayList<RenderSystem>();

    /**
     * 遍历调用所有组件function方法
     */
    public static void Function() {
        //遍历
        for (RenderSystem s : components) {
            s.function();
        }
    }

    /**
     * 构造时添加自己到组件表列
     */
    public RenderSystem() {
        components.add(this);
        System.out.println("RenderComponent Added!");
    }

    /**
     * 析构时将自己从组件表列移除
     */
    protected void finalize() {
        components.remove(this);
        System.out.println("RenderComponent Removed!");
    }
}
