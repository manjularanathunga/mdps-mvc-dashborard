var app = angular.module('myApp', []);
app.controller('loginController', function($scope, $location) {
    $scope.myUrl = $location.absUrl();
});
