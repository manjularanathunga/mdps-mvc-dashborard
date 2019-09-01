app.controller('OfficeRoomController', function ($scope, $rootScope, $http, $location, $window) {

    $rootScope.pageTitle = "Room Space";
    $scope.itemList = [];
    $scope.item = {};
    $scope.itemDisabled = false;
    $scope.opsType = 'add';
    $scope.heading = '';

    var onLoad = function () {
        loadList();
    };

    var loadList = function () {
        $http.get("officeRoom/getList").then(function (response) {
            $scope.itemList = response.data;
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
            var res = $http.post("officeRoom/save", $scope.item);
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
            name: 0,
            building: null,
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
