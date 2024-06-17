package DoubleLinkedList;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    //Create a DLL
    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }


    //insert into a DLL
    //0. If link list doesn't
    //1. inserting at the begining
    //2. Inserting at the ending
    //3. Insert anywhere

    public void  insertDLL (int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if(head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = tail;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    //Traverse a Linked List
    public void traverseDLL(){
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size -1) {
                    System.out.print(" <->");

                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    // Reverse Traverse
    public void reverseTraverseDLL() {
        if (tail == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = tail;
            for (int i = size - 1; i >= 0; i--) {
                System.out.print(tempNode.value);
                if (i != 0) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.prev;
            }
        }
        System.out.print("\n");
    }

    // Search Node
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            DoublyNode tempNode = head;
            while (tempNode != null) {
                if (tempNode.value == nodeValue) {
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    // Deletion Method
    public void deleteNodeDLL(int location) {
        if (head == null) {
            System.out.println("The DLL does not exist");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head = tail = null;
                size = 0;
                return;
            } else {
                head = head.next;
                head.prev = null;
                size--;
            }
        } else if (location >= size) {
            if (size == 1) {
                head = tail = null;
                size = 0;
                return;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }
    // Delete entire DLL
    public void deleteEntireDLL() {
        DoublyNode tempNode = head;
        while (tempNode != null) {
            DoublyNode nextNode = tempNode.next;
            tempNode.prev = null;
            tempNode.next = null;
            tempNode = nextNode;
        }
        head = tail = null;
        System.out.println("The DLL has been deleted");
    }





}
