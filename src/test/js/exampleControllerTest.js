'use strict';

describe('Controller: ExampleController', function () {

    // load the controller's module
    beforeEach(module('CodingDojoApp'));

    var scope, httpBackend, http, controller;
    var data={"test":"Bla"};
    beforeEach(inject(function ($rootScope, $controller, $httpBackend, $http) {
        scope = $rootScope.$new();
        httpBackend = $httpBackend;
        http = $http;
        controller = $controller;
    }));

    it('should GET example data', function () {
        httpBackend.expectGET('example/Foobar.json');
        httpBackend.when("GET", "example/Foobar.json").respond(data);
        controller('ExampleController', {
            $scope: scope,
            $http: http
        });
        httpBackend.flush();
        expect(scope.data).toBe(data);
    });
});

