package com.company.service;

import com.company.entity.Client;
import com.company.util.Helper;

public class TransactionService {

    public void transferOfMoney(Client client, Client clientAccountID) {
        Helper help = new Helper();
        if (!client.getClientID().equals(clientAccountID.getAccountID())) {
            help.customerComparison(client, clientAccountID);
        }
    }
}

