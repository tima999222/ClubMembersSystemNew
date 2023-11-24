package ui.printers

import ui.controls.MenuInterface
import javax.inject.Inject

class MenuPrinter @Inject constructor (private val menu: MenuInterface) : MenuPrinterInterface {
    override fun printMenu() {
        println("================================")
        for (menuItem in menu.menuItems) {
            println("${menuItem.id}. ${menuItem.caption}")
        }
        println("================================")
        print("press number to interact with db: ")
    }
}