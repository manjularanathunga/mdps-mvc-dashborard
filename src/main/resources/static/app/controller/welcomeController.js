app.controller('welcomeController', function($scope,$rootScope, $http, $location, $window) {
    $scope.myUrl = $location.absUrl();
});
