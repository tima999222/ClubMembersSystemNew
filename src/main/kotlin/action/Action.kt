package action

class Action(private val action: () -> Unit) : ActionInterface {
    override fun execute() {
        action()
    }

}