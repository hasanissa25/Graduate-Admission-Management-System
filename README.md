![](https://travis-ci.com/hasanissa25/GAMS.svg?token=HEzWgsEdthBJKxtEKe9t&branch=master)
# GAMS
# SYSC4806 - Group 3

Graduate Admissions Management System
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
* numberStudents
* professor
* status
*students

EndUser

* id
* confPassword
* password
* role
* username 