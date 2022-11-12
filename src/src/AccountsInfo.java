import java.util.HashMap;
import java.util.Map;

public class AccountsInfo implements Account{
	private static Map<Integer, BankAccount> accountValues;
	public AccountsInfo() {
		this.accountValues =  new HashMap<>();
	}
	public void addAccountDetailsToMap(int accountId, BankAccount bankaccount) {
		accountValues.put(accountId, bankaccount);
	}
	public void createAccount(String name, int balance) {
		BankAccount bankAccount = new BankAccount(name, balance);
		addAccountDetailsToMap(bankAccount.getAccountNo(), bankAccount);
		System.out.println(bankAccount.toString());
	}
	public void displayBalance(int accountId) {
		if(accountValues.containsKey(accountId)) {
			BankAccount bankAccount = accountValues.get(accountId);
			System.out.println(bankAccount.getBalance());
		}else {
			System.out.println("No account with id "+accountId);
		}
	}

	public void withdraw(int accountId, int amount) {
		if(amount >= 0 ) {
			if(accountValues.containsKey(accountId)) {
				BankAccount bankAccount = accountValues.get(accountId);
				if(bankAccount.getBalance() > amount) {
					bankAccount.setBalance(bankAccount.getBalance() - amount);
				}else {
					System.out.println("Insufficient amount ");
				}
			}else {
				System.out.println("No account with id "+accountId);
			}
		}else {
			System.out.println("Amount should be greater than zero ");
		}
		
	}

	public void depositAmount(int accountId, int amount) {
		if(amount >= 0 ) {
			if(accountValues.containsKey(accountId)) {
				BankAccount bankAccount = accountValues.get(accountId);
				bankAccount.setBalance( amount + bankAccount.getBalance());
			}else {
				System.out.println("No account with id "+accountId);
			}
		}else {
			System.out.println("Amount should be greater than zero ");
		}
	}
}
