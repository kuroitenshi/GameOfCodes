GOCApp.controller('ticketsController', function($scope,$rootScope, $http, API_URL, ticketFilterService) {

	$scope.houseOfHero = $rootScope.houseOfCurrentHero;
	// retrieve tickets
	$http({
		method : 'GET',
		url : API_URL + 'ticket/all/' + $scope.houseOfHero.domain
	}).then(function successCallback(response) {
		$scope.tickets = response.data;
	}, function errorCallback(response) {

	});

	$scope.questfilter = function(questID) {		
		ticketFilterService.filterQuest(questID);
	}

	$scope.$watch(function() {
		return ticketFilterService.returnSelectedQuest();
	}, function(value) {
		$scope.selectedQuest = value;
	});
});

