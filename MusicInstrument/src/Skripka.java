public class Skripka extends MusicalInstrument implements MusicInterface {
    Skripka() {
        super.price = 2000;
    }

    @Override
    public void song() {
        System.out.println("ТруньТрунь");
    }

    @Override
    public void appearance() {
        System.out.println("Красивая скрипка");
    }

    public String toString() {
        this.song();
        this.appearance();
        return String.valueOf(price)+" - цена";
    }
}
