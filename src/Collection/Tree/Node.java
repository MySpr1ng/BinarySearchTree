package Collection.Tree;



/**
 * Created by Spring on 15.12.2017.
 */
public class Node<E extends Comparable> implements Comparable<Node<E>> {

    private E element;
    private Node<E> left;
    private Node<E> right;

    public Node(E element) {
        this.element = element;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public void nodeDisplay(){
        System.out.println(getElement());
    }

    public Node<E> getRight() {
        return right;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    @Override
    public String toString() {
        return element.toString();
    }

    @Override
    public int compareTo(Node<E> o) {

        return  getElement().compareTo(o.getElement());
    }


}
