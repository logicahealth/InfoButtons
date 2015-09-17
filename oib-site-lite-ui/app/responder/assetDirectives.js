/**
 * Created by JoeNarus on 7/27/15.
 */
var asset_directives = angular.module('directives', []);

asset_directives.directive('dropdownMultiselect', function(){
    return {
        restrict: 'E',
        scope:{
            model: '=',
            options: '=',
            pre_selected: '=preSelected'
        },
        template: "<div class='btn-group' data-ng-class='{open: open}'>"+
        "<button class='btn' data-ng-click='open=!open;openDropdown()'>Select</button>"+
        "<button class='btn dropdown-toggle' data-ng-click='open=!open;openDropdown()'><span class='caret'></span></button>" +
        "<ul class='dropdown-menu' aria-labelledby='dropdownMenu'>" +
        "<li><a data-ng-click='selectAll()'><i class='icon-ok-sign'></i>  Check All</a></li>" +
        "<li><a data-ng-click='deselectAll();'><i class='icon-remove-sign'></i>  Uncheck All</a></li>" +
        "<li class='divider'></li>" +
        "<li data-ng-repeat='option in options track by option.id'> <a data-ng-click='setSelectedItem()'>{{option.displayName}}<span data-ng-class='isChecked(option.id)'></span></a></li>" +
        "</ul>" +
        "</div>" ,
        controller: function($scope){

            $scope.selectAll = function () {
                $scope.model = $scope.options;
            };
            $scope.deselectAll = function() {
                $scope.model=[];
            };
            $scope.setSelectedItem = function(){
                var obj = this.option;
                var id = this.option.id;
                if (_.contains($scope.model, obj)) {
                    $scope.model = _.without($scope.model, obj);
                }

                else if($scope.model.length >= 0) {
                    $scope.model.push(obj);
                }
                return false;
            };
            $scope.isChecked = function (id) {
                for(var i = 0; i < $scope.model.length; i++) { //checks the entire array
                    if (_.contains($scope.model[i], id)) {
                        return 'glyphicon glyphicon-ok pull-right';
                    }
                }
                return false;
            };
        }
    }
});