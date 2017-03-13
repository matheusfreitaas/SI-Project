angular.module('ad-extreme', ['ui.router', 'ngMaterial'])

.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider

        /*.state('app', {
            abstract: true,
            url: '/app',
            templateUrl: 'views/app.html'
        })*/

        .state('home', {
            url: '/home',
            templateUrl: 'views/home.html'
        })

        .state('login', {
            url: '/login',
            templateUrl: 'views/login.html',
            controller: 'loginCtrl'
        })

        .state('register', {
            url: '/register',
            templateUrl: 'views/register.html',
            controller: 'registerCtrl'
        })

        .state('user', {
            url: '/user',
            templateUrl: 'views/user.html'
        })

        .state('adList', {
            url: '/adList',
            templateUrl: 'views/adList.html',
            controller: 'adListCtrl'
        })

        .state('adRegister', {
            url: '/adRegister',
            templateUrl: 'views/adRegister.html',
            controller: 'adRegisterCtrl'
        });

}]);