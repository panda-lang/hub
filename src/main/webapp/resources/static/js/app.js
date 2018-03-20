var app = angular.module('app', ['ngRoute','ngResource']);

app.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl: 'assets/static/views/home.html',
            controller: 'homeController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});
