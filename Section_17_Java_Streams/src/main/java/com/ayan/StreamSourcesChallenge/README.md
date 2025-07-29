**The Stream Source Challenge**
- Generate the bingo ball labels as 5 different streams, using different Stream creation methods for each.
- Assign each pipeline to a stream variable.
- Concatenate the five streams together.
- Apply the terminal operation, forEach, to the final concatenated stream, to print each label.
- These should be printed in order as follows. 
    - B1 - B15  
    - I16 - I30
    - N31 - N45
    - G45 - G60
    - O61 - O75
- Remember that the **map** intermediate operation takes a Function, so you can return a different type, than the input stream element.
- To do this, you'd use map to return a String, by executing a method or expression that takes an integer and returns a String.
- The generate method may be difficult to use without creating side effects, or using other intermediate operations I haven't yet mentioned, but if you want a good challenge, you can play around with this one.
- It's time for you to give this a try, and when you're ready, comeback, and we can walk thorugh my solution together.

