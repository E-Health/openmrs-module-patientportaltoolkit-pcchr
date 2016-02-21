angular.module('pcchr.controllers', [])


.controller('getHl10', function($scope, $http) {
	$scope.getPcchr = function(patientId) {
	    var url = '/openmrs/patientportaltoolkit/seeReading/getAllHl10.action?returnFormat=json&successUrl=nuchange.ca&patientId='+patientId;
	    var req = {
	    	method: 'GET',
	    	url: url
	    }
	    $http(req).then(function(resp) {
               alert(resp);
        });
	}

		$scope.postPcchr = function(patientId) {
    	    var url = '/openmrs/patientportaltoolkit/seeReading/getAllHl10.action?returnFormat=json&successUrl=nuchange.ca&patientId='+patientId;
    	    var req = {
    	    	method: 'POST',
    	    	url: url,
    	    	headers: {
    	    		'Content-Type': 'json'
    	    	},
    	    	data: { returnFormat: 'json', patientId: patientId}
    	    }
    	    $http(req).then(function(resp) {
                   alert(resp);
            });
    	}
});




