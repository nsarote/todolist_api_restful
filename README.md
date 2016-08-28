# todolist_api_restful
Todo List API with RESTful Service Assignment

Deployment step copy the TaskAPI-0.1.war to tomcat/webapps folder then start the tomcat

##1) This URL for CRUD page of the task.
	http://localhost:8080/TaskAPI/task

##2) RESTful API of the task
I provided API Document.docx

##2.1) listTask

http://localhost:8080/TaskAPI/api/listTask

[{"class":"com.dotography.Task","id":1,"content":"Test Content 1","status":{"enumType":"com.dotography.Status","name":"Pending"},"subject":"Test 1"},{"class":"com.dotography.Task","id":2,"content":"Test Content 2","status":{"enumType":"com.dotography.Status","name":"Pending"},"subject":"Test 2"}]

##2.2) get task

http://localhost:8080/TaskAPI/api/task/1

{"class":"com.dotography.Task","id":1,"content":"Test Content 1","status":{"enumType":"com.dotography.Status","name":"Pending"},"subject":"Test 1"}

##2.3) add

http://localhost:8080/TaskAPI/api/create?subject=Test 11&content=Test Content 11

{"message":"Task id id ${id} is saved."}


{"message":"Task could not be saved."}

##2.4) edit
	http://localhost:8080/TaskAPI/api/update/${id}?subject=Test 11&content=Test Content 11
	
	{"message":"Task id ${id} is updated."}

	http://localhost:8080/TaskAPI/api/update/11?subject=Test 11&content=Test Content 11&status=X
	
	{"message":"Task 11 status could not be updated because No enum constant com.dotography.Status.X"}

##2.5) setStatus
	http://localhost:8080/TaskAPI/api/setStatus/12/?status=Pending
	
	{"message":"Task id 12 status updated."}

	http://localhost:8080/TaskAPI/api/setStatus/12/?status=X
	
	{"message":"Task 12 status could not be updated because No enum constant com.dotography.Status.X"}

##2.6) delete
	http://localhost:8080/TaskAPI/api/delete/${id}
	
	{"message":"Task id ${id} is deleted."}

	{"message":"Task not found with id 1."}
