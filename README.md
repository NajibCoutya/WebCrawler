**1. Build and Run instructions**

This WebCrawler exercise can be run via maven.

_**To build the code:**_

From the directory hosting the main pom.xml file run:

`mvn clean install`

_**To run the Tests alone**_

`mvn test `

**To run the main class that produces the structured site map**

`mvn exec:java -Dexec.args="http://wiprodigital.com"`

**2. Reasoning and things to be done with more time**

- Add passed argument friendly validation
- Increase the unit test coverage of the code
- Add a mocked website for the test so that if wiprodigital website is down the test will still
  run successfully in a CI environment
- Provide option to output to a date-time stamped file
- Add more cases for static pages, at the moment only images urls are picked up as static pages
- Add timeout for the whole operation
- Add depth limit to control the nesting of the crawling
- Test with more real websites and refactor the code according to the findings