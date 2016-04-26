<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
<form action="confirmOrder" method="post">

	<table>
		<tr>
			<th colspan=2>Shipping Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input type="text" name="shipToFirstName" value="${sessionScope.account.firstName}" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input type="text" name="shipToLastName" value="${sessionScope.account.lastName}"/></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input type="text" size="40" name="shipAddress1" value="${sessionScope.account.address1}"/></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input type="text" size="40" name="shipAddress2" value="${sessionScope.account.address2}"/></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="shipCity"  value="${sessionScope.account.city}"/></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" size="4" name="shipState"  value="${sessionScope.account.state}"/></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input type="text" size="10" name="shipZip" value="${sessionScope.account.zip}"/></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" size="15" name="shipCountry" value="${sessionScope.account.country}"/></td>
		</tr>


	</table>

	<input type="submit" name="newOrder" value="Continue" />
</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>