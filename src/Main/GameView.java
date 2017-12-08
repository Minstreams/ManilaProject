package Main;

import Components.RenderComponent;

import java.awt.*;

import javax.swing.*;

/**
 * 游戏界面类
 */
public class GameView {
    JFrame jFrame = new JFrame("Sailing!!!");
    JLayeredPane jLayeredPane = new JLayeredPane();

    public GameView() throws HeadlessException {
        CreatView();
        //创建输入控制实例
        Input inputController = new Input();
        //注册鼠标事件
        jLayeredPane.addMouseListener(inputController);
        //注册鼠标移动事件
        jLayeredPane.addMouseMotionListener(inputController);
        //注册键盘事件
        jFrame.addKeyListener(inputController);
    }

    /**
     * 创建窗口
     */
    public void CreatView() {
        //width = 800 + 159 + 8, height = 600 + 36
        jFrame.setSize(967, 636);
        jFrame.setContentPane(jLayeredPane);
        jFrame.setVisible(true);
    }

    /**
     * 显示相应物体
     * @param rc
     * @param layer
     */
    public void PaintGameObject(RenderComponent rc, int layer) {
        jLayeredPane.add(rc.getjPanel(), new Integer(layer));
    }

    /**
     * 删除相应物体
     * @param rc
     */
    public void Destroy(RenderComponent rc) {
        jLayeredPane.remove(rc.getjPanel());
        //刷新
        jFrame.setContentPane(jLayeredPane);
    }
}
