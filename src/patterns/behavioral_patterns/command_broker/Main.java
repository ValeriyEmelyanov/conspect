package patterns.behavioral_patterns.command_broker;

import patterns.behavioral_patterns.command_broker.broker.Broker;
import patterns.behavioral_patterns.command_broker.broker.Option;
import patterns.behavioral_patterns.command_broker.command.BuyCommand;
import patterns.behavioral_patterns.command_broker.command.Command;
import patterns.behavioral_patterns.command_broker.command.SellCommand;

import java.util.Scanner;

/**
 * Broker has two commands which are buy and sell.
 * The user gives an input sequence which is the amount of options to be bought and sold.
 * If the user has given a positive number it is to be bought.
 * If the user has given a negative number, that amount should be sold.
 * The user will give only three inputs.
 */
public class Main {
    public static void main(String[] args) {
        int commandNumber = 3;
        int[] amountList = new int[commandNumber];

        final Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < amountList.length; i++) {
            amountList[i] = scanner.nextInt();
        }
        scanner.close();

        Broker broker = new Broker();
        for (int i = 0; i < amountList.length; i++) {
            Option option = new Option(amountList[i]);
            Command command;
            if (amountList[i] < 0) {
                command = new SellCommand(option);
            } else {
                command = new BuyCommand(option);
            }
            broker.setCommand(command);
            broker.executeCommand();
        }
    }
}
