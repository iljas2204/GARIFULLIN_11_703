public class Guitar extends MusicalInstrument {
    Guitar() {
        super.price = 2000;
        super.name = "Guitar1.0";
        super.music = "truntrun";
    }

    public String toString() {
        return this.music+" "+"Название="+name+" "+"Цена="+price;
    }
}
