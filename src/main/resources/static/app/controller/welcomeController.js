var app = angular.module('myApp', []);
app.controller('welcomeController', function($scope, $location) {
    $scope.myUrl = $location.absUrl();
});
