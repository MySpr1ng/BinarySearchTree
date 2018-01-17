package Tree.Comparat;

/**
 * Created by Spring on 16.12.2017.
 */
public interface Collection <E>{

    public void insert(E element );

    public boolean contains(E element);

    public boolean delete(E element );

    public void display();

}
