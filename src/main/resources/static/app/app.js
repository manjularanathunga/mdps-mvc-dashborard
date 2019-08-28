var app = angular.module('myApp',['ngRoute'])
    .run(['$rootScope','$location','$window','$http', function(){
        $rootScope.presentDate = new Date();

    }])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when("/login", {
                templateUrl : 'app/view/loginPage.html',
                controller: 'LoginPageController'
            })
            .when("/dashboard", {
                templateUrl : 'app/view/dashboard.html',
                controller: 'DashboardPageController'
            })
            .when("/red", {
                templateUrl : "app/view/red.htm"
            })
            .when("/green", {
                templateUrl : "app/view/green.htm"
            })
            .when("/blue", {
                templateUrl : "app/view/blue.htm"
            })
    }]);



