$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('cucumberjava\cucumberJava.feature');
formatter.feature({
  "line": 1,
  "name": "successful gmail login",
  "description": "",
  "id": "successful-gmail-login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "login using valid credentials",
  "description": "",
  "id": "successful-gmail-login;login-using-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "user is on the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "enter username \"testabcxyz4567@gmail.com\" and password \"Abcdef123456\"",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "login and send a msg \"test1@gmail.com,test2@gmail.com,test3@gmail.com\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Annotation.user_is_on_the_login_page()"
});
formatter.result({
  "duration": 10950631299,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testabcxyz4567@gmail.com",
      "offset": 16
    },
    {
      "val": "Abcdef123456",
      "offset": 56
    }
  ],
  "location": "Annotation.when_entered_username_password(String,String)"
});
formatter.result({
  "duration": 9226458401,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test1@gmail.com,test2@gmail.com,test3@gmail.com",
      "offset": 22
    }
  ],
  "location": "Annotation.login_and_send_message(String)"
});
formatter.result({
  "duration": 58902060200,
  "status": "passed"
});
});