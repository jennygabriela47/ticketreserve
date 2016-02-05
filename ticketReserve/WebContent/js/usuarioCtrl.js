var app = angular.module('myApp');
app.controller('usuarioCtrl', function($scope, $http) {
	
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioUsuario/listarUsuario")
    .then(function(response) {$scope.usuario = response.data});
	
	
	$scope.login= function() {
		
		var usr=$scope.usuario;
		var psw=$scope.contrasenia;
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioUsuario/accesoLogin/"+usr+'/'+psw)
		.then(function(response) {$scope.usuario = response.data});
		console.log('Ingreso');
	
	}
	
	$scope.nuevoUsuario= {
		
			apellido:'',
			cedula: '',
			contrasenia: '',
			correoelectronico: '',
			nombre: '',
			usuario: ''		 
						
	}
	
	$scope.registrarU= function() {
		
		$http({
			url: 'http://localhost:8080/ticketReserve/rest/ServicioUsuario/registrarUsuario/'+$scope.nuevoUsuario.nombre+'/'+$scope.nuevoUsuario.apellido+'/'+$scope.nuevoUsuario.cedula+'/'+$scope.nuevoUsuario.correoelectronico+'/'+$scope.nuevoUsuario.usuario+'/'+$scope.nuevoUsuario.contrasenia, 
			 method: 'GET'}).then(function(response) {
				 
				 $scope.usuario = response.data
				 
			 
			 });
		
		
	}
});