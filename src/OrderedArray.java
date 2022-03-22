import java.util.ArrayList;
import java.util.Comparator;            //classe che serve per fare il confronto

/*
* This class maintains the elements inserted according to a criterium specified at creation time
* @param T : Type of elements in the array
* */

public class OrderedArray <T> {
    ArrayList <T> array = null;
    Comparator <? super T> comparator = null;           //si inizializza a null

    public OrderedArray() {
    }
}
