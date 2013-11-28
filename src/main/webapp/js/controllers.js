var CodingDojoApp = angular.module('CodingDojoApp', []);

CodingDojoApp.controller('ExampleController', ['$scope', '$http',
    function ($scope, $http) {
        $scope.test = "Hello World";
        $http.get('example/Foobar.json').success(function (data) {
            $scope.data = data;
        });
    }]);

CodingDojoApp.controller('PersonalityTestController', ['$scope', '$http',
    function ($scope, $http) {
        $http.get('personalityTest/A Test.json').success(function (data) {
            $scope.personalityTest = data;
        });

        $scope.sendReply = function() {
            var testData=$scope.personalityTest;
            $http.put('personalityTest/A Test', testData);
        }
    }]);