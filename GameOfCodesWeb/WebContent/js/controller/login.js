/**
 * Javascript controller for login
 * 
 */

GOCApp.controller('loginController', function($scope, $http, $state) {

	
	$scope.interacted = function(field) {
	      return $scope.submitted || field.$dirty;
	    
	};	
	
    $scope.loginValidate = function() {
           
    	$('#modal1').modal('hide');
    
    	/*
        $http({
            method: 'POST',
            url: url,
            data: JSON.stringify($scope.user),
            headers: {'Content-Type': 'application/json'}
        }).success(function(response) {
            console.log(response);
            $location.path(path);
        }).error(function(response) {
            console.log(response);
            alert('This is embarassing. An error has occured. Please check the log for details');
        });
        */
    }
   
});