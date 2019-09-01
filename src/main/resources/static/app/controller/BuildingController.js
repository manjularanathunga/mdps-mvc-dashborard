app.controller('BuildingController', function ($scope, $rootScope, $http, $location, $window) {

    $rootScope.pageTitle = "Building";
    $scope.itemList = [];
    $scope.item = {};
    $scope.itemDisabled = false;
    $scope.opsType = 'add';
    $scope.heading = '';

    var onLoad = function () {
        loadList();
    };

    var loadList = function () {
        $http.get("building/getList").then(function (response) {
            $scope.itemList = response.data;
        });
    };

    $scope.save = function () {

        if ($scope.opsType == 'delete') {
            var res = $http.delete("building/delete?id=" + $scope.item.id);
            res.then(function (response) {
                //Delay.alert('success',"Record has been updated successfully");
                $scope.refresh();
            });
        } else if ($scope.opsType == 'edit') {
            var res = $http.post("building/save", $scope.item);
            res.then(function (response) {
                $scope.refresh();
                //Delay.alert('success',"Record has been updated successfully");
            });
        } else {
            $scope.item.id = null;
            var res = $http.post("building/save", $scope.item);
            res.then(function (response) {
                $scope.refresh();
                //Delay.alert('success',"Record has been updated successfully");
            });
        }
    };

    $scope.showUI = function (itm, opType) {
        $scope.item = itm;
        $scope.itemDisabled = false;
        $scope.opsType = opType;

        if (opType == 'delete') {
            $scope.itemDisabled = true;
            $scope.heading = 'Delete Record';
        } else if (opType == 'edit') {
            $scope.item.dateModified = new Date();
            $scope.heading = 'Edit Record'
        } else {
            $scope.heading = 'Add Record'
            $scope.item = emptyItem();
        }
        $("#modal-inv").modal("show");
    };

    $scope.refresh = function () {
        loadList();
        $scope.itemDisabled = false;
        $scope.opsType = 'add';
    };

    var emptyItem = function () {
        return {
            id: null,
            buildingNumber: 0,
            name: null,
            noOfRooms: 0,
            ownedBy: '',
            dateCreated: null,
            dateModified: new Date(),
            remarks: '',
            status: 1
        }
    };

    onLoad();
});
