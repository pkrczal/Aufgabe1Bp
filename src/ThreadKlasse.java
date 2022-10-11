public class ThreadKlasse extends Thread {

    private final Hilfszahl hZ;
    private Semaphor mutex;

    public ThreadKlasse(String name, Hilfszahl hZ, Semaphor mutex) {
        super(name);
        this.mutex = mutex;
        this.hZ = hZ;
        System.out.println("Wird gestartet: " + getName());
        start();
    }

    public void run() {
        while (true) {
            mutex.p();
            //Anweisungen in der kritischen Region
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
            mutex.v();
        }


    }

}
