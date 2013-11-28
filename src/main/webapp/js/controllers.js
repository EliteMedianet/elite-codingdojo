var CodingDojoApp = angular.module('CodingDojoApp', []);

CodingDojoApp.controller('ExampleController', ['$scope', '$http',
    function($scope, $http) {
        $scope.test="Hello World";
        $http.get('example/Foobar.json').success(function(data) {
              $scope.data = data;
            });
    }
]);

CodingDojoApp.controller('PersonalityTestController', ['$scope', '$http',
    function($scope, $http) {
        $scope.test="Hello World";
        $http.get('personalityTest/A%20Test.json').success(function(data) {
            $scope.data = data;
        });
    }
]);

