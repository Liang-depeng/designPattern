package com.ldp.example.single;

/**
 * 5 种单例模式
 */
public class SingleInstanceClass {

    private SingleInstanceClass() {
        init();
    }


    /**
     * ---1--- 饿汉式 单例   线程安全
     * <p>
     * 是否 Lazy 初始化：否
     * <p>
     * 是否多线程安全：是
     * <p>
     * 实现难度：易
     * <p>
     * 描述：这种方式比较常用，但容易产生垃圾对象。
     * 优点：没有加锁，执行效率会提高。
     * 缺点：类加载时就初始化，浪费内存。
     * 它基于 classloader 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，
     * 虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法，
     * 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
     */
    private final static SingleInstanceClass instance1 = new SingleInstanceClass();

    public static SingleInstanceClass getInstance() {
        return instance1;
    }


    /**
     * ---2--- 懒汉式 单例  非线程安全
     * 是否 Lazy 初始化：是
     * 是否多线程安全：否
     * 实现难度：易
     * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
     * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作
     */
    private static SingleInstanceClass instance2;

    public static SingleInstanceClass getInstance2() {
        if (instance2 == null) {
            instance2 = new SingleInstanceClass();
        }
        return instance2;
    }

    /**
     * 懒汉式 单例  线程安全
     * <p>
     * 是否 Lazy 初始化：是
     * <p>
     * 是否多线程安全：是
     * <p>
     * 实现难度：易
     * <p>
     * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
     * 优点：第一次调用才初始化，避免内存浪费。
     * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
     * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
     */
    public static synchronized SingleInstanceClass getInstance22() {
        if (instance2 == null) {
            instance2 = new SingleInstanceClass();
        }
        return instance2;
    }

    /**
     * ---3--- 双检锁/双重校验锁（DCL，即 double-checked locking）
     * <p>
     * JDK 版本：JDK1.5 起
     * <p>
     * 是否 Lazy 初始化：是
     * <p>
     * 是否多线程安全：是
     * <p>
     * 实现难度：较复杂
     * <p>
     * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
     * getInstance() 的性能对应用程序很关键。
     */
    private volatile static SingleInstanceClass instance3;

    public static SingleInstanceClass getInstance3() {
        if (instance3 == null) {
            synchronized (SingleInstanceClass.class) {
                if (instance3 == null) {
                    instance3 = new SingleInstanceClass();
                }
            }
        }
        return instance3;
    }


    /**
     * ---4--- 静态内部类 单例
     * <p>
     * 是否 Lazy 初始化：是
     * <p>
     * 是否多线程安全：是
     * <p>
     * 实现难度：一般
     * <p>
     * 描述：这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
     * 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
     * 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，它跟第 1 种方式不同的是：
     * 第 1 种方式只要 Singleton 类被装载了，那么 instance 就会被实例化（没有达到 lazy loading 效果），
     * 而这种方式是 Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，
     * 只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。想象一下，
     * 如果实例化 instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例化，
     * 因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化 instance 显然是不合适的。这个时候，这种方式相比第 1 种方式就显得很合理。
     */
    private static class Instance {
        private final static SingleInstanceClass instance4 = new SingleInstanceClass();
    }

    public static SingleInstanceClass getInstance4() {
        return Instance.instance4;
    }

    /**
     * ---5--- 枚举
     * <p>
     * JDK 版本：JDK1.5 起
     * <p>
     * 是否 Lazy 初始化：否
     * <p>
     * 是否多线程安全：是
     * <p>
     * 实现难度：易
     * <p>
     * 描述：这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
     * 这种方式是 Effective Java 作者 Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还自动支持序列化机制，
     * 防止反序列化重新创建新的对象，绝对防止多次实例化。不过，由于 JDK1.5 之后才加入 enum 特性，用这种方式写不免让人感觉生疏，
     * 在实际工作中，也很少用。
     * 不能通过 reflection attack 来调用私有构造方法。
     */
    public enum Singleton {
        INSTANCE;

        public void anyMethod() {

        }
    }

    public static Singleton getInstance5() {
        return Singleton.INSTANCE;
    }


    public static void main(String[] args) {
        System.out.println("------单例模式------");
    }

    private void init() {
        System.out.println(System.currentTimeMillis() + "  SingleInstanceClass 初始化完成");
    }

}
