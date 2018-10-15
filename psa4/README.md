File Header:
This file contains my answers for PSA4 Part 4's questions.
These answers are at least 4 sentences and do not exceed 6 sentences.

Mark Choe
mychoe@ucsd.edu

1. Adding this method to Critter.java, causes all of Critter.java's sub
classes to inherit this method. This means that all other Critters will 
have this same method. Additonally, because none of Critter.java's
sub classes have this method, this method will never be overriden. This
means that all other Critters will execute this method the exact same way
Critter.java does.

2. SadAnimal.java does not have a fight method in it. However, its super
class, Critter.java, does. Thus, SadAnimal.java inherits a fight method
from Critter.java. Because Critter.java's fight method always forfeits,
so too will SadAnimal.java's fight method.

3. Commenting out the getColor method in HappyAnimal.java causes all
HappyAnimals and HappyAnimal sub class objects to become black. Without` 
a method to change the color to the decided color, these types of critters
will utilize Critter.java's method of getting colors due to Critter.java 
being their super class. This method just makes the critters black.

4. Adding an instance variable that is both public and static will affect
every class connected to SadAnimal.java in any way. The public status causes
this extension to everything. Additionally, any changes to this variable
will affect all constructed Sad Animals. The static status causes this.
