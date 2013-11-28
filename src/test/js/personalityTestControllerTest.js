'use strict';

describe('Controller: PersonalityTestController', function () {

    // load the controller's module
    beforeEach(module('CodingDojoApp'));

    var scope, httpBackend, http, controller;
    var data={"test":"Bla"};
    beforeEach(inject(function ($rootScope, $controller, $httpBackend, $http) {
        scope = $rootScope.$new();
        httpBackend = $httpBackend;
        http = $http;
        controller = $controller;
        controller('PersonalityTestController', {
            $scope: scope,
            $http: http
        });
        httpBackend.expectGET('personalityTest/A Test.json');
        httpBackend.when("GET", "personalityTest/A Test.json").respond(data);
        httpBackend.flush();
    }));

    it('should GET personality test data', function () {
        expect(scope.personalityTest).toBe(data);
    });


    it('should send personalitytest to server', function () {
        httpBackend.expectPUT('personalityTest/A Test', {"_id": 1, "questions" : [{"questionId":"q1", "value": "17"}]});
        httpBackend.when("PUT", "personalityTest/A Test").respond("OK");
        scope.personalityTest={"_id":1, "questions" : [{"questionId":"q1", "value": "17"}]}
        scope.sendReply();
        httpBackend.flush();
    });
});

