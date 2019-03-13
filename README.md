# AssessmentTask2
Assessment Task2 to add user in a website and checking the uniqueness of Username
Read Me:
1. The Automation tool used here is Selenium to write code using JavaScript.
2. The framework used here is 'TestNG' and annotations used here is '@Data Provider', '@BeforeTest', '@Aftertest', '@Test'.
3. Create an excel with test data. 
4. The webdriver for Firefox is ivoked and implicit wait is used.
5. The website "http://www.way2automation.com/angularjs-protractor/webtables/" is launched and the screen is maximized.
6. Method "getRdData()" is used to read the test data from excel row by row and coloumn by column using a for() loop and the value is stored in a double dimentional array.
7. In TestNG,data driven framework is used. @Data Provider method "GetDataExl()" is used which calls another method "getRdData()" to read test data from excel.
8. To read the excel file, Apache POI library is imported.
9. The parameters used in the method "getRdData()" is the file path "C:\\Pinks\\ReadExl12.xlsx" and the sheet name "AddUser111". 
10. @Test method "testDataProviderExp()" will used the parameter (dataProvider = "dp111") to get all the columns present in the excelsheet. For example: "Firstname", "Lastname", "Username", "Password", "Customer","Role","Email","Cell".
11. In the method "testDataProviderExp()", a condition is verfied using if() condition. If the Username is unique then the test data from excel is entered in the "AddUser" or else its skipped and looks for next test data.
12. Before entering the test data from excel, fields are cleared and then value is entered into the respective fields.
13. An if() condition is used to check the Customer field value and then the respective Radio button is clicked.
14. The file is not closed here, so that user can view the entered test data from excel is reflecting in the frontend GUI table.

NOTE: Customer value is not stored or reflecting in the GUI of the website "http://www.way2automation.com/angularjs-protractor/webtables/" after entering the value manually as well as automatically.
