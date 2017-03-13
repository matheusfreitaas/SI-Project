angular.module("ad-extreme")

.controller("adRegisterCtrl", ['$scope','$state','$mdToast', function ($scope, $state, $mdToast) {

	var myScope = $scope;

	myScope.registerAd = function(ad){
		goTo('adList');
	}

	myScope.cleanForm = function(){
		delete myScope.ad;
	}

	function goTo(state){
		$state.go(state);
	};

}]);