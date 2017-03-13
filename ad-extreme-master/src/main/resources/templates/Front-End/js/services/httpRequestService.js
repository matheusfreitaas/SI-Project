angular.module("ad-extreme")

.service('HttpRequestService', function($http) {

	return function(url, method, data, callback) {
		var requestParams = {
			method: method,
			url: url,
			headers: { 'Content-type': 'application/json',
	                  'Cross-Origin': "*"
			},
			data: data
		};

		$http(requestParams).then(
			function successCallback(response) {
				callback && callback(response);
			},

			function errorCallback(response) {

			}
		);
	};

})

.service('RestService', function(HttpRequestService) {
	var restFactory = {};
	
	var initialUrl = "http://localhost:8080";

	restFactory.find = function(url, callback) {
		HttpRequestService(initialUrl + url, "GET", {}, callback);
	};

	restFactory.add = function(url, data, callback) {
		HttpRequestService(initialUrl + url, "POST", data, callback);
	};

	restFactory.edit = function(url, data, callback) {
		HttpRequestService(initialUrl + url, "PUT", data, callback);
	};

	restFactory.delete = function(url) {
		HttpRequestService(initialUrl + url, "DELETE", null, null);
	};

	return restFactory;
});