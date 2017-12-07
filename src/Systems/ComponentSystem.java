package Systems;

import java.util.ArrayList;

/**
 * 输入系统，部分组件父类，继承该组件的组件须重写OnMouseDown方法
 *
 * @author 47465
 */
public abstract class ComponentSystem extends MySystem {


//-----------------------------------分割线------------------------------------
//以下的代码没什么好改的。
    /**
     * 所有组件表列
     */
    protected static ArrayList<ComponentSystem> components = new ArrayList<ComponentSystem>();

    /**
     * 遍历调用所有组件function方法
     */
    public static void Function() {
        //遍历
        for(int i = 0;i<components.size();i++){
            components.get(i).function();
        }
    }

    /**
     * 遍历调用所有组件Start方法
     */
    public static void Start() {
        //遍历
        for(int i = 0;i<components.size();i++){
            components.get(i).start();
        }
    }

    /**
     * 构造时添加自己到组件表列
     */
    public ComponentSystem() {
        components.add(this);
        System.out.println("InputComponent Added!");
    }

    /**
     * 析构时将自己从组件表列移除
     */
    @Override
    public void OnDestroy() {
        components.remove(this);
        System.out.println("InputComponent Removed!");
    }

}
