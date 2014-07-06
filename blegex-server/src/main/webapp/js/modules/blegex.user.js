angular.module('blegex.user', ['LocalStorageModule']);

angular.module('blegex.user').config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
});

angular.module('blegex.user').factory('authInterceptor', function ($q, $rootScope, Authentication) {
    return {
        request: function (config) {
            if (Authentication._token) {
                config.headers['Authorization'] = 'Bearer ' + Authentication._token;
            }
            return config || $q.when(config);
        }
    };
});

angular.module('blegex.user').service('Authentication', function ($q, localStorageService) {

    var self = this;

    self._token = localStorageService.get('token') || null;

    self.isSignedIn = localStorageService.get('isSignedIn') || false;

    /**
     * Logs the user in, returns a promise resolving when the authentication system successfully obtains a token, otherwise the promise is rejected.
     *
     * @param email
     * @param password
     * @returns {promise}
     */
    self.login = function (email, password) {
        // TODO: actually log the user in and get a token, store the token in local storage
        var deferred = $q.defer();
        deferred.resolve({});
        self._token = 'ASDF';
        self.isSignedIn = true;
        localStorageService.set('token', self._token);
        localStorageService.set('isSignedIn', self.isSignedIn);
        return deferred.promise;
    };

    /**
     * Registers the user, returns a promise resolving when the authentication system successfully obtains a token, otherwise the promise is rejected.
     *
     * @param email
     * @param password
     * @returns {promise}
     */
    self.register = function (email, password) {
        // TODO: actually log the user in and get a token, store the token in local storage
        var deferred = $q.defer();
        deferred.resolve({});
        self._token = 'ASDF';
        self.isSignedIn = true;
        localStorageService.set('token', self._token);
        localStorageService.set('isSignedIn', self.isSignedIn);
        return deferred.promise;
    };

    /**
     * Logs the user out, clearing the local token.
     */
    self.logout = function () {
        self._token = null;
        self.isSignedIn = false;
        localStorageService.set('token', self._token);
        localStorageService.set('isSignedIn', self.isSignedIn);
    };

});
