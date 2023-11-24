package ui.factories

import action.ActionInterface
import ui.controls.MenuItem


interface MenuItemFactoryInterface {
    fun createMenuItem(id: Int, caption: String, action: ActionInterface) : MenuItem
}