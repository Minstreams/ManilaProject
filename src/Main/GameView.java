package Main;

import Components.RenderComponent;

import java.awt.*;

import javax.swing.*;

public class GameView extends JFrame {
		JFrame jFrame = new JFrame("test");
		JPanel jPanel = new JPanel();

	public GameView() throws HeadlessException {
		CreatView();
	}

	public void CreatView() {
		jFrame.setSize(1000, 400);
		jPanel.setLayout(null);
		jFrame.add(jPanel);
		
		JLabel jLabel = new JLabel();
		ImageIcon icon = RenderComponent.getImageFile("g2.jpg");
		jLabel.setIcon(icon);
		jLabel.setOpaque(false);
		jPanel.add(jLabel);
		
		jFrame.setVisible(true);
		jFrame.setContentPane(jPanel);

		jPanel.addMouseListener(new MouseContrllor());
	}
	public void PaintGameObject(RenderComponent rc) {
		this.jPanel.add(rc.getjLabel());
	}
}
