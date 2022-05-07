# GENERIC PROJECT VERSION 1
Project Description

# Application Integrity Identify

> MD5-File (jar): xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

# Resources

* Java 8
* Maven Project
* Spring Boot 2.0.1.RELEASE

# Dependencies

* Lombok
* Spring Data JPA
* Mysql Driver
* Spring Rest Docs
* Spring Web
* Rest Repositories
* Rest Template (Client)
* Swagger (OpenAPI 3)
* Eureka Server
* Zuul Server
* Feign
* Prometheus
* Zipkin
* ELK
* OAUTH2 (Server and Client)
* JWT
* Junit + MockMvc

# Details
<pre>
- Linux Ubuntu 20.04 LTS

JDK
$ javac -version
javac 11.0.13

JRE
$ java -version
openjdk version "11.0.13" 2021-10-19
OpenJDK Runtime Environment (build 11.0.13+8-Ubuntu-0ubuntu1.20.04)
OpenJDK 64-Bit Server VM (build 11.0.13+8-Ubuntu-0ubuntu1.20.04, mixed mode, sharing)
</pre>

<pre>
- Windows 10 PRO

################
# JAVA 8 (1.8)
################

INSTALLERS
jdk-8u212-windows-x64.exe
jre1.8.0_212-windows-x64.exe (automatic download by jdk)

JDK
$ javac -version
javac 1.8.0_212

JRE
$ java -version
java version "1.8.0_212"
Java(TM) SE Runtime Environment (build 1.8.0_212-b10)
Java HotSpot(TM) 64-Bit Server VM (build 25.212-b10, mixed mode)

--------------------------------------------------------------------------------------------------

</pre>

---------------------------------------------------------------------------------------------------

# Maven Commands (jar generate)

1. mvn package
2. mvn clean compile assembly:single
3. mvn clean
4. mvn clean install
5. mvn clean package spring-boot:repackage

---------------------------------------------------------------------------------------------------

# OpenAPI

> The openAPI(Swagger) is available to query and help understand the application byST API

* http://localhost:31303/api-docs/
* http://localhost:31303/api-docs.yaml
* http://localhost:31303/swagger-ui/index.html

---------------------------------------------------------------------------------------------------

# Tests

