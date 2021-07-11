package yzk.leetcode;


import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private final Semaphore fooSync;
    private final Semaphore barSync;

    public FooBar(int n) {
        this.n = n;
        this.fooSync = new Semaphore(1);
        this.barSync = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            this.fooSync.acquireUninterruptibly();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            this.barSync.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            this.barSync.acquireUninterruptibly();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            this.fooSync.release();
        }
    }

//    public Runnable printFoo(){
//        Runnable aRunnable = new Runnable(){
//            public void run(){
//                System.out.println("foo");
//            }
//        };
//
//
//        return aRunnable;
//
//    }
//
//    public Runnable printBar(){
//        Runnable aRunnable = new Runnable(){
//            public void run(){
//                System.out.println("bar");
//            }
//        };
//        return aRunnable;
//    }
}

class printFoo implements Runnable {
    private Thread t;
    private String threadName;

    public void printFoo(String name) {
        threadName = name;
    }

    public void printFoo() {
        printFoo("printFoo");
        System.out.printf("Creating %s", threadName);
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

class printBar implements Runnable {
    private Thread t;
    private String threadName;

    public void printBar(String name) {
        threadName = name;
    }

    public void printBar() {
        printBar("printBar");
        System.out.printf("Creating %s", threadName);
    }

    public void run() {
        System.out.println("bar");
    }
}