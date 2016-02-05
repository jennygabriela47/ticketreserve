var app = angular.module('myApp');
app.controller('ubicacionCtrl', function($scope, $http) {
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioEvento/consultarUbicacion")
    .then(function(response) {$scope.lugar = response.data});
	
});