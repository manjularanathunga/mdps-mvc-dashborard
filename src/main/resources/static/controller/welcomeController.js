var app = angular.module('mdpsApp', []);
app.controller('welcomeController', function($scope, $location) {
    $scope.myUrl = $location.absUrl();
});
