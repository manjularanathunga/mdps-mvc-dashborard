var app = angular.module('myApp',['ngRoute'])
    .run(['$rootScope','$location','$window','$http', function($rootScope,$location,$window,$http){
        $rootScope.presentDate = new Date();

/*        $rootScope.currentUserId    = $window.localStorage.getItem('mdbUserId') || false;
        $rootScope.mdbRole          = $window.localStorage.getItem('mdbRole') || false;
        $rootScope.authdata      = $window.localStorage.getItem('mdbAuthData') || false;

        if($rootScope.currentUserId){
            $http.defaults.headers.common[''] = 'Basic ' + $rootScope.authdata;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
           var restrictedPage = $.inArray($location.path(),['/login']) === -1;
           if(restrictedPage && $rootScope.currentUserId == false){
               //$location.path('/login');
           }
        });*/
    }])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when("/login", {
                templateUrl : 'app/view/loginPage.html',
                controller: 'LoginPageController'
            })
            .when("/", {
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



