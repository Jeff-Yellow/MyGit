<%--
  Created by IntelliJ IDEA.
  User: songtie
  Date: 2015/4/21
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="../common/IncludeTop.jsp"%>
 <script type="text/javascript">
 function birdshow() {

	 var str = "";
	 str+="<div>Abouts Birds</div>";
	 str+="<div>AV_CB_01:Amazon Parrot AV_SB_02: Finch</div>";
		//str += "<p>Abouts Birds</p>";
	 document.getElementById("div4").innerHTML=str ;
	//var mydiv = document.getElementById("div4");
	//mydiv.innerHTML="<p>Abouts Birds</p>";
	
}
 function birdshowoff(){
	 var mydiv = document.getElementById("div4");
		mydiv.innerHTML="";
 }
 </script>
<div id="Welcome">
    <div id="WelcomeContent">
        Welcome to MyPetStore!
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <a href="viewCategory?categoryId=FISH"><img src="images/fish_icon.gif" /></a>
            <br/> Saltwater, Freshwater <br/>
            <a href="viewCategory?categoryId=DOGS"><img src="images/dogs_icon.gif" /></a>
            <br /> Various Breeds <br />
            <a href="viewCategory?categoryId=CATS"><img src="images/cats_icon.gif" /></a>
            <br /> Various Breeds, Exotic Varieties <br />
            <a href="viewCategory?categoryId=REPTILES"><img src="images/reptiles_icon.gif" /></a>
            <br /> Lizards, Turtles, Snakes <br />
            <a href="viewCategory?categoryId=BIRDS"><img src="images/birds_icon.gif" /></a>
            <br /> Exotic Varieties
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250" href="viewCategory?categoryId=BIRDS" shape="rect" onmouseover="birdshow()" onmouseout="birdshowoff()" />
                <area alt="Fish" coords="2,180,72,250" href="viewCategory?categoryId=FISH" shape="rect" onmouseover="fishshow()" onmouseout="fishshowoff()"/>
                <area alt="Dogs" coords="60,250,130,320" href="viewCategory?categoryId=DOGS" shape="rect" onmouseover="dogshow()" onmouseout="dogshowoff()"/>
                <area alt="Reptiles" coords="140,270,210,340" href="viewCategory?categoryId=REPTILES" shape="rect" onmouseover="reptileshow()" onmouseout="reptileshowoff()"/>
                <area alt="Cats" coords="225,240,295,310" href="viewCategory?categoryId=CATS" shape="rect" onmouseover="catshow()" onmouseout="catshowoff()"/>
                <area alt="Birds" coords="280,180,350,250" href="viewCategory?categoryId=BIRDS" shape="rect" onmouseover="birdshow()" onmouseout="birdshowoff()"/>
            </map>
            <img height="355" src="images/splash.gif" align="middle" usemap="#estoremap" width="350" />
        </div>
        <div id ="div4"></div>
    </div>
    <div id="Separator">&nbsp;</div>
</div>

<%@include file="../common/IncludeBottom.jsp"%>