package nkher.datastructures.trees;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * Created by nameshkher on 6/11/16.
 */
public class HashedArrayTree<T>  extends AbstractList<T> {

    private static final int minParentArraySize = 2;
    private T[][] data;
    private int size = 0;
    private int logSize = 0;

    public HashedArrayTree() {
        data = (T[][]) new Object[minParentArraySize][]; // topmost array
    }

    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T element) {

        if (size() == data.length * data.length)
            grow();

        /* Compute the array, index pair for the next position */
        int offset = computeOffset(size());
        int index = computeIndex(size());

        if (data[offset] == null)
            data[offset] = (T[]) new Object[data.length];

        /* Write the element to its location */
        data[offset][index] = element;

        ++size;

        return true;
    }

    @Override
    public T set(int index, T element) {

        int offset = computeOffset(index);
        int arrIndex = computeIndex(index);

        T result = data[offset][arrIndex];
        data[offset][arrIndex] = element;

        return element;
    }

    @Override
    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + ", size " + size());
        }

        return data[computeOffset(index)][computeIndex(index)];
    }

    @Override
    public void add(int index, T element) {

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + ", size " + size());
        }

        /* Add a dummy element to ensure that everything resizes correctly. There's no reason to repeat the logic. */
        add(null);

        for (int i=size(); i<index; ++i) {
            set(i, get(i-1));
        }

        set(index, element);
    }

    @Override
    public T remove(int index) {

        T result = get(index);

        /* Naive shuffle down algorithm to reposition elements after the removed one. */
        for (int i=index+1; i<size(); ++i)
            set(i-1, get(i));

        /* Clobber the last element to play nicely with the garbage collector */
        set(size()-1, null);

        --size;

        /* If we are now at 1/8 total capacity, shrink the structure. */
        if (size() * 8 <= data.length * data.length) {
            shrink();
        }

        /**
         * Otherwise, if the size is now an even multiple of the array size,
         * we can drop the very last array.  This is the array whose offset
         * is one after the end of the elements.
         */
        else if (size() % data.length == 0) {
            data[computeOffset(size())] = null;
        }

        return result;
    }


    /***
     * Given an index, this method returns the index of the parent array into which we insert data.
     *
     * @return
     */
    private int computeOffset(int index) {
        return index >> logSize;
    }

    /***
     * Given an index, this method returns the index of the sub array
     * into which we insert data.
     *
     * @return
     */
    private int computeIndex(int index) {
        return index & (data.length - 1);
    }

    private void grow() {

        T[][] newData = (T[][]) new Object[data.length * 2][];

        /* The new arrays each have size 2^(n + 1).  We need 2^(n - 1) of them
         * to hold the old elements.  Allocate those here and copy everything
         * over.
         */
        for (int i=0; i<data.length; i=i+2) {

            newData[i/2] = (T[]) new Object[newData.length];

            System.arraycopy(data[i], 0, newData[i/2], 0, data.length);
            System.arraycopy(data[i+1], 0, newData[i/2], data.length, data.length);

            /* Null out the old arrays to be nice to the GC during this potentially stressful time. */
            data[i] = data[i+1] = null;
        }

        data = newData;

        ++logSize;
    }

    private void shrink() {
        /* If the size of the topmost array is at its minimum, don't do
         * anything.  This doesn't change the asymptotic memory usage because
         * we only do this for small arrays.
         */
        if (data.length == minParentArraySize) return;

        /* Otherwise, we currently have 2^(2n) / 8 = 2^(2n - 3) elements.
         * We're about to shrink into a grid of 2^(2n - 2) elements, and so
         * we'll fill in half of the elements.
         */
        T[][] newData = (T[][]) new Object[data.length / 2][];

        for (int i=0; i<newData.length/2; i++) {
            newData[i] = (T[]) new Object[newData.length];

            /* Move everything into it.  If this is an odd array, it comes
             * from the upper half of the old array; otherwise it comes from
             * the lower half.
             */
            System.arraycopy(data[i/2], (i % 2 == 0) ? 0 : newData.length,
                            newData[i], 0, newData.length);

            /* Play nice with the GC.  If this is an odd-numbered array, we
             * just copied over everything we needed and can clear out the
             * old array.
             */
            if (i % 2 == 1)
                data[i / 2] = null;
        }

        data = newData;

        --logSize;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(data);
    }

}
