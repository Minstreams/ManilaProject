package Components;

import Systems.RenderSystem;

import javax.swing.*;
import java.awt.*;

public class TextRendererComponent extends RenderSystem {

    private String mString01 = null;

    private JTextArea m_JTextField = new JTextArea(mString01);

    /**
     * 需要显示的文本传进来，直接给游戏物体添加组件就ojbk
     *
     * @param mString01
     */
    public TextRendererComponent(String mString01) {
        super();
        this.mString01 = mString01;
    }

    @Override
    protected void createPanel() {
        // 创建一个 JPanel, 使用 1 行 1 列的网格布局
        JPanel panel = new JPanel(new GridLayout(4, 1));

        /**
         * 文本域属性设置
         */
        m_JTextField.setText(mString01);
        m_JTextField.setEditable(false);

        panel.add(m_JTextField);

        jPanel = panel;
    }

    @Override
    protected void function() {
        if (jPanel != null) {
            jPanel.setBounds(gameObject.x, gameObject.y, 100, 100);
        }
    }
}
