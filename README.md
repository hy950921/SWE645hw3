
# SWE 645: Assignment 3 Angular, RESTful Web Services, and JPA

This assignment is to develop a single page web application using Angular2 (or later
versions), RESTful Web Services and JPA/Hibernate along with Amazon Relational Database
Service (Amazon RDS)/MySQL to persist and read data to/from a relational database. The
application allows prospective students to fill out a survey form to provide feedback about their
campus visit. It also allows users to view all surveys recorded to date.

## URLs
- [Github repository](https://github.com/Assignment-645)
- [Application welcome page](http://35.245.10.248/)

## Authors
 - Sruthi Moothat G01176482 [AWS S3 homepage](http://sruthi-moothat-swe-645.s3-website-us-east-1.amazonaws.com/)
 - AJAY GUPTA DOGIPARTHI G01219857 [AWS S3 homepage](http://ajayguptahomepage.s3-website-us-east-1.amazonaws.com/)
 - Yu Han G00849895 [AWS S3 homepage](http://swe645-yhan27.s3-website-us-east-1.amazonaws.com)

## Summary

  - [Getting Started](#getting-started)
  - [Runing the tests](#running-the-tests)
  - [Deployment](#deployment)
  - [Built With](#built-with)
  - [References](#References)

## Getting Started

These instructions will get you a copy of the project up and running on
your local machine for development and testing purposes. See deployment
for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

- Visual Code Studio that we will be using o develop the angular part
- Eclipse EE to develpo the RESTful Web Services, we used Jersey API
- JPA, we used hibernate , developed in ecllipse
- Amazon RDS

# Executables and installation/setup instructions(including references)
 - Eclipse IDE for Java EE Developers  [use this link to download eclipse](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers)
 - Visual studio code [use this link for visual studio code](https://code.visualstudio.com/)
 - AWS- EC2, EKS.(https://aws.amazon.com/)
 - Kubernetes (This can be directly installed on the aws)
 - Docker(This can be directly installed on the aws)
 - Jenkins(https://jenkins.io/)
 
 
### Installing

A step by step series of examples that tell you how to get a development
env running

# Steps to repliicate my project
- Backend files has all the source code that will be reuired to replicate this project
- We can import the files to a eclipse EE as a maven project and run it on a server like tomcat 7
- The front end files has all the files required to create a angular front end
- You can use the visula code studio to import thr project
- Click "npm install" to get all the node modules and "ng serve" to run the project on the localhost


#### Angular Installation on visual code studio
   - Install Node.js from nodejs.org
   - Install Visual Studio Code IDE from code.visualstudio.com
   - Install Angular CLI

#### Creating an Angular application with CLI version 9.1.1 and develop it using VS Code IDE
	ng new swe645hw3

####  The application starts with a welcome homepage, which in essence has two links: 1) Student Survey, which allows a prospective student to fill out a survey form, with an acknowledgement and 2) List All Surveys, which allows a user to view all surveys done to date


#### Created the MySQL database in Amazon RDS
[Using Amazon RDS to create MySQL Database](https://s3.us-east-1.amazonaws.com/blackboard.learn.xythos.prod/5a30bcf95ea52/8566878?response-content-disposition=inline%3B%20filename%2A%3DUTF-8%27%27SWE645-HW3-AppendixA-Using%2520Amazon%2520RDS%2520to%2520create%2520MySQL%2520Database.pdf&response-content-type=application%2Fpdf&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200420T234445Z&X-Amz-SignedHeaders=host&X-Amz-Expires=21600&X-Amz-Credential=AKIAIL7WQYDOOHAZJGWQ%2F20200420%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=717268563d5d550275d1ab431538e2e0dd8836b3f131bfecf3d2786a8d1e698d)


## Running the tests

Explain how to run the automated tests for this system

### Backend

####  Creating jar files
	mvn clean package

#### Creating Dockerfile
	FROM tomcat:9-jdk8
	COPY target/*.war /usr/local/tomcat/webapps/homework3.war

#### Build the docker image
	docker build -t sruthimoothat/swe645hw3backend .

####  Run the docker image
	docker run --rm -it -p 9000:80 sruthimoothat/swe645hw3backend

#### Push the container to the docker hub
	docker push sruthimoothat/swe645hw3backend

### Frontend
Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

#### Create a new deployment in the Kubernetes cluster for the frontend and a Dockerfile for the frontend
    FROM node:12.16.2-alpine3.9 AS build-step
    WORKDIR /app
    COPY package.json ./
    RUN npm install
    COPY . .
    RUN npm run build
    FROM nginx:1.16.1-alpine AS prod-stage
    COPY --from=build-step /app/dist/angular8-frontend /usr/share/nginx/html

#### Build the docker image
    docker build -t sruthimoothat/swe645hw3frontend .

#### Run the docker image
    docker run --rm -it -p 9000:80 sruthimoothat/swe645hw3frontend

#### Push to the Dockerhub
    docker push sruthimoothat/swe645hw3frontend

####   Create a new deployment in the Kubernetes cluster for the front end
    [http://35.245.10.248](http://35.245.10.248/)

## Deployment

### Backend


### Mysql commands to create table

create table if not exists student_table(
   student_id INT(10) NOT NULL AUTO_INCREMENT,
   student_firstname VARCHAR(20),
   student_lastname VARCHAR(20),
   street_address VARCHAR(100) ,
   city VARCHAR(20),
   zip VARCHAR(10),
   telephone VARCHAR(15),
   email VARCHAR(100),
   submission_date DATE ,
   like_about_college VARCHAR(20),
   intrested_in_college VARCHAR(20),
   recommend VARCHAR(10),
   PRIMARY KEY ( student_id )
);

####  To deploy the containerized application in google Kubernetes engine
[https://cloud.google.com/kubernetes-engine/docs/quickstart](https://cloud.google.com/kubernetes-engine/docs/quickstart)
		gcloud config set project project-id

	gcloud config set compute/zone compute-zone

	gcloud container clusters create cluster-name --num-nodes=1

	gcloud container clusters get-credentials cluster-name

	kubectl create deployment hello-server --image=gcr.io/google-samples/hello-app:1.0

	kubectl expose deployment hello-server --type LoadBalancer --port 80 --target-port 8080

#### Deployed RESTful Web Service
[http://35.245.219.149/homework3/](http://35.245.219.149/homework3/)

#### Creating Jenkins project, add the Git repository URL and build with commands
	mvn clean package
	docker build -t sruthimoothat/swe645hw3backend:$BUILD_NUMBER .
	docker login -u <username> -p <password>
	docker push sruthimoothat/swe645hw3backend:$BUILD_NUMBER
	gcloud container clusters get-credentials swe645 --region us-east4
	kubectl set image deployment/backend swe645hw3backend=sruthimoothat/swe645hw3backend:$BUILD_NUMBER --record


### Frontend

#### Create a Jenkins project with added Github repository URL https://github.com/Assignment-645/frontend

#### Build the Jenkins project
    docker login -u <username> -p <password>
    docker build -t sruthimoothat/swe645hw3frontend:$BUILD_NUMBER .
    docker push sruthimoothat/swe645hw3frontend:$BUILD_NUMBER
    gcloud container clusters get-credentials swe645 --region us-east4
    kubectl set image deployment/frontend swe645hw3frontend=sruthimoothat/swe645hw3frontend:$BUILD_NUMBER --record

## Built With

  - [Angular](https://angular.io/) - Used for frontend
  - [RESTful](https://restfulapi.net/) - Used for backend
  - [JPA](https://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html) - Used for backend
  - [Google Kubernetes Engine](https://cloud.google.com/kubernetes-engine) - Used for deployment
  - [Docker](https://www.docker.com/) - Used for containerized application
  - [Amazon Relational Database Service (RDS)](https://aws.amazon.com/rds/) - Used for data storage
  - [Github](https://github.com/)- Used for git repository
  - [Jenkins](https://jenkins.io/) - Used for CI/CD pipeline

## References

  - [SWE645HW3 Documentation](https://s3.us-east-1.amazonaws.com/blackboard.learn.xythos.prod/5a30bcf95ea52/22077651?response-content-disposition=inline%3B%20filename%2A%3DUTF-8%27%27SWE%2520645-HW3-Spring2020%25281%2529%25281%2529.pdf&response-content-type=application%2Fpdf&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200420T224919Z&X-Amz-SignedHeaders=host&X-Amz-Expires=21600&X-Amz-Credential=AKIAIL7WQYDOOHAZJGWQ%2F20200420%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=3615d1bd9b9c6a03b9a6fa4c6f7b4b2a76725c1de0287314de89ac9f09918e51)
  - [HW3-Appendix-Using Amazon RDS to create MySQL Database](https://s3.us-east-1.amazonaws.com/blackboard.learn.xythos.prod/5a30bcf95ea52/8566878?response-content-disposition=inline%3B%20filename%2A%3DUTF-8%27%27SWE645-HW3-AppendixA-Using%2520Amazon%2520RDS%2520to%2520create%2520MySQL%2520Database.pdf&response-content-type=application%2Fpdf&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200421T010148Z&X-Amz-SignedHeaders=host&X-Amz-Expires=21600&X-Amz-Credential=AKIAIL7WQYDOOHAZJGWQ%2F20200421%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=bab9e31dbe6914933e467c0630868d864854c17a2250e420d551860061b10ebf)
  - [https://cloud.google.com/kubernetes-engine/docs/quickstart](https://cloud.google.com/kubernetes-engine/docs/quickstart)
  - [Lec4 - Angular Framework and TypeScript](https://s3.us-east-1.amazonaws.com/blackboard.learn.xythos.prod/5a30bcf95ea52/21328841?response-content-disposition=inline%3B%20filename%2A%3DUTF-8%27%27Lec4-Intro%2520to%2520Angular%2520Framework%2520and%2520TypeScript.pdf&response-content-type=application%2Fpdf&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200421T023342Z&X-Amz-SignedHeaders=host&X-Amz-Expires=21600&X-Amz-Credential=AKIAIL7WQYDOOHAZJGWQ%2F20200421%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=ccec23da558cf5e61a44e942a7301e6bf9483c6f5cfeb69923e40b0857d6addc)
  - [Lec5 - RESTful Web Services](https://s3.us-east-1.amazonaws.com/blackboard.learn.xythos.prod/5a30bcf95ea52/19557259?response-content-disposition=inline%3B%20filename%2A%3DUTF-8%27%27645Lec8-RESTful%2520%2520Web%2520Services.pdf&response-content-type=application%2Fpdf&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200421T023503Z&X-Amz-SignedHeaders=host&X-Amz-Expires=21600&X-Amz-Credential=AKIAIL7WQYDOOHAZJGWQ%2F20200421%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=8b62adc142fb18515ebbb9e8a43e318596b3c80b92061a5bddf021bc598491b7)
  - [Lec6 - JPA-Entitiy Manager - JPA Entity Relationships](https://s3.us-east-1.amazonaws.com/blackboard.learn.xythos.prod/5a30bcf95ea52/19128481?response-content-disposition=inline%3B%20filename%2A%3DUTF-8%27%27645Lec6-JPA-%2520EntityManager-and-Entity%2520Relationships.pdf&response-content-type=application%2Fpdf&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200421T023533Z&X-Amz-SignedHeaders=host&X-Amz-Expires=21600&X-Amz-Credential=AKIAIL7WQYDOOHAZJGWQ%2F20200421%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=efd43bb93eb9e83f91d579aeff073934cf2a49969eb4e130444168ea7a18a2a2)
  - [Lec7a - JPA QL](https://s3.us-east-1.amazonaws.com/blackboard.learn.xythos.prod/5a30bcf95ea52/13350846?response-content-disposition=inline%3B%20filename%2A%3DUTF-8%27%27SWE%2520645%2520-%2520JPQL.ppt.pdf&response-content-type=application%2Fpdf&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200421T023610Z&X-Amz-SignedHeaders=host&X-Amz-Expires=21600&X-Amz-Credential=AKIAIL7WQYDOOHAZJGWQ%2F20200421%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=0bb5c8b23ee550fd8a8ffc5a182f56edbc2b9b4422f58f955de4baf8d07ca079)
  - [Build and run Angular application in a Docker container](https://medium.com/@wkrzywiec/build-and-run-angular-application-in-a-docker-container-b65dbbc50be8)
