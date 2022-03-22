import java.util.ArrayList;
import java.util.Comparator;            //classe che serve per fare il confronto

/*
* This class maintains the elements inserted according to a criterium specified at creation time
* @param T : Type of elements in the array
* */

public class OrderedArray <T> {
    private ArrayList <T> array = null;
    private Comparator <? super T> comparator = null;

    /*
    Creates an empty Ordered Array
    takes a Comparator as input
    @author gtessore
    @param comparator :
    @throws: OrderedArrayException
     */
    public OrderedArray(Comparator <? super T> comparator) throws OrderedArrayException {
        if(comparator == null) {
            throw new OrderedArrayException("null comparator received in constructor");
        }
        this.array = new ArrayList<>();
        this.comparator = comparator;
    }
    /*
    @return True iff this ordered array is empty
     */
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    /*
    @return the number of elements currently in this ordered array
     */
    public int size(){
        return this.array.size();
    }

    /*
    @return the element at specified index (starting from 0)
    @throws OrderedArrayException
     */
    public T get(int index) throws OrderedArrayException {
        if(index<0 || index>=this.size()){
            throw new OrderedArrayException("OrderedArray.get: received index out of bounds (<0 or >size)");
        }
        return this.array.get(index);
    }
}
