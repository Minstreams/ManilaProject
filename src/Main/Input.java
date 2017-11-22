package Main;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener {

    //-----------------处理键盘输入----------------

    /**
     * 当某按键按下时返回true
     *
     * @param keyCode
     * @return
     */
    public static boolean GetKey(KeyCode keyCode) {
        //TODO
        return false;
    }

    public static boolean GetKeyDown(KeyCode keyCode) {
        //TODO
        return false;
    }

    public static boolean GetKeyUp(KeyCode keyCode) {
        //TODO
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //-----------------处理鼠标输入----------------
    private static boolean[] mouseCondition = new boolean[3];
    private static boolean[] mouseDownCondition = new boolean[3];
    private static boolean[] mouseUpCondition = new boolean[3];
    private static int MouseX = 0;
    private static int MouseY = 0;

    /**
     * 鼠标若已按下则返回true
     *
     * @param mouseCode 0-鼠标左键 1-鼠标右键 2-鼠标中键
     * @return
     */
    public static boolean GetMouse(int mouseCode) {
        return mouseCondition[mouseCode];
    }

    /**
     * 鼠标按下瞬间返回true
     *
     * @param mouseCode 0-鼠标左键 1-鼠标右键 2-鼠标中键
     * @return
     */
    public static boolean GetMouseDown(int mouseCode) {
        if (mouseDownCondition[mouseCode]) {
            mouseDownCondition[mouseCode] = false;
            return true;
        }
        return false;
    }

    /**
     * 鼠标松开瞬间返回true
     *
     * @param mouseCode
     * @return
     */
    public static boolean GetMouseUp(int mouseCode) {
        if (mouseUpCondition[mouseCode]) {
            mouseUpCondition[mouseCode] = false;
            return true;
        }
        return false;
    }

    /**
     * 获取鼠标x坐标
     *
     * @return 鼠标x坐标
     */
    public static int GetMouseXPosition() {
        return MouseX;
    }

    /**
     * 获取鼠标y坐标
     *
     * @return 鼠标x坐标
     */
    public static int GetMouseYPosition() {
        return MouseY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseCondition[e.getButton() - 1] = true;
        mouseDownCondition[e.getButton() - 1] = true;
        mouseUpCondition[e.getButton() - 1] = false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseCondition[e.getButton() - 1] = false;
        mouseDownCondition[e.getButton() - 1] = false;
        mouseUpCondition[e.getButton() - 1] = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MouseX = e.getX();
        MouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        MouseX = e.getX();
        MouseY = e.getY();
    }


}
