package cn.jietuo.singleton;

/**
 * @author zhangx & jietuo_zx@163.com
 * @version 1.0
 * @date 2019-10-04
 * @description: 静态内部类
 *
 * <pre>
 *     JVM保证单例，加载外部类时不会加载内部类，这样可以实现懒加载
 * </pre>
 */
public class Singleton7 {

    private Singleton7(){}

    private static class Singleton7Holder{
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return Singleton7Holder.INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> System.out.println(Singleton7.getInstance().hashCode())).start();
        }
    }
}
