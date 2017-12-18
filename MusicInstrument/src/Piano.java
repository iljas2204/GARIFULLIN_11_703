public class Piano extends MusicalInstrument implements MusicInterface {
    Piano() {
        super.price = 1000;
    }

    @Override
    public void song() {
        System.out.println("ТыньТынь");
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