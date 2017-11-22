package Main;

import Components.RenderComponent;

import java.awt.*;

import javax.swing.*;

/**
 * 游戏界面类
 */
public class GameView extends JFrame {
		JFrame jFrame = new JFrame("test");
		JPanel jPanel = new JPanel();

	public GameView() throws HeadlessException {
		CreatView();
		//创建输入控制实例
		Input inputController = new Input();
		//注册鼠标事件
		jPanel.addMouseListener(inputController);
		//注册鼠标移动事件
		jPanel.addMouseMotionListener(inputController);
		//注册键盘事件
		jPanel.addKeyListener(inputController);
	}

	public void CreatView() {
		jFrame.setSize(1000, 400);
		jPanel.setLayout(null);
		jFrame.add(jPanel);


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
	public void PaintGameObject(RenderComponent rc) {
		this.jPanel.add(rc.getjLabel());
	}
}
