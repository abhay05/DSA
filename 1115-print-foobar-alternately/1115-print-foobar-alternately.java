class FooBar {
    private int n;
    AtomicInteger change;

    public FooBar(int n) {
        this.n = n;
        change=new AtomicInteger(0);
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	
            while(change.get()%2==1){
                wait();
            }
            printFoo.run();
            change.addAndGet(1);
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	while(change.get()%2==0){
                wait();
            }
            printBar.run();
            change.addAndGet(1);
            notifyAll();
        }
    }
}