angular.module("ad-extreme", ['ui.router'])

.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
    
    $urlRouterProvider.otherwise("/");
     
    $stateProvider
            
	    .state('home', {
	        url: '/',
	        templateUrl: "../partials/layout_user.html"
	    })
	
	    .state('adList', {
	        url: '/adList',
	        templateUrl: '../partials/adList.html',
	        controller: 'adListCtrl'
	    });
}]);