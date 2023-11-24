package action.factories

import action.Action
import javax.inject.Inject

class ActionFactory @Inject constructor () : ActionFactoryInterface<Action>  {
    override fun createAction(action: () -> Unit): Action = Action(action)

}