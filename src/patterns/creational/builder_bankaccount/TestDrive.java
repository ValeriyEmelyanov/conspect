package patterns.creational.builder_bankaccount;

public class TestDrive {
    public static void main(String[] args) {
        BankAccount account = new BankAccount.Builder(1234L)
                .withOwner("Marge")
                .atBranch("Springfield")
                .openingBalance(100)
                .atRate(2.5)
                .build();
        System.out.println(account);

        BankAccount anotherAccount = new BankAccount.Builder(4567L)
                .withOwner("Homer")
                .atBranch("Springfield")
                .openingBalance(100)
                .atRate(2.5)
                .build();
        System.out.println(anotherAccount);
    }
}
