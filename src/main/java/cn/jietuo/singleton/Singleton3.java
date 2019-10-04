package cn.jietuo.singleton;

/**
 * @author zhangx & jietuo_zx@163.com
 * @version 1.0
 * @date 2019-10-04
 * @description: 懒汉式
 *
 * <pre>
 *     虽然达到了按需初始化的目的，却带来了线程不安全的问题
 * </pre>
 */
public class Singleton3 {

    private static Singleton3 INSTANCE;

    private Singleton3() {
    }

    private static Singleton3 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton3.getInstance().hashCode())).start();
        }
    }
}
