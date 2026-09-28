class FizzBuzz {
    private int n;
    int count = 0;
    Semaphore fizz = new Semaphore(0);
    Semaphore buzz = new Semaphore(0);
    Semaphore fizzbuzz = new Semaphore(0);
    Semaphore number = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
        assignNextWork();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true) {
            fizz.acquire();
            if(count == n + 1) return;
            printFizz.run();
            assignNextWork();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true) {
            buzz.acquire();
            if(count == n + 1) return;
            printBuzz.run();
            assignNextWork();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true) {
            fizzbuzz.acquire();
            if(count == n + 1) return;
            printFizzBuzz.run();
            assignNextWork();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            number.acquire();
            if(count == n + 1) return;
            printNumber.accept(count);
            assignNextWork();
        }
    }

    void assignNextWork() {
        count++;
        if(count == n + 1) { // release all
            fizzbuzz.release();
            fizz.release();
            buzz.release();
            number.release();
            return;
        }

        boolean div3 = count % 3 == 0;
        boolean div5 = count % 5 == 0;
        if(div3 && div5) {
            fizzbuzz.release();
        } else if (div3) {
            fizz.release();
        } else if (div5) {
            buzz.release();
        } else number.release();
    }
}