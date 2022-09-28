/**
 * 
 */

document.addEventListener("DOMContentLoaded", function(){
	//window.alert("test menuProjectsAll.js");
	
	var actualUrl = window.location.href;
	var newUrl = actualUrl.replace("list", "cards");
	window.alert(
		"actual url: " + actualUrl +"\n"+
		"new url: " + newUrl
		
	
	);
})
