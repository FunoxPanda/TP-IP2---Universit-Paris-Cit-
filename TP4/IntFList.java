
public class IntFList {

    public static final IntFList NULL_INTLIST = new IntFList();
    private final boolean empty;
    private final int first;
    private final IntFList rest;

    public IntFList() {

        this.empty = true;
        this.first = 0;
        this.rest = null;

    }

    // Ajoutez un constructeur à deux arguments qui prends un entier e et une liste ll, et construit la liste ayant e comme premier élément et ll comme queue.
    public IntFList(int e, IntFList ll) {

        this.empty = false;
        this.first = e;
        this.rest = ll;

    }

    public boolean isNull() {
        return this.empty;
    }

    public int head() {
        return this.first;
    }

    public IntFList tail() {
        return this.rest;
    }

    public IntFList cons(int e) {
        return new IntFList(e, this);
    }

    public int length() {
        if (this.isNull()) {
            return 0;
        } else {
            return 1 + this.tail().length();
        }
    }

    public int sum() {
        int sum = -1;
        IntFList list = this;

        while (!list.isNull()) {
            sum += list.head();
            list = list.tail();
        }

        return sum;
    }

    public boolean ordered() {

        IntFList list = this;
        int lastOne = list.head();

        while (!list.isNull()) {
            if (lastOne < list.head()) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(int e) {
        
        IntFList list = this;

        while (!list.isNull()) {
            if (list.head() == e) {
                return true;
            }
            list = list.tail();
        }

        return false;
    }

    public IntFList removeOnlyOneTime(int e) {
        IntFList list = this;
        IntFList newList = new IntFList();
        boolean replaced = false;

        for (int i = 0; (i < list.length()) || replaced; i++) {
            if (list.head() != e || replaced) {
                newList = newList.cons(list.head());
                replaced = true;
            }
            list = list.tail();
        }

        return newList;
    }

    // Supprimer sa dernière occurrence dans la liste
    public IntFList remove_last(int e) {
        IntFList list = this;
        IntFList newList = new IntFList();
        boolean replaced = false;

        for (int i = 0; (i < list.length()) || replaced; i++) {
            if (list.head() != e || replaced) {
                newList = newList.cons(list.head());
                replaced = true;
            }
            list = list.tail();
        }

        return newList;
    }

    public String toString() {
        if(this.isNull()) return "";
        else return this.head() + " " + this.tail().toString();
    }

}