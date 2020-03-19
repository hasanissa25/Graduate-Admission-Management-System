![](https://travis-ci.com/hasanissa25/GAMS.svg?token=HEzWgsEdthBJKxtEKe9t&branch=master)
# Graduate Admissions Management System 
# SYSC4806 - Group 3
# Deployment : https://group3-gams.herokuapp.com/login
#### Hasan [@hasanissa25](https://github.com/hasanissa25)
#### Amandeep Singh[@amandeepsingh5](https://github.com/amandeepsingh5)
#### Zoha Mehdi 
#### Tahereh Ghadiri Modarres
#### Tashfiq Akhand

## Project Description
Applicants submit their file containing their personal info, their desired field of research, a list of profs they want to work with, and various documents such as their CV, a copy of their diploma, grade audit, by a certain deadline. Profs submit a profile specifying their fields of research. The applicant files can be filtered/selected by an administrator. Those that are considered good enough are routed to profs for evaluation by a deadline. Profs receive an email notification to go check the list of new applicants assigned to them. They evaluate the student by studying their application info, and enter their assessment: “don’t recommend for admission”, “recommend but not interested in supervision”, “recommend but no funding”, “recommend and yes to funding”. The admin can then view the recommendation of the profs and make a decision.

### Overall Workflow 
1. An Applicant creates an account
1. Applicant submits their file with their corresponding information
1. A Professor submits their profile specifying their fields of research
1. Administrator filters applications and chooses certain applications to route to the professor 
1. Professor receives an email notification to go check the list of new applicants assigned to them
1. Professor opens the list of applicants
1. Professor reviews the applications of each applicant, and make an evaluation decision for them.
1. Administrator views the recommendation of the professor and makes a decision.
  
### List of project Use Cases
#### List of actors:
* Applicant
* Professor
* Administrator 

#### Use Case 1: User Creates Account 
Primary Actor: Applicant , Professor , Administrator

#### Use Case 2: User Logs in
Primary Actor: Applicant or Professor or Administrator

#### Use Case 3: Applicant Submits Application
Primary Actor: Applicant

#### Use Case 4: Professor Manages Profile
Primary Actor: Professor

#### Use Case 5: Administrator Screens Applicants
Primary Actor: Administrator

#### Use Case 6: Administrator Evaluates Applicants
Primary Actor: Professor

#### Use Case 7: Administrator Makes Final Decision on Applications
Primary Actor: Administrator


## Project Milestone 1:

* Set up project; Travis CI, Heroku, and GitHub.
* Functionality: Applicant Login, Professor Login, Professor Creates a Field Of Research, Applicant can view field of research.
* the Kanban
* Unit and Integration tests
* the Issues and Code reviews 

## Database Schema for Milestone 1:

FieldOfResearch

* id
* description
* name

EndUser

* id
* confPassword
* password
* role
* username 

Student

* email
* cv
* diploma
* grade audit

![entityManagerFactory(EntityManagerFactoryBuilder)](https://user-images.githubusercontent.com/34280127/76048172-0d570900-5f33-11ea-9ebe-1bd790f0a385.png)

## Project Milestone 2:
* Applicant Functionality: 
    * Create a profile
    * Join a Professors Field Of Research.
  
* Administrator Functionality:
    * Register an account
    * Login to the system
    * Administrator can view the data (email,cv, diploma and grade audit) submitted by the student
* Unit and Integration Tests for each new functionality
* Issues and Code Reviews 


# Email Functionality
It uses the springboot mail starter. 

We are using the JavaMailSender api to send the message.

As its quite difficult to setup a real mailbox like gmail. during the research we found out that we can use the mailtrap

# Mailtrap (GMAIL and other are hard to setup)

it provides us the sandbox mail box with real smtp and host and user name.

We are providing those details to spring boot java mail to send email.
The smtp and related email configuration is in application.properties file.

Whenever we click the student. We first find out the professor and professor has an email. 

5de98f88f8-cf8cbe@inbox.mailtrap.io is the email account that is setup on mailtrap

# Flow

The data is passed from studentData.htlm page to the controller

Then we find the professor email and send to it using the spring mail api.