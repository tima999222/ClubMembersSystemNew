package action.factories

import action.ActionInterface

interface ActionFactoryInterface<T> where T: ActionInterface {
    fun createAction(action: () -> Unit) : T
}