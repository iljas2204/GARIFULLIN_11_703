public class HeapSortClass {
    private int count;
    private int helper;
    int[] arrayInt;

    HeapSort[] tree(int[] arrayInt) {
        count = arrayInt.length;
        HeapSort[] array = new HeapSort[count];
        int k = 0;
        for (int i = 0; i < count / 2; i++) {
            array[i].point = i;
            array[i].value = arrayInt[k];
            k++;
            array[i].nextElement1 = array[k];
            k++;
            array[i].nextElement2 = array[k];
            k++;
        }
        for (int j = count / 2; j < count  ; j++) {
            array[j].point = j;
            array[j].value = arrayInt[k];
        }
        return array;
    }

    int[] sort(HeapSort[] array) {
        count = arrayInt.length;
        for (int i = count / 2 - 1; i >= 0 ; i--) {
            do{
                if(array[i].nextElement1.value > array[i].nextElement2.value){
                    helper = array[i].value;
                    array[i].value = array[i].nextElement1.value;
                    array[i].nextElement1.value = helper;
                }
                else {
                    helper = array[i].value;
                    array[i].value = array[i].nextElement2.value;
                    array[i].nextElement2.value = helper;
                }
            } while (array[i].nextElement1 != null);
        }
        for (int i = count - 1; i >= 0 ; i--) {
            do {//
                if(array[i].nextElement2.point <= i ){
                    helper = array[i].value;
                    array[i].value = array[i].nextElement2.value;
                    array[i].nextElement2.value = helper;
                }
                else {
                    helper = array[i].value;
                    array[i].value = array[i].nextElement1.value;
                    array[i].nextElement1.value = helper;
                }
            } while (array[i].nextElement1 != null);
        }
        for (int i = 0; i < count ; i++) {
            arrayInt[i] = array[i].value;
            System.out.print(arrayInt[i] + " ");
        }
        return arrayInt;
    }
}
