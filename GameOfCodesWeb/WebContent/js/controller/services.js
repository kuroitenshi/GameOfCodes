GOCApp.factory('HeroLevelsFactory', function ($resource) {
    return $resource('http://mancswfbedv0004:8081/GameOfCodesWeb-App/rest/'+'level/heroes', {}, {
        query: { method: 'GET', isArray: true },
    })
});
GOCApp.factory('HouseLevelsFactory', function ($resource) {
    return $resource('http://mancswfbedv0004:8081/GameOfCodesWeb-App/rest/'+'level/houses', {}, {
        query: { method: 'GET', isArray: true },
    })
});