angular.module('blegex.user', ['LocalStorageModule']);

angular.module('blegex.user').config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
});

angular.module('blegex.user').factory('authInterceptor', function ($q, $rootScope, Authentication) {
    return {
        request: function (config) {
            if (Authentication._authorization) {
                config.headers['Authorization'] = Authentication._authorization;
            }
            return config || $q.when(config);
        }
    };
});

angular.module('blegex.user').service('Authentication', function ($q, localStorageService) {

    var self = this;

    self._authorization = localStorageService.get('authorization') || null;

    self.isSignedIn = localStorageService.get('isSignedIn') || false;

    /**
     * Logs the user in, returns a promise resolving when the authentication system successfully obtains a authorization, otherwise the promise is rejected.
     *
     * @param email
     * @param password
     * @returns {promise}
     */
    self.login = function (email, password) {
        // TODO: actually log the user in and get a authorization, store the authorization in local storage
        var deferred = $q.defer();
        deferred.resolve({});
        self._authorization = 'Basic ' + window.btoa(email + ':' + password);
        self.isSignedIn = true;
        localStorageService.set('authorization', self._authorization);
        localStorageService.set('isSignedIn', self.isSignedIn);
        return deferred.promise;
    };

    /**
     * Registers the user, returns a promise resolving when the authentication system successfully obtains a authorization, otherwise the promise is rejected.
     *
     * @param email
     * @param password
     * @returns {promise}
     */
    self.register = function (email, password) {
        // TODO: actually log the user in and get a authorization, store the authorization in local storage
        var deferred = $q.defer();
        deferred.resolve({});
        self._authorization = 'Basic ' + window.btoa(email + ':' + password);
        self.isSignedIn = true;
        localStorageService.set('authorization', self._authorization);
        localStorageService.set('isSignedIn', self.isSignedIn);
        return deferred.promise;
    };

    /**
     * Logs the user out, clearing the local authorization.
     */
    self.logout = function () {
        self._authorization = null;
        self.isSignedIn = false;
        localStorageService.set('authorization', self._authorization);
        localStorageService.set('isSignedIn', self.isSignedIn);
    };

});
