public class Magazins extends PrintedEdtiton {
    String date;
    public Magazins(String name,String date) {
        super(name);
        this.date=date;
    }
    protected void fulltype(){
        System.out.println("name: "+name);
        System.out.println("date: "+date);
    }
}
