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

