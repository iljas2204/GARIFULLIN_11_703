public class Piano extends MusicalInstrument {
    Piano() {
        super.price = 1000;
        super.name = "Piano2.0";
        super.music = "trun";
    }

    public String toString() {
        return this.music+" "+"Название="+name+" "+"Цена="+price;
    }
}