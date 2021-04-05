package stream_api.course;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingLong;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingLong;

public class TerminationWithCollectors {
    public static void main(String[] args) {

        // producing collections

        List<Account> accounts = List.of(
                new Account(20_000L, "12gh0009"),
                new Account(231_010L, "12gh0010")
        );

        List<Account> accountList = accounts.stream()
                .collect(Collectors.toList());

        Set<Account> accountSet = accounts.stream()
                .collect(Collectors.toSet());

        LinkedList<Account> specificCollection = accounts.stream()
                .collect(Collectors.toCollection(LinkedList::new));

        // producing values

        // summingInt, summingLong, summingDouble;
        // averagingInt, averagingLong, averagingDouble;
        // maxBy, minBy;
        // counting
        // reducing

        long summary = accounts.stream()
                .collect(summingLong(Account::getBalance));

        double average = accounts.stream()
                .collect(averagingLong(Account::getBalance));

        String megaNumber = accounts.stream()
                .collect(reducing("", a -> a.getNumber(), (ns, n) -> ns.concat(n)));
    }

    static class Account {
        private long balance;
        private String number;

        public Account() {
        }

        public Account(long balance, String number) {
            this.balance = balance;
            this.number = number;
        }

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
