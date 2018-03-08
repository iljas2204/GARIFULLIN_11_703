public class Main {
    public static void main(String[] args) {
        int [] array = {5,3,2,1,4,6,7,9,8,10,15,14,13,12,11};
        HeapSortClass heapSort = new HeapSortClass();
        heapSort.sort(heapSort.tree(array));
    }
}
