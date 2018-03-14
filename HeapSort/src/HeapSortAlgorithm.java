class HeapSortAlgorithm {
    void sort(int a[]) {
        int length = a.length;
        for (int k = length / 2; k > 0; k--) downheap(a, k, length);
        do {
            int T = a[0];
            a[0] = a[length - 1];
            a[length - 1] = T;
            length--;
            downheap(a, 1, length);
        } while (length > 1);
    }

    private void downheap(int a[], int k, int length) {
        int T = a[k - 1];
        while (k <= length / 2) {
            int j = k + k;
            if ((j < length) && (a[j - 1] < a[j])) {
                j++;
            }
            if (T >= a[j - 1]) {
                break;
            } else {
                a[k - 1] = a[j - 1];
                k = j;
            }
        }
        a[k - 1] = T;
    }
}