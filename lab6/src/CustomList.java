import java.util.AbstractList;
import java.util.Iterator;

public class CustomList <Type> extends AbstractList<Type> {


    private Node root;
    private Node last;
    class Node{
        public Type value;
        public Node next;

        public Node(Type value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public CustomList() {
        root = null;
        last = null;
    }

    @Override
    public int size() {
        Node current = root;
        int size = 0;
        while (current != null){
            current = current.next;
            size++;
        }
        return size;
    }

    @Override
    public Type get(int i) {
        if (i > size()){
            throw new RuntimeException("position bigger than size");
        }
        int pos = 0;
        Node curr = root;
        while (pos < i){
            curr = curr.next;
            pos++;
        }
        return curr.value;
    }
    @Override
    public boolean add(Type newValue){
        addLast(newValue);
        return true;
    }


    public void addLast(Type value){
        Node newNode = new Node(value, null);
        if(last == null){
            this.root = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
    }
    public Type getLast(){
        return last.value;
    }

    public void addFirst(Type newValue){
        Node newNode = new Node(newValue, null);
        if(root == null){
            this.root = newNode;
            this.last = newNode;
        }else{
            newNode.next = root;
            this.root = newNode;
        }
    }

    public Type getFirst(){
        return root.value;
    }

    public Type removeFirst() {
        Node oldRoot = this.root;
        this.root = oldRoot.next;
        return oldRoot.value;
    }

    public Type removeLast() {
        if (this.root == null) {
            throw new RuntimeException("Empty list removal");
        } else if (this.root == this.last) {
            Node temp = this.root;
            this.root = null;
            this.last = null;
            return temp.value;
        }
        Node oldLast = this.last;
        Node beforeLast = this.root;
        while (beforeLast.next != this.last) {
            beforeLast = beforeLast.next;
        }
        beforeLast.next = null;
        this.last = beforeLast;
        return oldLast.value;
    }

    public Iterator<Type> iterator(){
       return new Iterator<Type>() {
           Node current = root;
           @Override
           public boolean hasNext() {
               if(current==null){
                   return false;
               }
               return current.next != null;
           }

           @Override
           public Type next() {
               Type previous = current.value;
               current = current.next;
               return previous;
           }
       };


    }


}
