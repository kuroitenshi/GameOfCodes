angular.module('herodemo', [])
.controller('hero', function($scope, $http) {
    $http.get('http://localhost:8080/GameOfCodesWeb-App/rest/hero/all').
        then(function(response) {
            $scope.heroes = response.data;
        });
});