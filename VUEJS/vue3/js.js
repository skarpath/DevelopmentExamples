Vue.component('app-username', {
  props: ['username'],
   data: function() {
      return {
        //username: 'Chris'
      }
    },
    template: '<p> {{ username }} </p>'
});



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

new Vue({
   el: '#app2',  //Select all of App
   data: {
     message: 'App 2'

   }



});
