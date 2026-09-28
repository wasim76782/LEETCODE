class DiningPhilosophers {
    private static final int N = 5;
    private final Object[] forks = new Object[N];

    public DiningPhilosophers() {
        Arrays.fill(forks, new Object());
    }

    public void wantsToEat(
        int i,//philosopher num
        Runnable pickLeftFork,
        Runnable pickRightFork,
        Runnable eat,
        Runnable putLeftFork,
        Runnable putRightFork) throws InterruptedException {
            int min = Math.min(i,(i+1)%N);
            int max = Math.max(i,(i+1)%N);

            synchronized(forks[min]){
                synchronized(forks[max]){
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    putRightFork.run();
                }
            }
    }
}