This repository contains functional User Interface tests for formedix challenge 

In combination with cucumber reports we can see which tests are failing and analyse the problem directly from the report. 

### How to start selenium tests
The main requirements to run test cases are:
- Java 8 SDK
- Gradle >= 3.1  < 7.0
- Firefox latest version

### How it works
All behaviour tests cases are defined in human readable language called Gherkin. 
This language was created to easily write functional requirements for the test without to be a technical expert.

In addition, we use Cucumber Software to map BDD test description to specific Java implementation and to execute tests.
Actual mapping from BDD to Java code is done by annotations. Every annotation contains regular expression that match specific BDD description.

### Running Selenium Test Case
To run one single test it's required to provide system parameters to cucumber. Otherwise it will use default parameters which may **not work** for your system.
Other required parameter is `CUCUMBERTAGS` which defines a number of the feature.     

To execute cucumber task simply run 'gradle selenium' in the terminal or execute 'selenium' task in gradle Tasks window.