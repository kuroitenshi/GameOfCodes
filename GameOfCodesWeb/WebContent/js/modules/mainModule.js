var GOCApp = angular.module('GOC', [ 'ngMessages', 'ui.router', 'ngCookies' ]);

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
		},
		module : 'public'

	})

	// HOME PAGE =================================
	.state('home', {
		url : '^/home',
		views : {
			'header' : {
				templateUrl : 'modulePages/home_page.html',

			},
			'content' : {
				templateUrl : 'modulePages/hero_page.html',

			}
		},
		module : 'private'

	})

	// QUEST PAGE =================================
	.state('quest', {
		url : '^/quest',
		views : {
			'header' : {
				templateUrl : 'modulePages/home_page.html',

			},
			'content' : {
				templateUrl : 'modulePages/quest_page.html',

			}

		},
		module : 'private'

	})

	// ADVENTURE PAGE =================================
	.state('adventure', {
		url : '^/adventure',
		views : {
			'header' : {
				templateUrl : 'modulePages/home_page.html',

			},
		/*
		 * 'content' : { templateUrl : 'modulePages/quest_page.html', }
		 */

		},
		module : 'private'

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

		},
		module : 'private'

	});

});
/*
GOCApp.run(function($rootScope, $cookies, $http, $state) {
	// keep user logged in after page refresh
	
	$rootScope.globals = $cookies.getObject('globals') || {};
	if ($rootScope.globals.currentUser) {
		$http.defaults.headers.common['Authorization'] = 'Basic '
				+ $rootScope.globals.currentUser.authdata;
	}
	

	$rootScope.$on('$stateChangeStart', function(event, toState, toParams,
			fromState, fromParams, options) {

		var loggedIn = $rootScope.globals.currentUser;

		if (toState.module = 'private' && !loggedIn) {
			event.preventDefault();
			$state.go('GOC_landing');
		}		
	});
});
*/