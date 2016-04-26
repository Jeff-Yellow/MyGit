<%--
  Created by IntelliJ IDEA.
  User: NERV
  Date: 15/4/20
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../common/IncludeTop.jsp"%>

  <ul class="messages">
    <li>Thank you, your order has been submitted.</li>
  </ul>
  <div id="BackLink">
    <a href="main">Return to Main Menu</a>
  </div>

  <div id="Catalog">

    <table>
      <tbody>
      <tr>
        <th align="center" colspan="2">Order #${sessionScope.order.orderId}
          <fmt:formatDate value="${sessionScope.order.orderDate}"
                          pattern="yyyy/MM/dd hh:mm:ss" /></th>
      </tr>
      <tr>
        <th colspan="2">Payment Details</th>
      </tr>
      <tr>
        <td>Card Type:</td>
        <td>${sessionScope.order.cardType}</td>
      </tr>
      <tr>
        <td>Card Number:</td>
        <td>${sessionScope.order.creditCard}</td>
      </tr>
      <tr>
        <td>Expiry Date (MM/YYYY):</td>
        <td>${sessionScope.order.expiryDate}</td>
      </tr>
      <tr>
        <th colspan="2">Billing Address</th>
      </tr>
      <tr>
        <td>First name:</td>
        <td>${sessionScope.order.billToFirstName}</td>
      </tr>
      <tr>
        <td>Last name:</td>
        <td>${sessionScope.order.billToLastName}</td>
      </tr>
      <tr>
        <td>Address 1:</td>
        <td>${sessionScope.order.billAddress1}</td>
      </tr>
      <tr>
        <td>Address 2:</td>
        <td>${sessionScope.order.billAddress2}</td>
      </tr>
      <tr>
        <td>City:</td>
        <td>${sessionScope.order.billCity}</td>
      </tr>
      <tr>
        <td>State:</td>
        <td>${sessionScope.order.billState}</td>
      </tr>
      <tr>
        <td>Zip:</td>
        <td>${sessionScope.order.billZip}</td>
      </tr>
      <tr>
        <td>Country:</td>
        <td>${sessionScope.order.billCountry}</td>
      </tr>
      <tr>
        <th colspan="2">Shipping Address</th>
      </tr>
      <tr>
        <td>First name:</td>
        <td>${sessionScope.order.shipToFirstName}</td>
      </tr>
      <tr>
        <td>Last name:</td>
        <td>${sessionScope.order.shipToLastName}</td>
      </tr>
      <tr>
        <td>Address 1:</td>
        <td>${sessionScope.order.shipAddress1}</td>
      </tr>
      <tr>
        <td>Address 2:</td>
        <td>${sessionScope.order.shipAddress2}</td>
      </tr>
      <tr>
        <td>City:</td>
        <td>${sessionScope.order.shipCity}</td>
      </tr>
      <tr>
        <td>State:</td>
        <td>${sessionScope.order.shipState}</td>
      </tr>
      <tr>
        <td>Zip:</td>
        <td>${sessionScope.order.shipZip}</td>
      </tr>
      <tr>
        <td>Country:</td>
        <td>${sessionScope.order.shipCountry}</td>
      </tr>
      <tr>
        <td>Courier:</td>
        <td>${sessionScope.order.courier}</td>
      </tr>
      <tr>
        <td colspan="2">Status: ${sessionScope.order.status}</td>
      </tr>
      <tr>
        <td colspan="2">
          <table>
            <tbody>
            <tr>
              <th>Item ID</th>
              <th>Description</th>
              <th>Quantity</th>
              <th>Price</th>
              <th>Total Cost</th>
            </tr>

            <c:forEach var="lineItem" items="${sessionScope.order.lineItems}">
            <tr>
              <td><a href="Item?itemId=${lineItem.item.itemId}">${lineItem.item.itemId}</a></td>
              <td><c:if test="${lineItem.item != null}">
                ${lineItem.item.attribute1}
                ${lineItem.item.attribute2}
                ${lineItem.item.attribute3}
                ${lineItem.item.attribute4}
                ${lineItem.item.attribute5}
                ${lineItem.item.product.name}
              </c:if> <c:if test="${lineItem.item == null}">
                <i>{description unavailable}</i>
              </c:if></td>

              <td>${lineItem.quantity}</td>
              <td><fmt:formatNumber value="${lineItem.unitPrice}"
                                    pattern="$#,##0.00" /></td>
              <td><fmt:formatNumber value="${lineItem.total}"
                                    pattern="$#,##0.00" /></td>
            </tr>
            </c:forEach>
            <tr>
              <th colspan="5">Total: <fmt:formatNumber
                      value="${sessionScope.order.totalPrice}" pattern="$#,##0.00" /></th>
            </tr>
          </table>
        </td>
      </tr>

    </table>

  </div>
  <%@include file="../common/IncludeBottom.jsp"%>
