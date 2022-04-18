class ZeroEvenOdd {
    private int n;
    Semaphore s1,s2,s0;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        s0=new Semaphore(0);
        s1=new Semaphore(0);
        s2=new Semaphore(0);
        s0.release();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<this.n;i++){
            s0.acquire();
            printNumber.accept(0);
            if(i%2==0){
            s1.release();
            }else{
            s2.release();    
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=this.n;i++){
            if(i%2==0){
        s2.acquire();
        printNumber.accept(i);
        s0.release();}
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=this.n;i++){
            if(i%2==1){
        s1.acquire();
        printNumber.accept(i);
        s0.release();
            }
    }
    }
}