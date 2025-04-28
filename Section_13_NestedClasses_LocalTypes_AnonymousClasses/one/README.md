**Nesting classes (or types) within another class (or type)**
- A class can contain other types within the class body, such as other classes, interfaces, enums, and records.
- These are called nested types, or nested classes. 
- You might want to use nested classes when your classes are tightly coupled, meaning their functionality is interwoven.

**Nested Classes**
- The four different types of nested classes you can use in Java are: the static nested class, the innner class, a local class and an anonymous class.
  
  | Type                    | Description                                                                                                  |
  |-------------------------|--------------------------------------------------------------------------------------------------------------|
  | static nested class     | declared in class body. Much like a static field, access to this class is through the Class name identifier. |
  | instance or inner class | declared in class body. This type of class can only be accessed thorugh an instance of the outer class.      |
  | local class             | declared within a method body.                                                                               |
  | anonymous class         | unnamed class, declared and instantiated in same statement.                                                  |

**Static Nested Class**
- The static nested class is a class enclosed in the structure of another class, declared as static.
- This means the class, if accessed externally, requires the outer class name as part of the qualifying name.
- This class has the advantage of being able to access private attibutes on the outer class.
- The enclosing class can access any attributes on the static nested class, including private attributes.

**Inner Classes**
- Inner classes are non-static classes, declared on an enclosing class at the member level.
- Inner classes can have any of the four valid access modifiers. 
- An inner class has access to instance members, including private members of the enclosing class.
- Instantiating an inner class from external code is a bit tricky. I'll cover that shortly. As of JDK16, static members of all types are supported on inner classes.

- To create an instance of an inner class, you first need to have an instance of the Enclosing Class. 
- From that instance you call .new, followed by the inner class name and the parentheses, taking any constructor arguments. 
- This defintely looks strange the first time you see it.

```java
EnclosingClass outerClass = new EnclosingClass();
EnclosingClass.InnerClass innerClass = outerClass.new InnerClass();
```

**Local Classes**
- Local classes are inner classes, but declared directly in a code block, usually a method body.
- Because of that, they don't have access modifiers and are only accessible in that method body while it's executing.
- Like an inner class, they have access to all field and methods on the enclosing class. 
- They can also access local variables and method arguments, that are final or effectively final. 

**Local Class's 'Captured Variables'**
- When you create an instance of a local class, referenced variables used in the class, from the enclosing code, are 'captured'.
- This means a copy is made of them, and the copy is stored with the instance. 
- This is done because the instance is stored in a different memory area, than the local variables in the method. 
- For this reason, if a local class uses local variables, or method arguments, from the enclosing code, these must be final or effectively final.

**Anonymous Classes**
- An anonymous class is a local class that doesn't have a name.
- All the nested classes we've looked at so far have been created with a class declaration.
- The anonymous class is never created with a class declaration, but it's always instantiated as part of an expression.
- Anonymous classes are used a lot less, since the introduction of Lambda Expressions in JDK 8.
- But there are still some use cases where an anonymous class might be a good solution.

**Anonymous class creation**
- An anonymous class is instantiated and assigned in a single statement. 
- The new Keyword is used followed by any type.
- This is NOT the type of the class being instantiated. 
- It's the super class of the anonymous class, or it's the interface this anonymous class will implement below.

<code>var c4 = new Comparator<StoreEmployee>() {};</code>
- In this first example, the anonymous unnamed class will implement the Comparator interface.

<code>var c4 = new Comparator<StoreEmployee>() {};</code>

- In this second example, the anonymous class extends the Employee class, meaning it's a subclass of Employee.

<code>var e1 = new Employee {}</code>

- In both cases, it's important to remember the semi-colon after the closing bracket, because this is an expression, not a declaration. 
- 