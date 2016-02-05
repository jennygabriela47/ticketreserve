var app = angular.module('myApp');
app.controller('adminReservaCtrl', function($scope, $http) {
	/*$scope.buscar= function() {
		$http.get("http://localhost:8080/ticketReserve/rest/ServicioEvento/consultarEvento")
	    .then(function(response) {$scope.evento = response.data});
	}*/
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioReserva/consultarReserva")
	.then(function(response) {$scope.reserva = response.data});
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioEvento/consultarEvento")
	.then(function(response) {$scope.evento = response.data});
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioUsuario/listarUsuario")
	.then(function(response) {$scope.usuario = response.data});
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioEvento/consultarBoleto")
    .then(function(response) {$scope.boleto = response.data});


	
	
});