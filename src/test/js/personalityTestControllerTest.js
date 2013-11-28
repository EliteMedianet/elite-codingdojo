'use strict';

describe('The PersonalityTestController', function () {

    // load the controller's module
    beforeEach(module('CodingDojoApp'));

    var scope, httpBackend, http, controller;
    var data = {"test":"Bla"};

    beforeEach(inject(function ($rootScope, $controller, $httpBackend, $http) {
        scope = $rootScope.$new();
        httpBackend = $httpBackend;
        http = $http;
        controller = $controller;
    }));

    it('should GET test data', function () {
        httpBackend.expectGET('personalityTest/A%20Test.json');
        httpBackend.when("GET", "personalityTest/A%20Test.json").respond(data);
        controller('PersonalityTestController', {
            $scope: scope,
            $http: http
        });
        httpBackend.flush();
        expect(scope.data).toBe(data);
    });
});

