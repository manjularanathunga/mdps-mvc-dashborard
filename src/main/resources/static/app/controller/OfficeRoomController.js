app.controller('OfficeRoomController', function ($scope, $rootScope, $http, $location, $window) {

    $rootScope.pageTitle = "Room Space";
    $scope.itemList = [];
    $scope.item = {};
    $scope.itemDisabled = false;
    $scope.opsType = 'add';
    $scope.heading = '';
    $scope.buildingList = [];
    $scope.selectedBuilding = {};

    var onLoad = function () {
        loadList();
    };

    var loadList = function () {
        $http.get("officeRoom/getList").then(function (response) {
            $scope.itemList = response.data;
        });
    };

    var loadBuildingList = function () {
        $http.get("building/getList").then(function (response) {
            $scope.buildingList = response.data;
        });
    };

    $scope.save = function () {

        if ($scope.opsType == 'delete') {
            var res = $http.delete("officeRoom/delete?id=" + $scope.item.id);
            res.then(function (response) {
                //Delay.alert('success',"Record has been updated successfully");
                $scope.refresh();
            });
        } else if ($scope.opsType == 'edit') {
            var res = $http.post("officeRoom/save", $scope.item);
            res.then(function (response) {
                $scope.refresh();
                //Delay.alert('success',"Record has been updated successfully");
            });
        } else {
            $scope.item.id = null;
            var res = $http.post("officeRoom/save", JSON.stringify($scope.item));
            res.then(function (response) {
                $scope.refresh();
                //Delay.alert('success',"Record has been updated successfully");
            });
        }
    };

    $scope.showUI = function (itm, opType) {
        $scope.opsType = opType;
        loadBuildingList();
        $scope.item = itm;
        $scope.refrshModal();
    };

    $scope.OnChangeBuilding = function () {
        $scope.item.buildingId=selectedBuilding.id;
        $scope.item.buildingName=selectedBuilding.name;
    };

    $scope.refresh = function () {
        loadList();
        $scope.itemDisabled = false;
        $scope.opsType = 'add';
    };

    $scope.refrshModal = function () {
        $scope.itemDisabled = false;
        if ($scope.opsType == 'delete') {
            $scope.itemDisabled = true;
            $scope.heading = 'Delete Record';
        } else if ($scope.opsType == 'edit') {
            $scope.item.dateModified = new Date();
            $scope.heading = 'Edit Record'
        } else {
            $scope.heading = 'Add Record'
            $scope.item = emptyItem();
        }
        $("#modal-room").modal("show");
    };


    var emptyItem = function () {
        return {
            id: null,
            name: 0,
            buildingId: null,
            buildingName: null,
            roomNumber: 0,
            noOfPeopleUsedBy: 0,
            dateCreated: new Date(),
            dateModified: null,
            remarks: '',
            status: 1
        }
    };

    onLoad();
});
