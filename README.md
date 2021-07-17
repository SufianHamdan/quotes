# quotes

This application reads JSON file and create a list of type object that we created 
which will have the author name and his text.

create Gson instance

convert JSON array to list of quotes

print out either 1 random object or all of them

Cloning this Repo you will have to:
- include GSON library inside the build.gradle dependencies `implementation 'com.google.code.gson:gson:2.8.7'`
- import GSON library
- import reader buffer library

links:
- [App](./app/src/main/java/quotes/App.java)
- [Quotes object class](./app/src/main/java/quotes/Quotes.java)
- [JSON File](./app/src/main/java/quotes/gson/recentquotes.json)

## second lab for quotes

we read from API link a random text and author then print it out 

if the connection failed: 

we convert json to string, 
and we save data into our existing file then print out the saved quote







