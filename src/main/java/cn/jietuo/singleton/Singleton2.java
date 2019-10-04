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
public class Singleton2 {

    private final static Singleton2 INSTANCE ;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton2 instance1 = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(instance1 == instance2);
    }
}
