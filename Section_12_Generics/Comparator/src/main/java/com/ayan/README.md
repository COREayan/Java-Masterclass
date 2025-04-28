**Interfaces used for sorting**
- Now that I've covered interfaces and generic classes, I want to review interfaces we used in previous lectures, in more detail. 
- The first is Comparable. 
- For an array, we can simply call Arrays.sort and pass it an array, but as I've previously mentioned, the elements in the array need to implement Comparable.
- Types like String or primitive wrapper classes like Integer or Character are sortable, and this is because they do actually implement this interface.

**Comparable INterface**
- The interface declaration in Java.

<code>
public interface Comparable<T> { int compareTo(T o); }
</code>

- It's a generic type, meaning it's parameterized. 
- Any class that implements this interface, needs to implement the compareTo method. 
- This method takes one object as an argument, shown on this slide as the letter o, and compares it to the current instance, shown as this.
  The table on this slide show what the results of the compareTo method should produce, when implemented.

zero == this

negative value this < o 

positive value this > o

**The Comparator Interface**
- The Comparator interface is similar to the Comparable interface, and the two can often be confused with each other. 
- Its declaration and primary abstract method are shown here, in comparison to Comparable. 
- Notice that the method names are different, compare vs. compareTo.

| Comparator                                                               | Comparable                                                            |
|--------------------------------------------------------------------------|-----------------------------------------------------------------------|
| <code>public interface Comparator<T> { int compare(T o1, T o2); }</code> | <code> public interface Comparable<T> { int compareTo(T o); } </code> |

- The compare method takes two arguments vs. one for compareTo, meaning that it will compare the two arguments to one another and not one object to the instance itself. 
- I'll review Comparator in code, but in a slightly manufactured way.
- It's common practice to include a Comparator as a nested class. 

**Summary of Differences**

| Comparable                                                                           | Comparator                                                                                              |
|--------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| <code> int compareTo(T o); </code>                                                   | <code> int compare(T o1, T o2); </code>                                                                 |
| Compares the argument with the current instance.                                     | Compares two arguments of the same type with each other.                                                |
| Called from the instance of the class that implements Comparable.                    | Called from an instance of Comparator.                                                                  |
| Best practice is to have this.compareTo(o) == 0 result in this.equals(o) being true. | Does not require the class itself to implement comparator, though you could also implement it this way. |
| Arrays.sort(T[] elements) requires T to implement Comparable.                        | Arrays.sort(T[], Comparator<T> does not require T to implement Comparable.                              |
