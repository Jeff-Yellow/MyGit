package myJpetStore.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import myJpetStore.domain.Account;
import myJpetStore.domain.Product;
import myJpetStore.persistence.AccountDAO;
import myJpetStore.persistence.DBUtil;

public class AccountDAOImpl implements AccountDAO {
	private static final String getAccountByUsernameString = "SELECT SIGNON.USERNAME, ACCOUNT.EMAIL, ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS,ACCOUNT.ADDR1 AS address1, ACCOUNT.ADDR2 AS address2, ACCOUNT.CITY,ACCOUNT.STATE, ACCOUNT.ZIP, ACCOUNT.COUNTRY,ACCOUNT.PHONE,PROFILE.LANGPREF AS languagePreference, PROFILE.FAVCATEGORY AS favouriteCategoryId, PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
	private static final String insertAccountString = "INSERT INTO ACCOUNT (EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID) VALUES(?,?,?,?,?,?,?,?, ?,?,?,?)";
	private static final String insertProfileString = "INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID) VALUES (?, ?, ?)";
	private static final String insertSignonString = "INSERT INTO SIGNON (PASSWORD,USERNAME) VALUES (?,? )";
	private static final String updateAccountString = " UPDATE ACCOUNT SET EMAIL =?, FIRSTNAME =?, LASTNAME =?, STATUS =?, ADDR1 = ?, ADDR2 = ?,CITY = ?, STATE =?,ZIP =?, COUNTRY = ?, PHONE = ? WHERE USERID =?";
	private static final String updateProfileString = "UPDATE PROFILE SET LANGPREF = ?, FAVCATEGORY = ? WHERE USERID = ?";
	private static final String updateSignonString = "UPDATE SIGNON SET PASSWORD = ? WHERE USERNAME = ?";
	private static final String getAccountByUsernameAndPasswordString  = "SELECT SIGNON.USERNAME, ACCOUNT.EMAIL, ACCOUNT.FIRSTNAME, ACCOUNT.LASTNAME, ACCOUNT.STATUS, ACCOUNT.ADDR1 AS address1, ACCOUNT.ADDR2 AS address2,  ACCOUNT.CITY, ACCOUNT.STATE, ACCOUNT.ZIP,  ACCOUNT.COUNTRY, ACCOUNT.PHONE, PROFILE.LANGPREF AS languagePreference, PROFILE.FAVCATEGORY AS favouriteCategoryId, PROFILE.MYLISTOPT AS listOption, PROFILE.BANNEROPT AS bannerOption, BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID =? "+" AND SIGNON.PASSWORD =? "+" AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
	
public  Account getAccountByUsername(String username) {
		Account account = null;
		 try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
                    .prepareStatement(getAccountByUsernameString);
			pStatement.setString(1, username);
			 ResultSet resultSet = pStatement.executeQuery();
			 if (resultSet.next()) {
				  account = new Account();
				  account.setUsername(resultSet.getString(1));	
				  account.setEmail(resultSet.getString(2));
				  account.setFirstName(resultSet.getString(3));
				  account.setLastName(resultSet.getString(4));
				  account.setStatus(resultSet.getString(5));
				  account.setAddress1(resultSet.getString(6));
				  account.setAddress2(resultSet.getString(7));
				  account.setCity(resultSet.getString(8));
				  account.setState(resultSet.getString(9));
				  account.setZip(resultSet.getString(10));
				  account.setCountry(resultSet.getString(11));
				  account.setPhone(resultSet.getString(12));
				  account.setLanguagePreference(resultSet.getString(13));
				  account.setFavouriteCategoryId(resultSet.getString(14));
				  account.setListOption(resultSet.getBoolean(15));
				  account.setBannerOption(resultSet.getBoolean(16));
				  account.setBannerName(resultSet.getString(17));
				 
	            }
	            DBUtil.closeResultSet(resultSet);
	            DBUtil.closePreparedStatement(pStatement);
	            DBUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}


	public Account getAccountByUsernameAndPassword(Account account) {
		Account accountbypass = null;
		 try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
                   .prepareStatement(getAccountByUsernameAndPasswordString);
			pStatement.setString(1, account.getUsername());
			pStatement.setString(2, account.getPassword());
		    ResultSet resultSet = pStatement.executeQuery();
			 if (resultSet.next()) {
				 accountbypass = new Account();
				 accountbypass.setUsername(resultSet.getString(1));	
				 accountbypass.setEmail(resultSet.getString(2));
				 accountbypass.setFirstName(resultSet.getString(3));
				 accountbypass.setLastName(resultSet.getString(4));
				 accountbypass.setStatus(resultSet.getString(5));
				 accountbypass.setAddress1(resultSet.getString(6));
				 accountbypass.setAddress2(resultSet.getString(7));
				 accountbypass.setCity(resultSet.getString(8));
				 accountbypass.setState(resultSet.getString(9));
				 accountbypass.setZip(resultSet.getString(10));
				 accountbypass.setCountry(resultSet.getString(11));
				 accountbypass.setPhone(resultSet.getString(12));
				 accountbypass.setLanguagePreference(resultSet.getString(13));
				 accountbypass.setFavouriteCategoryId(resultSet.getString(14));
				 accountbypass.setListOption(resultSet.getBoolean(15));
				 accountbypass.setBannerOption(resultSet.getBoolean(16));
				 accountbypass.setBannerName(resultSet.getString(17));
				 
	            }
	            DBUtil.closeResultSet(resultSet);
	            DBUtil.closePreparedStatement(pStatement);
	            DBUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountbypass;
	}


	public void insertAccount(Account account) {
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
                    .prepareStatement(insertAccountString);
			pStatement.setString(1, account.getEmail());
			pStatement.setString(2, account.getFirstName());
			pStatement.setString(3, account.getLastName());
			pStatement.setString(4, account.getStatus());
			pStatement.setString(5, account.getAddress1());
			pStatement.setString(6, account.getAddress2());
			pStatement.setString(7, account.getCity());
			pStatement.setString(8, account.getState());
			pStatement.setString(9, account.getZip());
			pStatement.setString(10, account.getCountry());
			pStatement.setString(11, account.getPhone());
			pStatement.setString(12, account.getUsername());
			pStatement.execute();
			
	        DBUtil.closePreparedStatement(pStatement);
	        DBUtil.closeConnection(connection);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void insertProfile(Account account) {
		Connection connection;
		try {
			connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
	                .prepareStatement(insertProfileString);
			pStatement.setString(1, account.getLanguagePreference());
			pStatement.setString(2, account.getFavouriteCategoryId());
			pStatement.setString(3, account.getUsername());
			pStatement.execute();
			
		    DBUtil.closePreparedStatement(pStatement);
		    DBUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


	public void insertSignon(Account account) {
		
		Connection connection;
		try {
			connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
	                .prepareStatement(insertSignonString);
			pStatement.setString(1, account.getPassword());
			pStatement.setString(2, account.getUsername());
			pStatement.execute();
			
		    DBUtil.closePreparedStatement(pStatement);
		    DBUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void updateAccount(Account account) {
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
                    .prepareStatement(updateAccountString);
			pStatement.setString(1, account.getEmail());
			pStatement.setString(2, account.getFirstName());
			pStatement.setString(3, account.getLastName());
			pStatement.setString(4, account.getStatus());
			pStatement.setString(5, account.getAddress1());
			pStatement.setString(6, account.getAddress2());
			pStatement.setString(7, account.getCity());
			pStatement.setString(8, account.getState());
			pStatement.setString(9, account.getZip());
			pStatement.setString(10, account.getCountry());
			pStatement.setString(11, account.getPhone());
			pStatement.setString(12, account.getUsername());
			pStatement.execute();
			
	        DBUtil.closePreparedStatement(pStatement);
	        DBUtil.closeConnection(connection);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public void updateProfile(Account account) {
		Connection connection;
		try {
			connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
	                .prepareStatement(updateProfileString);
			pStatement.setString(1, account.getLanguagePreference());
			pStatement.setString(2, account.getFavouriteCategoryId());
			pStatement.setString(3, account.getUsername());
			pStatement.execute();
			
		    DBUtil.closePreparedStatement(pStatement);
		    DBUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void updateSignon(Account account) {
		Connection connection;
		try {
			connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
	                .prepareStatement(updateSignonString);
			pStatement.setString(1, account.getPassword());
			pStatement.setString(2, account.getUsername());
			pStatement.execute();
			
		    DBUtil.closePreparedStatement(pStatement);
		    DBUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
