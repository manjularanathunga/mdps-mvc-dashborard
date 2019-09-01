app.controller('OfficeRoomController', function($scope,$rootScope, $http, $location, $window) {
    $rootScope.pageTitle = "Building";

    $scope.itemList={};

    var onLoad = function () {
        var res = $http.get("officeRoom/getList");
        res.then(function(response) {
            $scope.itemList = response.data;
            //$scope.statuscode = response.status;
            //$scope.statustext = response.statusText;
        });
    }

    $scope.show = function(){
        $("#modal-oroom").modal("show");

    }

    onLoad();
});
