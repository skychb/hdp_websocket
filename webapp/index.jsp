<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en">
  <head>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700" rel="stylesheet" type="text/css" />
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
  </head>
  <body ng-app="chatApp">
    <div ng-controller="ChatCtrl" class="container">
      <form ng-submit="addMessage()" name="messageForm">
        <input type="text" placeholder="Compose a new message..." ng-model="message" />
        <div class="info">
          <span class="count" ng-bind="max - message.length" ng-class="{danger: message.length > max}">140</span>
          <button ng-disabled="message.length > max || message.length === 0">Send</button>
        </div>
      </form>
      <hr />
      <p ng-repeat="message in messages | orderBy:'time':true" class="message">
        <time>{{message.time | date:'HH:mm'}}</time>
        <span ng-class="{self: message.self}">{{message.message}}</span>
      </p>
    </div>
    
    <script src="/bower_components/sockjs/sockjs.min.js" type="text/javascript"></script>
    <script src="/bower_components/stomp-websocket/lib/stomp.min.js" type="text/javascript"></script>
    <script src="/bower_components/angular/angular.min.js"></script>
    <script src="/bower_components/lodash/dist/lodash.min.js"></script>
    <script src="/js/app.js" type="text/javascript"></script>
    <script src="/js/controllers.js" type="text/javascript"></script>
    <script src="/js/services.js" type="text/javascript"></script>
  </body>
</html>