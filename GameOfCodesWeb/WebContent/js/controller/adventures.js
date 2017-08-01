GOCApp.controller('adventuresController', function($scope, $rootScope, $http, API_URL, AdventuresOfHouseFactory) {
	
	$scope.houseOfHero = $rootScope.houseOfCurrentHero;
	
	AdventuresOfHouseFactory.getHouseAdventures($scope.houseOfHero.domain).then(function(adventuresToReturn){
		$scope.houseAdventures=adventuresToReturn;
		
		$scope.tickets = $scope.houseAdventures[0].tickets;
		$scope.adventure = $scope.houseAdventures[0];
		$scope.length = Object.keys($scope.tickets).length;
	});
	
	$http({
   	  method : 'GET',
   	  url: API_URL + 'adventure/all'
   	}).then(function successCallback(response) {
   		$scope.adventures = response.data;
   	 }, function errorCallback(response) {
   
    });
   
	$scope.setAdventure = function(adventureID) {
		$http({
		   	  method : 'GET',
		   	  url: API_URL + 'adventure/' + adventureID
		}).then(function successCallback(response) {
		   	$scope.adventure = response.data;
		}, function errorCallback(response) {
		
		});
	}
	
	$scope.search = function(searchString) {
		var filtered = [];
		var tick = {};
		
		if(searchString == undefined) {
			searchString = "";
		}
		searchString = searchString.toLowerCase();
		
		$scope.tickets = $scope.adventure.tickets;
		
		for(i = 0; i < Object.keys($scope.tickets).length; i++)
		{
			tick = Object.values($scope.tickets)[i];
			if(tick.jiraId.toLowerCase().indexOf(searchString) >= 0 ||
					tick.title.toLowerCase().indexOf(searchString) >= 0) {
				filtered.push(tick);
			}
		}
		
		$scope.tickets = filtered;
		$scope.length = Object.keys($scope.tickets).length;
		
	}

});