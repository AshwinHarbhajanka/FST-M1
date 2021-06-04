package activities;
public class BankAccount {

	private int balance;

	public BankAccount(int initialAmount) {
		balance = initialAmount;
	}

	public int withdraw(int amount) {
		if (balance < amount)
			throw new NotEnoughFundsException(amount, balance);
		balance -= amount;
		return balance;
	}
}
