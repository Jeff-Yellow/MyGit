<%--
  Created by IntelliJ IDEA.
  User: songtie
  Date: 2015/4/21
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>

</div>

<div id="Footer">

    <div id="PoweredBy">&nbsp<a href="www.csu.edu.cn">www.csu.edu.cn</a>
    </div>

  	<div id="Banner">
  	<c:if test="${sessionScope.account!= null }">
          ${sessionScope.account.bannerName}
    </c:if>	
	</div>
</div>
</body>
</html>
