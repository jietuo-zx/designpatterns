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
public class Singleton6 {

    private static volatile Singleton6 INSTANCE; // volatile 防止指令重拍序，线程间可见

    private Singleton6() {
    }

    private static Singleton6 getInstance() {
        if (INSTANCE == null) {
            // 双重检查
            synchronized (Singleton6.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton6();
                }
            }
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> System.out.println(Singleton6.getInstance().hashCode())).start();
        }
    }
}
