public class Skripka extends MusicalInstrument {
    Skripka() {
        super.price = 2000;
        super.name = "Skripka";
        super.music = "truntruntrun";
    }

    public String toString() {
        return this.music+" "+"Название="+name+" "+"Цена="+price;
    }
}
