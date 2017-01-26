# trialtask
2)	Please write Automated tests using Selenium server, covering Registration form for https://github.com
<br>
a.	Access the registration form on the page https://github.com/join<br>
i.	Make registration through form pages. Make sure that form fields captured with valid values: Username, Email Address.<br>
ii.	On the second page make selected "Unlimited public repositories for free." checkbox<br>
iii.	On the third page make selected "Development" and "Research" checkboxes.<br>
iv.	Complete registration by asserting correct message "Learn Git and GitHub without any code!"<br>
b.	Access the registration form on the page https://github.com/join<br>
i.	Start making registration through form pages. Try to capture form fields with NOT valid values: Username and Email Address.<br>
ii.	Assert error message returned "There were problems creating your account."<br>
iii.	Print out messages that captured through not valid fields values captures
(Login can't be blank; Email is invalid or already taken etc.).<br>

# Solution

solution includes 5 packages.<br>
<b>appmanager</b>: provides interractin between application parts and tests<br>
<b>dataProviders</b>: method used to get/generate test data<br>
<b>model</b>: classes to map test data to logical objects<br>
<b>test</b>s: test classes and methods.<br>
<b>utils</b>: custom annotations and specified expected conditions.<br>

Test data are in csv files under resources folder.<br>
simple logging: app.log file is in home directory.<br>
