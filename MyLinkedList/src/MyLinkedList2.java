import javax.swing.text.Segment;
import java.io.FileWriter;
import java.io.IOException;

public class MyLinkedList2 {
    private int count;

    private static class Node {//создаем класс Ноде
        int number;
        Node next;
        Node previous;
        // даем ему поля
        Node(int i) {
            this.number = i;
        }
    }

    private Node head; //Начало списка
    private Node tail; //Конец списка

    MyLinkedList2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);//добавляем элементы в список из массива
        }
    }

    int[] decode() {
        try (FileWriter writer = new FileWriter("C:\\Users\\Iljas\\Desktop", false);) {
            Node decoder = head;
            for (int i = 0; i < count; i++) {
                //выписываем элементы списка в файл
                if (decoder != tail) {
                    writer.write(decoder.number + " ");
                    decoder = decoder.next;
                } else {
                    writer.write(decoder.number + " ");
                }
            }
            writer.close(); // закрытие потока
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;// потому что ничего не надо возвращать
    }

    void insert(int k) {
        //добавление элемента в список
        Node newNode = new Node(k);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.previous = null;
        } else {
            Node tailNode = tail;
            tail.next = newNode;
            tail = newNode;
            tail.previous = tailNode;
        }
        count++;
    }

    void delete(int k) {
        //удаление элемента из списка
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        }
        if (head.number == k) {
            head = head.next;
            return;
        }
        Node deleting = head;
        while (deleting != null) {
            if (deleting.next.number == k) {
                deleting.next = deleting.next.next;
                count--;
                return;
            }
            deleting = deleting.next;
        }
    }

    MyLinkedList2 merge(MyLinkedList2 ll1) {
        //слияние двух упорядоченных списков
        MyLinkedList2 ll2 = MyLinkedList2.this;
        if (head == null) {
            return ll1;
        }
        if (ll1.head == null) {
            return ll2;
        }

        Node ll1node = ll1.head;
        Node ll2node = ll2.head;
        MyLinkedList2 merged = new MyLinkedList2(new int[]{});
        //Сливаем, пока один из списков не кончится
        do {
            if (ll1node.number - ll2node.number < 0) {
                merged.insert(ll1node.number);
                ll1node = ll1node.next;
            } else {
                merged.insert(ll2node.number);
                ll2node = ll2node.next;
            }
        } while (ll1node != null && ll2node != null);
        //Досливаем
        if (ll1node == null) {
            do {
                merged.insert(ll2node.number);
                ll2node = ll2node.next;
            }
            while (ll2node != null);
        } else {
            do {
                merged.insert(ll1node.number);
                ll1node = ll1node.next;
            }
            while (ll1node != null);
        }
        return merged;
    }

    int maxNum() {
        //поиск максимального повтора элемента в списке
        int thisnum = head.number;
        int allmax = 1;
        int nowmax = 1;

        Node the = head;
        while (the.next != null) {
            if (the.next.number == thisnum) {
                nowmax++;
            } else {
                thisnum = the.next.number;
                if (allmax < nowmax) {
                    allmax = nowmax;
                    nowmax = 1;
                }
            }
            the = the.next;
        }

        return allmax;
    }

    MyLinkedList2[] devide() {
        //разделение на два списка, где один содержит элементы, которые делятся на 3
        //а другой остальные элементы

        MyLinkedList2 list1 = new MyLinkedList2(new int[]{});
        MyLinkedList2 list2 = new MyLinkedList2(new int[]{});
        MyLinkedList2[] arrList = new MyLinkedList2[2];
        Node list1node = this.head;
        do {
            if (list1node.number % 3 == 0) {
                list2.insert(list1node.number);
            } else {
                list1.insert(list1node.number);
            }
        }
        while (list1node.next != null);
        return arrList;
    }

    MyLinkedList2 newList() {
        //создание нового списка
        MyLinkedList2 list = new MyLinkedList2(new int[]{});
        Node tailN = tail;
        Node headN = head;
        do {
            list.insert(tailN.number * headN.number);
            headN = headN.next;
            tailN = tailN.previous;
        }
        while (headN.next != null);
        return list;
    }

    public void sort() {
        Node current = head;
        Node following = head.next;
        while (current != null) {
            while (following != null) {
                if (current.number > following.number) {
                    Node t = current;
                    current = following;
                    following = t;
                    current.next = following.next;
                    following.next = current;
                }
                following=following.next;
            }
            head = following;
            following=following.next;
        }
    }
}
