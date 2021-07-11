package yzk.leetcode;

//https://www.tutorialspoint.com/java/java_multithreading.htm
public class MultiThreadTest {

    public static void main(String[] args) throws InterruptedException {
        int n = 10;

        FooBar fb1 = new FooBar(n);
        fb1.bar(new printFoo());
        fb1.foo(new printBar());
    }

}



