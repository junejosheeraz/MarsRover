										README
										======
					
								MarsRover 0.1.0-SNAPSHOT
								------------------------
					
Welcome to the MarsRover exploration project. The aim of this project is to navigate
virtual robot in a specified confined space with plain string commands like `RLFFRRL`
where each character provided by user would be translated into a specific command and
then list of these commands will be executed on a robot. 


JDK Version Notes
-----------------

The MarsRover is built and supported with JDK 1.7 or higher and tested with the same version.


Requirements
------------

You can use Maven 3.X.X to build the project. Note that project build and tested with Eclipse 
embedded maven 3.0.4.


Build
------

		UNIX/Linux
		----------
		
		1. 	Unzip the MarsRover.zip archive
		
		2. 	Set the JAVA_HOME to the JDK 11:
				
				export JAVA_HOME=<JDK_Install_Dir>
		
		3. 	Set MAVEN_HOME to maven install dir:
				
				export MAVEN_HOME=<Maven_Install_Dir>
				
		3. 	Add JAVA_HOME/bin and MAVEN_HOME/bin into PATH:
				
				export PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH
				
		4. 	Navigate to the extracted 'MarsRover' directory you got after Step 1 and
			apply following command to build the source, run unit test and release 
			the project artifact:
				
				mvn clean install

		Windows
		-------
		
		1. 	Unzip the MarsRover.zip archive
		
		2. 	Set the JAVA_HOME to the JDK 11:
				
				export JAVA_HOME=<JDK_Install_Dir>
		
		3. 	Set MAVEN_HOME to maven install dir:
				
				export MAVEN_HOME=<Maven_Install_Dir>
				
		3. 	Add JAVA_HOME/bin and MAVEN_HOME/bin into PATH:
					export PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%
				
		4. 	Navigate to the extacted 'MarsRover' directory you got after Step 1 and
			apply following command to build the source, run unit test and release 
			the project artifact:

				mvn clean install
			
Execution
---------			
		
	Server Side
	-----------
	
		1.  Successfull build will produce executable MarsRover jar under
			'target\MarsRover-0.1.0-SNAPSHOT.jar', run the jar as follows to start 
			the MarsRover:
				java -jar target\MarsRover-0.1.0-SNAPSHOT.jar {GridWidth} {GridHeight}
			
			Note: GridWidth & GridHeight are optional, if not provided program will use default as 5X5
		
		2.  Above command will present MarsRover menu as follows:
				Mars Rover Exploration
				======================
				Current grid view:
 				_ _ _ _ _ _ _ _ _ _
 				_ _ _ _ _ _ _ _ _ _
 				_ _ _ _ _ _ _ _ _ _
 				_ _ _ _ _ _ _ _ _ _
 				_ _ _ _ _ _ _ _ _ _
 				_ _ _ _ _ _ _ _ _ _
 				_ _ _ _ _ _ _ _ _ _
 				_ _ _ _ _ _ _ _ _ _
 				_ _ _ _ _ _ _ _ _ _
 				^ _ _ _ _ _ _ _ _ _


				Enter command for Rover to move (Example: RFLFFRF, X to exit) ? 
			
			
Note: From here you can control the Rover (which is represented as `^` symbol in grid layout).
		
Enjoy!