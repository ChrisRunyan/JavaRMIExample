// filename: Hello2.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello2 extends Remote {
	String sayHello(Student std) throws RemoteException;
} 
