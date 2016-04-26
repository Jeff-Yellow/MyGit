package myJpetStore.service;

import myJpetStore.domain.Account;
import myJpetStore.persistence.AccountDAO;
import myJpetStore.persistence.impl.AccountDAOImpl;



public class AccountService {


  private AccountDAO accountDAO;
  public AccountService(){
	  
	  accountDAO = new AccountDAOImpl();
  }
  

  public Account getAccount(String username) {
    return accountDAO.getAccountByUsername(username);
  }

  public Account getAccount(String username, String password) {
    Account account = new Account();
    account.setUsername(username);
    account.setPassword(password);
    return accountDAO.getAccountByUsernameAndPassword(account);
  }

  public void insertAccount(Account account) {
	  accountDAO.insertAccount(account);
	  accountDAO.insertProfile(account);
	  accountDAO.insertSignon(account);
  }

  public void updateAccount(Account account) {
	  accountDAO.updateAccount(account);
	  accountDAO.updateProfile(account);
	  accountDAO.updateSignon(account);

    if (account.getPassword() != null && account.getPassword().length() > 0) {
    	accountDAO.updateSignon(account);
    }
  }
  public Boolean uernameIsExist(String username){
	  Account account1 = new Account();
	  account1 = accountDAO.getAccountByUsername(username);
	  if(account1 ==null){
		  return false;
	  }else{
		  return true;
	  }
  }

}
