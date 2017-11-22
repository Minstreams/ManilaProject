package Main;

import com.sun.xml.internal.bind.v2.TODO;

import java.awt.event.*;

public class Input implements KeyListener,MouseListener,MouseMotionListener{

    //-----------------处理键盘输入----------------
    /**
     * 当某按键按下时返回true
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
    /**
     *
     * @param mouseCode 0-鼠标左键 1-鼠标右键 2-鼠标中键
     * @return
     */
    public static boolean GetMouseDown(int mouseCode){
        //TODO
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}
