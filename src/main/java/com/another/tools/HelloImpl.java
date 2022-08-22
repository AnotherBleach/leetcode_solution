package com.another.tools;

import java.rmi.RemoteException;

public class HelloImpl implements Hello{
    @Override
    public String sayHello() throws RemoteException {

        return (System.getProperty("os.name"));

    }
}
