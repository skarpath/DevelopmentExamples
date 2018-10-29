//Node basics | UDEMY.COM
//Stephen Karpathakis 

function greetMaker(name){
	
	function greet(){
		console.log('Hello ' + name + '!');
	}
	return greet;
}


var greetAndrew = greetMaker('Andrew');

greetAndrew();

// ^ In other words assigning a function to a varible


var greetWorld = greetMaker('world');
greetWorld();



//-------------------------------------------
//Assignment 1
function createAdder (baseNumber) {
	
	return function (numberToAdd){
		return baseNumber + numberToAdd;
	}
}

var addTen = createAdder(10);
console.log(addTen(2));
console.log(addTen(10));
