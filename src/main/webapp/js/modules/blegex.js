angular.module('blegex', ['ngRoute']);

angular.module('blegex').config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            controller: 'HomeController',
            templateUrl: 'views/home.html'
        })
        .when('/edit/:draftId', {
            controller: 'EditController',
            templateUrl: 'views/detail.html'
        })
        .otherwise({
            redirectTo: '/'
        });
});

angular.module('blegex').controller('HomeController', function ($scope, $location) {
});

angular.module('blegex').controller('EditController', function ($scope, $location, $routeParams) {
    // $routeParams.draftId;
});
