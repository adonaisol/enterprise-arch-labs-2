package cs544.sph1.dao;

import java.util.Collection;

import cs544.sph1.domain.Account;



public interface IAccountDAO {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(long accountnumber);
	public Collection<Account> getAccounts();
}
