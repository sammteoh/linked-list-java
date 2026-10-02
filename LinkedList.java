package hw7;

public class LinkedList<E> {

    private Node<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return this.data;
        }
    }

    private int size() {
        return this.size;
    }

    private boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void clear() {
        this.head = null;
        this.size = 0;
    }

    private void add(int index, E data) {
        Node<E> n = new Node<>(data, null);

        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        // if the list initially empty
        if (this.size == 1) {
            this.head = n;
        } else {
            Node<E> current = this.head;

            for (int i = 1; i < index; i++) {

                if (current.next == null) {
                    current.next = n;
                }
                current = current.next;
            }

            current.data = data;

        }
    }

    private void add(E data) {
        this.size++;
        this.add(size, data);
    }

    private boolean contains(E Object) {
        Node<E> current = this.head;

        for (int i = 0; i < size; i++) {
            if (current.getData().equals(Object)) {
                return true;
            }

            current = current.next;
        }

        return false;

    }

    private int indexOf(E Object) {
        Node<E> current = this.head;

        for (int i = 0; i < size; i++) {
            if (current.getData().equals(Object)) {
                return i;
            }

            current = current.next;
        }

        return -1;
    }

    private E get(int index) {

        Node<E> current = this.head;

        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {

            current = current.next;

        }

        return current.getData();


    }

    private E remove(int index) {

        Node<E> current = this.head;
        E return_data = null;

        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return_data = current.getData();

            this.head = current.next;

            this.size--;

            return return_data;
        }

        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        this.size--;

        if (current.next.next == null || current.next == null) {
            current.next = null;

            return null;
        } else {
            return_data = current.next.getData();
            
            current.next = current.next.next;
        }

        return return_data;
    }

    private boolean remove(E Object) {
        Node<E> current = this.head;
        int index = 0;

        for (index = 0; index < this.size; index++) {

            if (current.getData().equals(Object)) {
                this.remove(index);

                return true;
            }

            current = current.next;
        }

        return false;
    }

    private E set(int index, E data) {
        Node<E> current = this.head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        E return_data = current.getData();

        current.data = data;

        return return_data;
    }

    public String toString() {
        String return_string = new String();
        Node<E> current = this.head;

        for (int i = 0; i < this.size; i++) {
            return_string += current.getData();

            if (current.next != null) {
                return_string += ", ";
            }

            current = current.next;
        }

        return "[" + return_string + "]";
    }

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.add("Samuel");
        list.add("Cheryl");

        System.out.println("List: " + list);
    }
}
