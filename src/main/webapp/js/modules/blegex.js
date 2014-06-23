angular.module('blegex', ['ngRoute', 'ui.bootstrap']);

angular.module('blegex').config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            controller: 'HomeController',
            templateUrl: 'views/home.html'
        })
        .when('/draft/:id', {
            controller: 'DraftController',
            templateUrl: 'views/draft.html'
        })
        .when('/draft', {
            controller: 'DraftController',
            templateUrl: 'views/draft.html'
        })
        .when('/inbox', {
            controller: 'InboxController',
            templateUrl: 'views/inbox.html'
        })
        .when('/database/:id', {
            controller: 'DatabaseController',
            templateUrl: 'views/database.html'
        })
        .when('/database', {
            controller: 'DatabaseController',
            templateUrl: 'views/database.html'
        })
        .when('/configuration', {
            controller: 'ConfigurationController',
            templateUrl: 'views/configuration.html'
        })
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'views/login.html'
        })
        .when('/register', {
            controller: 'RegisterController',
            templateUrl: 'views/register.html'
        })
        .when('/logout', {
            controller: 'LogoutController',
            templateUrl: 'views/logout.html'
        })
        .otherwise({
            redirectTo: '/'
        });
});

angular.module('blegex').controller('HomeController', function ($scope, $location) {
});

angular.module('blegex').controller('DraftController', function ($scope, $location, $routeParams) {
    // $routeParams.id;
});

angular.module('blegex').controller('InboxController', function ($scope, $location, $routeParams) {
    // $routeParams.id;
});

angular.module('blegex').controller('DatabaseController', function ($scope, $location, $routeParams) {
    // $routeParams.id;
});

angular.module('blegex').controller('ConfigurationController', function ($scope, $location, $routeParams) {
    // $routeParams.id;
});
