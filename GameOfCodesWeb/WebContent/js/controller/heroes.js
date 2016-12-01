app.controller('heroesController', function($scope, $http, API_URL) {
    //retrieve employees listing from API
    $http.get(API_URL + "hero/all")
            .success(function(response) {
                $scope.heroes = response;
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
                $http.get(API_URL + 'hero/username/' + username)
                        .success(function(response) {
                            console.log(response);
                            $scope.hero = response;
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