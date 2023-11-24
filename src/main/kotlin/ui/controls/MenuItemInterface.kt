package ui.controls

import action.ActionInterface

interface MenuItemInterface {
    val id: Int
    val caption: String
    val action: ActionInterface
}