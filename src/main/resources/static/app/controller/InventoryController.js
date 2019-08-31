app.controller('InventoryController', function($scope,$rootScope, $http, $location, $window) {
    $rootScope.pageTitle = "Inventory";

    $scope.inventLst={};

    var onLoad = function () {
        var res = $http.get("inventory/getList");
        res.then(function(response) {
            $scope.inventLst = response.data;
            //$scope.statuscode = response.status;
            //$scope.statustext = response.statusText;
        });
    }

    $scope.show = function(){
        $("#modal-inv").modal("show");

    }

    onLoad();
});
