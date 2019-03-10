# WordLadder
## Usage
This program is used to find a route between the given start word and end word. Every step of the route changes only one letter.
> for example:
>
> input: cat log
>
> output:cat->cot->lot->log

## How to use
The program is packaged in "./target/hw1-1.0-SNAPSHOT.jar".

The program need an dictionary text file named "EnglishWord.txt" in the same path. You can use the .txt file provided in ./target or use your own dictionary.

execute the progeam:
```
java -cp hw1-1.0-SNAPSHOT.jar wordladder
```

The program need some seconds to read the dictionary and build an index. When these are finished, it will be printed on console:
```
Reading dictionary...
Done
Building the index...
Done
Input the start word and the end word:(Input "q" to quit)
```
Now you can input your words in the format of "word1 word2":(use space to seperate them)
```
Input the start word and the end word:(Input "q" to quit)cat log
```
Enter, then the result will be printed: 
```
Input the start word and the end word:(Input "q" to quit)cat log
cat->cot->lot->log
Input the start word and the end word:(Input "q" to quit)
```
You can continue to input another double of words. 

When there is no route between the two words, it output "Not found!":
```
Input the start word and the end word:(Input "q" to quit)rabbit tank
Not found!
Input the start word and the end word:(Input "q" to quit)
```

When you want to stop, input "p" to quit.
```
Input the start word and the end word:(Input "q" to quit)q

```

## Precations
- This program runs to find the shortest route. When there are several routes, it will print only one of them.
- This program need to read the dictionary every time it's restarted, which may cost some time.
