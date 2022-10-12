public class Main {

    public static void main(String[] args) {
        Hilfszahl hZ = new Hilfszahl();
        Semaphor s = new Semaphor(1);
        ThreadKlasse t1 = new ThreadKlasse("Thread 1", hZ, s);
        ThreadKlasse t2 = new ThreadKlasse("Thread 2", hZ, s);
        ThreadKlasse t3 = new ThreadKlasse("Thread 3", hZ, s);
    }
}
