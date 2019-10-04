package cn.jietuo.singleton;

/**
 * @author zhangx & jietuo_zx@163.com
 * @version 1.0
 * @date 2019-10-04
 * @description: 懒汉式
 *
 * <pre>
 *     可以使用synchornized解决，但是也带来了效率的降低
 * </pre>
 */
public class Singleton4 {

    private  static Singleton4 INSTANCE;

    private Singleton4() {
    }

    private static synchronized Singleton4 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton4.getInstance().hashCode())).start();
        }
    }
}
