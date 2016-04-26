package myJpetStore.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import myJpetStore.domain.Account;
import myJpetStore.domain.Sequence;
import myJpetStore.persistence.DBUtil;
import myJpetStore.persistence.SequenceDAO;

public class SequenceDAOImpl implements SequenceDAO {
	private static final String GetSequenceString = "SELECT name, nextid FROM SEQUENCE WHERE NAME = ?";
	private static final String UpdateSequenceString  = " UPDATE SEQUENCE SET NEXTID =? WHERE NAME =?";


	public Sequence getSequence(Sequence sequence) {
		//Sequence sequence1 = null;
		 try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
                   .prepareStatement(GetSequenceString);
			pStatement.setString(1, sequence.getName());
			 ResultSet resultSet = pStatement.executeQuery();
			 if (resultSet.next()) {
				//  sequence1.setName(resultSet.getString(1));
				  sequence.setNextId(resultSet.getInt(2));
				  return sequence;
	            }
	            DBUtil.closeResultSet(resultSet);
	            DBUtil.closePreparedStatement(pStatement);
	            DBUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updateSequence(Sequence sequence) {
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
                    .prepareStatement(UpdateSequenceString);
			pStatement.setInt(1, sequence.getNextId());
			pStatement.setString(2, sequence.getName());
			pStatement.execute();
			
	        DBUtil.closePreparedStatement(pStatement);
	        DBUtil.closeConnection(connection);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
