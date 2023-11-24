package ui.factories

import helpers.MenuItemsInitializerInterface
import ui.controls.Menu
import ui.controls.MenuItem
import javax.inject.Inject

class MenuFactory @Inject constructor () : MenuFactoryInterface {
    override fun createMenu(menuItemsInitializer: MenuItemsInitializerInterface): Menu {
        return Menu(menuItemsInitializer)
    }
}