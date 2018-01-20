package Collection.Tree;

import Collection.Tree.Comparat.TreeInterface;
/**
 * Created by Spring on 15.12.2017.
 */
public class Tree<E extends Comparable> implements TreeInterface<E> {


    private Node<E> root;

    private  Tree(E value){
        root = new Node<E>(value);
    }

    private  Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<E>(element);
        if (root == null) {
            root = newNode;
        }
        else {
            recursiveInsert(root, newNode);
        }
    }

    private  void recursiveInsert(Node<E> current, Node<E> newNode){
        if((current.compareTo(newNode) < 0) && current.getRight()==null){
            current.setRight(newNode);
        }
        else if((current.compareTo(newNode) < 0) && current.getRight()!=null) {
            recursiveInsert(current.getRight(), newNode);
        }

        else if((current.compareTo(newNode) > 0) && current.getLeft()==null){
            current.setLeft(newNode);
        }
        else if((current.compareTo(newNode) > 0) && current.getLeft()!=null) {
            recursiveInsert(current.getLeft(), newNode);
        }
    }

    private boolean isEmpty(){

        return getRoot() == null;

    }

    @Override
    public void display() {

        if (!isEmpty()) {
            Node<E> root = getRoot();
            System.out.println(root.getElement());
            recursiveDisplay(root);
        }
    }

    private void recursiveDisplay(Node<E> current){

        Node<E> leftNode = current.getLeft();
        Node<E> rightNode = current.getRight();

        if(leftNode !=null){
            leftNode.nodeDisplay();
            recursiveDisplay(leftNode);
        }
        if(rightNode !=null){
            rightNode.nodeDisplay();
            recursiveDisplay(rightNode);
        }
    }

    @Override
    public boolean contains(E element) {

        Node<E> root = getRoot();
        Node<E> nodeToFind = new Node<E>(element);

            return recursiveFind(root, nodeToFind)!= null;

    }

    public Node<E> recursiveFind(Node<E> current, Node<E> nodeToCompare){

        if(current!=null) {

            if (current.compareTo(nodeToCompare) == 0)
                return current;

            else if (current.compareTo(nodeToCompare) > 0)
                return recursiveFind(current.getLeft(), nodeToCompare);

            else if (current.compareTo(nodeToCompare) < 0)
                return recursiveFind(current.getRight(), nodeToCompare);

        }

        return  null;
    }

    @Override
    public boolean delete(E element) {

        Node<E> nodeToDelete = recursiveFind(root, new Node<E>(element));
        Node<E> nodeParent = findParentOfDelete(root, nodeToDelete);
        Node<E> tempLeft = nodeToDelete.getLeft();
        Node<E> tempRight = nodeToDelete.getRight();

        if(root.getLeft() == null && root.getRight() == null && root.getElement() == element){
            root = null;
            return true;
        }
        // удаляемый нод без сынов.
        else if(tempLeft == null && tempRight == null) {
            if(nodeParent.getLeft()!= null){
                nodeParent.setRight(null);
            }
            else if(nodeParent.getRight()!=null) {
                nodeParent.setLeft(null);
            }
        }
            // один сын у удаляемого нода.
         else if ((tempLeft != null && tempRight == null) || (tempLeft == null && tempRight != null)){ // найти свапера в одной ветке

            if(tempLeft != null){
                nodeParent.setLeft(tempLeft);
                return true;
            }
            else {

                nodeParent.setRight(tempRight);
                return true;
            }
        }
         // два сына у удаляемого нода.
        else if (tempLeft != null && tempRight != null) {

            Node<E> nodeToSwap = findMostLeft(nodeToDelete);  // если есть дети у свапа, нужно переопределить ссылки.
            Node<E> nodeParentSwap = findParentOfDelete(nodeParent, nodeToSwap);
            nodeToDelete.setElement(nodeToSwap.getElement());
            if(nodeParentSwap.getRight().getElement() == nodeToDelete.getElement()) {
                nodeParentSwap.setRight(nodeToSwap.getLeft());
            }
            else nodeParentSwap.setLeft(nodeToSwap.getRight());
        }

        return false;
    }
        //метод вернет ссылку на Node предка удаляемого элемента, который на него ссылается через Node.left || Node.right
    private Node<E> findParentOfDelete(Node<E> current, Node<E> nodeToDelete){

        Node<E> parent;

        if(nodeToDelete == root){
            return parent = root;
        }
        else {

            if (current.compareTo(nodeToDelete) > 0 && current.getLeft().compareTo(nodeToDelete) != 0) {
                return findParentOfDelete(current.getLeft(), nodeToDelete);
            } else if (current.compareTo(nodeToDelete) > 0 && current.getLeft().compareTo(nodeToDelete) == 0) {
                return parent = current;
            } else if (current.compareTo(nodeToDelete) < 0 && current.getRight().compareTo(nodeToDelete) == 0) {
                return parent = current;
            } else if (current.compareTo(nodeToDelete) < 0 && current.getRight().compareTo(nodeToDelete) != 0) {
                return findParentOfDelete(current.getRight(), nodeToDelete);
            }
        }
        return null;
    }
        // вернет нод, который самый малый в правой половине и подходить для свапа.
    private Node<E> findMostLeft(Node<E> nodeToDelete){

        Node<E> node = nodeToDelete.getRight();

        while(node.getLeft() != null){

            node = node.getLeft();
        }

        return node;
    }
        }

