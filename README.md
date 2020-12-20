## Fruit RMI

Project that uses Java RMI protocol for objects in different heaps (JVMs) to communicate with each other.

<hr/>

### Compiling the java files.

Run the command: `javac -d out server/compute/FruitComputeEngine.java &` to compile server files.\
Run the command: `javac -d out client/ClientTask.java &` to compile client files.

<hr/>

### Start the server
The main file that runs the server is the `FruitComputeEngine.java` file.\
Run the command `java -classpath out server.compute.FruitComputeEngine &`\
The `FruitComputeTaskRegistry.java` creates a rmi registry file if one doesn't exist and binds the server to listen to port `1099`

***Note: You don't need to generate the server and client stubs, Java will automatically do this for you.***

### Start the client
The main file that runs the server is the `ClientTask.java` file.\
Run the command `java -classpath out client.ClientTask &` \
The following files implement serializable and Task interface to enable communication
 - `AddFruitPrice.java`
 - `CalFruitCost.java`
 - `ClientService.java`
 - `ClientTask.java`
 - `DeleteFruitPrice.java`
 - `Fruit.java` (This is the data model)
 - `PrintReceipt.java`
 - `UpdateFruit.java`