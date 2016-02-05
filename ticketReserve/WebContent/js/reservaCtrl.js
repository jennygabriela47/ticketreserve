var app = angular.module('myApp');
app.controller('reservaCtrl', function($scope, $http) {
	
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioReserva/consultarReserva")
    .then(function(response) {$scope.reserva = response.data});


	
	
});