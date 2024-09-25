
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
     *
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
