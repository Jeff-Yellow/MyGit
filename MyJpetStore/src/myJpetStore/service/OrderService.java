package myJpetStore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myJpetStore.persistence.ItemDAO;
import myJpetStore.persistence.LineItemDAO;
import myJpetStore.persistence.OrderDAO;
import myJpetStore.persistence.SequenceDAO;
import myJpetStore.persistence.impl.ItemDAOImpl;
import myJpetStore.persistence.impl.LineItemDAOImpl;
import myJpetStore.persistence.impl.OrderDAOImpl;
import myJpetStore.persistence.impl.SequenceDAOImpl;
import myJpetStore.domain.Item;
import myJpetStore.domain.LineItem;
import myJpetStore.domain.Order;
import myJpetStore.domain.Sequence;



public class OrderService {

	 private ItemDAO itemDAO;

	  private OrderDAO orderDAO;

	  private SequenceDAO sequenceDAO;

	  private LineItemDAO lineItemDAO;

	  public OrderService(){
	    itemDAO = new ItemDAOImpl();
	    orderDAO = new OrderDAOImpl();
	    sequenceDAO = new SequenceDAOImpl();
	    lineItemDAO = new LineItemDAOImpl();
	  }

	  public void insertOrder(Order order) {
	    order.setOrderId(getNextId("ordernum"));
	    for (int i = 0; i < order.getLineItems().size(); i++) {
	      LineItem lineItem = (LineItem) order.getLineItems().get(i);
	      String itemId = lineItem.getItemId();
	      Integer increment = new Integer(lineItem.getQuantity());
	      Map<String, Object> param = new HashMap<String, Object>(2);
	      param.put("itemId", itemId);
	      param.put("increment", increment);
	      itemDAO.updateInventoryQuantity(param);
	    }

	    orderDAO.insertOrder(order);
	    orderDAO.insertOrderStatus(order);
	    for (int i = 0; i < order.getLineItems().size(); i++) {
	      LineItem lineItem = (LineItem) order.getLineItems().get(i);
	      lineItem.setOrderId(order.getOrderId());
	      lineItemDAO.insertLineItem(lineItem);
	    }
	  }


	  public Order getOrder(int orderId) {
	    Order order = orderDAO.getOrder(orderId);
	    order.setLineItems(lineItemDAO.getLineItemsByOrderId(orderId));

	    for (int i = 0; i < order.getLineItems().size(); i++) {
	      LineItem lineItem = (LineItem) order.getLineItems().get(i);
	      Item item = itemDAO.getItem(lineItem.getItemId());
	      item.setQuantity(itemDAO.getInventoryQuantity(lineItem.getItemId()));
	      lineItem.setItem(item);
	    }

	    return order;
	  }

	  public List<Order> getOrdersByUsername(String username) {
	    return orderDAO.getOrdersByUsername(username);
	  }

	  public int getNextId(String name) {
	    Sequence sequence = new Sequence(name, -1);
	    sequence = (Sequence) sequenceDAO.getSequence(sequence);
	    if (sequence == null) {
	      throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
	          + " sequence).");
	    }
	    Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
	    sequenceDAO.updateSequence(parameterObject);
	    return sequence.getNextId();
	  }

}
