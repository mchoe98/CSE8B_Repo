File Header:
This file contains my answers to the PSA8 questions.
I did not edit the Makefile.

Mark Choe
mychoe@ucsd.edu

Conceptual Question:
The overhead time does not change with the amount of threads, so that will
remain the same. It takes one thread 8 charTime to create an 8-character String
after the overhead time. After the overhead time, adding a second thread would
cut the time it takes to the 8-character String in half, because there are now
two threads working to create it. Thus, it would take 4 charTime on top of the
overhead time to create a legal 8-character String with two threads in use
simultaneously.

Pointer Question:
The benefit of the way we used pointers to build MyStringBuilder is that we can
avoid making brand new objects for a character we have previously used if we 
wanted to. We can just point the reference to the already used node with that 
chracter. To modify the way CharacterNodes used pointers to allow this, we
could create instance variable CharacterNodes that keep track of each letter.
With these CharacterNodes, we could just link these up with corresponding 
constructed CharacterNodes and reference them. To keep track of how many times
we should reuse a letter, we could just create an int tracker.

Design Question:
I used loops for MyStringBuilder. I used loops instead of recursion, because I
am just more comfortable with loops; I have much more experience with loops 
than with recursion. Loops take less time and memory than recursion, however,
recursion can provide clearer, simpler solutions than loops.

