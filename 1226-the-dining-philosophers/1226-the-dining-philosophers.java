class DiningPhilosophers {
    Semaphore left,right;
    Semaphore[] philosopherS;
    Phaser phaser;
    public DiningPhilosophers() {
        left=new Semaphore(1);
        right=new Semaphore(1);
        phaser=new Phaser(1);
        philosopherS=new Semaphore[]{new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1)};
        
    }

    // call the run() method of any runnable to execute its code
    public synchronized void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        philosopherS[philosopher].acquire();
        //left.acquire();
        pickLeftFork.run();
      //  right.acquire();
        pickRightFork.run();
       // phaser.arriveAndAwaitAdvance();
        eat.run();
        putLeftFork.run();
       // left.release();
        putRightFork.run();
       // right.release();
        philosopherS[philosopher].release();
        
    }
}