<%--
  Created by IntelliJ IDEA.
  User: songtie
  Date: 2015/4/21
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css" media="screen" />

    <meta name="generator" content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>MyJpetStore</title>
    <meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />
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

	function auto()
	{
	 var keyword = document.getElementById("keyword").value;
	
	 var auto = document.getElementById("auto");
	
	 var tags = document.getElementById("tags");
	 
	 createXMLHttpRequest();
	
	 var url = "autoComplete?tag=" + keyword;
	 xmlHttpRequest.open("GET",url,true);
	 xmlHttpRequest.onreadystatechange = backFct;
	 xmlHttpRequest.send(null);
	 
	 if(event.keyCode == 40)
	 {  
		  if(keyword.value != "" && auto.style.visibility != "hidden")
		 	 {
			   tags.focus();
			   tags.selectedIndex = 0;
			   keyword.value = tags.options[0].text;
			   return;
		  	}
	 }
		 
		 
 function backFct()
	 {
	  if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200)
		  {
			   var rs = xmlHttpRequest.responseText;
			   if(rs != "")
				   {
				    var tagsRs = rs.split(",");
				    var auto = document.getElementById("auto");
				    var tags = document.getElementById("tags");
				    var keyword = document.getElementById("keyword");
				    tags.length = 0;
				    tags.size = tagsRs.length;
				    for(var i=0;i<tagsRs.length;i++)
					    {
				    	
					     var option = document.createElement("option");
					     option.value = tagsRs[i];
					     //option.setAttribute("text", tagsRs[i]);
					     //tags.options[i] = option;
					     option.text = tagsRs[i];
					     tags.add(option);
					    }
				  	auto.style.width =115;
				   	tags.style.width =115;
				 
				   auto.style.left = keyword.offsetLeft - 1;
				    auto.style.top = keyword.offsetTop + keyword.offsetHeight + 1;
				    auto.style.visibility = "visible";
				   } 
				   else
				   {
				    document.getElementById("auto").style.visibility = "hidden";
				   }
			  }
		 }
	 
	}
	function text()
		{
		 var keyword = document.getElementById("keyword");
		 var auto = document.getElementById("auto");
		 var tags = document.getElementById("tags");
		 if(event.keyCode == 40 || event.keyCode == 38)
			 {  
			  if(keyword.value != "" && auto.style.visibility != "hidden")
			  {
			   	keyword.value = tags.options[tags.selectedIndex].text;
			  }
			 }
		 else if(event.keyCode == 13)
			 {
		  		auto.style.visibility = "hidden";
		  		keyword.focus();
	 		}
	}




	

</script>
</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.gif" /></a>
    </div>
 </div>
<div id="Menu">
<div id="MenuContent">
 	   <a href="viewCart">
            <img align="middle" name="img_cart" src="images/cart.gif" />
	   </a> 
            <img align="middle" src="images/separator.gif" />
 <c:if test="${sessionScope.account == null}">
	<a href="signonForm">Sign In</a> 
</c:if> 
<c:if test="${sessionScope.account!= null}">
		 <a href="quitLogin">Sign Out</a> 
             <img align="middle" src="images/separator.gif" /> 
             <a href="editAccountForm">My Account</a> 
             <img align="middle"  src="images/separator.gif" /> 
</c:if> 

 
<img align="middle" src="images/separator.gif" /> 
<a href="../help.html">?</a>
	</div>
</div>

    <div id="Search">
        <div id="SearchContent">
            <form action="searchProduct" method="post" name="searchForm">
                <input type="text" id="keyword" name="keyword" size="14"  onkeyup="auto();" />
                <input type="submit" name="searchProducts" value="Search" />
            </form>
        </div>
        <div id="auto" style="border-style: solid; border-width: 1px; visibility: hidden; position: absolute;">
     
    	<select id="tags" onkeyup="text();" size="0" style=" margin:0px;"></select>  
  	    </div>
   </div>
    <div id="QuickLinks">
        <a href="viewCategory?categoryId=FISH">
            <img src="images/sm_fish.gif" />
        </a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=DOGS">
            <img src="images/sm_dogs.gif" />
        </a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=REPTILES">
            <img src="images/sm_reptiles.gif" />
        </a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=CATS">
            <img src="images/sm_cats.gif" />
        </a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=BIRDS">
            <img src="images/sm_birds.gif" />
        </a>
    </div>

</div>

<div id="Content">
