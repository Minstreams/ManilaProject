package Components;

import Systems.RenderSystem;

import javax.swing.*;
import java.awt.*;

public class TextRendererComponent extends RenderSystem {

    private JTextField textField;

    /**
     * 需要显示的文本传进来，直接给游戏物体添加组件就ojbk
     *
     * @param mString
     */
    public TextRendererComponent(String mString) {
        super();
        textField = new JTextField(mString);
        layerOffset = 1;
    }

    @Override
    protected void createPanel() {
        // 创建一个 JPanel
        JPanel panel = new JPanel();

        panel.setBounds((int)gameObject.x, (int)gameObject.y, 159, textField.getHeight());
        panel.setOpaque(false);

        textField.setEditable(false);
        panel.add(textField);

        jPanel = panel;
    }

    @Override
    protected void function() {
        if (jPanel != null) {
            jPanel.setBounds((int)gameObject.x, (int)gameObject.y, 159, textField.getHeight());
        }
    }
}
