## **What is this repository about ?**

This is a library of in memory data structures and algorithms implemented in Java. I had been investing a lot of time studying algorithms and data structures since some time now and hence wanted a way of sharing this with any one who might be interested in learning or contributing to this kind of stuff. The repository is an effort towards building an API for the basic data structures (some advanced ones too). It also contains implementations of a few popular algorithms. The repository by no means is at production level, but you can surely go ahead and try using it for your projects. The solutions are absolutely readable and easy to understand. I still work on this repository in my free time and try improving the current code base by adding new implementations or adding more utility functions to the existing ones.

**TODOs**

1. Work on adding more implementations to data structures/algorithms not available.
2. Improve current code base by making it cleaner and more readable.
3. Write unit tests whereever necessary. (This is something that I did not pay much attention to earlier, but would want to pay equal importance to going ahead.)
4. Ideas on change/modification in design of API (including design patterns, making code more readable, simpler are welcome)

Below is a list of what is already implemented. The list is not a comprehensive one but would definitely grow as I continue to add more over time.

####**_Data Structures -_**

1. Arrays and Lists
 * DynamicArray - Self resizing arrays
 * SinglyLinkedList
 * DoublyLinkedList
 * BitMap

2. Stacks  
 * StackArray - Array based stack
 * StackLinked - Linked List based stack

3. Queues
 * QueueArray - Array Based queue
 * DequeArray - Linked List Based Double Ended Queue.

4. Maps
 * HashMapSC - HashMap using separate chaining
 * HashMapLP - HashMap using linear probing

5. Trees
 * BinarySearchTree
 * AVLTree
 * RedBlackTree

6. Tries
 * BasicTrie
 * EnhancedTrie (Read description in the code for knowing the differences)
 * TernarySearchTrie

7. DisjointSet

8. BloomFilter

####**_Algorithms -_**

  1. Pattern Matching
*  Naive Pattern Matching
*  KMP Search
*  Rabin Karp Algorithm
*  ZAlgorithm for Pattern Matching

  2. Sorting
* BubbleSort
* InsertionSort
* SelectionSort
* QuickSort
* MergeSort

  3. Hashing
* FNV
* Murmur3

_Obviously, I have not written each line of code completely by myself, and all my work in this repository is a product of various other online resources that I have use for learning, getting more ideas on implementations, design stuff. Please find a list of very very useful references below._

-------------------------------
List of References: |
--------------------- |
http://www.geeksforgeeks.org/  |
https://www.youtube.com/user/tusharroy2525/ |
http://algs4.cs.princeton.edu/home/  |
http://people.cs.vt.edu/~shaffer/Book/  |
https://en.wikipedia.org/wiki/Data_structure  |
http://saurabhschool.org/  |
https://github.com/Baqend/Orestes-Bloomfilter  |
http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/  |
http://mycodeschool.com/  |


You might have very different views and suggestions about the choice and style of implementation, code and design. I would be happy to have ideas on improving the current code base ! Please feel free to file bugs or come up with design concerns. You can reach out to me at the following email address.

namesh.kher@gmail.com
