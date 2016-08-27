package com.dotography

import grails.converters.JSON

class ApiController {

    def listTask() {
        def list = Task.listOrderById()
        render list as JSON
    }

    def task(Task task) {
        def list = Task.listOrderById()
        render task as JSON
    }

    def create() {
        def result
        def task = new Task(params)
        if(!task.hasErrors() && task.save()) {
            result = new Result(message: "Task id ${task.id} is saved.")
        } else {
            result = new Result(message: "Task could not be saved.")
        }

        render result as JSON
    }

    def update() {
        def result
        def task = Task.get(params.id)
        println "update task=>"+task
        if(task) {
            try {
                task.properties = params
                task.status = params.status
                if(!task.hasErrors() && task.save()) {
                    result = new Result(message: "Task id ${task.id} is updated.")
                } else {
                    result = new Result(message: "Task id ${task.id} could not be saved because "+task.errors.allErrors)
                }
            } catch(e) {
                result = new Result(message: "Task ${task.id} status could not be updated because "+e.message)
            }
        } else {
            result = new Result(message: "Task not found with id ${params.id}")
        }
        render result as JSON
    }

    def setStatus(Task task) {
        def result
        if(task) {
            println "setStatus task=>"+task+" to "+params.status
            try {
                task.status = params.status

                if(!task.hasErrors() && task.save()) {
                    result = new Result(message: "Task id ${task.id} status updated.")
                } else {
                    result = new Result(message: "Task ${task.id} status could not be updated.")
                }

            } catch(e) {
                result = new Result(message: "Task ${task.id} status could not be updated because "+e.message)
            }

        } else {
            result = new Result(message: "Task not found with id ${params.id}")
        }
        render result as JSON
    }

    def delete(Task task) {
        def result
        if(!task) {
            result = new Result(message: "Task not found with id ${params.id}.")
        } else {
            task.delete()
            result = new Result(message: "Task id ${params.id} is deleted.")
        }
        render result as JSON
    }
}
