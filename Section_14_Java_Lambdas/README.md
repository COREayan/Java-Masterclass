**Introduction to Lambda Expressions**
- Welcome to the Lambda Expressions section of the course. 
- While I considered introducing this topic earlier, it's important to have a solid understanding of  core Java concepts before tackling lambda expressions. These expressions, introduced in Java with JDK 8, are now an essential feature and are supported by various methods within Java's interfaces and classes. 
- Lambda expressions can be a bit cahllenging to grasp inititally, especially when trying to unnlock their full potential. That's why it made sense to first build a strong foundation before exploring these more advanced features. 
- Think of a lambda expression as a shorthand for an anonymous class that implements a functional interface - an interface that contains only a single abstract method. This makes your code more concise and easier to understand. 

- Lambda expressions allow you to pass blocks of code as parameters, offering a powerful and flexible way to write cleaner and more functional code with minimal effort. Tehse compact and expressive constructs can greatly simplify your programming tasks. 
- Method references build on this concept, providing an even more concise way to refer to existing methods using lambda experssion syntax. 
- By the end of this section, I hope you'll be excited about the new possibilities that lambda expressions bring and feel ready to use them effectively in your projects. 
- In the final part of this section, I'll introduce you to some handy default and static methods available on many interfaces. These methods can help you reduce repetitive coding tasks, so be sure to explore this part in detail.

**The Lambda Expression**

| The generated Lambda Expression                                  | Comparator's Abstract Method         |
|------------------------------------------------------------------|--------------------------------------|
| <code> (o1, o2) -> o1.lastName().compareTo(o2.lastName())</code> | <code>int compare(T o1, T o2)</code> |

- The syntax of this lambda expression is on the left below.
- This was passed directly as a method argument, for a parameter type that was a Comparator.
- The Comarator's abstract method, compare, is shown here on the right side. 
- The lambda expression parameters are determined by the associated interface's method, the functional method. More on the function method, shortly.
- In the case of a Comparator, and it's compare method, there are two arguments. 
- This is why we get o1, and o2 in parentheses, in the genrated lambda expression. 
- These arguments can be used in the expression, which is on the right of the arrow token. 
- Technically arrow, rather than arrow token is the official term used by Oracle, when using it in a lambda expression, so I'll use that moving forward. 

**The Syntax of a Lambda Expression**
- A lambda expression consists of a formal parameter list, usually but not always declared in parentheses; the arrow; and either an expression or a code block after the arrow. 
- Because lambda expressions are usually simple expressions, it's more common to see them written as shown on this slide.
<pre>(parameter1, parameter2, ...) -> expression; </pre>

The expression should return a value, if the assoicated interface's method returns a value. 
<pre>(o1, o2) -> o1.lastName().compareTo(o2.lastName())</pre>

In the case of our generated expression, it returns an int, which is the result of the compare method on Comparator.

<code>(o1, o2) -> o1.lastName().compareTo(o2.lastName())</code>

**Comparing the anonymous class and the lambda expression**
<table>
    <tr>
        <td> Anonymous Class </td>
        <td> Lambda Expression </td>
    </tr>
    <tr>
        <td>
            <pre>
<code class="language-java">public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}</code>
            </pre>
        </td>
        <td>
            <pre><code class="language-java">(o1, o2) -> o1.lastName().compareTo(o2.lastName())</code></pre>
        </td>
    </tr>
</table>

- Perhaps you are asking, where's the link between the compare method, and this lambda expression? 
- It's obvious in the anonymous class, because we override the compare method, and return the result of that expression.
- We can see the two parameters and their types, and what the return value should be, in the anonymous class.
- But the lambda expression has no reference to an enclosing method, as far as we can see from this code.

**Where's the method in the lambda expression?**
- For a lambda expression, the method is inferred by Java!
**How can Java infer the method?**
- Java takes its clue from the refernce type, in the context of the lambda expression usage.

**How can Java infer the method?**
- Java takes its clue from the refernce type, in the context of the lambda expression usage.
- Here, I show a simplified view, of the sort method on List.

<code>void sort(Comparator c)</code>
- And here is the call to that method passing the lambda expression. 

<code>people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));</code>

- From this, Java can infer that this lambda expression, resolves to a Comparator type, because of the method declaration.
- This means the lambda expression passed, should represent code for a specific method on the Comparator interface. 

**How can Java infer the method?**
- But which method?
- Well, there's only one the lambda expression cares about, and that's the abstract method on Comparator.
- Java requires types which support lambda expressions, to be something called a functional interface. 

**What's a functional interface?**
- A functional interface is an interface that has one, and only one, abstract method.
- This is how Java can infer the method to derive the parameters and return type, for the lambda expression. 
- You may also see this referred to as SAM, which is short for Single Abstract Method, which is called the functional method.
- A functional interface is the target type for a lambda expression.

**The Lambda Expression**
- The functional interface is the framework that lets a lambda expression be used.
- Lambda expressions area also called lambdas for short.
- Many of Java's classes use functional interfaces in their method signatures, which allows you to pass lambdas as arguments to them.
- You'll soon discover that lambdas will reduce the amount of code you write.

**The Consumer Interface**
- The Consumer interface is in the java.util.function package.
- It has one abstract method that takes a single argument and doesn't return anything.
- <code>void accept(T t)</code>
- This doesn't seem like a very interesting interface at first, but let's see what this means in practice, as far as the lambda expressions we can use with it.

**Lambda expression variations, for a single parameter**
- This slide shows the different ways to declare a single parameter in a lambda expression.

| Lambda Expression                                             | Description                                                 |
|---------------------------------------------------------------|-------------------------------------------------------------|
| <code>element-> System.out.println(element);</code>           | A single parameter without a type can omit the parentheses. |
| <code>(element) -> System.out.println(element);</code>        | Parentheses are optional.                                   |
| <code>(String element) -> System.out.println(element);</code> | Parentheses required if a reference type is specified.      |
| <code>(var element) -> System.out.println(element);</code>    | A reference type can be var.                                |

**Lambda expression varations, the lambda body**
- The lambda body can be a single expresison or can contain a lambda body in opening and closing curly braces

| Lambda Expression                                                                                                                                    | Description                                                                                                                                                                                                              |
|------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <code>(element) -> System.out.println(element);</code>                                                                                               | An expression can be a single statement. <br/>Like a switch expression, that does not require yield for a single statement resutl, the use of return is not needed and would result in a compile error.                  |
| <pre><code>(var element) -> {<br/> char first = elementelement.charAt(0);<br/> System.out.println(element + " means " + first); <br/>};</code></pre> | An expression can be a code block.<br/> Like a switch expression, that requires yield, a lambda that returns a value, would require a final return statement.<br/>All statements in the block must end with semi-colons. |

**Functional Programming**
- Lambdas are Java's first step into functional programming.
- This is a programming paradigm that focuses on computing and returning results.
- For more information about functional programming, there's a good wikipedia article here.
  (https://en.wikipedia.org/wiki/Functional_programming)

**Streams**
- Another feature of Java, makes extensive use of lambda expressions, and that's streams. 
- Streams are exciting, because they create a pipeline of work that can be formed into a chain.
- Many stream operations take functional interfaces as parameters, meaning you can code them with lambda expressions.


**Lambda expressions with multiple parameters**
- The rules for multiple parameters used in a lambda expression are shown here.


| Lambda Expression                             | Description                                                                                     |
|-----------------------------------------------|-------------------------------------------------------------------------------------------------|
| <code>(a, b) -> a + b; </code>                | Parentheses are always required. Explicit types are not.                                        |
| <code>(Integer a, Integer b) -> a + b;</code> | If you use explicit type for one parameter, you must use explicit types for all the parameters. |
| <code>(var a, var b) -> a + b</code>          | If you use var for one parameter, you must use var for all parameters.                          |

**Lambda expressions that return values**
- This slide shows the two rules for returning values from a lambda expression.

| Lambda Expression                                                            | Description                                                                                      |
|------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| <code>(a, b) -> a + b;                                                       | When not using curly braces, the return keyword is unnecessary, and will throw a compiler error. |
| <pre><code>(a, b) -> {<br/> var c = a + b;<br/> return c;<br/>}</code></pre> | If you use a statement block, meaning you use the curly braces, a return is required.            |

**java.utill.function**
- Java provides a library of functional interfaces in the java.util.function package.
- We've looked at one already, the consumer interface.
- I'll look at another of these interfaces now, the BinaryOperator, in code.

**The Four categories of Functional Interfaces**
- It's a good idea to know the four basic types of functional interfaces in the java.util.function package.
- There are over forty interfaces in this package.
- This slide shows the four categories, with the simplest method shown.
- These can all be categorized as one of the following types.

  | Interface Category | Basic Method Signature         | Purpose                                     |
  |--------------------|--------------------------------|---------------------------------------------|
  | Consumer           | <code>void accept(T t)         | execute code without returning data         |
  | Function           | <code>R apply(T t)</code>      | return a result of an operation or fucntion |
  | Predicate          | <code>boolean test(T t)</code> | test if a condition is true or false        |
  | Supplier           | <code>T get()</code>           | return an instance of something             |

**The Consumer interface**
- On this slide, I'm showing the two most common Consumer interfaces, and the functional method on each.
- The Consumer interface takes one argument of any type.
- The BiConsumer interace takes two arguments, of two different types.

| Interface Name | Method Signature                   |
|----------------|------------------------------------|
| Consumer       | <code>void accept(T t)</code>      |
| BiConsumer     | <code>void accept(T t, U u)</code> |

**A Consumer Lambda Expression Example**
- This slide shows an example consumer lambda expression. It takes one argument and executes a single statement.
- No result returned. 

| Example Lambda Expression for Consumer   | Consumer Method               |
|------------------------------------------|-------------------------------|
| <code>s -> System.out.println(s);</code> | <code>void accept(T t)</code> |

**The Predicate Interface**
- The predicate interfaces take one or two arguments, and always returns a boolean value.
- The are used to test a condition, and if the condition is true, to perform an operation.

| Interface Name | Method Signature                    |
|----------------|-------------------------------------|
| Predicate      | <code>boolean test(T t)</code>      |
| BiPredicate    | <code>boolean test(T t, U u)</code> |

**A Predicate Lambda Expression Example**
- In this example, the expression takes a String, and tests if it's equal to the literal text "Hello", ignoring case. It returns either true or false.

| Example Lambda Expression for Consumer |
|----------------------------------------|
| s -> s.equalsIgnoreCase("Hello")       |

**The Function interface**
- On this slide, I'm showing four of the most common interfaces in this category.
- Each has a return type, shown here as either T, or R, which stands for result, meaning a result is expected for any of these.
- In addition to Function and BiFunction, there is also UnaryOperator and BinaryOperator.
- You can think of the UnaryOperator as a Function Interface, but where the argument type is the same as the result type.
- The BinaryOperator is a BiFunction interface, where both arguments have the same type, as does the result. which is why the reuslt is shown as T, and not R.
- I've also included the type parameters with each interface name on this slide, because I wanted you to see that the result for a Function or BiFunction, is declared as the last type argument.
- For UnaryOperator and BinaryOperator, there is only one type argument declared, because the types of the arguments and result, will be the same.

  | Interface Name              | Method Signature                | Interface Name                    | Method Signature                  |
  |-----------------------------|---------------------------------|-----------------------------------|-----------------------------------|
  | <code>Function<T, R></code> | <code>R apply(T t)</code>       | <code>UnaryOperator< T > </code>  | <code>T apply(T t)</code>         |
  | <code>BiFunction<T, U, R>   | <code>R apply(T t, U u) </code> | <code>BinaryOperator< T > </code> | <code>T apply(T t1, T t2) </code> |


**A Function Interface Lambda Expresison Example**
- On this slide, I'm showing an example of a lambda expression which targets a Function Interface.
- This lambda expression takes a String, s, and splits that String on commas, returning an array of String.
- In this case, the argument type, T, is a String and the result, R, is an array of String. 
- To demonstrate how to declare a variable of this type, I'm showing a variable declaration as well.

| Example Lambda Expression for Function | Function Method             | Variable Declaration for this example        |
|----------------------------------------|-----------------------------|----------------------------------------------|
| <code>s -> s.split(","); </code>       | <code> R apply(T t) </code> | <code>Function<String, String[]> f1; </code> |

**The Supplier Interface** 
- The supplier interface takes no arguments but returns an instance of some type, T.

| Interface Name | Method Signature |
|----------------|------------------|
| Supplier       | T get()          |
- You can think of this as kind of like a factory method.
- It will produce an instance of some object.
- However, this doesn't have to be a new or a distinct result returned. 

**A Supplier Lambda Expression Example**
- In the example I'm showing you on this slide, I'm using the Random class to generate a random Integer.
- This method takes no arguemnt, but lamdba expressions can use final or effectively final variables in their expressions, which I'm demonstrating here. 
- The variable random is an example of a variable from the enclosing code.

| Example Lambda Expression for Consumer |
|----------------------------------------|
| () -> random.nextInt(1, 100)           |

**Valid Lambda Declarations for different number of arguments**
- This slide shows the many varieties of declaring a parameter type in a lambda expression.
- Parentheses are required in all but the one case, where the funtional method has a single argument, and you don't specify a type, or use var.
- When using var as the type, every argument must use var.
- When specifying explicit types, every argument must include a specific type. 

| Arguments in Functional Method                                                                                                          | Valid lambda syntax                                                                                               |
|-----------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| None                                                                                                                                    | <code>() -> statement</code>                                                                                      |
| One                                                                                                                                     | <pre><code>s -> statement <br/>(s) -> statement<br/>(var s) -> statement<br/>(String s) -> statement</code></pre> |
| Two <br/>- When using var, all arguments must use var.<br/>- When specifying explicit types, all arguments must specify explicit types. | <pre><code>(s, t) -> statement<br/>(var s, var t) -> statement<br/>(String s, List t) -> statement</code></pre>   |

**What's a Method Reference?**
- Java gives us an alternative syntax to use for this second kind of lambda that uses named methods.
- These are called method references. 
- These provide a more compact, easier-to-read lambda expression, for methods that are already defined on a class. 
- For the last couple of videos, I've been ignoring IntelliJ's warnings and hints, whenever I've used System.out.println in a lambda expression. 
- IntelliJ is issuing the warnings because they can be replaced with a method reference. 

**Why are these statements equal?**
- At first glance, it's not really obvious why a method reference has this syntax.

  | Lambda Expression          | Method Reference    |
  |----------------------------|---------------------|
  | s -> System.out.println(s) | System.out::println |

- A method reference abstracts the lambda expression even further, eliminating the need to declare formal parameters. 
- We also don't have to pass arguments to the method in question, in this case println.
- A method reference has double colons, between the qualifying type, and the method name. 
- In this example of a Consumer interface, not only is the method inferred, but the parameters are as well.
- Methods which can be used as method references are based on the context of the lambda expression. 
- This means the method reference, is again dependent on the targeted interface's method.
- You can reference a static method on a class. 
- You can reference an instance method from either an instance external to the expression, or an instance passed as one of the arguments. 
- Method references can be used to increase the readability of your code. 

**Deferred Method Invocation**
- When you create variables that are lambda expressions or method references, it's important to remember that the code isn't invoked at that point.
- The statement or code block gets invoked at the point in the code that are targeted functional method is called.

**Some Terminology for the next couple of Slides**
- A Type Reference refers to a class name, an interface name, an enum name, or a record name. 
- Static methods are usually called using Type References but can also be called by instances in our code. 
- This is NOT true for method references. 
- static methods, in method references and lambda expressions, must be invoked using a reference type only. 
- There are two ways to call an instance method. 
- The first is when you refer to the method with an instance derived from the enclosing code. 
- This instance is delcared outside of the method reference. 
- The System.out::println method reference is an example of this. 
- You'll find that some web sites call this instance a Bounded Receiver, and I actually like that terminology as a differentiator. 
- A Bounded Receiver is an instance derived from the enclosing code, used in the lambda expression on which the method will be invoked. 
- The second way to call an instance method is where the confusion starts. 
- The instance used to invoke the method will be the first argument passed to the lambda expression or method reference when executed. 
- This is known in some places as the Unbounded Receiver. 
- It gets dynamicall bound to the first argument, which is passed to the lambda expression when the method is executed. 
- Unfortunately, this looks an awful lot like a static method reference using a reference type. 
- This means there are two method references that reemeble each other but have two very different meanings. 
- The first actually does call a static method and uses a reference type to do it. 
- You saw this earlier, when I used the sum method on the Integer wrapper class. 
    
<code>Integer::sum</code>
- This is a Type Reference(Integer is the type), which will invoke a static method.
- This is easy to understand.
- But there is another, which you'll see when I start working with String method references in particular. 
- Here, I show a method reference for the concat method on String. 
    
<code>String::concat</code>
- Now, you know by now I hope that the concat method, isn't a static method on String. It's an instance method that is called on a specific String object. 
- So why is this method reference even valid?
- You could never call concat from the String class directly, because it needs to be called on a specific instance. 
- I just said, not two slides ago, that instance methods can't be called using REference Types. 
- But the example shown here, is a special syntax, when it's declared in the right context, meaning when it's associated to the right type of interface. 
<code>String::concat</code>
- This is valid when you use a method reference in the context of an **unbounded receiver.**

**Remember, the unbounded receiver means that the first argument becomes the instance used on which the method gets invoked.**
<code>String::concat</code>
- Any method reference that uses String::concat, must be in the context of a two-parameter functional method.
- The first parameter is the String instance on which the concat method get invoked, and the second argument is the String argument passed to the concat method. 

**Convenience Methods**
- In this video, you'll learn how to do something similar, using what are called convenience methods. 
- These are default methods on some of the functional interfaces I've been covering in the last few videos.
- The Consumer, Predicate, and Function interfaces all come with these methods, as does the Comparator, which I'll also include here. 

**Convenience Methods on functional interfaces in java.util.function package**

| Category of Interface | Convenience method example                | Notes                                                        |
|-----------------------|-------------------------------------------|--------------------------------------------------------------|
| Function              | <code>function1.andThen(function2)</code> | Not implemented on IntFunction, DoubleFunction, LongFunction |
| Function              | <code>function2.compose(function1)</code> | Only implemented on Function & UnaryOperator                 |
| Consumer              | <code>consumer1.andThen(consumer2)</code> |                                                              |
| Predicate             | <code>predicate.and(predicate2)</code>    |                                                              |
| Predicate             | <code>predicate.or(predicate2)</code>     |                                                         |
| Predicate             | <code>predicate1.negate()</code>          |                                                              |

- For and Then, and compose, on the Function category of interfaces, any Interim functions are not required to have the same type arguments.
- Instead, one function's output becomes the next function's input, and the next function's output is not constrained to any specific type, except the last function executed in the chain. 
- The Consumer's andThen method is different, because it never returns a result, so you use this when you're chaining methods independent of one another.
- The Predicate methods always return a boolean, which will combine the output of the two expressions, to obtain a final boolean result.
