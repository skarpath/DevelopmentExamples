var argv = require('yargs').argv;
var command = argv._[0];

if (command === 'hello' && typeof argv.name !== 'undefined' && typeof argv.lastname != 'undefined') {
	console.log('Hello ' + argv.name + ' - ' + argv.lastname);
} else {
	console.log("hello world");
}
