Feature: successful gmail login 
Scenario: login using valid credentials
	Given user is on the login page
	When enter username "testabcxyz4567@gmail.com" and password "Abcdef123456"
	Then login and send a msg "test1@gmail.com,test2@gmail.com,test3@gmail.com"