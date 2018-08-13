** Login Page **

#TESTCASE-1
#### TITLE: Login with existing user -check happy scenario
#### Preconditions
* Existing user
#### Test steps
* Open [Home page](http://127.0.0.1:8080/)
* Click *login* 
* Fill *login* text field with "admin" from json file
* Fill *Password* text field with "admin" from json file
* Click *Authenticate*  button
#### Assertions
* Welcome message contains the name as in login field "admin"


#TESTCASE-2
#### TITLE: Logout successfully
#### Preconditions
* User is logged in
#### Test steps
* Open [Home page](http://127.0.0.1:8080/)
* Click *Account* tab 
* Click *logout* 
#### Assertions
* User is on homepage.
* "Entities" tab dissapeared
* "login" and "register" links are available
* "Account" tab has two options "Authenticate" and "Register"


#TESTCASE-3
#### TITLE: Login with wrong user 
#### Preconditions
* N/A
#### Test steps
* Open [Home page](http://127.0.0.1:8080/)
* Click *login* 
* Fill *login* text field with "fakeUser" from json file
* Fill *Password* text field with "password" from json file
* Click *Authenticate*  button
#### Assertions
* User is still on login page , url contains "login"
* "Authentication failed! Please check your credentials and try again." message appears

********************************************************************************************************************
********************************************************************************************************************

** Forgot password Page **

#TESTCASE-1
#### TITLE: Check navigation to "forgot password" page
#### Preconditions
* User is not logged in
#### Test steps
* Open [Home page](http://127.0.0.1:8080/)
* Click *login* 
* Click *Did you forget your password?*  link
#### Assertions
* User is navigated to url contains /reuest
* text field for email is presented
*"Reset Password" button is not clickable


#TESTCASE-2
#### TITLE: Check validations on email field
#### Preconditions
* user is on Forgot password page
#### Test steps
* Open [Home page](http://127.0.0.1:8080/)
* Click *login* 
* Click *Did you forget your password?*  link
* Check with text field that doesnt contain "@" 
* Check with text field that ends with "@" 
* Check with text field that ends with "."
* Check with text field that is less than 5 characters
* Check with a good email field
#### Assertions
*"Reset Password" button is only clickable at the last step

********************************************************************************************************************
********************************************************************************************************************

** Registration Page **

#TESTCASE-1
## TITLE: Check structure of Registration page
## Preconditions
* user is not logged in
## Test steps
* Open [Home page](http://127.0.0.1:8080/)
* Click *Register a new account* link
## Assertions
* check the existance of the following fields: Login , email, new password, new password confirmation


#TESTCASE-2
## TITLE: Check login text field
## Preconditions
* user is not logged in
## Test steps
* Open [Home page](http://127.0.0.1:8080/)
* Click *Register a new account* link
## Assertions
* Check login text field cant be more than 50 characters.
* Check login can only contain lower-case letters and digits.


#TESTCASE-3
## TITLE: Check email text field
## Preconditions
* user is not logged in
## Test steps
* Open [Home page](http://127.0.0.1:8080/)
* Click *Register a new account* link
* Check with text field that doesnt contain "@" 
* Check with text field that ends with "@" 
* Check with text field that ends with "."
* Check with text field that is less than 5 characters
## Assertions
* check the existance of the following error: "Your e-mail is invalid."
* check the existance of the following error: "Your e-mail is required to be at least 5 characters."


#TESTCASE-4
## TITLE: Check "new password" text field
## Preconditions
* user is not logged in
## Test steps
* Open [Home page](http://127.0.0.1:8080/)
* Click *Register a new account* link
* Check with text field that is more than 50 character
* Check with text field that is less than 5 characters
* Check with a text field that is 10 chars containing special characters
## Assertions
* Check existance of errors for the 3rd and 4th steps
* Check no errors for the 5th step


#TESTCASE-5
## TITLE: Check "new password confirmation" text field
## Preconditions
* user is not logged in
## Test steps
* Open [Home page](http://127.0.0.1:8080/)
* Click *Register a new account* link
* Check with text field that is more than 50 character
* Check with text field that is less than 5 characters
* Check with a text field that is 10 chars containing special characters
## Assertions
* Check existance of errors for the 3rd and 4th steps
* Check no errors for the 5th step


********************************************************************************************************************
********************************************************************************************************************




