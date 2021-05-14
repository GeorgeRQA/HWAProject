Coverage: 50.9%
# Supermarket Inventory System

This project include a Supermarket Inventory System with 1 Supermarket class that is connected to a front-end making API requests. It allows you add, remove and update items in the system through interacting with a browser-based front end.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
	
### Prerequisites

What things you need to install the software and how to install them

```
To run the .jar file:
1. Download the appropiate Java 14 installer for your machine at https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
2. Run the installer then click next when prompted until you can click close
3. Press the Windows button and type path, then select 'Edit the system environment variables'
4. Click environment variables then click 'new' under system variables
5. Create a variable called JAVA_HOME and give it a value corresponding to the JDK folder installed earlier
6. Click 'okay' then select the 'Path' variable under system variables then click 'edit'
7. Add ;%JAVA_HOME%\bin; to the end of the existing variable value
8. To test this has worked properly open command prompt, type java and press enter. If configured correctly then your OS will run a file called Java.
9. Next you must install MYSQL
10. To do so go to https://dev.mysql.com/downloads/installer/ and select the top option
11. Run the installer and select the custom install option
12. Select MySQL Server 8.0 and MySQL Workbench and press next
13. Open command prompt and enter cd C:\Program Files\MySQL\MySQL Server 8.0\bin
14. Then enter mysqld --console --initialize and press enter
15. Tick both private and public networks when the alert pops up, then allow access
16. Minimise this command prompt and open a new command prompt
17. Enter 
cd C:\Program Files\MySQL\MySQL Server 8.0\bin
 mysql -u root -p 
 and press enter
18. Enter ALTER USER 'root'@'localhost' IDENTIFIED BY 'root'; 
 and press enter to reset the password to root
19. Close all command prompt windows
20. Open a new command prompt as administator
21. Enter cd C:\Program Files\MySQL\MySQL Server 8.0\bin and press enter
22. Enter  mysqld --install and press enter
23. Open up windows services and find MySQL in the list
24. Right click it and press start
25. Press the Windows button and type path, then select 'Edit the system environment variables'
26. Click environment variables then click 'new' under system variables	
27. Create a variable called MYSQ:_HOME and give it a value corresponding to the MySQL folder installed earlier
28. Click 'okay' then select the 'Path' variable under system variables then click 'edit'
29. Add ;%MYSQL_HOME%\bin; to the end of the existing variable value
30. Click okay untul all system windows are closed


To develop and test the file locally:
1. Follow the steps to run the .jar file
2. Download Eclipse from http://www.eclipse.org/downloads
3. Run the installer and select Eclipse IDE for developers then press install
4. Download maven from https://maven.apache.org/download.cgi
5. Unzip the downloaded maven file
6. Press the Windows button and type path, then select 'Edit the system environment variables'
7. Click environment variables then click 'new' under system variables
8. Create a variable called MAVEN_HOME and give it a value corresponding to the maven folder extracted earlier
9. Click 'okay' then select the 'Path' variable under system variables then click 'edit'
10. Add ;%MAVEN_HOME%\bin; to the end of the existing variable value
11. Next you must install Spring for Eclipse
12. Go to https://marketplace.eclipse.org/content/spring-tools-4-aka-spring-tool-suite-4
13. Drag the install into a running Eclipse instance
14. This will automatically import and install Spring 
15.  Go to https://code.visualstudio.com/
16. Download the appropriate installer for your operating system
17. Run the installer and follow the steps to install VisualStudioCode

```

### Installing

A step by step guide that tell you how to get a development environment running

```
For the back-end:
1. Open up Eclipse IDE for Java Developers
2. Navigate to the folder where this repository is cloned to
3. Open up this Java Project
4. You should now be able to edit any file associated with the back-end
5. Go into application.properties in src/main/resources and ensure the correct profile is being used
6. As an example to see if it's working properly:
   1. Right click on the project and select run as Spring Boot App
   2. The console should display connection successful
   3. Navigate to http://locahost:8080:index.html
   4. You should be able to interact with the page
For the front-end:
1. Open up Visual Studio Code
2. Copy the 4 files found in src/main/resources/static into VisualStudioCode
3. You should now be able to edit the files associated with the front-end
4. In VSCode navigate to th extensions tab on the left-hand side
5. Search for live server and install it
6. As an example to see if it's working properly: 
   1.Click the go live button in the bottom right-hand corner
   2.This should open up an instance of the code running on port 5500
   3.You should be able to interact with all the elements on screen

```
## Running the tests

To run the automated tests for this system right click on the runner src/test/java folder and click run as JUnit test.
### Unit Tests 
Currently there are only 2 successful unit tests, one is testing the create method in the SupermarketService class and the other is for the create method in the SupermarketController class. 

SupermarketService create test:
```
@SpringBootTest
public class ServiceTest {
	
	@Autowired 
	private SupermarketService service;
	
	@MockBean
	private SupermarketRepo repo;
	
	@Test
	void testCreate() {
		Supermarket apple = new Supermarket("Apple", 0.49, 10);
		Supermarket addedApple = new Supermarket(1L, "Apple", 0.49, 10);
		
		Mockito.when(this.repo.save(apple)).thenReturn(addedApple);
		
		assertThat(this.service.create(apple)).isEqualTo(addedApple);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(apple);
	}
```
This test works by Mocking an instance of the SupermarketRepo class and stating what methods called from that class will return. It then runs the create method from the SupermarketService class and asserts that the response is equal to that of the Mocked one.


##[Jira Board](https://georgeqa.atlassian.net/secure/RapidBoard.jspa?rapidView=3&view=planning.nodetail&epics=visible&issueLimit=100)
## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/tools) - Framework and aversion of control container

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **George Ryalls** - [GeorgeRQA](https://github.com/GeorgeRQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
