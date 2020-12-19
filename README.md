## Fruit RMI
Project that uses Java RMI protocol for objects in different heaps to communicate with each other.


### Compiling the java files.
Run the command: `javac -d out server/compute/FruitComputeEngine.java &` to compile server files
Run the command: `javac -d out client/ClientTask.java &` to compile client files

### Start the server
Run the command `java -classpath out server.compute.FruitComputeEngine &`

### Start the client
Run the command `java -classpath out client.ClientTask &`