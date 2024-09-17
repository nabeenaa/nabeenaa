import java.util.Arrays;
/**
 * Assessment2 class2
 *
 * @author (ni94)
 */
public class Assessment2
{
    /*
     * merge method for Task 1.1
     */
    public static int[] merge(int[] a, int[] b) {
        int c[] = new int[a.length + b.length];
        int i = 0, j = 0,k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k] = a[i]; i++; k++;
            } else {
                c[k] = b[j];j++; k++;
            }
        }

        while (i < a.length) 
        {
            c[k] = a[i]; i++;  k++;
        } 

        while (j < b.length) 
        {
            c[k] = b[j]; j++; k++;
        } 
        return c;
    }

    /*
     * mergesort method for Task 1.2
     */
    public static int[] mergesort(int[] arr) {
        if (arr.length <2) {
            return arr;
        } 
        int half = arr.length/2;
        int[] array1 = Arrays.copyOfRange(arr, 0, half);
        int[] array2 = Arrays.copyOfRange(arr, half ,arr.length);

        array1 = mergesort(array1);array2 = mergesort(array2);
        int[]array3 = merge(array1,array2);

        return array3;

    }

    /*
     * merge3 method for Task 1.3
     */
    public static int[] merge3(int[] a, int[] b, int[] c) {
        int d[] = new int[a.length + b.length + c.length];
        int i = 0, j = 0, k = 0, l = 0;
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] < b[j] && a[i] < c[k]) {
                d[l] = a[i];l++; i++; 
            } else if (b[j] < a[i] && b[j] < c[k]) {
                d[l] = b[j]; l++; j++; 
            } else {
                d[l] = c[k]; l++; k++; 
            }
        }

        while (i< a.length && j < b.length) {
            if (a[i] < b[j]) {
                d[l]=a[i]; l++; i++; 
            } else {
                d[l]=b[j]; l++; j++;
            }
        }

        while (i< a.length && k < c.length) {
            if (a[i] < c[k]) {
                d[l]=a[i]; l++; i++;
            } else {
                d[l]=c[k]; l++; k++;
            }
        }

        while (k < c.length && j < b.length) {
            if (c[k] < b[j]) {
                d[l]=c[k]; l++; k++;
            } else {
                d[l]=b[j];l++; j++;
            }
        }

        while (i < a.length) 
        {
            d[l] = a[i]; l++; i++;
        } 

        while (j < b.length) 
        {
            d[l] = b[j]; l++; j++;
        } 

        while (k < c.length) 
        {
            d[l] = c[k]; l++; k++; 
        } 
        return d;

    }

    /*
     * mergesort3 method for Task 1.4
     */
    public static int[] mergesort3(int[] arr) {
        if (arr.length <3) {
            return arr;
        } 
        int third = arr.length/3;
        int twothirds = third* 2;
        int[] array1 = Arrays.copyOfRange(arr, 0, third);
        int[] array2 = Arrays.copyOfRange(arr, third ,twothirds);
        int[]array3 = Arrays.copyOfRange(arr,twothirds, arr.length);
        array1 = mergesort3(array1); array2 = mergesort3(array2);array3=mergesort3(array3);
        int[] array4 = merge3(array1, array2, array3);
        return array4;
    }

    /*
     * mergeAll method for Task 1.5
     */
    public static int[] mergeAll(int[][] arrays) {
        
        int Len = 0;
        int ii = 0;
        while (ii < arrays.length) {
            Len = Len + arrays[ii].length;
            ii++;
        }

        int[] the_final = Arrays.copyOf(arrays[0], Len);
        int loc = arrays[0].length;
        int start = 1;
        while (start < arrays.length) {
            int[] array = arrays[start];
            System.arraycopy(array, 0, the_final, loc, array.length);
            loc = loc + array.length;
            start++;
        }

        Arrays.sort(the_final);

        return the_final;
    }
    

    /*
     * mergesortK method for Task 1.6
     */
    public static int[] mergesortK(int[] arr, int k) {
        int length = arr.length / k;
        int[][] array2 = new int[k][length];
        int i = 0;
        while (i < arr.length) {
            array2[i / k] = Arrays.copyOfRange(arr, i, i + length); i= i + k;
        }
        return mergeAll(array2);
    }

    /*
     * maxResources method for Task 2.1
     */
    public static int maxResources(int[][] mine) {
        int collected = -1;
        int i = 0;
        while (i < mine[0].length) {
            if (collected < maxResources(mine, i, 0)) {
                collected = maxResources(mine, i, 0);
            }
            i++;
        }
        return collected;
    }

    public static int maxResources(int[][] mine, int r, int c) 
    {
        if (r-1 < 0 ) {
            return maxResources(mine,r+1,c+1);
        }

        if (r+1 > mine.length) {
            return maxResources(mine,r-1,c+1);
        }

        if (c + 1 >= mine[0].length) {
            return mine[r][c-1]; 
        }

        int collected = 0;

        if (maxResources(mine, r-1, c+1) > maxResources(mine, r+1, c+1)) {
            collected = maxResources(mine, r-1, c+1);
        } else {
            collected = maxResources(mine, r+1, c+1);
        }
        return mine[r][c] + collected;
    }

    /*
     * maxResources method for Task 2.2
     */
    public static int maxResourcesM(int[][] mine) {
        int[][] memo = new int[mine.length][];
        for(int i = 0; i < mine.length; i++) {
            memo[i] = new int[mine[i].length];
            for(int j = 0; j < mine[i].length; j++)
                memo[i][j] = -1;
        }
        int collected = -1;
        int i = 0;
        while (i < mine[0].length) {
            if (collected < maxResourcesM(mine, i, 0, memo)) {
                collected = maxResourcesM(mine, i, 0, memo);
            }
            i++;
        }
        return collected;
    }

    public static int maxResourcesM(int[][] mine, int r, int c, int[][]memo) {

        if (r-1 < 0 ) {
            return maxResourcesM(mine,r+1,c+1, memo);
        }

        if (r+1 > mine.length) {
            return maxResourcesM(mine,r-1,c+1, memo);
        }

        if (c + 1 >= mine[0].length) {
            return mine[r][c-1]; 
        }

        if(memo[r][c] > -1)
            return memo[r][c];

        int collected = 0;
        if (maxResourcesM(mine, r-1, c+1, memo) > maxResourcesM(mine, r+1, c+1, memo)) {
            collected = maxResourcesM(mine, r-1, c+1, memo);
        } else {
            collected = maxResourcesM(mine, r+1, c+1, memo);
        }
        memo[r][c] =  mine[r][c] + collected;
        return mine[r][c] + collected;
    }

    /*
     * Main method for testing
     * Includes some basic tests for each of the methods required by tasks
     * You can use this method to check your methods before submitting
     */
    public static void main(String[] args) {
        System.out.println("Beginning testing");

        System.out.println("   Testing merge method:");

        try {
            int[] a = new int[] {1,3,5};
            int[] b = new int[] {2,4,6};
            int[] expected = new int[] {1,2,3,4,5,6};
            int[] result = Assessment2.merge(a, b);
            boolean testPassed = expected.length == result.length;
            if(testPassed)
                for(int i = 0; i < expected.length; i++)
                    if(expected[i] != result[i]) {
                        testPassed = false;
                        break;
                    }
            if(testPassed)
                System.out.println("     [V] Test passed!");
            else {
                System.out.println("     [X] Test failed.");
                System.out.println("     Inputs were [1,3,5] and [2,4,6]");
                System.out.println("     Expected output [1,2,3,4,5,6]");
                System.out.print("     But got [");
                for(int i = 0; i < result.length; i++) {
                    System.out.print(result[i]);
                    if(i < result.length - 1)
                        System.out.print(",");
                }
                System.out.println("]");
            }
        }
        catch(Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            System.out.println("     [X] Test failed with " + exceptionName);
        }
        catch(StackOverflowError e){
            System.out.println("     [X] Test failed with a StackOverflowError");
        }

        System.out.println("   Testing mergesort method:");

        try {
            int[] arr = new int[] {3,6,4,1,5,2};
            int[] expected = new int[] {1,2,3,4,5,6};
            int[] result = Assessment2.mergesort(arr);
            boolean testPassed = expected.length == result.length;
            if(testPassed)
                for(int i = 0; i < expected.length; i++)
                    if(expected[i] != result[i]) {
                        testPassed = false;
                        break;
                    }
            if(testPassed)
                System.out.println("     [V] Test passed!");
            else {
                System.out.println("     [X] Test failed.");
                System.out.println("     Input was [3,6,4,1,5,2]");
                System.out.println("     Expected output [1,2,3,4,5,6]");
                System.out.print("     But got [");
                for(int i = 0; i < result.length; i++) {
                    System.out.print(result[i]);
                    if(i < result.length - 1)
                        System.out.print(",");
                }
                System.out.println("]");
            }
        }
        catch(Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            System.out.println("     [X] Test failed with " + exceptionName);
        }
        catch(StackOverflowError e){
            System.out.println("     [X] Test failed with a StackOverflowError");
        }

        System.out.println("   Testing merge3 method:");

        try {
            int[] a = new int[] {1,4,7};
            int[] b = new int[] {2,5,8};
            int[] c = new int[] {3,6,9};
            int[] expected = new int[] {1,2,3,4,5,6,7,8,9};
            int[] result = Assessment2.merge3(a, b, c);
            boolean testPassed = expected.length == result.length;
            if(testPassed)
                for(int i = 0; i < expected.length; i++)
                    if(expected[i] != result[i]) {
                        testPassed = false;
                        break;
                    }
            if(testPassed)
                System.out.println("     [V] Test passed!");
            else {
                System.out.println("     [X] Test failed.");
                System.out.println("     Inputs were [1,4,7], [2,5,8] and [3,6,9]");
                System.out.println("     Expected output [1,2,3,4,5,6,7,8,9]");
                System.out.print("     But got [");
                for(int i = 0; i < result.length; i++) {
                    System.out.print(result[i]);
                    if(i < result.length - 1)
                        System.out.print(",");
                }
                System.out.println("]");
            }
        }
        catch(Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            System.out.println("     [X] Test failed with " + exceptionName);
        }
        catch(StackOverflowError e){
            System.out.println("     [X] Test failed with a StackOverflowError");
        }

        System.out.println("   Testing mergesort3 method:");

        try {
            int[] arr = new int[] {8,3,6,2,9,5,1,7,4};
            int[] expected = new int[] {1,2,3,4,5,6,7,8,9};
            int[] result = Assessment2.mergesort3(arr);
            boolean testPassed = expected.length == result.length;
            if(testPassed)
                for(int i = 0; i < expected.length; i++)
                    if(expected[i] != result[i]) {
                        testPassed = false;
                        break;
                    }
            if(testPassed)
                System.out.println("     [V] Test passed!");
            else {
                System.out.println("     [X] Test failed.");
                System.out.println("     Input was [8,3,6,2,9,5,1,7,4]");
                System.out.println("     Expected output [1,2,3,4,5,6,7,8,9]");
                System.out.print("     But got [");
                for(int i = 0; i < result.length; i++) {
                    System.out.print(result[i]);
                    if(i < result.length - 1)
                        System.out.print(",");
                }
                System.out.println("]");
            }
        }
        catch(Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            System.out.println("     [X] Test failed with " + exceptionName);
        }
        catch(StackOverflowError e){
            System.out.println("     [X] Test failed with a StackOverflowError");
        }

        System.out.println("   Testing mergeAll method:");

        try {
            int[] a = new int[] {1,6,11,16,21};
            int[] b = new int[] {2,7,12,17,22};
            int[] c = new int[] {3,8,13,18,23};
            int[] d = new int[] {4,9,14,19,24};
            int[] e = new int[] {5,10,15,20,25};
            int[][] arrs = new int[][] {a,b,c,d,e};
            int[] expected = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
            int[] result = Assessment2.mergeAll(arrs);
            boolean testPassed = expected.length == result.length;
            if(testPassed)
                for(int i = 0; i < expected.length; i++)
                    if(expected[i] != result[i]) {
                        testPassed = false;
                        break;
                    }
            if(testPassed)
                System.out.println("     [V] Test passed!");
            else {
                System.out.println("     [X] Test failed.");
                System.out.println("     Inputs were [1,6,11,16,21], [2,7,12,17,22], [3,8,13,18,23], [4,9,14,19,24] and [5,10,15,20,25]");
                System.out.println("     Expected output [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25]");
                System.out.print("     But got [");
                for(int i = 0; i < result.length; i++) {
                    System.out.print(result[i]);
                    if(i < result.length - 1)
                        System.out.print(",");
                }
                System.out.println("]");
            }
        }
        catch(Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            System.out.println("     [X] Test failed with " + exceptionName);
        }
        catch(StackOverflowError e){
            System.out.println("     [X] Test failed with a StackOverflowError");
        }

        System.out.println("   Testing mergesortK method:");

        try {
            int[] arr = new int[] {10,4,11,15,2,14,6,8,1,12,3,16,7,9,13,5};
            int[] expected = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
            int[] result = Assessment2.mergesortK(arr,4);
            boolean testPassed = expected.length == result.length;
            if(testPassed)
                for(int i = 0; i < expected.length; i++)
                    if(expected[i] != result[i]) {
                        testPassed = false;
                        break;
                    }
            if(testPassed)
                System.out.println("     [V] Test passed!");
            else {
                System.out.println("     [X] Test failed.");
                System.out.println("     Input was [10,4,11,15,2,14,6,8,1,12,3,16,7,9,13,5] with K=4");
                System.out.println("     Expected output [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]");
                System.out.print("     But got [");
                for(int i = 0; i < result.length; i++) {
                    System.out.print(result[i]);
                    if(i < result.length - 1)
                        System.out.print(",");
                }
                System.out.println("]");
            }
        }
        catch(Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            System.out.println("     [X] Test failed with " + exceptionName);
        }
        catch(StackOverflowError e){
            System.out.println("     [X] Test failed with a StackOverflowError");
        }

        System.out.println("   Testing maxResources method:");

        try {
            int[][] mine = new int[][] {new int[] {91,82,55,25,10},
                    new int[] {99,75,49,37,21},
                    new int[] {80,63,32,48,51},
                    new int[] {40,36,47,52,64},
                    new int[] {12,27,33,71,82}
                };
            int expected = 362;
            int result = Assessment2.maxResources(mine);
            boolean testPassed = expected == result;
            if(testPassed)
                System.out.println("     [V] Test passed!");
            else {
                System.out.println("     [X] Test failed.");
                System.out.println("     Input was [[91,82,55,25,10]");
                System.out.println("                [99,75,49,37,21]");
                System.out.println("                [80,63,32,48,51]");
                System.out.println("                [40,36,47,52,64]");
                System.out.println("                [12,27,33,71,82]]");
                System.out.println("     Expected output 362");
                System.out.println("     But got " + result);
            }
        }
        catch(Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            System.out.println("     [X] Test failed with " + exceptionName);
        }
        catch(StackOverflowError e){
            System.out.println("     [X] Test failed with a StackOverflowError");
        }

        System.out.println("   Testing maxResourcesM method:");

        try {
            int[][] mine = new int[][] {new int[] {91,82,55,25,10},
                    new int[] {99,75,49,37,21},
                    new int[] {80,63,32,48,51},
                    new int[] {40,36,47,52,64},
                    new int[] {12,27,33,71,82}
                };
            int expected = 362;
            int result = Assessment2.maxResourcesM(mine);
            boolean testPassed = expected == result;
            if(testPassed)
                System.out.println("     [V] Test passed!");
            else {
                System.out.println("     [X] Test failed.");
                System.out.println("     Input was [[91,82,55,25,10]");
                System.out.println("                [99,75,49,37,21]");
                System.out.println("                [80,63,32,48,51]");
                System.out.println("                [40,36,47,52,64]");
                System.out.println("                [12,27,33,71,82]]");
                System.out.println("     Expected output 362");
                System.out.println("     But got " + result);
            }
        }
        catch(Exception e) {
            String exceptionName = e.getClass().getSimpleName();
            System.out.println("     [X] Test failed with " + exceptionName);
        }
        catch(StackOverflowError e){
            System.out.println("     [X] Test failed with a StackOverflowError");
        }

        System.out.println("Finished testing");
    }

}