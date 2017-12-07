package Main;

import Components.RenderComponent;

import java.awt.*;

import javax.swing.*;

/**
 * 游戏界面类
 */
public class GameView extends JFrame {
		JFrame jFrame = new JFrame("test");
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

	public void CreatView() {
		jFrame.setSize(808, 636);
		jFrame.setContentPane(jLayeredPane);

		/*
		JLabel jLabel = new JLabel();
		ImageIcon icon = RenderComponent.getImageFile("g2.jpg");
		jLabel.setIcon(icon);
		jLabel.setOpaque(false);
		jPanel.add(jLabel);
		*/
		jFrame.setVisible(true);

		//jPanel.addMouseListener(new MouseContrllor());
	}
	public void PaintGameObject(RenderComponent rc,int layer) {
		jLayeredPane.add(rc.getjPanel(), new Integer(layer) );
	}
}
