new Vue({
   el: '#app',  //Select all of App
   data: {
     name: 'max',
     list: []
   },
   methods: {
     changeName: function(){
       this.name = 'Max';
     },
     addElement: function(){
       this.list.push(this.list.length + 1);
     },
     getColor: function(number){
       return number % 2 == 0 ? 'green' : 'red';
     }
   }



});
