**Lambda Mini Challenges**
- This challenge video is going to be a little different, and consist of several small tasks, to help you really practice creating and using lambda expressions.
- I'll assign a task you to try on your own, and then we will solve it together.
- Then I'll present the next one, and so on.

**Mini Challenge 1**
- Write the following anonymous class that you can see on screen, as a lambda expression. 
- Try to do it manually on your own, rather than relying on IntelliJ's tools to do it for you.
- This will help you understand lambdas better.

<pre><code>
Consumer<String> printTheParts = new Consumer<String>() {
    @Override
    public void accept(String sentence) {
        String[] parts = sentence.split(" ");
        for (String part : parts) {
            System.out.println(part);
        }
    }
};
</code></pre>