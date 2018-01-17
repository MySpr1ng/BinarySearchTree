package Tree.Comparat;

import Tree.Node;

/**
 * Created by Spring on 16.12.2017.
 */
public class TreeTesting<E extends Comparable<E>> implements Collection<E>, Comparable<Node<E>>  {

    Node<E> root;

    public TreeTesting(E element){
        root = new Node<E>(element);
    }

    public Node<E> getRoot() {
        return root;
    }

    @Override
    public void insert(E value) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public boolean delete(E element) {
        return false;
    }

    @Override
    public void display() {

    }

    @Override
    public int compareTo(Node<E> o) {
        return root.compareTo(o);
    }
}
