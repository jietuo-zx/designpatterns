package cn.jietuo.singleton;

/**
 * @author zhangx & jietuo_zx@163.com
 * @version 1.0
 * @date 2019-10-04
 * @description: 饿汉式
 *
 * <pre>
 *     类加载到内存后，就实例化一个单例，JVM保证线程安全
 *     简单实用，推荐使用!
 *     唯一缺点：不管用到与否，类装载时都会完成实例化
 * </pre>
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        System.out.println(instance1 == instance2);
    }
}
