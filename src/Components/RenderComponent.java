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
    private JPanel jPanel;

    public JPanel getjPanel() {
        return jPanel;
    }

    public RenderComponent(String name) {
        super();
        this.name = name;
        imageIcon = getImageFile(name);
    }

    @Override
    protected void function() {
        if (jPanel != null) {
            jPanel.setBounds(gameObject.x, gameObject.y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        }
    }

    @Override
    protected void start() {
        jPanel = createPanel(imageIcon, gameObject.x, gameObject.y);
        gameView.PaintGameObject(this, gameObject.layer);
    }

    public static ImageIcon getImageFile(String name) {
        String path = System.getProperty("user.dir") + "\\src";
        ImageIcon image = new ImageIcon(path + "\\" + name);
        return image;
    }

    private static JPanel createPanel(ImageIcon icon, int x, int y) {
        // 创建一个 JPanel, 使用 1 行 1 列的网格布局
        JPanel panel = new JPanel(new GridLayout(1, 1));


        // 设置容器的位置和宽高
        panel.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());

        // 设置 panel 的背景
        panel.setOpaque(true);

        // 创建标签并设置相应属性
        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);

        // 添加标签到容器
        panel.add(label);

        return panel;
    }

    /**
     * 析构时将自己从组件表列移除
     */
    @Override
    public void OnDestroy() {
        gameView.Destroy(this);
        jPanel = null;
        components.remove(this);
        System.out.println("RenderComponent Removed!");
    }
}
