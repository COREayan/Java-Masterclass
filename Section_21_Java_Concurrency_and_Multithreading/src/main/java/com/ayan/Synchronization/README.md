**Synchronized Methods**
- Different invocations of synchronized methods, on the same object, are guaranteed not to interleave.
- When one thread is executing a synchronized method for an object, all other threads that invoke synchornized methods for the same object, block, and suspend their execution, until the first thread is done with the object.
- When a synchronized method exits, it ensures that the state of the object is visibel to all threads. 

**Critical Section**
- The critical section is the code that's referencing a shared resource like a variable.
- Only one thread at a time should be able to execute a critical section.
- When all critical sections are synchronized, the class is thread safe.

**The Object instance monitor**
- Every object instance in Java has a built-in intrinsic lock, also known as a monitor lock.
- A thread acquires a lock by executing a synchornized method on the instance, or by using the instance as the parameter to a synchronized statement.
- A thread releases a lock when it exits from a synchronized block or method, even if it throws an exception.
- Only one thread at a time can acquire this lock, which prevents all other threads from accessing the instance's state, until the lock is released.
- All other threads, which want access to the instance's state through synchronized code, will block, and wait, until they can acquire a lock.

**The synchronized statement can be applied to a more granular code block**
- The synchronized statement is usually a better option in most circumstances, since it limits the scope of synchronization, to the critical section of code.
- In other words, it gives you much more graular control, over when you want other threads to block.

**The synchronized statement can be applied to a more granular object in state**
- The synchornized blcok can use a different object, on which to acquire its lock.
- This means that code, accessing this bank account instance, wouldn't have to block entirely.
- 