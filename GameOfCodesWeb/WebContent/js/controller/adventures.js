GOCApp.controller('adventuresController', function($scope, $rootScope, $http, API_URL, AdventuresOfHouseFactory) {
	
	$scope.houseOfHero = $rootScope.houseOfCurrentHero;
	
	/* GET ALL ADVENTURES OF HOUSE */
	AdventuresOfHouseFactory.getHouseAdventures($scope.houseOfHero.domain).then(function(adventuresToReturn){
		$scope.houseAdventures=adventuresToReturn;
		
		/* INITIALIZE TICKETS ON PAGE LOAD */
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
   
	/* SET CURRENT ADVENTURE ON DROPDOWN CLICK EVENT */
	$scope.setAdventure = function(adventureID) {
		$http({
		   	  method : 'GET',
		   	  url: API_URL + 'adventure/' + adventureID
		}).then(function successCallback(response) {
		   	$scope.adventure = response.data;
		}, function errorCallback(response) {
		
		});
	}
	
	$scope.setQuarter = function(quarter){
		switch(quarter) {
			case "Q1":
				// date + 3months
				println("Q1");
			case "Q2":
				//date + 6months
		}			
	}
	$scope.getPoints
	
	/* SEARCH EVENT ON BUTTON CLICK */
	$scope.search = function(searchString) {
		var filtered = [];
		var tick = {};
		
		if(searchString == undefined) {
			searchString = "";
		}
		searchString = searchString.toLowerCase();
		
		$scope.tickets = $scope.adventure.tickets;
		
		/* Filter tickets based on entered search string */
		for(i = 0; i < Object.keys($scope.tickets).length; i++)
		{
			tick = Object.values($scope.tickets)[i];
			
			/* Compare search string to JIRA ID and TITLE of ticket */
			if(tick.jiraId.toLowerCase().indexOf(searchString) >= 0 ||
					tick.title.toLowerCase().indexOf(searchString) >= 0) {
				filtered.push(tick);
			}
		}
		
		/* Update tickets based on search and check the length */
		$scope.tickets = filtered;
		$scope.length = Object.keys($scope.tickets).length;
		
	}

});