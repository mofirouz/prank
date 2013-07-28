__Mouse Mover Prank__

A little Java script/application that moves a victim mouse bit by bit every X seconds.          
This program monitors the existence of a file. If file exists, then the mouse will be moved.          
This program tries not to be a CPU hog.          

_Configuration_
          
Download this source, create a file in `src/main/resources` named `prank.config`. (Only the first two lines are parsed)
- Prank configuration (such as SMB password/user).
- Location of the 'stop' file. Stop file can have Prank Properties that can be changed on the fly.

_Prank Properties_
         
List of properties are given below:
- `QUIT` - If set, will terminate the application. (have to be in capital)
- `PAUSE=false` - Will pause the script. Will have the same effect as removing stop file.
- `speed=100` - Speed that the cursor will move (1 - 30000ms) (Higher number, slower speed)
- `distance=100` - Distance that the cursor will move (1px - 1000px)
- `jiggle=true` - Will re-evaluate whether to move the mouse negative or positive in X/Y position for every movement.

_Building_       

Project depends on Gradle 1.0+.      
You can build the project using `gradle clean build`.        
A deployable jar file is created in the `build/lib` folder.        

