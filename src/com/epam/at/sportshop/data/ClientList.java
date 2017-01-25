package com.epam.at.sportshop.data;

import com.epam.at.sportshop.beans.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains data of all clients.
 * Singleton pattern.
 *
 * @author Eugeny Titenkov
 */
public class ClientList {
    private List<Client> clients = new ArrayList<>();
    private static ClientList clientList;

    private ClientList() {
    }

    public static ClientList getClientList() {
        if (clientList == null) {
            clientList = new ClientList();
        }
        return clientList;
    }

    /**
     * Adds client to the list.
     *
     * @param client - client to add.
     * @return object of ClientList.
     */
    public ClientList addClient(Client client) {
        clients.add(client);
        return this;
    }

    /**
     * Removes the client from the list.
     *
     * @param client - client to delete.
     * @return object of ClientList.
     */
    public ClientList deleteClient(Client client) {
        clients.remove(client);
        return this;
    }

    /**
     * Looking client in the list and returns it.
     *
     * @param client - client to find.
     * @return object of client if he was found, else returns null.
     */
    public Client getClient(Client client) {
        for (Client currentClient : clients) {
            if (currentClient.getName().equals(client.getName()) &&
                    currentClient.getPhoneNumber().equals(client.getPhoneNumber())) {
                return currentClient;
            }
        }
        return null;
    }

    /**
     * Displays the information about all clients with their rented unit.
     */
    public void displayRentClientsInfo() {
        for (Client client: clients) {
            System.out.println(client);
        }
    }
}
