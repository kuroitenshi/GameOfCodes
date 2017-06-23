GOCApp.filter('orderByStoryPoints', function() {
	  return function(items, field, reverse) {
	    var filtered = [];
	    angular.forEach(items, function(item) {
	      filtered.push(item);
	    });
	    filtered.sort(function (a, b) {
	      return (a[field] > b[field] ? 1 : -1);
	    });
	    if(reverse) filtered.reverse();
	    return filtered;
	  };
	});

GOCApp.controller('leaderboardController', function($scope, $rootScope, HeroLevelsFactory, $http, API_URL) {
    var d = new Date();
    var months = ["JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"];
    
    
    $scope.date = months[d.getMonth()];
    
	//retrieve heroes
	$scope.heroLevels = HeroLevelsFactory.query();
	
	$http({
  	  method : 'GET',
  	  url: API_URL + 'hero/all'
  	 }).then(function successCallback(response) {  	  		
  		$scope.heroes = response.data;  		
  	 }, function errorCallback(response) {
  
  	 });
	
	//retrieve houses
    $http({
    	  method : 'GET',
    	  url: API_URL + 'house/all'
    	}).then(function successCallback(response) {
    		$scope.houses = response.data;
    	 }, function errorCallback(response) {
    
    });
});