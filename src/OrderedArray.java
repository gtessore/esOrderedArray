import java.util.ArrayList;
import java.util.Comparator;            //classe che serve per fare il confronto

/*
* This class maintains the elements inserted according to a criterium specified at creation time
* @param T : Type of elements in the array
* */

public class OrderedArray <T> {
    ArrayList <T> array = null;
    Comparator <? super T> comparator = null;

    /*
    Creates an empty Ordered Array
    takes a Comparator as input

     */
    public OrderedArray(Comparator <? super T> comparator) throws OrderedArrayException {
        if(comparator == null) {
            throw new OrderedArrayException("null comparator received in constructor");
        }
        this.array = new ArrayList<>();
        this.comparator = comparator;

    }
}
