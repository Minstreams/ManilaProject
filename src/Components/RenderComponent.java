package Components;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Systems.RenderSystem;

public class RenderComponent extends RenderSystem {
    private String name;
    private ImageIcon imageIcon;

    /**
     * 初始化属性
     *
     * @param name
     */
    public RenderComponent(String name) {
        super();
        this.name = name;
        imageIcon = getImageFile(name);
    }

    /**
     * 每帧刷新位置
     */
    @Override
    protected void function() {
        if (jPanel != null) {
            jPanel.setBounds(gameObject.x, gameObject.y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        }
    }

    @Override
    protected void createPanel() {
        // 创建一个 JPanel, 使用 1 行 1 列的网格布局
        JPanel panel = new JPanel(new GridLayout(1, 1));

        // 设置容器的位置和宽高
        panel.setBounds(gameObject.x, gameObject.y, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        // 设置 panel 的背景
        panel.setOpaque(false);

        // 创建标签并设置相应属性
        JLabel label = new JLabel();
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);

        // 添加标签到容器
        panel.add(label);

        jPanel = panel;
    }

    public static ImageIcon getImageFile(String name) {
        String path = System.getProperty("user.dir") + "\\src";
        ImageIcon image = new ImageIcon(path + "\\" + name);
        return image;
    }
}
