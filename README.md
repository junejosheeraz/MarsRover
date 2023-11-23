# MarsRover 
					
Welcome to the MarsRover exploration project. This project aims to navigate a virtual robot in a specified confined space with plain string commands like `RLFFRRL` where each character provided by a user would be translated into a specific command and then the list of these commands will be executed on a robot.

This project uses Command pattern and abstract UI from the execution layer hence providing an opportunity in the future to provide any UI as per need.

## JDK Version Notes

The MarsRover is built and supported with JDK 11 or higher and tested with the same version.

## Requirements

You can use Maven 3.3.X to build the project. Note that the project was built and tested with Eclipse embedded maven 3.3.8 as well as Visual Studio Code.

## Container (Docker) Support

Run the rover using the Docker container with a single command.

	docker run -i junejosheeraz/marsrover 10 10

Container image would be pulled from [Docker Hub](https://hub.docker.com/repository/docker/junejosheeraz/marsrover/general)

#### Note: Make sure you have a cker desktop or container runtime available. The project has been tested using Docker

## System Build

### UNIX/Linux
	
	1. 	Unzip the MarsRover.zip archive
	
	2. 	Set the JAVA_HOME to the JDK 11:
			
			export JAVA_HOME=<JDK_Install_Dir>
	
	3. 	Set MAVEN_HOME to maven install dir:
			
			export MAVEN_HOME=<Maven_Install_Dir>
			
	3. 	Add JAVA_HOME/bin and MAVEN_HOME/bin into PATH:
			
			export PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH
			
	4. 	Navigate to the extracted 'MarsRover' directory you got after Step 1 and
		apply the following command to build thsource, run the unit test and release 
		the prprojectrtefact:
			
			mvn clean install

### Windows

	1. 	Unzip the MarsRover.zip archive
	
	2. 	Set the JAVA_HOME to the JDK 11:
			
			export JAVA_HOME=<JDK_Install_Dir>
	
	3. 	Set MAVEN_HOME to maven install dir:
			
			export MAVEN_HOME=<Maven_Install_Dir>
			
	3. 	Add JAVA_HOME/bin and MAVEN_HOME/bin into PATH:
				export PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%
			
	4. 	Navigateo the extracted 'MarsRover' directory you got after Step 1 aTheply the follthe owing command to build the source, ruthee unit test and release 
		the project artefact:

			mvn clean install
			
### Execution
	
	1.  Successful build will produce an executable MarsRover jar under
		'target\MarsRover-0.1.0-SNAPSHOT.jar', run the jar as follows to start 
		the MarsRover:
			java -jar target\MarsRover-0.1.0-SNAPSHOT.jar {GridWidth} {GridHeight}
		
		Note: GridWidth & GridHeight are optional, if not provided program will use default as 5X5
		
	2.  The above command will present the MarsRover menu as follows:
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


		Enter command for Rover to move (Example: RFLFFRF, X to exit)? 
	
		
### Note: From here you can control the Rover (which is represented as the `^` symbol in the grid layout).
		
### Enjoy!
