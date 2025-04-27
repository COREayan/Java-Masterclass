**Introduction to Concurrency and Threads**
- Process is a unit of execution, that has its own memory space.
- The terms process and application are foten used interchangeably, and I've done that myself, and will again in this section.

**Process memory space = Heap**
- Each application has its own memory space, also known as the heap.
- The heap isn't shared between two applications or two processes, they each have their own.

**A Thread**
- A thread is a single unit of execution, within a process.
- Each process can have multiple threads. 
- Every application has at least one thread, and that's the main thread. 
- Our code will run on the main thread. 
- We can also have our code run in other threads, which we can explicitly create and start. 

**Threads Share Process Memory**
- Creating a thread doesn't require as many resources as creating a process does.
- Every thread created by a process, shares that process's memory space, the heap.
- This can cause big problems with your applications.

**Threads also have Stack Memory**
- Each thread's got what's called a thread stack.
- This is memory, that only a single thread, will have access to. 
- Every Java application runs as a single process, and each process can then have multiple threads within it.
- Every process has a heap, and every thread has a thread stack. 

**Why use multiple threads?**
- What are some of the adavantages, to creating a multi-threaded application?
- One of the most common reasons, is to offload long running tasks. 
- Instead of tying up the main thread, we can create additional threads, to execute tasks that might take a long time. 
- This frees up the main thread so that it can continue working, and executing, and being responsive to the user. 
- You also might use multiple threads to process large amounts of data, which can improve performance, of data internsive operations.
- A web server, is another use case for many threads, allowing multiple connections and requests to be handled, simultaneously. 

**Concurrency**
- Concurrency, refers to an application doing more than one thing at a time. 
- Concurrency allows different parts of a program to make progress independently, often leadig to better resource utilization and improved performance. 
- One task doesn't have to complete, before another one can start, and multiple threads can make incremental progress.

**Java's Threads**
- Threads are the fundamental building blocks, to support concurrency, in a Java application. 
- They're essential, because they allow us to perform multiple tasks simultaneously, within a single process. 

**The java.util.Thread Class** 
- this class implements the Runnable interface, which has a single abstract method, the run method. 
- Each instance of a thread has some state. 
- The fields displayed here are all encapsulated and this includes thread group, a name, a priority, a staus, and a thread id. 
- A thread can be constructed with no arguments. 
- It can be constructed by passing a Runnable instance to it. 
- The first method is the run method, which has to be overridden, sinct it's declared abstract on the Runnable interface. 

**Thread Priority**
- Thread priority is a value from 1 to 10.
- The Thread class has three pre-defined priorities, included as constants. 
- Thread.MIN_PRIORITY = 1 (low)
- Thread.NORM_PRIORITY = 5 (default)
- Thread.MAX_PRIORITY = 10 (high)
- Higher-priority threads have a better chance of being scheduled, by a thread scheduler, over the lower-priority threads. 
- However, priority behavior can vary across different operating systems and JVM implementations. 
- You can think of this priority as more of a suggestion, to the thread management process. 

**Creating a Thread Instance**
- Extend the Thread class, and create an instance of this new subclass. 
- Create a new instance of Thread, and pass it any instance that implements the Runnable interface. This includes passing a lambda expression. 
- Use an Executor, to create one or more threads for you. 

**The difference between executing run and start on a thread**
- There's a big difference between calling run() and start().
- If you execute the run method, it's executed synchronously, by the running thread it's invoked from. 
- If you want your code to be run asynchronously, you must call the start method. 

The native modifier on a method 
- The native modifier indicates that this method's source code isn't written in Java. 
- It's written in another language, such as C or C++. 
- The code in this example, is part of a native library, such as a dll file. 

Why use a native library? 
The reasons to do this include 
- To access system-level functionality that's platform-specific. 
- To interface with hardware. 
- To optimize performance for tasks that might be computationally-intensive. 

Runnable is a Functional Interface 
- It's important to recognize that Runnable is a functional interface. 
- It's functional method, or its single access method, is the run method. 
- Anywhere you see a Runnable type, it's a target for a lambda expression. 
- You can have any class implement the Runnable interface to run asynchronously. 

Extending the Thread Class
- The new subclass overrides the Thread's run method, to provide the concurrent thread's task. 
- To use this thread, you create a new instance of your subclass, with a no argument constructor, and execute the start method on that instance. 

Advantages of Extending Thread
- You have more control over the thread's behavior and properties. 
- You can access the thread's methods and fields directly from your sub class. 
- You can create a new thread for each task.

Disadvantages of Extending Thread
- You can only extend one class in Java, so your subclass can't extend any other classes. 
- Your class is tightly coupled to the Thread class, which may make it difficult to maintain. 

Implementing Runnable
- Besides extending the Thread class, you can create threads, by implementing the Runnable interface. 
- This method allows any class, to implement Runnable, meaning any class at all, can be used in a thread. 
- This class is passed to the Thread constructor, that accepts a Runnable. 
- You can also pass an anonymous class, lambda expression, or a method reference to this constructor, to create an instance of a Thread. 

- You again call start on the new thread instance, to execute the code asynchronously. 

Advantages of Implementing a Runnable and creating a Thread instance with it. 
- You can extend any class and still implement Runnable. 
- Your class(if you create a class) is loosely coupled to the Thread class, which makes it easier to maintain. 
- You can use anonymous classes, lambda expressions, or method references, to very quickly describe thread behavior. 

Disadvantages of Implementing a Runnable and creating a Thread instance with it
- You do have less control over the thread's behavior and properties. 
- In other words, You can't access the thread's methods and fields directly, from the run method.

