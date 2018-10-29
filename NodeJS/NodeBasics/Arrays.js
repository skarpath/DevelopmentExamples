//Node basics | UDEMY.COM
//Stephen Karpathakis 
var grades = [100,50,90];

//Add to grades array
grades.push(79);
console.log(grades);

//Remove 79
grades.pop(79);
console.log(grades);

//Print all within array
grades.forEach(function (grade){
		console.log(grade);
});

//Pull out an item in a certain location
console.log(grades[1]);


//Find average
var sum = 0
var count = 0;
grades.forEach(function (grade){
		sum = sum + grade;
		count = count + 1;
});

console.log("Average " + (sum/count));
