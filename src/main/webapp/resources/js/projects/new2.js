/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {
	//alert("test js!");//ok
	let btnSearchDevices = document.getElementById("btn-search-devices").addEventListener('click', () => test(7));
	let counter = 0;
	
	let xPos=10;
	let yPos =5;
	
	function test(param) {
		counter +=param;
		console.log("test counter: "+counter);
	}
	
	
});