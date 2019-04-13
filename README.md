![alt text](http://t2online.com/unsafe/780x380/smart/s3.ap-south-1.amazonaws.com/cms-abp-prod-media/library/polopoly_fs/1.75901.1496484359!/image/image.jpg_gen/derivatives/matrix2x1/image.jpg)
# javapenalty

A simple football/soccer penalty shootout game, written in Java.

# How it works

1. Pick your favourite player from a list of five players. This is the player with which you will play this game.

2. Select a goalkeeper from a list of five keepers.

3. Choose where you want to shoot the ball.

4. On the bottom right, a speedbar will be displayed. It will be used to determine the strength with which you kick the football. Click on the desired range, arranged ascending from left to right, to power up your shot.

5. If the goalkeeper guesses it right he saves the shot, else you score!

6. The player will get a total of 5 chances to score(or miss!).

# Installing and running javapenalty(Text-based version)

1. Switch to 'Demo-3' branch.

2. Download *all the files* by clicking on the 'Clone or download' button and unzip the files in a directory of your choice.

3. Navigate to the unzipped folder and then proceed to the 'Penalty Shootout Text Version' folder, which should be in the unzipped folder.

4. Compile the .java files using

`javac *.java`

5. You should then be clear to run the AnimationApp file using 

`java AnimationApp`

![alt text](http://lifesomundane.net/images/-rZ1GcHv5p_k/Uz4UWQqEHiI/AAAAAAAANMA/RzOgIadyUzE/s1600/penalty.jpg)


# Installing and running javapenalty(GUI version)

1. Confirm that you are on the 'Demo-3' branch. If not, switch to this branch. 

2. Download all the files by clicking on the 'Clone or download' button and unzip the files in a directory of your choice.

3. Navigate to the unzipped folder and then proceed to the 'Penalty Shootout' folder, which should be in the unzipped folder.

3. Compile the .java files using

`javac *.java`

3. You should then be clear to run the AnimationApp file using 

`java AnimationApp`

# Running JUnit tests 

1. Navigate to the directory/folder in which you downloaded all the files from the 'Demo-3' branch.

2. Ensure that you have the files: junit-4.12.jar and hamcrest-core-1.3.jar in this folder as these are required for testing the java files.

3. Compile the java files and the test files using the command

`javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java`

4. Run the test using the commands

`java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore PlayerTest`

  and

`java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore GoalkeeperTest`

![alt text](https://simplifaster.com/articles/wp-content/uploads/sites/5/2018/07/Soccer-Penalty-Kick.jpg)

# Finding demo-2

* Navigate over to the 'Demo-2-Official' branch.

* Follow the same instructions as Installing and running javapenalty.


# Authors
* Reeyan Maknojiya
* Shehzan Udani
* Renji Takeda
* Ranadip Chatterjee

# Acknowledgments
* Our Professor(**Sohaib Bajwa**) and Teaching Assistant(**Daniel Fisher**) who provided indispensable, crucial, critical, key, vital and irreplaceable feedback which was of utmost help all through the project.

* [StackOverflow](https://stackoverflow.com/) of course.

* [For further reading on the topic of penalty kicks in football](https://en.wikipedia.org/wiki/Penalty_kick_(association_football))

![alt text](https://i.ytimg.com/vi/uZsnr4No36I/maxresdefault.jpg)
