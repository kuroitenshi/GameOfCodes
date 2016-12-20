var GOCApp = angular.module('GOC', [ 'ngMessages', 'ui.router' ]);

GOCApp.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/GOC_landing');

	$stateProvider

	// LOGIN STATE ========================================
	.state('GOC_landing', {
		url : '/GOC_landing',
		views : {
			'header' : {
				templateUrl : 'modulePages/login_page.html',
				controller : 'loginController'
			}
		}

	})

	// HOME PAGE =================================
	.state('home', {
		url : '^/home',
		views : {
			'header' : {
				templateUrl : 'modulePages/home_page.html',

			}
		// Add default view for Hero Here
		}

	})

	// HOUSE PAGE =================================
	.state('houses', {
		url : '^/houses',
		views : {

			'header' : {
				templateUrl : 'modulePages/home_page.html',

			},
			'content' : {
				templateUrl : 'modulePages/house_page.html',

			}

		}
	});

});