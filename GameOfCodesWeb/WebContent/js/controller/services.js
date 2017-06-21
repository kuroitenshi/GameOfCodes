GOCApp.factory('HeroLevelsFactory', function($resource) {
	return $resource('http://mancswfbedv0004:8081/GameOfCodesWeb-App/rest/'
			+ 'level/heroes', {}, {
		query : {
			method : 'GET',
			isArray : true
		},
	})
});
GOCApp.factory('HouseLevelsFactory', function($resource) {
	return $resource('http://mancswfbedv0004:8081/GameOfCodesWeb-App/rest/'
			+ 'level/houses', {}, {
		query : {
			method : 'GET',
			isArray : true
		},
	})
});

GOCApp.factory('SingleHeroFactory', function($http) {

	var heroToReturn = {};
	heroToReturn.getSingleHero = function(hero) {
		return $http.get(
				'http://mancswfbedv0004:8081/GameOfCodesWeb-App/rest/'
						+ 'hero/username/' + hero).then(function(response) {
			return response.data;

		},function(error){
		       console.log(error);
		});

	}
	
	return heroToReturn;
});

GOCApp.factory('HouseOfHeroFactory', function($http) {

	var houseToReturn = {};
	houseToReturn.getSingleHouse = function(heroID) {
		return $http.get(
				'http://mancswfbedv0004:8081/GameOfCodesWeb-App/rest/'
						+ 'house/' + heroID).then(function(response) {
			return response.data;

		},function(error){
		       console.log(error);
		});

	}
	
	return houseToReturn;
});

