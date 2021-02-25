package com.company.util;

import com.company.entity.Client;
import com.company.exception.UserExpectedError;
import com.company.exception.WrongFieldException;
import com.company.exception.WrongSumExseption;

public class Helper {

    public void parameterSize(Client clientAccountID) throws WrongFieldException {
        checkClientAccountID(clientAccountID);
    }

    public void sumAmount(Client sum) throws WrongSumExseption {
        checkSum(sum);
    }

    public void customerComparison(Client sender, Client host) {
        checkTransactions(sender, host);
    }

    private void checkClientAccountID(Client clientID) throws WrongFieldException {
        if (clientID.getAccountID().length() != 10) {
            throw new WrongFieldException();
        }
    }

    private void checkSum(Client sum) throws WrongSumExseption {
        if (sum.getSum() > 1000) {
            throw new WrongSumExseption();
        }
    }

    private void checkTransactions(Client clientAccountID1, Client clientAccountID2) throws UserExpectedError {
        if (!clientAccountID1.getAccountID().equals(clientAccountID2.getAccountID())) {
            throw new UserExpectedError();
        }
    }
}