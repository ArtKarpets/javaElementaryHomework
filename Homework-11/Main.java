package com.company;

import com.company.entity.Client;
import com.company.exception.UserExpectedError;
import com.company.exception.WrongFieldException;
import com.company.exception.WrongSumExseption;
import com.company.service.TransactionService;
import com.company.util.Helper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TransactionService tranzit = new TransactionService();
        Helper help = new Helper();
        Client client1 = new Client();
        Client client2 = new Client();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Введите идентификатор отправителя:");
            client1.setAccountID(scan.next());
            try {
                help.parameterSize(client1);
                break;
            } catch (WrongFieldException e) {
                e.printStackTrace();
                System.out.println("Введен не правильный идентификатор");
            }
        }

        while (true) {
            System.out.println("Введите идентификатор получателя:");
            client2.setAccountID(scan.next());
            try {
                help.customerComparison(client1, client2);
                break;
            } catch (UserExpectedError e) {
                e.printStackTrace();
                System.out.println("Введен не правильный идентификатор");
            }
        }

        while (true) {
            System.out.println("Введите сумму:");
            client1.setSum(scan.nextInt());
            try {
                help.sumAmount(client1);
                break;
            } catch (WrongSumExseption e) {
                e.printStackTrace();
                System.out.println("Сумма больше 1000, введите допустимую сумму");
            }
        }

        try {
            tranzit.transferOfMoney(client1, client2);
        } finally {
            System.out.println("операция прошла успешно");
        }
    }
}
