public class HeapSort {
    int value;
    HeapSort nextElement1;
    HeapSort nextElement2;
    int point;

    HeapSort(int value, HeapSort nextElement1, HeapSort nextElement2 , int point) {
        this.value = value;
        this.nextElement1 = nextElement1;
        this.nextElement2 = nextElement2;
        this.point = point;
    }
}
