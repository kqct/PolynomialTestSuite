A collection of polynomial tests from the original assignment, my own tests, and the Megatester. 
These tests require JUnit 5 to run.

Feel free to add your own test cases! If you want, you can submit a pull request and I'll probably add your cases too.

### If you are using Sasha's SpeedTester program:
Please uncomment and change the relevant line in `build.gradle` to the location and name of the `RuntimeTester.jar` file.

## Installation
### IntelliJ
To import the project from version control:
1. Click "Get from version control..."
2. Select "GitHub"
3. Select a local directory and paste the URL of this project
4. You're done!

### Eclipse
1. Select "Git -> Projects from Git (with smart import)"
2. Select "Clone URI"
3. Paste the URL of this project into "URI"
4. Select the "master" branch
5. Once the project is imported, click the "Gradle Tasks" tab and import the Gradle project. The root directory will be wherever you cloned the project to.

## Usage
### IntelliJ
#### To run all tests:
Right-click on the package "src/test/java/assignment2" and click "Run 'Tests in 'assignment2''"

#### To run a smaller selection of tests:
Either right-click the files or go in to the files and run whatever methods you want

### Eclipse
Run the build task in Gradle Tasks -> build -> build. This will run all the tests and show failed tests with an x, skipped tests with an arrow, and passed tests with a check mark. I haven't yet figured out how to run individual tests...
