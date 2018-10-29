var age = 24; //Global 



function localfunction()
{
	var age = 0; //Local varible
	console.log(age + " inside");
	
}
localfunction();
console.log(age + " outside");
