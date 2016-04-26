<%@ include file="../common/IncludeTop.jsp"%>

<script type="text/javascript">
	var xmlHttpRequest;
	function createXMLHttpRequest() {
		if (window.XMLHttpRequest) { //非IE浏览器
			xmlHttpRequest = new XMLHttpRequest();
		} else if (window.ActiveObject) { //IE6以上版本的IE浏览器
			xmlHttpRequest = new ActiveObject("Msxml2.XMLHTTP");
		} else { //IE6及以下版本IE浏览器
			XMLHttpRequest = new ActiveObject("Microsoft.XMLHTTP");
		}
	}

	function sendRequest(url) {
		createXMLHttpRequest();
		xmlHttpRequest.open("GET", url, true);
		xmlHttpRequest.onreadystatechange = processResponse;
		xmlHttpRequest.send(null); 
		}

	function usernameIsExist() {
		var username = document.registerForm.username.value;
		sendRequest("usernameIsExist?username=" + username); 
		}

	function processResponse() {
		if (xmlHttpRequest.readyState == 4) {
			if (xmlHttpRequest.status == 200) {
				var responseInfo = xmlHttpRequest.responseXML.getElementsByTagName("info")[0].firstChild.data;
				var div1 = document.getElementById("usernameInfo");
				if (responseInfo == "Exist") {
					div1.innerHTML = "<font color='red'>Username is unavailable.</font>";
				}
				else {
					div1.innerHTML = "<font color='green'>Available username</font>";
				}  
			}  
		}
	}

	function passwordIsCorrect() {

		var password = document.registerForm.password.value;;
		var repeatedPassword = document.registerForm.repeatedPassword.value;
		xmlHttpRequest.open("GET", "samePassword?password=" + password
				+ "&repeatedPassword=" + repeatedPassword, true);
		xmlHttpRequest.onreadystatechange = processResponse1;
		xmlHttpRequest.send(null);
	}

	function processResponse1() {
		if (xmlHttpRequest.readyState == 4) {
			if (xmlHttpRequest.status == 200) {
				var responseInfo = xmlHttpRequest.responseXML
						.getElementsByTagName("msg")[0].firstChild.data;
				var div2 = document.getElementById("passwordMsg");
				if (responseInfo == "Yes") {
					div2.innerHTML = "<font color='green'> the same passwords.</font>";
				} else {
					div2.innerHTML = "<font color='red'>inconformity passwords.</font>";
				}
			}
		}

	}
	
</script>


<div id="Catalog">
	<form action="newAccount" method="post" name="registerForm">

		<h3>User Information</h3>

		<table>
			<tr>
				<td>User ID:</td>
				<td><input type="text" name="username"  onblur="usernameIsExist();"/>
					<div id="usernameInfo"></div>
				</td>
			</tr>
			<tr>
				<td>New password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Repeat password:</td>
				<td>
					<input type="password" name="repeatedPassword"  onblur="passwordIsCorrect()"/>
					<div id="passwordMsg"></div>
				</td>
			</tr>
		</table>

		<%@ include file="IncludeAccountFields.jsp"%>

		<input type="submit" name="newAccount" value="Save Account Information" />
	</form>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>