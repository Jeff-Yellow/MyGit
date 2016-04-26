package myJpetStore.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import myJpetStore.domain.Category;
import myJpetStore.domain.LineItem;
import myJpetStore.persistence.DBUtil;
import myJpetStore.persistence.LineItemDAO;

public class LineItemDAOImpl implements LineItemDAO {
	private static final String GetLineItemsByOrderIdString = " SELECT ORDERID, LINENUM AS lineNumber, ITEMID, QUANTITY, line FROM LINEITEM WHERE ORDERID =?";
	private static final String InsertLineItemString = "INSERT INTO LINEITEM (ORDERID, LINENUM, ITEMID, QUANTITY, UNITPRICE) VALUES (?,?, ?,?,?)";


	public List<LineItem> getLineItemsByOrderId(int orderId) {
		 List<LineItem> result = new ArrayList<LineItem> ();
	        try {
	            Connection conn = DBUtil.getConnection();
	            PreparedStatement statement = conn.prepareStatement(GetLineItemsByOrderIdString);
	            statement.setInt(1, orderId);
	            ResultSet resultSet = statement.executeQuery(GetLineItemsByOrderIdString);

	            while(resultSet.next())
	            {
	                LineItem lineItem = new LineItem();
	                lineItem.setOrderId(resultSet.getInt(1));
	                lineItem.setLineNumber(resultSet.getInt(2));
	                lineItem.setItemId(resultSet.getString(3));
	                lineItem.setQuantity(resultSet.getInt(4));
	                lineItem.setUnitPrice(resultSet.getBigDecimal(5));
	                result.add(lineItem);
	            }
	            DBUtil.closeResultSet(resultSet);
	            DBUtil.closeStatement(statement);
	            DBUtil.closeConnection(conn);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	}


	public void insertLineItem(LineItem lineItem) {
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pStatement = connection
                    .prepareStatement(InsertLineItemString);
			
			pStatement.setInt(1,lineItem.getOrderId() );
			pStatement.setInt(2,lineItem.getLineNumber());
			pStatement.setString(3,lineItem.getItemId());
			pStatement.setInt(4, lineItem.getQuantity());
			pStatement.setBigDecimal(5, lineItem.getUnitPrice());
			pStatement.execute();
			
	        DBUtil.closePreparedStatement(pStatement);
	        DBUtil.closeConnection(connection);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
