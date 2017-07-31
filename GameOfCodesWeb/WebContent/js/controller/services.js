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

GOCApp.factory('TicketsOfHeroFactory', function($http) {
	
	var ticketsToReturn = {};
	ticketsToReturn.getHeroTickets = function(heroName) {
		return $http.get(
				'http://mancswfbedv0004:8081/GameOfCodesWeb-App/rest/'
						+ 'ticket/all/hero/' + heroName).then(function(response) {
			return response.data;

		},function(error){
		       console.log(error);
		});

	}
	
	return ticketsToReturn;
});

GOCApp.factory('AdventuresOfHouseFactory', function($http) {
	
	var adventuresToReturn = {};
	adventuresToReturn.getHouseAdventures = function(domain) {
		return $http.get(
				'http://mancswfbedv0004:8081/GameOfCodesWeb-App/rest/'
						+ 'adventure/all/domain/' + domain).then(function(response) {
			return response.data;

		},function(error){
		       console.log(error);
		});

	}
	
	return adventuresToReturn;
});

GOCApp.factory('ticketFilterService', function() {
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


GOCApp.factory('PagerServiceFactory', function() {
    // service definition
    var service = {};
 
    service.GetPager = GetPager;
 
    return service;
 
    // service implementation
    function GetPager(totalItems, currentPage, pageSize) {
        // default to first page
        currentPage = currentPage || 1;
 
        // default page size
        pageSize = pageSize || 4;
 
        // calculate total pages
        var totalPages = Math.ceil(totalItems / pageSize);
 
        var startPage, endPage;
        if (totalPages <= 10) {
            // less than 10 total pages so show all
            startPage = 1;
            endPage = totalPages;
        } else {
            // more than 10 total pages so calculate start and end pages
            if (currentPage <= 6) {
                startPage = 1;
                endPage = 10;
            } else if (currentPage + 4 >= totalPages) {
                startPage = totalPages - 9;
                endPage = totalPages;
            } else {
                startPage = currentPage - 5;
                endPage = currentPage + 4;
            }
        }
 
        // calculate start and end item indexes
        var startIndex = (currentPage - 1) * pageSize;
        var endIndex = Math.min(startIndex + pageSize - 1, totalItems - 1);
 
        // create an array of pages to ng-repeat in the pager control
        var pages = [];
        for(var i = startPage; i < endPage + 1; i++)
        	{
        	 pages.push(i);
        	}
         
 
        // return object with all pager properties required by the view
        return {
            totalItems: totalItems,
            currentPage: currentPage,
            pageSize: pageSize,
            totalPages: totalPages,
            startPage: startPage,
            endPage: endPage,
            startIndex: startIndex,
            endIndex: endIndex,
            pages: pages
        };
    }
});