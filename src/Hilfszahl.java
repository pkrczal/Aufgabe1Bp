public class Hilfszahl {

    private int zahl;

    public Hilfszahl() {
        this.zahl = 0;
    }

    //Wert lesen
    int getZahl() {
        return zahl;
    }

    //Wert schreiben
    public synchronized void setZahl(String name) {
        System.out.println();
        System.out.println("Thread: " + name);
        System.out.println("Zahl vorher: " + zahl);
        this.zahl++;
        System.out.println("Zahl nachher: " + zahl);
    }
}
