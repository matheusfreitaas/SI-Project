angular.module("ad-extreme")

.controller("loginCtrl", ['$scope','$state','$mdToast', function ($scope, $state, $mdToast) {

	var myScope = $scope;

	myScope.singIn = function(user){
		//checa se o usuario é valido
			//if s, loga
		goTo('user');
			//else, mostra usuario invalido
	};

	function goTo(state){
		$state.go(state);
	};

}]);