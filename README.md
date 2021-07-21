# quotes

This application reads JSON file and create a list of type object that we created 
which will have the author name and his text.

create Gson instance

convert JSON array to list of quotes

print out either 1 random object or all of them

I created a class for Quotes and getters to get the data

Cloning this Repo you will have to:
- include GSON library inside the build.gradle dependencies `implementation 'com.google.code.gson:gson:2.8.7'`
- import GSON library
- import reader buffer library

run this file by typing `gradle run` u will get a random quote from json file


## second lab for quotes

we read from API link a random text and author then print it out,
we convert json to string,
and we save data into our existing file then print out the saved quote if the connection failed.

I created QuotesApi Class for the Api data 
I created class for Connection that includes the read from api and save the quote to file
i created class to read from file 

in App class there is a try catch so if the api connection failed it will print from file

run this code by typing `gradle run` u will get random quote from API link

or you can try to change the link and u will get the saved quote from the file










