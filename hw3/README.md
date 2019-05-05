# WordLadder - packaged by docker

## This guide works on linux

## Get&Run the image
docker url:  
> https://hub.docker.com/r/baldlee/wordladder-hw3
> https://hub.docker.com/r/baldlee/login-hw3

### pull the image
```
docker pull baldlee/wordladder-hw3
docker pull baldlee/login-hw3
```
### run the image
```
docker run baldlee/login-hw3
docker run -p 6655:8082 baldlee/wordladder-hw3
```
now you can access the service by
>http://172.17.0.3:6655/wordladder
## Usage
This program is used to find a route between the given start word and end word. Every step of the route changes only one letter.
> for example:
>
> http://172.17.0.3:6655/wordladder/build?startword=cat&endword=log&username=user&password=user
>
> cat->cot->lot->log
## How to run
This project is based on Spring boot and Maven, developed with Intellij Idea.  
It's recommended to run the project on Intellij Idea.  
1. Import the project as a maven project in Intellij Idea.
2. Import all maven projects.
3. Run/Debug Configurations -> Add new comfiguration -> Spring boot
4. the main class choose "wordladder.Application"
5. Run 'wordladder'(Shift+F10)
6. then you can access the server on '172.17.0.3:6655/wordladder'
## How to use
Make sure the Spring boot is running.  
Two parameters of the method:'startword' and 'endword'.  
You can pass the parameter by
```
172.17.0.3:6655/wordladder/build?startword=[the start word]&endword=[the end word]
```
The default value is: startword = 'cat', endword = 'dog'.  
The response is a string in format like  
> [startword] -> [word1] -> [word2] -> [word3] -> [endword]

The default output:
>cat -> cat -> cot -> dot -> dog
## Authorization
You cannot access "/wordladder/build" unless you've login
Anyone can access "/wordladder/".
 
You can login with paramters.

> USER:  
> username: user   
> password: user 

if you access "/build" with wrong authorization, you'll get "login fail"