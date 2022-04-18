class H2O {
    Semaphore s1;
    Semaphore s2;
    AtomicInteger a;
    int cnt=0;
    public H2O() {
        s1=new Semaphore(0);
        s2=new Semaphore(0);
      //  a=new AtomicInteger(0);
        s1.release();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        s1.acquire();
        releaseHydrogen.run();
       // a.incrementAndGet();
        cnt++;
        if(cnt%2==0){
          //  cnt=0;
            s2.release();
        }else{
        s1.release();}
       // releaseHydrogen.run();
       // s2.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		s2.acquire();
        releaseOxygen.run();
        s1.release();
    }
}