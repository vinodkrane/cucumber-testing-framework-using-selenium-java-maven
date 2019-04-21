# Web application Testing with cucumber framework using Selenium and Java

This is the test automation framework developed for web application Gurukula. This automation framework is developed using selenium, cucumber, java and maven.

## Project Description

It is a behavior driven development (BDD) approach to write automation test script to test Web applications. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding.

## Installation

Pre-requisite You need to have following softwares installed on your computer

1) Install JDK 1.8 and set path
2) Install Maven and set path
3) Eclipse
4) Eclipse Plugins: Maven and Cucumber
5) Installation In order to start using the project you need to create your own Fork on Github and then clone the project.

git clone https://github.com/vinodkrane/cucumber-testing-framework-using-selenium-java-maven.git

## Project structure

```python
Project Name
├───.settings
├───config
├───driver
├───resources
├───screenshots
├───src
│   ├───main
│   │   └───java
│   │       ├───gurukul
│   │       │   └───feature
│   │       ├───pages
│   │       ├───stepDefination
│   │       └───utility
│   └───test
│       └───java
│           └───testRunner
├───target
│   ├───classes
│   │   ├───gurukul
│   │   │   └───feature
│   │   ├───pages
│   │   ├───stepDefination
│   │   └───utility
│   ├───cucumber-reports
│   ├───maven-archiver
│   ├───maven-status
│   │   └───maven-compiler-plugin
│   │       ├───compile
│   │       │   └───default-compile
│   │       └───testCompile
│   │           └───default-testCompile
│   ├───surefire-reports
│   └───test-classes
│       └───testRunner
└───web_app_aut
```

1) src/main/java/gurukul/feature - Cucumber features files
2) src/main/java/pages - All page object classes
3) src/main/java/stepDefination - Cucumber step defination class
4) src/main/java/utility - Utility classes
5) src/test/java/testRunner - Cucumber test runner class


## Writing test cases
The cucumber features goes in the features library and should have the ".feature" extension.

You can start out by looking at src/main/java/gurukul/feature. You can extend this feature or make your own features using some of the predefined steps that comes with selenium-cucumber.

## Application under test
You can find the application under test and it's guidelines in web_app_aut directory.

## Execute test cases in the framework
Navigate to your project directory from terminal and run following commands 

```python
mvn clean test
```

## Contributing
1) Fork it!
2) Create your feature branch: git checkout -b my-new-feature
3) Commit your changes: git commit -am 'Add some feature'
4) Push to the branch: git push origin my-new-feature
5) Submit a pull request :D
6) Please make sure to update tests as appropriate.

## License
(The MIT License)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. readme
