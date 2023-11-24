package ui.controls

import helpers.MenuItemsInitializerInterface
import ui.printers.MenuPrinterInterface
import javax.inject.Inject

class Menu @Inject constructor(menuItemsInitializer: MenuItemsInitializerInterface) : MenuInterface {
    override val menuItems: MutableList<MenuItemInterface> = mutableListOf()


    init {
        val items = menuItemsInitializer.initMenuItems()
        for (item in items) {
            menuItems.add(item)
        }
    }

    override fun pickMenuItem(id: Int) {
        if (!menuItems.any { it.id == id })
            return
        menuItems[id-1].action.execute()
    }
}