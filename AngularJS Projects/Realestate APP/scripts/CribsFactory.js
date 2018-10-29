angular
    .module('ngCribs')
    .factory('cribsFactory',function($http) {
    
    //Data
    /*
     var cribsData = [         
         {
             "type": "Condo",
             "Price": 22000,
             "Address": "213 Grove Street",
             "Description": "Excellent place, really nice view!"
         },          
         {
             "type": "House",
             "Price": 22000,
             "Address": "213 Grove Street",
             "Description": "Excellent place, really nice view!"
         },          
         {
             "type": "Duplex",
             "Price": 39500,
             "Address": "834 River Lane",
             "Description": "Great neighbood and lots of nice green space"
         }
     ];*/
    
    function getCribs() {
      
        return $http.get('data/data.json');
    }
    
    return {
        getCribs:getCribs
    }
        
});