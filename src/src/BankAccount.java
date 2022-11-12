import java.util.Objects;
public class BankAccount {
	private static int accountNoValue = 5001;
	private int accountNo;
	private String name;
	private double balance;
	public BankAccount() {}
	public BankAccount(String name, double balance) {
		this.accountNo = accountNoValue;
		this.name = name;
		this.balance = balance;
		accountNoValue++;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return accountNo == other.accountNo
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(name, other.name);
	}
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount("rizers", 5000000);
		AccountsInfo accountsInfo = new AccountsInfo();
		System.out.println(bankAccount.toString());
		accountsInfo.addAccountDetailsToMap(bankAccount.getAccountNo(), bankAccount);
		accountsInfo.displayBalance(5001);
		
	}
}

