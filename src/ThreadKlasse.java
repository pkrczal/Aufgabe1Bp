public class ThreadKlasse extends Thread {

    private final Hilfszahl hZ;

    public ThreadKlasse(String name, Hilfszahl hZ) {
        super(name);
        this.hZ = hZ;
    }

    public void run() {
        System.out.println("Wird gestartet: " + getName());
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hZ.setZahl(getName());
    }


    public static void main(String[] args) {
        Hilfszahl hZ = new Hilfszahl();
        ThreadKlasse t1 = new ThreadKlasse("Thread 1", hZ);
        ThreadKlasse t2 = new ThreadKlasse("Thread 2", hZ);
        ThreadKlasse t3 = new ThreadKlasse("Thread 3", hZ);
        t1.start();
        t2.start();
        t3.start();
    }
}
