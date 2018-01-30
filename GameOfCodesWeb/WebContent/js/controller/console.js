GOCApp.controller('consoleController', function($scope, $rootScope, $http, API_URL) {
    
	
	$scope.updatePeriod = function(){
		
		
		if($scope.periodType == "Quarterly"){
			var quarterNames = ["Q1", "Q2", "Q3", "Q4"];
			$scope.periods = quarterNames;		
			
		}else if($scope.periodType == "Monthly"){
			var monthNames = ["January", "February", "March", "April", "May", "June",
				  "July", "August", "September", "October", "November", "December"];
			$scope.periods = monthNames;
		}
	}
	
	
	//retrieve houses
    $http({
    	  method : 'GET',
    	  url: API_URL + 'house/all' 
    	}).then(function successCallback(response) {
    		$scope.houses = response.data;
    	 }, function errorCallback(response) {
    
    });
    
    
      

});

