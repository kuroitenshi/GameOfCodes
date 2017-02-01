GOCapp.controller('housesController', function($scope, $http, API_URL) {
    //retrieve employees listing from API
    $http.get(API_URL + "house/all")
            .success(function(response) {
                $scope.houses = response;
            });
    
    //show modal form
    $scope.toggle = function(modalstate, houseid) {
        $scope.modalstate = modalstate;

        switch (modalstate) {
            case 'add':
                $scope.form_title = "Add New House";
                break;
            case 'edit':
                $scope.form_title = "House Detail";
                $scope.houseid = houseid;
                $http.get(API_URL + 'house/id/' + houseid)
                        .success(function(response) {
                            console.log(response);
                            $scope.hero = response;
                        });
                break;
            default:
                break;
        }
        console.log(houseid);
    }

    //save new record / update existing record
    $scope.save = function(modalstate) {
        var url = API_URL + "house";
        
        //append employee id to the URL if the form is in edit mode
        if (modalstate === 'edit'){
            url += "/update";
        } else {
        	url += "/create";
        }
        
        $http({
            method: 'POST',
            url: url,
            data: JSON.stringify($scope.house),
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
                url: API_URL + 'house/delete/' + id
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

function showFlagName(imgFlag) {
	var domain = imgFlag.id;
	var domainDiv = document.getElementById(domain + "Div");
	var domainName = document.getElementById(domain + "Name");
	
	domainName.style.setProperty("-webkit-transform", "translateY(0)");
	domainName.style.setProperty("transform", "translateY(0)");
	
	domainDiv.style.setProperty("opacity", "1");
	domainDiv.style.setProperty("-webkit-transform", "scale(1)");	
	domainDiv.style.setProperty("-ms-transform", "scale(1)");	
	domainDiv.style.setProperty("transform", "scale(1)");	
}

function hideFlagName(imgFlag) {
	var domain = imgFlag.id;
	var domainDiv = document.getElementById(domain + "Div");
	var domainName = document.getElementById(domain + "Name");
	
	domainName.style.setProperty("-webkit-transform", "translateY(170px)");
	domainName.style.setProperty("transform", "translateY(170px)");
	domainName.style.setProperty("-webkit-transition", "-webkit-transform 0.3s");
	domainName.style.setProperty("transition", "transform 0.3s");
	
	domainDiv.style.setProperty("opacity", "0");
	domainDiv.style.setProperty("-webkit-transition", "-webkit-transform 0.3s, opacity 0.3s");
	domainDiv.style.setProperty("transition", "transform 0.3s ease, opacity 0.3s");
	domainDiv.style.setProperty("-webkit-transform", "scale(0.6)");	
	domainDiv.style.setProperty("-ms-transform", "scale(0.6)");	
	domainDiv.style.setProperty("transform", "scale(0.6)");	
	
}