//Functions with node JS | UDEMY.COM
//Stephen Karpathakis 

//Basic function
function greatUser () { 
	console.log("Hello World");
}

//Passing varible to function
function printMessage(value)
{
	console.log(value);
}


//Adds numbers
function add(value1, value2)
{
	var results = value1 + value2;
	console.log(results);
}

//Returns value
function addReturn(value1, value2)
{
	return value1 + value2;
	
}

greatUser();
printMessage("hello");
printMessage("World");

var results = addReturn(2,5)

console.log(results);
