/**
 * Javascript controller for login
 * 
 */

GOCApp.controller('loginController', function($scope, $http, $state,
		AuthenticationService) {

	(function initController() {
		// reset login status
		AuthenticationService.ClearCredentials();
	})();

	$scope.interacted = function(field) {
		return $scope.submitted || field.$dirty;

	};

	$scope.loginValidate = function() {

		//var loginUsername = $scope.user.username;
		//var loginPassword = $scope.user.password;

		$('#modal1').modal('hide');

		/*
		AuthenticationService.Login(loginUsername, loginPassword, function(
				response) {
			if (response.success) {
				AuthenticationService.SetCredentials(loginUsername, loginPassword);

			} else {
				//Show Error Here
			}
		});
		 */

	}

});