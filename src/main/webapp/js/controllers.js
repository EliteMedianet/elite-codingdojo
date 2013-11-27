var CodingDojoApp = angular.module('CodingDojoApp', []);

CodingDojoApp.controller('ExampleController', ['$scope', '$http',
    function($scope, $http) {
        $scope.test="Hello World";
        $http.get('example/Foobar.json').success(function(data) {
              $scope.data = data;
            });
    }]);