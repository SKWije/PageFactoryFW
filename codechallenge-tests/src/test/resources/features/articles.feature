Feature: Validating functionality of straitstimes articles

#Using this Scenario can execute both Web and Mobile tests sequentially
#All these scripted using POM, to reduce code redundancy and easy to maintain even the with huge number of test cases
Scenario Outline: Validate main aricle
Given Open the "<env>"
When Login to the system using "<username>" and "<password>"
Then Validate user login using "<username>"
And Valdate the main article on thumbnail image or video
When Go to the main article page
And Validate the main article multimedia contents

Examples:
|env|username|password|
|WEB|sulakkhana_wijesooriya@yahoo.com|Testexam1|
|MOBILE|sulakkhana_wijesooriya@yahoo.com|Testexam1|
