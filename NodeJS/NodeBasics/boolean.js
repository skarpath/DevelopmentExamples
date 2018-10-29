//Node basics | UDEMY.COM
//Stephen Karpathakis 
var isValid = true;

//Function to check the varible type.
//If type is boolean and is true returns false. IF false makes it true.
function changeType(booleanVar)
{
	if (typeof booleanVar === 'boolean' )
	{
		if(isValid == true){
			console.log('Data is valid!');
			return false;
		} else{
			
			console.log('Data is not valid!')
			return true;
		}
	}
	else
	{
		console.log("Warning! not a boolean type");
	}
}

isValid = changeType(isValid);
console.log(isValid);
