package myJpetStore.persistence;

import java.util.List;

import myJpetStore.domain.LineItem;

public interface LineItemDAO {
	
	List<LineItem> getLineItemsByOrderId(int orderId);

	  void insertLineItem(LineItem lineItem);

}
