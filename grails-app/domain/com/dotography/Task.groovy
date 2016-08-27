package com.dotography

class Task {

    String subject
    String content
    Status status = Status.Pending

    static constraints = {
        subject nullable: false
        content nullable: false
        status nullable: false
    }
}
