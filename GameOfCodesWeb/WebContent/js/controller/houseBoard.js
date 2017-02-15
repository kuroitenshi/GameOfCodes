GOCApp.controller('houseBoardController', function($scope, $http, API_URL,
		houseFilterService) {
	// retrieve houses
	$http({
		method : 'GET',
		url : API_URL + 'house/all'
	}).then(function successCallback(response) {
		$scope.houses = response.data;
	}, function errorCallback(response) {

	});

	$scope.$watch(function() {
		return houseFilterService.returnSelectedHouse();
	}, function(value) {
		$scope.selectedHouse = value;
	});

});