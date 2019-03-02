package semestr3.Pr8;

import java.util.*;

public class DoubleList implements Collection<Item>, Iterable<Item>{

    @Override
    public int size() {
        int counter = 0;
        if(isEmpty()){
            return 0;
        }
        Node node = head;
        while(node != head.prev){
            counter++;
            node = node.next;
        }
        return ++counter;
    }

    @Override
    public Object[] toArray() {
        if(isEmpty()){
            return new Object[0];
        }
        MyIterator iterator = new MyIterator();
        ArrayList<Item> list = new ArrayList<>(size());
        do{
            list.add(iterator.next());
        }while(iterator.hasNext());
        return list.toArray();
    }

    @Override
    public boolean contains(Object o) {
        if(isEmpty()){
            return false;
        }
        MyIterator iterator = new MyIterator();
        do{
            if(iterator.next().getName().equals(((Item)o).getName())){
                return true;
            }
        }while(iterator.hasNext());
        return false;

    }
    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }
    public ListIterator<Item> listIterator(){
        return new MyIterator();
    }

    @Override
    public <Item> Item[] toArray(Item[] a){

        return null;
    }
    private boolean removeByNode(Node node){
        if(isEmpty()){
            return false;
        }
        if(size() == 1 && head.equals(node)){
            head = null;
            return true;
        }

        node.next.prev = node.prev;
        node.prev.next = node.next;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(isEmpty()){
            return false;
        }
        MyIterator iterator = new MyIterator();
        do{
            if(iterator.next().equals(o)){
                iterator.remove();
                return true;
            }
        }while(iterator.hasNext());
        return false;
    }
    public boolean removeByName(String name){ //FIX
        MyIterator it = new MyIterator();
        if(isEmpty()){
            return false;
        }
        do{
            if(it.previous().getName().equals(name)){
                it.remove();
                return true;
            }
        }while(it.hasPrevious());
        return false;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator it = c.iterator();
        while(it.hasNext()){
            if(!contains(it.next())){
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean addAll(Collection<? extends Item> c) {
        Iterator it = c.iterator();
        boolean flag = false;
        while(it.hasNext()){
            add((Item)it.next());
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Node node = head;
        if(isEmpty()){
            return false;
        }
        while(node != head.prev && !isEmpty()){
            if(c.contains(node.data)){
                remove(node.data);
                node = head;
            }
            node = node.next;
        }
        if(c.contains(node.data)){
            remove(node.data);
            node = head;
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) { //Unchecked May contain errors
        Node node = head;
        if(isEmpty()){
            return  false;
        }
        boolean flag = false;
        while(node != head.prev && !isEmpty()){
            if(!c.contains(node.data)){
                remove(node.data);
                node = head;
                flag = true;
            }else{
                node = node.next;
            }
        }
        return flag;
    }

    @Override
    public void clear() {
        if(isEmpty()){
            return;
        }
        while(!isEmpty()){
            removeByNode(head.prev);
        }
    }


    private Node head;
    private Node createNewNode(Item data, Node next, Node prev){
        Node node = new Node();
        node.data = data;
        node.next = next;
        node.prev = prev;
        return node;
    }


    public boolean isEmpty(){
        if(head == null)
            return  true;
        else
            return false;
    }
    public boolean add(Item data){

        if(isEmpty()){
            head = createNewNode(data, null, null);
            head.prev = head;
            head.next = head;
        }else{
            Node last =  createNewNode(data, head, head.prev);
            head.prev.next = last;
            head.prev = last;
        }
        return true;
    }

    public DoubleList() {
        head = null;
    }
    public DoubleList(Collection<Item> c){
        Item[] items = (Item[])c.toArray();
        for(int i = 0; i < items.length; i++){
            add(items[i]);
        }
    }

    @Override
    public String toString() {
        Node node = head;
        if(isEmpty()){
            return "none";
        }
        String string = "";
        MyIterator it = new MyIterator();
        do{
            string += it.next().getName() + " ";
        }while(it.hasNext());
        return string;
    }
    private class Node{
        public Item data;
        public Node next;
        public Node prev;
    }
    private class MyIterator implements ListIterator<Item>{
        private Node nextNode;
        private Node lastReturned;

        public MyIterator(){
            if(isEmpty()){
                nextNode = null;
                lastReturned = null;
            }else{
                nextNode = head;
                lastReturned = nextNode;
            }
        }
        @Override
        public boolean hasNext(){
            if(isEmpty()){
                return false;
            }
            updateIteratorPointer();
            return nextNode != head;
        }

        @Override
        public Item next(){
            if(isEmpty()){
                return null;
            }
            updateIteratorPointer();
            lastReturned = nextNode;
            Item data = nextNode.data;
            nextNode = nextNode.next;
            return data;
        }

        @Override
        public boolean hasPrevious() {
            if(isEmpty()){
                return false;
            }
            updateIteratorPointer();
            return nextNode.prev != head.prev;
        }

        @Override
        public Item previous() {//Fix!!!
            updateIteratorPointer();
            if(isEmpty()){
                return null;
            }


            lastReturned = nextNode.prev;
            Item data = nextNode.data;
            nextNode = nextNode.prev;
            return data;
        }

        @Override
        public int nextIndex() {
            return -1;
        }

        @Override
        public int previousIndex() {
            return - 1;
        }

        @Override
        public void remove() {
            updateIteratorPointer();
            if(lastReturned == nextNode){
                nextNode = nextNode.next;
            }else{
                nextNode = nextNode.prev;
            }
            if(lastReturned == head){
                head = nextNode;
            }
            lastReturned.next.prev = lastReturned.prev;
            lastReturned.prev.next = lastReturned.next;
            lastReturned = nextNode;
        }

        @Override
        public void set(Item item) {
            lastReturned.data = item;
        }

        @Override
        public void add(Item item) {

            if(isEmpty()){
                DoubleList.this.add(item);
                return;
            }
            updateIteratorPointer();

            Node node = createNewNode(item, nextNode, nextNode.prev);
            nextNode.prev.next = node;
            nextNode.prev = node;
        }
        public void updateIteratorPointer(){
            if(isEmpty()){
                nextNode = null;
                lastReturned = null;
            }else if(nextNode == null){
                nextNode = head;
                lastReturned = head;
            }
        }
    }







}
