GOCApp.service('HouseHeroFilterService', function() {
	var selectedHouseOfHero;

	var filterSelectedHouseOfHero = function(house) {
		selectedHouseOfHero = "";
		selectedHouseOfHero = house;
	};
	
	var getHouseOfHero = function(){
		return selectedHouseOfHero;
	};
	
	
	return {
		filterSelectedHouseOfHero : filterSelectedHouseOfHero,
		getHouseOfHero : getHouseOfHero
	};

});

GOCApp.controller('heroesController', function($scope, $rootScope, HeroLevelsFactory, $http, API_URL, SingleHeroFactory, HouseOfHeroFactory, TicketsOfHeroFactory, PagerServiceFactory) {
    
	$scope.currentUser = $rootScope.globals.currentUser.username;
	//retrieve heroes
	$scope.heroLevels = HeroLevelsFactory.query();
	
	$http({
  	  method : 'GET',
  	  url: API_URL + 'hero/all'
  	 }).then(function successCallback(response) {  	  		
  		$scope.heroes = response.data;  		
  	 }, function errorCallback(response) {
  
  	 });
	
	var user;
	SingleHeroFactory.getSingleHero($scope.currentUser).then(function(heroToReturn){
		$scope.currentHero=heroToReturn;
		user = $scope.currentHero;
		HouseOfHeroFactory.getSingleHouse(user.id).then(function(houseToReturn){
			$scope.currentHouseOfHero=houseToReturn;
			$rootScope.houseOfCurrentHero = $scope.currentHouseOfHero
			
		});
		
		TicketsOfHeroFactory.getHeroTickets(user.username).then(function(ticketsToReturn){
			$scope.tickets=ticketsToReturn;
			
			// Pagination for Hero Quests
		    var vm = this;
		    vm.ticketItems = [];
			for(i = 0; i < $scope.tickets.length; i++)
			{
				vm.ticketItems.push($scope.tickets[i]); // array of items to be paged
			}
		    
		    $scope.setPage = function set(page) {
		        if (page < 1 || page > vm.pager.totalPages) {
		            return;
		        }
		 
		        // get pager object from service
		        vm.pager = PagerServiceFactory.GetPager(vm.ticketItems.length, page, 0);
		        $scope.pager = vm.pager;
		        // get current page of items
		        $scope.progTickets = vm.ticketItems.slice(vm.pager.startIndex, vm.pager.endIndex + 1);
		    }
		    
		    vm.pager = {};
		    
		    initController();
		 
		    function initController() {
		        // initialize to page 1
		        $scope.setPage(1);
		    }
		 

		});
		
		
		
		
		
	   
	});
	  
    //show modal form
    $scope.toggle = function(modalstate, username) {
        $scope.modalstate = modalstate;

        switch (modalstate) {
            case 'add':
                $scope.form_title = "Add New Hero";
                break;
            case 'edit':
                $scope.form_title = "Hero Detail";
                $scope.username = username;
                $http({
                	  method : 'GET',
                	  url: API_URL + 'hero/username/' + username
                	 }).then(function successCallback(response) {
                		$scope.hero = response.data;
                	 }, function errorCallback(response) {
                
                });
                              
                break;
            default:
                break;
        }
        console.log(username);
    }

    //save new record / update existing record
    $scope.save = function(modalstate) {
        var url = API_URL + "hero";
        
        //append employee id to the URL if the form is in edit mode
        if (modalstate === 'edit'){
            url += "/update";
        } else {
        	url += "/create";
        }
        
        $http({
            method: 'POST',
            url: url,
            data: JSON.stringify($scope.hero),
            headers: {'Content-Type': 'application/json'}
        }).success(function(response) {
            console.log(response);
            location.reload();
        }).error(function(response) {
            console.log(response);
            alert('This is embarassing. An error has occured. Please check the log for details');
        });
    }

    //delete record
    $scope.confirmDelete = function(id) {
        var isConfirmDelete = confirm('Are you sure you want this record?');
        if (isConfirmDelete) {
            $http({
                method: 'DELETE',
                url: API_URL + 'hero/delete/' + id
            }).
                    success(function(data) {
                        console.log(data);
                        location.reload();
                    }).
                    error(function(data) {
                        console.log(data);
                        alert('Unable to delete');
                    });
        } else {
            return false;
        }
    }
	
});