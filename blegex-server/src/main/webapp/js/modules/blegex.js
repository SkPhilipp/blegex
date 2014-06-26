angular.module('blegex', ['ngRoute', 'ui.bootstrap', 'blegex.user', 'blegex.ui']);

/**
 * Puts both UI and Authentication on the $rootScope for easy referencing from the views.
 */
angular.module('blegex.ui').run(function ($rootScope, UI, Authentication) {
    $rootScope.ui = UI;
    $rootScope.authentication = Authentication;
});

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

angular.module('blegex').controller('InboxController', function ($scope) {
});

angular.module('blegex').controller('DraftController', function ($scope, $routeParams) {
});

angular.module('blegex').controller('DatabaseController', function ($scope, $routeParams) {
});

angular.module('blegex').controller('ConfigurationController', function ($scope, $routeParams) {
});

angular.module('blegex').controller('LoginController', function ($scope, $location, Authentication) {

    $scope.login = function (form) {
        Authentication.login(form.email, form.password)
            .then(function () {
                $location.path('/inbox');
            });
    };

});

angular.module('blegex').controller('RegisterController', function ($scope, $location, Authentication) {

    $scope.register = function (form) {
        Authentication.login(form.email, form.password)
            .then(function () {
                $location.path('/inbox');
            });
    };

});

angular.module('blegex').controller('LogoutController', function ($scope, Authentication) {

    Authentication.logout();

});