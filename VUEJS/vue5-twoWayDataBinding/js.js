Vue.component('app-username', {
  props: ['username'],
   data: function() {
      return {
        //username: 'Chris'
      }
    },
    template: '<p v-on:click="usernameClicked"> {{ username }} </p>',

    methods: {
      usernameClicked(){
        //ES6 formatting( name of event)
        this.$emit('mnmnm', this.username)
      }
    }
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
     },
     userWasClicked(name){
       alert(name);
     }
   }



});

new Vue({
   el: '#app2',  //Select all of App
   data: {
     message: 'App 2'

   }



});
