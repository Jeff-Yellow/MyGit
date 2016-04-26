<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="main">Return to Main Menu</a>
	</div>

<div id="Catalog">
Please confirm the information below and then press continue...
<form action="confirmedOrder" method="post">
<table>
	<tr>
		<th align="center" colspan="2"><font size="4"><b>Order</b></font>
		<br />
		<font size="3">
			<b>
			
			</b>
		</font>
		</th>
	</tr>

	<tr>
		<th colspan="2">Billing Address</th>
	</tr>
	<tr>
		<td>First name:</td>
		<td><c:out value="${sessionScope.account.firstName}" /></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><c:out value="${sessionScope.account.lastName}" /></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><c:out value="${sessionScope.account.address1}" /></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><c:out value="${sessionScope.account.address2}" /></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><c:out value="${sessionScope.account.city}" /></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><c:out value="${sessionScope.account.state}" /></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><c:out value="${sessionScope.account.zip}" /></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><c:out value="${sessionScope.account.country}" /></td>
	</tr>
	<tr>
		<th colspan="2">Shipping Address</th>
	</tr>
	<tr>
		<td>First name:</td>
		<td><c:out value="${sessionScope.order.shipToFirstName}" /></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><c:out value="${sessionScope.order.shipToLastName}" /></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><c:out value="${sessionScope.order.shipAddress1}" /></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><c:out value="${sessionScope.order.shipAddress2}" /></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><c:out value="${sessionScope.order.shipCity}" /></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><c:out value="${sessionScope.order.shipState}" /></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><c:out value="${sessionScope.order.shipZip}" /></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><c:out value="${sessionScope.order.shipCountry}" /></td>
	</tr>

</table>
<input type="submit" name="newOrder"  value="Confirm">
</form>


<%@ include file="../common/IncludeBottom.jsp"%>





