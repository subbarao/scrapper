app = angular.module('checkMovies', ["ui.bootstrap"])

app.controller('TypeaheadCtrl', ['$scope','$http', ($scope, $http) ->
    $scope.getMovies = (movieName) ->
    	$http.get('/movies/autocomplete',
    	  params:
    	    name: movieName
    	).then (r) -> r.data
])
