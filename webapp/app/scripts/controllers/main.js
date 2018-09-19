'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappApp
 */
angular.module('webApp')
    .controller('MainCtrl', function($scope, $http) {
        var self = this;
        self.init = function() {
            var url = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1043e0e52faa7e3c&redirect_uri=http://localhost:9000&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect';
            $http.get(url)
                .then(function success(response) {
                    $scope.data = response.data;
                    console.log(response);
                }, function error(response) {
                    console.log('发生了错误');
                    console.log(response);
                });

        }
        self.init();
    });