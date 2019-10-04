package cn.jietuo.singleton;

/**
 * @author zhangx & jietuo_zx@163.com
 * @version 1.0
 * @date 2019-10-04
 * @description: 枚举单例
 *
 * <pre>
 *     不仅可以解决线程同步，还可以防止反序列化
 *     推荐使用
 * </pre>
 *
 */
public enum Singleton8 {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> System.out.println(Singleton8.INSTANCE.hashCode())).start();
        }
    }
}
