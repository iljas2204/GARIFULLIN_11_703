public class Journals extends PrintedEdtiton {
    String year;
    protected Journals(String name,String year) {
        super(name);
        this.year=year;
    }
    protected void fulltype(){
        System.out.println("name: "+name);
        System.out.println("year: "+year);
    }
}
