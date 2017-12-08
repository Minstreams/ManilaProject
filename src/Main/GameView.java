package Main;

import Systems.RenderSystem;

import java.awt.*;
import java.awt.image.MemoryImageSource;

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
        //width = 800 + 159 + 8, height = 600 + 46
        jFrame.setSize(967, 646);
        jFrame.setContentPane(jLayeredPane);
        jFrame.setVisible(true);

        Image image = Toolkit.getDefaultToolkit().createImage(
                new MemoryImageSource(0, 0, new int[0], 0, 0));
        jFrame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image,
                new Point(0, 0), null));
    }

    /**
     * 显示相应物体
     *
     * @param rc
     * @param layer
     */
    public void PaintGameObject(RenderSystem rc, int layer) {
        jLayeredPane.add(rc.getjPanel(), new Integer(layer));
    }

    /**
     * 删除相应物体
     *
     * @param rc
     */
    public void Destroy(RenderSystem rc) {
        jLayeredPane.remove(rc.getjPanel());
        //刷新
        jFrame.setContentPane(jLayeredPane);
    }
}
