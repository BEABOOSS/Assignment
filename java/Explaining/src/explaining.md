# Assignment 4
### Problem 1
Q. Describe and explain what happens when you try to compile a program HugeArray.java with the following statement:


```
public class HugeArray { 
    public static void main(String[] args) {
       int N = 1000;
       int[] a = new int[N*N*N*N];
    }
};
```
A.  
We are creating an array of integers with 1,000,000,000,000 (1 trillion) elements.  
The program will compile, however when you run the program you'll get this exception:  
`Exception in thread "main" java.lang.NegativeArraySizeException: -727379968`.  
An integer has a maximum value of 2,147,483,647 (2 billion).
Like we are trying to calculate 1000⁴ which is (1 trillion) we get an overflow exception.
When the integer overflows it goes back to its minimum value.
That is where the -727379968 comes from.

### Problem 2
Q. Describe and explain what happens when you try to compile a program HugeArray.java with the following statement:
```
public class HugeArray { 
    public static void main(String[] args) {
       int N = 200;
       int[] a = new int[N*N*N*N];
    }
};
```
A.  
We are trying to create an array of integers with 1,600,000,000 (1.6 billion) elements.   
The program will compile, however when you run the program you'll get this exception:
`Exception in thread 'main' java.lang.OutOfMemoryError: Java heap space`.   
Java takes 4 bytes to store an integer.
1,600,000,000 * 4 = 6.4 billion bytes -> 6.4GB 
Current specifications for my computer:  
`size_t HeapSizePerGCThread = 43,620,760   {product} {default}`  
`size_t MaxHeapSize         = 4,259,315,712 {product} {ergonomic}`  
`size_t MinHeapSize         = 8,388,608    {product} {ergonomic}`  
By default the maximum heap size varies but is often around 1/4 of your physical RAM.  
Like the program exceeded the total max size of the heap it threw an exception due to the lack of space.

### Problem 3 & 4
Both of then are in Main.java