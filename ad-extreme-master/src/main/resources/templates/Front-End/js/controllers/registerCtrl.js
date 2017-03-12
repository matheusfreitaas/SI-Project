angular.module("ad-extreme")

.controller("registerCtrl", ['$scope','$state', function ($scope, $state) {

	var myScope = $scope;

	function goTo(state){
		$state.go(state);
	};

}]);