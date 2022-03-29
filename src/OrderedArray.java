import java.util.ArrayList;
import java.util.Comparator;            //classe che serve per fare il confronto

/*
* This class maintains the elements inserted according to a criterium specified at creation time
* @param T : Type of elements in the array
* */

public class OrderedArray <T> {
    ArrayList <T> array;
    Comparator <? super T> comparator;

    /*
    Creates an empty Ordered Array
    takes a Comparator as input
    @author gtessore
    @param comparator :
    @throws: OrderedArrayException
     */
    public OrderedArray(Comparator <? super T> comparator) throws OrderedArrayException {
        if(comparator == null)
            throw new OrderedArrayException("null comparator received in constructor");
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
    public T getElementAt(int index) throws OrderedArrayException {
        if(index<0 || index>=this.size())
            throw new OrderedArrayException("OrderedArray.get: received index out of bounds (<0 or >size)");
        return this.array.get(index);
    }

    //+ non deve essere public, solo i servizi che la libreria
    //      offre all'esterno, questo lo fa per aiutare sè stessa
    //+ questo sotto è il commento javadoc, + semplice perchè
    //      non deve andare a chi usa la lib ma a chi la sviluppa,
    //      sempre per questo motivo non devo fare controlli "banali"
    //      tipo controllare che i parametri non siano null perchè
    //      posso assumere che chi lavora alla lib non sia scemo
    //+ i metodi interni non devono lanciare eccezioni, perchè
    //      interrompono il flusso del metodo superiore, e chi usa
    //      il metodo si trova con un'eccezione nata da un metodo
    //      che nemmeno può vedere

    //determines the index at which the element has to be added
    private int getIndexInsert(T element){
        int index = 0;
        boolean cont = true;
        T currEl = null;
        while((index<(this.array).size())&&cont){
            currEl = (this.array).get(index);
            if((this.comparator).compare(element, currEl)<0)
                cont = false;
            else index++;
        }
        return index;
    }

    /*
    insert an element maintaining the ordering of the array
    @param the element to be added
    @throws OrderedArrayException
     */
    public void add(T element) throws OrderedArrayException {
        if(element == null)
            throw new OrderedArrayException("insert: null element cannot be inserted");
        int index = this.getIndexInsert(element);
        this.array.add(index, element);
    }
}
