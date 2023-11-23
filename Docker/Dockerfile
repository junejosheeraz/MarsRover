# Base image to have git ready
FROM maven:3.8.1-adoptopenjdk-11
RUN apt-get -y update
RUN apt-get -y install git
RUN apt-get -y install openjdk-11-jre

# Get git and clone repo
RUN git clone https://github.com/junejosheeraz/MarsRover.git

# Get Maven setup with JDK 11
# FROM maven:3.8.1-adoptopenjdk-11

# Change working directory to project folder
WORKDIR /MarsRover

# Build the project
RUN mvn install

# Change working directory and update the jar name from snapshot to plain name
WORKDIR /MarsRover/target
RUN mv *.jar MarsRover.jar

# Define entry point by executing the jar
ENTRYPOINT ["java", "-jar", "/MarsRover/target/MarsRover.jar"]