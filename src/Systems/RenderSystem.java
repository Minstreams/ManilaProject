package Systems;

import java.util.ArrayList;

import Main.GameView;

import javax.swing.*;

/**
 * 渲染系统，所有渲染组件的父类
 *
 * @author 47465
 */
public abstract class RenderSystem extends MySystem {
    protected JPanel jPanel;
    protected int layerOffset = 0;

    public static GameView gameView = new GameView();

    public JPanel getjPanel() {
        return jPanel;
    }

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
        for (int i = 0; i < components.size(); i++) {
            components.get(i).function();
        }
    }

    /**
     * 构造时添加自己到组件表列
     */
    public RenderSystem() {
        components.add(this);
        //System.out.println("RenderComponent Added!");
    }

    @Override
    public void start() {
        createPanel();
        gameView.PaintGameObject(this, gameObject.layer + layerOffset);
    }

    /**
     * 自定义jPanel
     * @return
     */
    protected abstract void createPanel();

    /**
     * 析构时将自己从组件表列移除
     */
    @Override
    public void OnDestroy() {
        gameView.Destroy(this);
        jPanel = null;
        components.remove(this);
        //System.out.println("RenderComponent Removed!");
    }
}
