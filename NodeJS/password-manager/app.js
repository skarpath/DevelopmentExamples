 console.log("--- starting password manager ---");
 
//Include third party node storage
 var storage = require('node-persist');

 //Start using 
 storage.initSync();

//Create account
function createAccount(account){
	var accounts = storage.getItemSync('accounts');
	if (typeof accounts === 'undefined'){
		
		//Create new array object
		accounts = [];
	}	
	//Add the information
	accounts.push(account);	
		
	//Save Items
	storage.setItemSync('accounts', accounts);
		
	return account;
}

//Get Account
function  getAccount(accountName){
	var accounts = storage.getItemSync('accounts');
	var matchedAccount;
	
	accounts.forEach(function(account) {
		if (account.name === accountName){
			matchedAccount = account;
		}
	});
	
	return matchedAccount;
}




//--------------------

/*
createAccount({
	name: 'facebook',
	username: 'somemail@gmail.com',
	password: '123!'
});*/

var facebookAccount = getAccount('facebook');
console.log(facebookAccount);

