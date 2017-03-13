angular.module("ad-extreme")

.controller("adListCtrl", ['$scope','$state','$mdToast', function ($scope, $state, $mdToast, RestService) {

	var myScope = $scope;

	myScope.adList = [];

	getAds();

	function getAds() {
		RestService.find("/user/listar/anuncios", function(response) {
			myScope.adList = response.data;
		});
	};

	function goTo(state){
		$state.go(state);
	};

}]);