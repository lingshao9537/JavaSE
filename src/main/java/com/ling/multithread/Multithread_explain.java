package com.ling.multithread;

import java.util.concurrent.*;

/**
 * 1.程序：是为完成特定任务、用某种语言编写的一组指令的集合。即指一段静态的代码，静态对象
 * 2.进程：是程序的一次执行过程，或是正在运行的一个程序。是一个动态的过程：有它自身的产生、存在、消亡的过程。—— 生命周期
 *      程序是静态的，进程是动态的      进程作为资源分配的单位，系统在运行时会为每个进程分配不同的内存区域
 * 3.线程：进程可进一步细化为线程，是一个程序内部的一条执行路径。
 *      若一个进程同一时间并行执行多个线程，就是支持多线程的
 *      线程作为调度和执行的单位，每个线程拥有独立的运行栈和程序计数器(PC)，线程切换的开销小。
 *      一个进程中的多个线程共享相同的内存单元/内存地址空间 → 它们从同一堆中分配对象，可以访问相同的变量和对象。这就使得线程间通信更为简单、高效。
 *          但多个线程操作共享的系统资源可能会带来安全隐患。
 *
 *  并行与并发：
 *      并行：多个CPU执行多项任务      并发：单个CPU执行多个任务
 *
 *  线程的创建和启动：JVM允许程序运行多个线程，通过java.lang.Thread类来体现
 *      每个线程都是通过某个特定的Thread对象的run()方法来完成操作的，经常把run()方法的主体成为线程体
 *      通过该Thread对象的start()方法来启动这个线程，而非直接调用run();
 *  Thread类：
 *      构造器：
 *          Thread():创建新的Thread对象
 *          Thread(String threadname):创建线程并指定线程实例名
 *          Thread(Runnable target):指定创建线程的目标对象，它实现了Runnable接口中的run()方法。
 *          Thread(Runnable target,String name):创建新的Thread对象
 *
 *      创建线程的三种方式：(4种)
 *          1.继承Thread类的方式
 *              1.1 定义子类继承Thread类
 *              1.2 子类中重写Thread类中的run()方法  (必须是重写Thread的run方法)
 *          (子类方法体构建完成，main方法中开始创建线程对象)
 *              1.3 创建Thread子类对象，即创建了线程对象
 *              1.4 调用线程对象start()方法，即启动线程，自动调用run()方法。(必须且只能调用start方法，否则无法开启线程)
 *
 *          2.实现Runnable接口的方式
 *              2.1 定义实现类，实现Runnable接口
 *              2.2 实现类中重写Runnable接口中的run()方法
 *              2.3 通过Thread类含参构造器创建线程对象
 *              2.4 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中
 *              2.5 调用Thread类的start方法，即开启线程，自动调用Runnable子类重写的run方法
 *          二者的区别：
 *              1.继承Thread：线程代码存放Thread子类的run方法中
 *              2.实现Runnable：线程代码存放在实现接口的子类run()方法当中。
 *             实现Runnable的好处：
 *                避免了单继承的局限性
 *                多个线程可以共享同一个接口实现类的对象，非常适合多个相同线程来处理同一份资源
 *
 *          相对于前者而言，是有状态的，存在返回值分析，前两者是只关心执行了吗，后者是执行之后返回情况
*           3.实现Callable接口的方式
*              3.1 定义实现类实现Callable接口，需要返回值类型
*              3.2 实现类中重写call()方法，需要返回值类型，需要抛出异常，
*              3.3 创建目标对象
*              3.4 创建执行服务：ExecutorService ser = Executors.newFixedThreadPool(1);
*              3.5 提交执行：Future<Boolean> result1 = ser.submit(t1);
*              3.6 获取结果：boolean r1 = result1.get();
*              3.7 关闭服务：ser.shutdownNow();
 *
 *    测试Thread中的常用方法：
 *      1.start():启动当前线程；调用当前线程的run()方法
 *      2.run():通常需要重写Thread类中的run()方法，将创建的线程要执行的操作声明在此方法中。
 *      3.currentThread():静态方法；返回执行当前代码的线程
 *      4.getName:获取当前线程的名字
 *      5.setName:设置当前线程的名字，在创建对象后，执行start()方法前。语法：对象.setName("XX线程");
 *      6.yield():是一种静态方法，
 *          a.释放当前cpu的执行权，暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程
 *          b.若队列中没有同优先级的线程，此方法无效。
 *      7.join():在线程A中调用线程B的join()方法，此时线程A就进入阻塞状态，直到线程B完全执行完后，线程A才结束阻塞状态。
 *          低优先级的线程也可以获得执行。
 *      8.sleep(long millis):(指定时间:毫秒)：让当前线程休息一段时间后再执行
 *          令当前活动线程在指定时间段内放弃对CPU的控制，使其他线程有机会被执行，时间到了之后重新排队
 *          抛出InterruptedExcep异常  try catch处理
 *      9.stop():强制线程生命周期结束，不推荐使用  //过时了
 *      10.boolean isAlive():返回boolean，判断线程是否还活着。
 *
 */
public class Multithread_explain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.3创建Thread子类对象，即创建了线程对象
        ThreadTest threadTest = new ThreadTest(0); //子类构造方法中调用Thread的有参构造方法，重命名线程名
        ThreadTest threadTest1 = new ThreadTest(1);
        //1.4调用线程对象start()方法：启动线程，自动调用run()方法。
        threadTest.start();
        threadTest1.start();

        /** 2.3 通过Thread类含参构造器创建线程对象
            2.4 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中  */
        //Runnable runnableTest = new RunnableTest();

        Thread thread = new Thread(new RunnableTest(0),"输出偶数线程");
        Thread thread1 = new Thread(new RunnableTest(1),"输出奇数线程");
        //2.5 调用Thread类的start方法，即开启线程，自动调用Runnable子类重写的run方法
        thread.start();
        thread1.start();
        //如果直接调run()方法，就不是开启线程了是用的main线程，会先执行完run()方法，然后向下执行main方法中的方法体。


        Callable c1 = new CallableTest();
        Callable c2 = new CallableTest();
        Callable c3 = new CallableTest();

        ExecutorService ser = Executors.newFixedThreadPool(3);
        Future<Boolean> r1 = ser.submit(c1);
        Future<Boolean> r2 = ser.submit(c2);
        Future<Boolean> r3 = ser.submit(c3);

        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        ser.shutdown();
    }
}
//1.1定义子类继承Thread类
class ThreadTest extends Thread{
    public  int num;
    //1.2子类中重写Thread类中的run()方法
    public ThreadTest(String name){  //构造器方法更改线程名
        super(name);
    }

    public ThreadTest(){

    }
    public ThreadTest(int num){
        this.num = num;
    }

    @Override
    public void run() {
//        this.yield();
//        try {
//            this.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName()+"的线程开启");
        for(int i = 0; i< 100; i++){
            if(i % 2 != num){
                continue;
            }
            System.out.println(Thread.currentThread().getName()+": "+i);

        }
    }
}
//2.1 定义子类，实现Runnable接口
class RunnableTest implements Runnable{
    public  int num;
    public RunnableTest(){

    }
    public RunnableTest(int num){
        this.num = num;
    }



    //2.2 子类中重写Runnable接口中的run()方法
    @Override
    public void run() {
        for(int i = 0; i< 100; i++){
            if(i % 2 != num){
                continue;
            }
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}

class CallableTest implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        return null;
    }
}


