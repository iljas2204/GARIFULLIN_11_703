public class HeapSortClass {
    private int count;
    private int helper;
    int[] arrayInt;

    HeapSort[] tree(int[] arrayInt) {
        count = arrayInt.length;
        HeapSort[] array = new HeapSort[count];
        int k = 1;
        for (int i = 0; i < arrayInt.length; i++) {
            array[i] = new HeapSort();
            array[i].value = arrayInt[i];
        }
        for (int i = 0; i < array.length / 2; i++) {
            array[i].nextElement1 = array[k];
            k++;
            array[i].nextElement2 = array[k];
            k++;
        }
        return array;
    }

    int[] sort(HeapSort[] array) {
        int valueElement;
        for (int i = array.length / 2; i >= 0; i--) {
            HeapSort t = array[i];
            while (t.nextElement1 != null) {
                if (t.nextElement1.value > array[i].nextElement2.value) {
                    valueElement = t.value;
                    t.value = t.nextElement1.value;
                    t.nextElement1.value = valueElement;
                    t = t.nextElement1;
                } else {
                    valueElement = t.value;
                    t.value = t.nextElement2.value;
                    t.nextElement2.value = valueElement;
                    t = t.nextElement2;
                }
            }
        }
        int[] arrayInt = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {

        }
        return arrayInt;
    }
}
