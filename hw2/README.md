# WordLadder - deployed on a RESTful Web Service
## Usage
This program is used to find a route between the given start word and end word. Every step of the route changes only one letter.
> for example:
>
> http://localhost:8080/wladder?startword=cat&endword=log
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
6. then you can access the server on 'localhost:8080/wladder'
## How to use
Make sure the Spring boot is running.  
Two parameters of the method:'startword' and 'endword'.  
You can pass the parameter by
```
localhost:8080/wladder?startword=[the start word]&endword=[the end word]
```
The default value is: startword = 'cat', endword = 'dog'.  
The response is a string in format like  
> [startword] -> [word1] -> [word2] -> [word3] -> [endword]

The default output:
>cat -> cat -> cot -> dot -> dog