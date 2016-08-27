import com.dotography.Task

class BootStrap {

    def init = { servletContext ->
        10.times { index ->
            def task = new Task(subject: "Test ${index+1}",content: "Test Content ${index+1}")
            task.save(flush: true)
        }
    }
    def destroy = {
    }
}
