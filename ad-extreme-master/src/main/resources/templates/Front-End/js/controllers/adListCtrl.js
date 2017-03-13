angular.module("ad-extreme")

.controller("adListCtrl", ['$scope','$state','$mdToast', function ($scope, $state, $mdToast) {

	var myScope = $scope;

	myScope.adList = [
		{
			title: "title1",
			type: "type1",
			date: "date1",
			price: "price1"
		},
		{
			title: "title2",
			type: "type2",
			date: "date2",
			price: "price2"
		}
	]

	function goTo(state){
		$state.go(state);
	};

}]);