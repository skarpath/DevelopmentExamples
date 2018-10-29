angular
    .module('ngCribs')
    .controller('cribsController', function($scope, cribsFactory ) {
    
    
    $scope.cribs;
    
    $scope.priceInfo = {
        min: 0,
        max: 1000000
    }
    
   
    
    cribsFactory.getCribs().success(function(data) {
        $scope.cribs = data;
    }).error(function(error){
       console.log(error); 
    });
            
        
    });