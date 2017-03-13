angular.module("ad-extreme")

.controller("registerCtrl", ['$scope','$state','$mdToast', function ($scope, $state, $mdToast) {

	var myScope = $scope;

	myScope.registration = function(user){
		if(user.password === user.confirmPassword){
			//checa se ja ta cadastrado no bd
				//if n, cadastra
				//else mostra q o usuario ja foi cadastrado
				goTo('login');
		}else{
			showToast("As senhas devem ser iguais");
		}
	}

	myScope.cleanForm = function(){
		delete myScope.user;
	}

	function showToast(justification){
		$mdToast.show(
      		$mdToast.simple()
        		.textContent(justification)
        		.position('bottom right')
        		.hideDelay(3000)
    	);
	}

	function goTo(state){
		$state.go(state);
	};

}]);