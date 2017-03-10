angular.module("ad-extreme")

.controller("loginCtrl", ['$scope','$state', function ($scope, $state) {

	var myScope = $scope;

	myScope.singIn = function(user){
		goTo('user');
	};

	function goTo(state){
		$state.go(state);
	};

}]);