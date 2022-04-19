class FizzBuzz {
    private int n;
    Semaphore s1;
    Semaphore s2;
    Semaphore s3;
    Semaphore s4;
    AtomicInteger i;

    public FizzBuzz(int n) {
        this.n = n;
        s1=new Semaphore(0);
        s2=new Semaphore(0);
        s3=new Semaphore(0);
        s4=new Semaphore(1);
        i = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
            while(i.get()<=this.n){
			if(i.get()%3==0 && i.get()%5!=0){
       //     s1.acquire();
               // if(i.get()>this.n) break;
            printFizz.run();
              
                
                i.incrementAndGet();
       //     callNext(i.get());
                notifyAll();
                if(i.get()>this.n) break;
			}else{
                wait();}
			}
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
            while(i.get()<=this.n){
			if(i.get()%3!=0 && i.get()%5==0){
         //   s2.acquire();
            //    if(i.get()>this.n) break;
            printBuzz.run();
                
                i.incrementAndGet();
                
        //    callNext(i.get());
                notifyAll();
                if(i.get()>this.n) break;
                
			}else{
                wait();}
            }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while(i.get()<=this.n){
			if(i.get()%15==0){
        //    s3.acquire();
          //      if(i.get()>this.n) break;
            printFizzBuzz.run();
                
                i.incrementAndGet();
                
        //    callNext(i.get());
                notifyAll();
                if(i.get()>this.n) break;
			}else{
                wait();}
            }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
            while(i.get()<=this.n){
			if(i.get()%3!=0 && i.get()%5!=0){
       //     s4.acquire();
         //   if(i.get()>this.n) break;
            printNumber.accept(i.get());
                
                i.incrementAndGet();
                
       //     callNext(i.get());
                notifyAll();
                if(i.get()>this.n) break;
			}else{
                wait();}
            }
    }
    
    public void callNext(int i){
        if(i%3==0 && i%5!=0){
            
                s1.release(); 
            }
            else if(i%3!=0 && i%5==0){
                
                s2.release();
            }else if(i%15==0){
                s3.release();
            }else{
              //  System.out.println(i);
                s4.release();
            }
    }
}