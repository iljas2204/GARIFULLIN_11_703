public class Books extends PrintedEdtiton {
    public String author;
    protected Books(String author, String name){
        super(name);
        this.author=author;
    }
    protected void fulltype(){
        System.out.println("name: "+name);
        System.out.println("authors: "+author);
    }
}
