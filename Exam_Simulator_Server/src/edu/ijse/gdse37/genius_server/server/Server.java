/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.server;

import edu.ijse.gdse37.genius_server.controllers.RemoteFactoryImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dinuka
 */
public class Server {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "localhost");
            Registry rmiRegistry=LocateRegistry.createRegistry(5050);
            System.out.println("Server is running....");
            rmiRegistry.rebind("Server", new RemoteFactoryImpl());
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
