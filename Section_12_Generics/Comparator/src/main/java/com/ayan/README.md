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


