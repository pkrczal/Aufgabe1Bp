public class ThreadKlasse extends Thread {

    private final Hilfszahl hZ;

    public ThreadKlasse(String name, Hilfszahl hZ) {
        super(name);
        this.hZ = hZ;
    }

    public void run() {
        System.out.println("Wird gestartet: " + getName());
        synchronized (hZ) {
            System.out.println(getName() + " lädt Zahl aus Hilfszahl");
            System.out.println("Geladene Zahl: " + hZ.getZahl());
            //Wert erhöhen
            int increment = hZ.getZahl() + 1;
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread: " + getName() + " hat geladene Zahl um eins erhöht.");
            System.out.println("Neue Zahl: " + increment);
            hZ.setZahl(increment);
            System.out.println("Thread: " + getName() + " hat die Zahl (" + increment + ") zurückgeschrieben");
        }
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
