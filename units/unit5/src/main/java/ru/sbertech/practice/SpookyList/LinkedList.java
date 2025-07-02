package ru.sbertech.practice.SpookyList;


public class LinkedList {

    private Node root = null;
    private int size = 0;

    public LinkedList() {}


    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("List index out of range");
        }
    }


    /**
     * @param data Добавляемый объект
     */
    public void add(Object data) {
        Node addedNode = new Node(data);
        Node currentNode;


        // Если список пустой
        if (root == null) {
            root = addedNode;

        // Если список не пустой
        } else {
            currentNode = root;

            // Перемещаемся до конца списка
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = addedNode;
        }

        size += 1;
    }



    public Object get(int index) {
        checkIndex(index);

        Node currentNode = this.root;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }


    public void insert(int index, Object data) throws IndexOutOfBoundsException {
        checkIndex(index);


        Node addedNode = new Node(data);
        Node currentNode;

        // Вставка в начало
        if (index == 0) {
            addedNode.next = this.root;
            this.root = addedNode;
        } else {
            
        }
    }
}
