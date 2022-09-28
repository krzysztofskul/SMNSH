/**
 * 
 */

document.addEventListener("DOMContentLoaded", function(){
	
	//test
	//window.alert("test menuProjectsAll.js");
	
	var actualUrl = window.location.href;

	var btnViewCards = document.querySelector("#btnViewCards");
	var btnViewList = document.querySelector("#btnViewList");
	
	btnViewCards.classList.remove("disabled");
	btnViewCards.setAttribute("href", actualUrl.replace("list", "cards"));
	
	btnViewList.classList.remove("disabled");
	btnViewList.setAttribute("href", actualUrl.replace("cards", "list"));
	
	//test
	//var newUrl = actualUrl.replace("list", "cards");
	/*window.alert(
		"actual url: " + actualUrl +"\n"+
		"new url: " + newUrl
		
	
	);*/
})
