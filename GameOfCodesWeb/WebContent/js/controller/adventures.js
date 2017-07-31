GOCApp.controller('adventuresController', function($scope, $rootScope, $http, API_URL, AdventuresOfHouseFactory) {
	
	$scope.houseOfHero = $rootScope.houseOfCurrentHero;
	
	AdventuresOfHouseFactory.getHouseAdventures($scope.houseOfHero.domain).then(function(adventuresToReturn){
		$scope.houseAdventures=adventuresToReturn;
		
		$scope.tickets = $scope.houseAdventures[0].tickets;
	});
	
	$http({
   	  method : 'GET',
   	  url: API_URL + 'adventures/all'
   	}).then(function successCallback(response) {
   		$scope.houses = response.data;
   	 }, function errorCallback(response) {
   
    });
   
	

});