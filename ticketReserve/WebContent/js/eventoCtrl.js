var app = angular.module('myApp');
app.controller('eventoCtrl', function($scope, $http) {
	
	
	$scope.nuevoEvento= {
			
		codigoubicacion:'',
		 descripcionevento: '',
		 fechaevento:'',
		 horaevento: '',
		 nombreevento: ''
			 
						
	}
	

		
	
	$scope.registrar= function(u) {
		debugger;
		console.log(document.getElementById("value").value);
		$scope.nuevoEvento.codigoubicacion=document.getElementById("value").value;
		console.log(	$scope.nuevoEvento.codigoubicacion);
	
		
		$http({
			url: 'http://localhost:8080/ticketReserve/rest/ServicioEvento/registrarEvento/'+$scope.nuevoEvento.nombreevento+'/'+$scope.nuevoEvento.descripcionevento+'/'+$scope.nuevoEvento.fechaevento+'/'+$scope.nuevoEvento.horaevento+'/'+$scope.nuevoEvento.codigoubicacion, 
			 method: 'GET'}).then(function(response) {
				 
				 $scope.evento = response.data
				 
			 
			 });
		
		
	}
	
	$scope.buscar= function() {
		debugger;
		var nombresito=$scope.nombreevento;
		
		$http.get("http://localhost:8080/ticketReserve/rest/ServicioEvento/buscarEvento/"+nombresito)
	    .then(function(response) {$scope.evento = response.data});
		
	}
	
	$scope.ubicacion={
			
			codigoubicacion:[0,1,2],
			nombreubicacion:''
			
			
	}
	
	$scope.aqui=function (){
		debugger;
		for(i=0;i<=evento.length;i++){
			for(j=0;j<=ubicacion.length;j++){
				if($scope.ubicacion[i].codigoubicacion=$scope.evento[j].codigoubicacion){
					lugar1.push($scope.evento[j].nombreubicacion);
				}				
			}
		}		
	}
	
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioEvento/consultarEvento")
    .then(function(response) {$scope.evento = response.data});
	
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioEvento/consultarUbicacion")
    .then(function(response) {$scope.ubicacion = response.data});

	$scope.filtrar= function(e) {
		debugger;
	//	var mera=$scope.codigoubicacion;
	
	$http.get("http://localhost:8080/ticketReserve/rest/ServicioEvento/getUbicacionNombre/"+e)
    .then(function(response) {$scope.evento1= response.data});
	

	}
	
});