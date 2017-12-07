package Systems;

import java.util.ArrayList;
import Main.GameView;

/**
 * 渲染系统，所有渲染组件的父类
 *
 * @author 47465
 */
public abstract class RenderSystem extends MySystem {

    public static GameView gameView = new GameView();






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
     * 遍历调用所有组件Start方法
     */
    public static void Start() {
        //遍历
        for (RenderSystem s : components) {
            s.start();
        }
    }

    /**
     * 构造时添加自己到组件表列
     */
    public RenderSystem() {
        components.add(this);
        System.out.println("RenderComponent Added!");
    }
}
