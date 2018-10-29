//Objects in NODE/Javascript
var person = {
	
	gender: 'Male,
	eye_color: 'brown'
		
};

person.firstname = 'Stephen'; 
// ^ Another way of writing above is bracket location person['firstname'] = 'Andrew';

person.lastname = 'Karpathakis';
person.age = 24;

//Delete age value
delete person.age;

//Prints Firstname and lastname
function greetuser(person){
	console.log('Hello ' + person.firstname + ' ' + person.lastname);
}

greetuser(person);
