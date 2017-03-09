angular.module('ad-extreme', ['ui.router', 'ngMaterial'])

.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider

        .state('home', {
            url: '/home',
            templateUrl: 'views/home.html'
        })

        .state('login', {
            url: '/login',
            templateUrl: 'views/login.html'
        })

        .state('register', {
            url: '/register',
            templateUrl: 'views/register.html'
        });
}]);