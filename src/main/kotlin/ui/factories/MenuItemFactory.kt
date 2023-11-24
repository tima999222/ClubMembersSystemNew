package ui.factories

import action.ActionInterface
import ui.controls.MenuItem
import javax.inject.Inject

class MenuItemFactory @Inject constructor (): MenuItemFactoryInterface {
    override fun createMenuItem(id: Int, caption: String, action: ActionInterface): MenuItem {
        return MenuItem(id, caption, action)
    }
}