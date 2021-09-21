package com.codehouse.data;

import java.util.ArrayList;

import com.codehouse.entity.Client;
import com.codehouse.entity.OperationStatus;

public class BankDAO {

	private ArrayList<Client> clients;

	private BankDAO() {
		Client client1 = new Client("Noah", 1, "01aaa", 3200);
		Client client2 = new Client("Ignatius", 2, "ab200", 4550);
		clients = new ArrayList<>();
		clients.add(client1);
		clients.add(client2);
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public boolean addClient(final Client client) {
		clients.add(client);
		OperationStatus.display("New Client Registered Successfully");
		return true;
	}

	public boolean removeClient(final int id) {
		int index = findIndexById(id);
		if (index != -1) {
			clients.remove(index);
			OperationStatus.display("Client Removed Successfully");
			return true;
		}
		OperationStatus.display("No Client With That ID");
		return false;
	}

//
//	private Client findById(final int id) {
//		for (Client client : clients) {
//			if (client.getId() == id)
//				return client;
//		}
//		return null;
//	}

	private int findIndexById(final int id) {
		for (Client client : clients) {
			if (client.getId() == id) {
				return clients.indexOf(client);
			}
		}
		return -1;
	}

	private static BankDAO bankDAO = null;

	public static BankDAO getBankDAO() {
		if (bankDAO == null)
			return new BankDAO();
		return bankDAO;
	}

}
