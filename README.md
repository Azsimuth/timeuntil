# timeuntil
Small quick and dirty util written in java to tell the time remaining until a future time on the same day.  
```timeuntil hh:mm -> Time remaining until hh:mm: H Hour(s) and M Minute(s)```  
You can acquire the program either by cloning the source code, and compiling yourself, or alternatively by downloading one of the releases.  
## Compliation
cd into the downloaded timeuntil/, if you haven't already 
`javac *.java`
### Usage after Compilation
`java TimeUntil hh:mm`
### Quick hack to 'normalize' the program
If you want to use the program, by just typing out its name in the terminal, like so
```
timeuntil hh:mm
```
then you can add the following bashscript to a directory in your path:
```
cd <path-to-timeuntil>/timeuntil/
java TimeUntil ${1}
```
named as `timeuntil`. If you `+chmod x timeuntil`, you should then be able to call upon it
with `timeuntil hh:mm`
(PS, I have not yet learned how to ship compiled packages, for that I apologise)
## Usage (After downloading a release)
```
java -jar timeuntil.jar hh:mm
```
