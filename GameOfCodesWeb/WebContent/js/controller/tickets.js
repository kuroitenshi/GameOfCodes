app.controller('ticketsController', function($scope, $http, API_URL) {
    //retrieve employees listing from API
    $http.get(API_URL + "ticket/all")
            .success(function(response) {
                $scope.tickets = response;
            });

    //delete record
    $scope.confirmDelete = function(id) {
        var isConfirmDelete = confirm('Are you sure you want this record?');
        if (isConfirmDelete) {
            $http({
                method: 'DELETE',
                url: API_URL + 'ticket/delete/' + id
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