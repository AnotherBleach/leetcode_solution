package com.another.tools;

import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteTools {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Hello hello = new HelloImpl();

        Hello proxy = (Hello) UnicastRemoteObject.exportObject(hello, 0);
        Registry registry = LocateRegistry.createRegistry(9999);
        registry.rebind("lc", proxy);


    }
}
