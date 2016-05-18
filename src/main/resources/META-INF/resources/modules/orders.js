define([
    'module',
    '{angular}/angular'
], function (module, angular) {
    'use strict';
    var ordersModule = angular.module('orders', []);

    ordersModule.controller('OrderListController', ['$scope', '$location', 'HomeService', function ($scope, $location, api) {
        $scope.fetchOrders = function () {
            $scope.orders = api('nightclazz').enter('order/list', {customerId: $scope.customerId}).query();
        };

        $scope.reset = function () {
            delete $scope.customerId;
            $scope.fetchOrders();
        };

        $scope.customerId = parseInt($location.search().customerId) || undefined;
        $scope.fetchOrders();
    }]);

    ordersModule.controller('OrderDetailsController', ['$scope', '$routeParams', 'HomeService', function ($scope, $routeParams, api) {
        $scope.order = api('nightclazz').enter('order/details', {
            orderId: $routeParams.orderId
        }).get();
    }]);

    return {
        angularModules: ['orders']
    };
});