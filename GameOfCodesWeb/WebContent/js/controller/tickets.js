GOCApp.service('ticketFilterService', function() {
	var selectedQuest;

	var filterQuest = function(quest) {
		selectedQuest = "";
		selectedQuest = quest;
	};

	var returnSelectedQuest = function() {
		return selectedQuest;
	};

	return {
		filterQuest : filterQuest,
		returnSelectedQuest : returnSelectedQuest
	};

});

GOCApp.controller('ticketsController', function($scope,$rootScope, $http, API_URL, ticketFilterService) {

	$scope.houseOfHero = $rootScope.houseOfCurrentHero;
	// retrieve tickets
	$http({
		method : 'GET',
		url : API_URL + 'ticket/all'
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

