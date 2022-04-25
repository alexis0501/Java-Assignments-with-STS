(In no specific order)

\\ if sts is not working \\

Paste the following lines in the terminal
(1 at a time)

1.  sudo codesign --force --sign - /Applications/SpringToolSuite4.app
2.  codesign -v -vvv --deep /Applications/SpringToolSuite4.app

\\ Error with connecting to MySQL \\

Common error:
java.sql.SQLException: The server time zone value 'PDT' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.

Solution: spring.datasource.url=jdbc:mysql://localhost:3306/book-schema?serverTimezone=UTC

Common error:
Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.

Solution: spring.datasource.driver-class-name=com.mysql.jdbc.Driver

\\ All application.properties files \\
# Where are jsp files? HERE!
spring.mvc.view.prefix=/WEB-INF/
# Data Persistence
spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR_SCHEMA_NAME>>
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
# For Update and Delete method hidden inputs
spring.mvc.hiddenmethod.filter.enabled=true

1. \\ Dependencies to add to pom.xml file: \\
        <!-- DEPENDENCIES FOR STARTING SPRING PROJECTS-->
    code:
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- DEPENDENCIES FOR DISPLAYING JSPS AND USING JSTL TAGS -->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>
        <!-- DEPENDENCIES FOR INTEGRATING SQL DATABASE AND USING JPA -->
        <!-- Note: Project will not run until a schema has been created and the 
            proper settings in application properties are present for 
            connecting to a database. -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <!-- DEPENDENCY FOR USING VALIDATION ANNOTATIONS -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <!-- DEPENDENCY FOR USING BCRYPT  -->
        <dependency>
            <groupId>org.mindrot</groupId>
            <artifactId>jbcrypt</artifactId>
            <version>0.4</version>
        </dependency>
        <!-- DEPENDENCIES FOR BOOTSTRAP -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>webjars-locator</artifactId>
            <version>0.30</version>
        </dependency>
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>5.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>jquery</artifactId>
            <version>3.6.0</version>
        </dependency>

 \\ JSP/HTML \\

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   
</body>
</html>

For the OTHER Model file:

@Column(updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date createdAt;

@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAt;

@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}

@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}

References:
For model user file:
@OneToMany(mappedBy="reader", fetch = FetchType.LAZY)
private List<Book> theReader;

For model OTHER file: 
ex: this code snippet is from BookClub

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="reader_id")
private User reader;


For edit page: <input type="hidden" name="_method" value="put" />
    <div class="form-group">
				<form:label path="title">Title:</form:label>
				<form:input path="title" class="form-control" />
				<form:errors path="title" class="text-danger" />
	</div>

When using strings: <c:out value="${book.title}"/>