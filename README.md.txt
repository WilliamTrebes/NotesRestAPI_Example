##### How to run the application ######
open a command line prompt/terminal in notesV2. Then run these commands:
- mvnw install
-mvnw spring-boot:run

###### How to use the API #######

1. Save a new note (PUT Request)
URL= localhost:8080/notes
Header = 'Content-Type: application/json'
Body = '{"name": "", "info":"", "isArchived":true/false}'
Example Request = curl --location --request PUT 'localhost:8080/notes' \
--header 'Content-Type: application/json' \
--data-raw '{"name":"Hello World","info":"Welcome to the world","isArchived":false}'

2. Updating a previously saved note (PATCH Request)
URL= localhost:8080/notes/id (where id is the id of the note you want to update)
Header = 'Content-Type: application/json'
Body = '{"id":(id number) ,"name": "", "info":"", "isArchived":true/false}'
Example Request = curl --location --request PATCH 'localhost:8080/notes/1' \
--header 'Content-Type: application/json' \
--data-raw '{"id":1,"name":"Im Will","info":"Hello my name is William","isArchived":true/false}'

3. Delete a saved note (DELETE Request)
URL = localhost:8080/notes/id (where id is the id of the note you want to delete)
Header = None 
Body = None
Example Request = curl --location --request DELETE 'localhost:8080/notes/1'

4/5. Archive a note and Unarchive a previously archived note (PUT Request)
URL = localhost:8080/notes/archive/id (where id is the id of the note you want to archive or unarchive)
Header = 'Content-Type: application/json'
Body = '{"archiveStatus": false/true}'
Example Request = curl --location --request PUT 'localhost:8080/notes/archive/5' \
--header 'Content-Type: application/json' \
--data-raw '{"archiveStatus": false}'

6. List saved notes that are not archived (GET Request)
URL = localhost:8080/notes/unarchived
Header = None
Body = None
Example Request = curl --location --request GET 'localhost:8080/notes/unarchived'

7. List notes that are archived (GET Request)
URL = localhost:8080/notes/archived
Header = None
Body = None
Example Request = curl --location --request GET 'localhost:8080/notes/archived'

###### Reason for technology ####### 
I chose to use Java as it is a language that I am farmilar with, which would aid in the production of a rest api that I do not have much experience in. 
I chose to use Spring boot as it is designed for java with a large amount of built in functionality,

##### If I was to spend more time on this task #####
If i had more time , this would be a put request to move data into a deleted database so that a user would be able to have the option to recover any mistakenly deleted notes.
But to prevent notes from being mistakenly deleted I would also implement a confirm tool that has the user confirm that they indeed do want to delete a given note.


