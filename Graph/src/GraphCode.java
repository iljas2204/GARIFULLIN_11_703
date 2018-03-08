import java.util.ArrayList;

public class GraphCode {
    private int count;

    public int getCount() {
        return count;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
    
    public int[][] getMatrix() {
        return matrix;
    }

    private static class Node {
        int first;
        int second;
        Node next;

        Node(int i, int j) {
            this.first = i;
            this.second = j;
        }
    }

    private Node head;
    private Node tail;

    public int[][] matrix;

    public GraphCode() {
        this.count = 0;
    }

    public void insert(int i, int j) {
        Node newNode = new Node(i, j);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    public void delete(int i, int j) {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        if (head.first == i && head.second == j) {
            head = head.next;
            return;
        }

        Node del = head;
        while (del != null) {
            if (del.next.first == i && del.next.second == j) {
                if (tail == del.next) {
                    tail = del;
                }
                del.next = del.next.next;
                count--;
                return;
            }
            del = del.next;
        }
    }

    public void GraphCode(int[][] mi) {
        matrix = mi;
        int n = mi.length;
        int m = mi[0].length;

        int one;
        int two;
        for (int i = 0; i < n; i++) {
            one = 0;
            two = 0;
            for (int j = 0; j < m; j++) {
                if (mi[i][j] == 1 && one == 0) {
                    one = j + 1;
                }
                if (mi[i][j] == 1 && one != 0) {
                    two = j + 1;
                }
            }
            insert(one, two);
        }
    }

    public void GraphCode(int i) {
        Node iTop = head;
        int k = 0;
        while (iTop != null) {
            if (iTop.first == i || iTop.second == i) {
                System.out.print("(" + iTop.first + "," + iTop.second + ")");
            }
            k++;
            iTop = iTop.next;
        }
    }

    int[][] getMI() {
        Node mat = head;
        int max = 0;
        while (mat != null) {
            if (mat.second > max) {
                max = mat.second;
            }
            mat = mat.next;
        }

        int[][] matrixI = new int[count][max];
        Node mat1 = head;
        for (int i = 0; i < matrixI.length; i++) {
            for (int j = 0; j < matrixI[0].length; j++) {
                if (mat1.first == j + 1) {
                    matrixI[i][j] = 1;
                }
                if (mat1.second == j + 1) {
                    matrixI[i][j] = 1;
                }
                System.out.print(matrixI[i][j] + " ");
            }
            mat1 = mat1.next;
            System.out.println();
        }
        return matrixI;
    }

    ArrayList<Integer> show(int m) {
        int k;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < matrix.length; i++) {
            k = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    k++;
                }
            }
            if (k > m) {
                arrayList.add(i + 1);
            }
        }
        return arrayList;
    }

    void modify(int i) {
        Node mod = head;
        while (mod != null) {
            if (mod.second == i || mod.first == i) {
                delete(mod.first, mod.second);
            }
            mod = mod.next;
        }
    }


}
