# Setup and how to run guide

## Pre-requisite
1. JAVA 8
2. MySQL 8
3. Maven 3+
4. Any IDE (STS / Eclipse / IntelliJ Idea)
5. Tomcat 8.5

## Steps to import the project in STS
1. Open STS.
2. Go to File -> Import
3. Search for `Existing maven Projects`. Select this option.
4. Select the path of the directory in which the source code of the project is present and click next.

After this step, STS will start importing the project and will download the required dependencies. This might take a while.

Once this step is complete make sure the Tomcat server is added in the STS, if not follow the steps below to add a tomcat server in STS.

## Steps to add tomcat server in STS
1. In STS, select the option `Window -> Show view` and search for Servers.
2. Select the option to add new server.
3. Under the apache folder, select the correct version of the apache tomcat.
4. Then select the path of the apache tomcat directory in your local system.

 
## Configure the database
This application uses MySQL 8 as a database to store flights and users data. Make sure that you hava MySQL 8 installed in your system.

Open MySQL Workbench and create a new database schema which will be used by this application. Run the below command to create a new database

> `CREATE DATABASE flight_search CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;`


Once the database is created, then make sure the correct properties are present in the source code to connect to the database. To check the properties open the file `jpaContext.xml` present in the `src->main->resources` directory. 

In the file, a bean with id dataSource is created which contains properites to connect to the database with below code
```
	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url"
			value="jdbc:mysql://localhost:3306/flight_search?autoReconnect=true" />
		<property name="username" value="{database_username}" />
		<property name="password" value="{database_password}" />
	</bean>
```

Replace the values `{database_username}` and `{database_password}` with correct username and password for the local MySQL database.

## Update CSV file location

Before building the project make sure you update the correct path to the CSV files in the code. This can be configured in the `Constant.java` file. Open this file and update the path in the `DIRECTORY_PATH` constant. The path provided in this variable should be of the directory containing all the CSV files.

## Build Project

To build the project from STS, follow below steps:

1. Right click on the project name in Project Explorer.
2. Select the option `Run as` and then select the option `Maven Build`
3. In the prompt, in the goals field enter `clean install`.
4. Click `Apply` and then `Run`

This will create a war file for the project. 

You can also build the project from command line. To build the project from command line, run the following command from the terminal inside project directory.

> `mvn clean install`

## Run Project
Once the project is successfully build, then run the project by following the below steps
1. Add Project to tomcat server.
    - To add the project in the tomcat server, Right click on the tomcat server added in [Add Tomcat Server](##Steps-to-add-tomcat-server-in-STS)
    - Select the option `Add and Remove`.
    - In the prompt, you should see the name `Assignment11-SpringMVC`. Move this to the right.
2. Start the server by Right clicking on the server and selecting the option `Start`

This would start the server and will also create the required tables in the database. Once the server is started successfully go to the browser and enter the URL:

> `http://localhost:8080/Assignment11-SpringMVC/register.html`

This would open the page to register a new user in the application. Create a new user and then login to the application and start searching...


## Common problems faced while running the program

If you open the URL and application gives an error that the URL is not found make sure correct JAVA Path is configured in the STS. To do that Right click on the project and select the "properties" option. In the properties, click on the "Java Compiler" option and make sure correct version of the JAVA is selected. For the project it should be 1.8



