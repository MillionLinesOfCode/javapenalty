![alt text](http://t2online.com/unsafe/780x380/smart/s3.ap-south-1.amazonaws.com/cms-abp-prod-media/library/polopoly_fs/1.75901.1496484359!/image/image.jpg_gen/derivatives/matrix2x1/image.jpg)
# javapenalty
A simple football penalty shootout game with a GUI written in the Java programming language.

# How it works

1.Select your favourite player from a list of five players.

2.Select a goalkeeper from a list of five keepers.

3.Choose where you want to shoot the ball.
 _A number (between 1 and 6) is randomly generated to determine where the keeper will dive._

4.If the goalkeeper guesses it right he saves the shot, else you score!

5.The player will get a total of 5 chances to score(or miss!).

# Installing 

1.Confirm that you are on the 'Demo-3' branch. If not, switch to this branch. 

2.Download all the files by clicking on the 'Clone or download' button and unzip the files in a directory of your choice.

3.Navigate to the unzipped folder and then proceed to the 'Penalty Shootout' folder, which should be in the unzipped folder.

3.Compile the .java files using

`javac *.java`

3.You should then be clear to run the AnimationApp.java file using 

`java AnimationApp`

4.Try scoring some goals against some of the best goalkeepers in the world!.
![alt text](http://lifesomundane.net/images/-rZ1GcHv5p_k/Uz4UWQqEHiI/AAAAAAAANMA/RzOgIadyUzE/s1600/penalty.jpg)

# Running JUnit tests 

1. Navigate to the directory/folder in which you downloaded all the files from the 'Demo-3' branch.

2. Ensure that you have junit-4.12.jar and hamcrest-core-1.3.jar in this folder as these are required for testing the java files.

3. Compile the java files and the test files using the command

`javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java`

4. Run the test using the command

`java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore <test class>`

*NOTE: Replace 'test class'(without brackets) with PlayerD3Test and GoalkeeperD3Test to test the Player.java and Goalkeeper.java files respectively.*

# Finding demo-2

* Navigate over to the 'Demo-2-Official' branch.

# Authors
* Reeyan Maknojiya
* Shehzan Udani
* Renji Takeda
* Ranadip Chatterjee

# Acknowledgments
* Our Professor(**Sohaib Bajwa**) and Teaching Assistant(**Daniel Fisher**) who provided indispensable, crucial, critical, key, vital and irreplaceable feedback which was of utmost help throughout the project.

* We haven't forgotten you yet,[StackOverflow](https://stackoverflow.com/)!.

* [For further reading on the topic of penalty kicks in football](https://en.wikipedia.org/wiki/Penalty_kick_(association_football))

![alt text](https://i.ytimg.com/vi/uZsnr4No36I/maxresdefault.jpg)
