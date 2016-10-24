/**
 * Javascript controller for login
 * 
 */

app.controller('loginController', function($scope) {
    
   
    $scope.loginValidate = function() {
       
    	alert(JSON.stringify($scope.user));
        $http({
            method: 'POST',
            url: url,
            data: JSON.stringify($scope.user),
            headers: {'Content-Type': 'application/json'}
        }).success(function(response) {
            console.log(response);
            location.reload();
        }).error(function(response) {
            console.log(response);
            alert('This is embarassing. An error has occured. Please check the log for details');
        });
    }
   
});