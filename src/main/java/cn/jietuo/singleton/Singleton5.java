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
public class Singleton5 {

    private static Singleton5 INSTANCE;

    private Singleton5() {
    }

    private static Singleton5 getInstance() {
        if (INSTANCE == null) {
            // 希望通过减小同步代码块的方式来提高效率，但是不可行
            synchronized (Singleton5.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton5.getInstance().hashCode())).start();
        }
    }
}
