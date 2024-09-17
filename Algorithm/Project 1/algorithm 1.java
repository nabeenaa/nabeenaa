/**
 * For COMP5180 Assessment 1 2022/23
 * 
 * EDIT THIS FILE.
 * 
 * Implenting a DynamicArray as described in the week 10 case study.
 * To show  how dynamic arrays work in practice.
 * 
 * This class extends the UoKDynamicArray.java file, supplied.
 * 
 * All your edits must be in this file, MyUoKDynamicArray. 
 * During marking, your file will be tested with our copy of UoKDynamicArray.java.
 * 
 * 
 * EDIT THIS FILE.
 * 
 * @author INSERT_YOUR_USER_NAME_HERE
 * 
 * From Week 10 lecture slides:
 * 
 * Our dynamic array for this assignment has three fields relating to the array:
 * 1. hiddenArray - a hidden array of fixed length - storage for actual content of the dynamic array object
 * 2. nextFreeSlot - an integer index that points to the next free slot in the array
 * 3. capacity - an integer field giving the length of the hidden array (the “capacity”); equivalent to performing the length function on the hidden array.
 * 
 * We also maintain two global variables for the purpose of calculating runtime performance of the add operation
 * opCountForAdds keeps track of how many single operations are performed on the contents of the hidden array over the lifetime of the dynamic array object
 * numItemsAdded keeps track of how many items are added over the lifetime of the dynamic array object
 * 
 */
package comp5180a12022;

import java.util.Random;

public class MyUoKDynamicArray extends DynamicArray {

    public MyUoKDynamicArray() {
        super();
    }

    public MyUoKDynamicArray(int length) {
        super(length);
    }

    // a random generator
    private Random rg = new Random();

    /**
     * Q1. edit this method to perform a check of if the hidden array is full
     * replace the return value of false with your calculated value for whether the
     * hidden array is full (true) or not full (false)
     * 
     * WARNING Until you edit this code, this method will always return false, even
     * if the hidden array is full
     * 
     * @return boolean true if the hidden array is full, false if the hidden array
     *         is not full
     */
    @Override
    boolean isFullQ1() {
        if(nextFreeSlot == capacity){
            return true;
        }
        else{
            return false;
        }
    
    }

    /**
     * Q2. edit this method to enable the array to dynamically increase in size by a
     * factor of x every time it needs to be expanded, keeping track of the number
     * of
     * "copy/add item" operations conducted.
     * 
     * @param item the item to be added
     * @param x    the factor by which the hidden array should be increased in size
     *             every time it needs to be expanded (e.g. if x = 2 then the hidden
     *             array should double in size every time it needs to be expanded)
     * 
     *             WARNING Until you edit this code, this method will crash when the
     *             hidden
     *             array becomes full
     */

    void addItemQ2(int item, double x) {
        if (isFullQ1()) {
            int[] tempArray = hiddenArray;
            double doubleCapacity = capacity;
            double result = doubleCapacity * x;
            System.out.println((int) result);
            hiddenArray = new int[(int) result];
            for (int i = 0; i < capacity; i++) {
                hiddenArray[i] = tempArray[i];
                opCountForAdds++;
            }
            capacity = (int) result;
        }
        insertIntoHiddenArray(item);
        nextFreeSlot++;
        numItemsAdded++;
    }


    /**
     * Q3. edit this method to calculate the amortized complexity of the add
     * operation.
     * 
     * Remember that the amortized complexity is the complexity of the operation over the lifetime of the object, 
     * i.e. the average cost of running this operation over time. 
     * For this question we calculate amortized complexity by taking the total number of
     * "copy/add item" operations performed for this object divided by the
     * number of times an item has been added to this object
     * 
     * replace the return value of -1.0 with your calculated value for the amortized
     * complexity of the add operation as described above.
     * 
     * @return your calculated value for the amortized complexity of the add
     *         operation, in the form of the average cost of running this operation over time.
     * 
     *         WARNING Until you edit this code, this method will always return a
     *         nonsensical value of -1.0
     */
    double calcAddAmCompQ3() {
        
            return (double) opCountForAdds / numItemsAdded;
        
    }

    /**
     * Q4. edit this method to remove the item at the index position given in the
     * parameters, making sure to reorder the array items so that there are no empty
     * slots between items in the array.
     * If the position parameter is not a correct index of an item in the hidden
     * array, the method should terminate
     * 
     * This method should be able to resize the array dynamically, halving the
     * size of the hidden array if the dynamic array object is less than 25% full to capacity
     * 
     * NB You do not have to keep track of the number of items removed from the dynamic array over its lifetime. 
     * You also do not have to keep track of the number of operations performed to change the contents of the dynamic array for remove operations.
     * This method should _not_ make any changes to the opCountFor Adds or numItemsAdded fields.
     * 
     * @param position the position in the dynamic array of the item that is to be
     *                 removed
     * 
     *                 WARNING Until you edit this code, this method will not
     *                 perform any action
     */
    void removeItemAtQ4(int position) {
        
        if (nextFreeSlot==0 || nextFreeSlot< (hiddenArray.length *(25/100)))
        {
            int[] tempArray = hiddenArray;
            capacity = capacity / 2;
            hiddenArray = new int[capacity];
            for (int i = 0, j = 0; i < capacity; i++) {
                if ( i!=position){
                    hiddenArray[j++] = tempArray[i];   
                }   

            }
        } 
        else {
            int[] tempArray = hiddenArray;
            hiddenArray = new int[capacity];
            for (int i = 0, j= 0 ; i < capacity; i++) {
                if ( i!=position){
                    hiddenArray[j++] = tempArray[i];   
                }   
            }
        }
        nextFreeSlot--;
    }






    // the following methods are only used for testing

    void basicTestQ1a() {
        System.out.println("\nStarting basic test 1a for Q1... ");
        if (isFullQ1() == false) {
            System.out.println(
                    "Until you edit isFullQ1, this method will always return false even if the hidden array is full");
        }
    }

    void basicTestQ1b() {
        System.out.println("\nStarting basic test 1b for Q1... ");
        try {
            int c = capacity;
            for (int i = 1; i <= c; i++) {
                addItem(rg.nextInt());
                System.out.println(toString());
            }
        } catch (Exception e) {
            System.out.println("Until isFullQ1 functions correctly, this test will always crash: " + e);
        }
    }

    void basicTestQ2() {
        System.out.println("\nStarting basic test 2 for Q2... ");
        try {
            int c = capacity;
            for (int i = 1; i <= c; i++) {
                addItemQ2(rg.nextInt(), 1.3);
                System.out.println(toString());
            }
        } catch (Exception e) {
            System.out.println(
                    "This test will crash if isFullQ1 functions incorrectly and may also crash if addItemQ2 functions incorrectly: "
                            + e);
        }
    }

    void basicTestQ3() {
        System.out.println("\nStarting basic test 3 for Q3... ");
        double amComp = calcAddAmCompQ3();
        if (amComp < 0) {
            System.out.println("Until you edit calcAddAmCompQ3, this method will always return -1");
        } else {
            System.out.println("Amortised complexity: on average over the lifetime of this data structure, the add operation has an average cost of "+amComp+" operations.");
        }
    }

    void basicTestQ4a() {
        System.out.println("\nStarting basic test 4a for Q4... ");
        try {
            removeItemAtQ4(rg.nextInt(nextFreeSlot));
        } catch (Exception e) {
            System.out.println("This test will crash if removeItemAtQ4 functions incorrectly: " + e);
        }
        System.out.println("Until you edit removeItemAtQ4, this method will do nothing");
    }

    void basicTestQ4b() {
        System.out.println("\nStarting basic test 4b for Q4... ");
        try {
            removeItemAtQ4(nextFreeSlot);
        } catch (Exception e) {
            System.out.println(
                    "This test will crash if removeItemAtQ4 is edited but does not handle an example of invalid input correctly: "
                            + e);
        }
        System.out.println("Until you edit removeItemAtQ4, this method will do nothing");
    }

    /**
     * The main method contains code to set up and run tests on a MyUoKDynamicArray
     * object
     * During marking, your code will be tested with significantly more cases than
     * included here.
     * Test your code thoroughly with multiple examples.
     * You can edit the main method below as much as you like, to help you test the
     * code.
     */
    public static void main(String[] args) {
        MyUoKDynamicArray mda = new MyUoKDynamicArray(1);

        // stick some dummy data into
        System.out.println(mda.toString());
        mda.addItem(22);
        System.out.println(mda.toString());
        mda.addItemQ2(33, 4);
        System.out.println(mda.toString());
        System.out.println("Amortized complexity: " + mda.calcAddAmCompQ3());
        mda.removeItemAtQ4((mda.nextFreeSlot - 1));
        System.out.println(mda.toString());
        mda.basicTestQ1a();
        mda.basicTestQ1b();
        mda.basicTestQ2();
        mda.basicTestQ3();
       // mda.basicTestQ4a();
        //mda.basicTestQ4b();

    }

}
