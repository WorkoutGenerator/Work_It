# Work_It
___

## About
General info about the Decisionator
* What does it do?
* Who is the target audience
* what cloud aspects are there?

## Development Environment
___
What tools we use
* Android
* Android studio
* Git
* Github
* Waffle.io
* Hipchat
* GDrive
* Google App engine / amazon aws
* JUnit
* Travis CI
* Java

## Architechure
___
Different diagrams and methodologies used

## Contributing
___

How to contribute to the project

1. Clone repo into local machine
    * **git clone http://github.com/Mosquito-Mashers/Decisionator.git**
2. Build and run (master branch should be clean)
3. checkout new branch
    *  **git checkout -b {branch-name}**
          * Branch names: "name_of_feature-#issue_number"
          * ex: **git checkout -b adding_login-#12**
4. Add your changes while git adding and git committing often
    * **git checkout...**
    * Open android studio and make code changes
    * **git add -A**
    * **git commit -am "Descriptive message explaining what work was done"**
    * make more changes (maybe add more files)
    * **git add -A**
    * **git commit -am "Descriptive message explaining what work was done"**
5. If done working but the feature is not closed:
    * **git add -A**
    * **git commit -am "Descriptive message explaining what work was done"**
    * **git push origin {branch_name}**
        * Enter username and password
6. If done working and your branch closes #issue_number
    * **git add -A**
    * **git commit -am "Description of the changes Fixes #issue_number"**
        * This will close the particular issue once it is merged with master
    * **git push origin {branch_name}**
    * On Github, select your branch from the dropdown menu and click the button to create ***New Pull Request***
    * Either replace the pull requests title with ***Fixes #issue_number*** or put ***Fixes #issue_number*** in the body of the pull request
    * Leave a comment using the @mention for another team memeber to review the code
