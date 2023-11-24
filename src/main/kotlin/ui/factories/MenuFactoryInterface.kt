package ui.factories

import helpers.MenuItemsInitializerInterface
import ui.controls.Menu
import ui.controls.MenuItem

interface MenuFactoryInterface {
    fun createMenu(menuItemsInitializer: MenuItemsInitializerInterface) : Menu
}