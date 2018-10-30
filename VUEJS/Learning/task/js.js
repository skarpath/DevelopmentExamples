new Vue({
   el: '#main',  //Select all of App
   data: {
     taskList: [],
     userInput: ''
   },
   methods: {
    addTask: function() {
      //Checks if valid
      if (this.userInput.trim() == ''){
        return;
      }
      var newTask = {
          id: _.uniqueId(),
          value: this.userInput
      };

      this.taskList.push(newTask);
      this.userInput = '';
      console.log(this.taskList);
    },
    removeTask: function(task){
      var id = task.id;
      for (var i = 0; i < this.taskList.length; i++){
        if (this.taskList[i].id == id){
          this.taskList.splice(i, 1);
          break;
        }
      }

    }
  }

});
