public class SomeThread extends Thread {
    int [] arr;
    int summArr = 0;
    static int firstNum = 0;
    int secondNum = 0;

    public SomeThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = firstNum; i <secondNum ; i++) {
            summArr += arr[i];
        }
        firstNum = secondNum;
    }
}
