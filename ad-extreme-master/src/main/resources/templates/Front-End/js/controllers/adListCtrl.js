angular.module("ad-extreme")

.controller("adListCtrl", ['$scope','$state','$mdToast', function ($scope, $state, $mdToast, RestService) {

	var myScope = $scope;

	var adRoute = 

	myScope.adList = [];

	getAds();

	function getAds() {
		console.log("entrou")
		RestService.find("/user/listar/anuncios", function(response) {
			console.log("chegou")
			myScope.adList = response.data;
		});
	};

	function goTo(state){
		$state.go(state);
	};

}]);