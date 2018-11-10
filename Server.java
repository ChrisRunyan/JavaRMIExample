// filename: Server.java

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.rmi.*;
import java.rmi.server.*;

public class Server implements Hello2 {
	public Server() {}
	
	public String sayHello() {
		return "Hello, world!";
	}

	public String sayHello(Student std) throws RemoteException {
		std.setID(9999);
		System.out.println("new ID: " + std.getID());
		return "Hello, world2!";
	}

	public static void main(String args[]) {
		try {
			// set the security manager
			Server obj = new Server();
			Hello2 stub = (Hello2) UnicastRemoteObject.exportObject(obj, 0);
			
			// bind the remote object's stub in the registry
			//Registry registry = LocateRegistry.getRegistry();
			Registry registry = LocateRegistry.getRegistry(00000);
			registry.bind("Hello2", stub);
			System.err.println("Server ready");
		}
		catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
