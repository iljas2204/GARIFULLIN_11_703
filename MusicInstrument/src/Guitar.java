public class Guitar extends MusicalInstrument implements MusicInterface {
    Guitar() {
        super.price = 2000;
    }

    @Override
    public void song() {
        System.out.println("БрыньБрынь");
    }

    @Override
    public void appearance() {
        System.out.println("Красивая гитара");
    }

    public String toString() {
        this.song();
        this.appearance();
        return String.valueOf(price)+" - цена";
    }
}
