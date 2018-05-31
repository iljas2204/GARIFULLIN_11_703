import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] array1 = {1,2,5,3,6,4};
        int [] array2 = {1,4,5,7};

        MyLinkedList2 list1 = new MyLinkedList2(array1);
        MyLinkedList2 list2 = new MyLinkedList2(array2);
        list1.sort();
    }
}
