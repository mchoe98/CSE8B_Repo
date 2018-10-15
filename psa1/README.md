File Header: This file answers the questions in the PSA instructions. 
Additionally, this file has summaries of the PSA parts and provides 
some details on the changes I made to the other files.

Mark Choe
mychoe@ucsd.edu
A13917840
01/12/18

Part 1:
A:types: terms.java explicitly lists int as a type. Integer is the same as int. 
B:instances: This is an individual of a class, has something that can execute
methods of this class, and has its own personal data.
C:method definition: This is writing a method.
D:parameters: These define the inputs of the method. 
E:method call: This is executing a method.

C and F are matched up because C sets up the parameters for the 
method, while F inputs the arguments for these parameters when
the method is called. Java is able to identify and connect the two
because they both refer to the same method within the same class.

Part 3:
p2:
1) The second parameter, t, is not checked to see whether or not
   it is a null value.
2) Inputting null for the second parameter will make it fail.
3) program crash
4) This method was written correctly, but the tutor who wrote this
   code just forgot to check for null pointer exceptions for the 
   second parameter. 
5) This mistake was minor. It only pertained to one parameter, and
   the code catches the null pointer exception.

p3:
1) Method p3 only checks for all the characters in the second parameter
   being present the correct number of times.
2) Adding any letters that were not orginally in the first parameter on top
   of any anagram of the first parameter will make it fail.
3) wrong output
4) This method was for the most part written correctly. The tutor who
   wrote this code just forgot to account for extra, different letters
   being added to the anagram.
5) This mistake was minorly critical. With its somewhat easily attainable
   wrong output this code can be quite misleading.

p4:
1) The values of the first parameter are not checked to see whether or 
   not they are null values. 
2) Inputting null for any of the first parameter's values will make it
   fail.
3) program crash
4) This method was for the most part written correctly. The tutor who
   wrote this code just forgot to check for null pointer exceptions for
   the first parameter's values.
5) This mistake was minor. It only pertained to one parameter, and the
   code catches the null pointer exception.

p5:
1) Method p5 only checks for all the characters in the second parameter
   being present. It does check for characters not present in the
   second parameter.
2) If the original uses two of the same character, using only one of those
   characters in an anagram will make it fail.
3) wrong output
4) This method was for the most part written correctly. The tutor who
   wrote this code just forgot to check for the anagrams to use the
   proper amount of characters.
5) This mistake was minorly critical. With its somewhat easily attainable
   wrong output this code can be quite misleading.

p6:
1) Method p6 does not check to see if the first parameter actually has
   any values.
2) Making the first parameter empty will make it fail.
3) wrong output
4) This method was for the most part written correctly. The tutor who
   wrote this code just forgot to check to see if the first parameter
   actually has any values.
5) This mistake was minor. Though this mistake results in a very different
   output from that which is expected, this mistake is fairly obvious and
   will probably not mislead anybody.

p7:
1) When comparing the possible anagrams to the given word, method p7 does
   not check to see if the given word has any extra characters compared to
   the possible anagrams, despite checking for the given word having the
   correct amount of characters compared to the possible anagrams.
2) Adding extra characters that were not in the given word to the second
   parameter will make it fail.
3) wrong output
4) This method was for the most part written correctly. The tutor who
   wrote this code just forgot to check to see if the first parameter
   had any extra, different letters.
5) This mistake was minorly critical. With its somewhat easily attainable 
   wrong output, this mistake can be quite misleading.

p8:
1) Method p8 counts the exact same word as an anagram.
2) Having a perfectly matching possible anagram and given word will make it
   fail.
3) wrong output
4) The tutor who wrote this code was probably just unaware of what specifically
   did and did not count as an anagram.
5) This mistake was critical, as it can easily mislead readers of what should
   and what should not be counting as an anagram.

Part 4:
1.
Trial 1: encryptTwo: 1.141s
	 encrypt: 20.045s
Trial 2: encryptTwo: 0.952s
	 encrypt: 21.023s
Trial 3: encryptTwo: 1.103s
	 encrypt: 21.536s
2. StringBuilder is more efficient than String because StringBuilder is mutable.
   Whenever changes are made to a String, a completely new String is created
   with these changes. However, when changes are made to a StringBuilder, a
   completely new StringBuilder is not created and the current StringBuilder is
   just modified. Due to creating less objects, StringBuilder is faster and more
   efficient.
3. Compared to Part B, coding Part A was slightly easier and less complicated,
   because Part B utilized both String and StringBuilder and required 
   translations between the two.

Summary
Part 1: Summary: In this section I matched vocabulary terms to portions of the
        image in the instructions. Additionally, I explained why C is matched up
	with F.
        Descriptions: My answers to this section are located under Part 1 in 
        README.md.
        Explanation: I learned some vocabulary terms for java. Additionally, I
        learned how to edit code using vim better.
Part 2: Summary: In this section I got rid of the mistakes in the given code and
	explained why these mistakes were incorrect.
        Descriptions: FunWithIntArrays.java contains the code I fixed. This code
	for the most part manipulates a list of numbers and provides info about
	it. ArraysTester.java tests this file to check if I correctly fixed it. 
        Explanation: I learned how to edit code using vim better. Specifically,
	I learned how to better fix code using vim.
Part 3: Summary: In this section I created tests for the given code to see if 
	there were any mistakes. Additionally, I provided details of found
	errors.
        Descriptions: My tests are located in AnagramTester.java. I knew my
	tests found an error when the results did not match the correct answer.
	The details of	the found errors are found in the README.md file.
        Explanation: I learned how to create tests to check for mistakes in
	code.
Part 4: Summary: In this section I created ways of encrypting and decrypting
	messages. Additionally, I compared the efficiciency between methods.
        Descriptions: Caesar.java contains the ways in which I encrypt and
	decrypt messages. To compare the efficiency between my methods I used
	a file called "script". I found that the method that does not keep
	creating new messages for every change is more efficient. Additonally,
	I answered the questions from the instructions pertaining this section 
	in the README.md file.
        Explanation: I learned how to encrypt and decrypt messages by changing
        around letters. Additionally, I learned how to increase the efficiency
        of my code.
