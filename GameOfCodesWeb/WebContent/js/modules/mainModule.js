/**
 * Angular Module - GOC Login
 */

var GOCapp = angular.module('GOC', [ 'ngMessages', 'ngRoute' ]);

GOCapp.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/GameOfCodesWeb-App/modulePages/login_page.html',
		controller : 'loginController'
	})
	.when('/home', {
		templateUrl : '/GameOfCodesWeb-App/modulePages/home_page.html',
		controller : ''
	});

});
