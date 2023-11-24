package helpers

import scanners.IntScanner
import ui.factories.MenuFactoryInterface
import ui.printers.MenuPrinterInterface
import validation.EntityValidator
import javax.inject.Inject

class MenuInitializer @Inject constructor (
    private val menuFactory: MenuFactoryInterface,
    private val menuPrinter: MenuPrinterInterface,
    private val menuItemsInitializer: MenuItemsInitializerInterface,
    private val intScanner: IntScanner,
    private val intValidator: EntityValidator<Int>
) : MenuInitializerInterface {
    override fun initMenu() {
        val menu = menuFactory.createMenu(menuItemsInitializer)
        while (true) {
            menuPrinter.printMenu()
            val input: Int? = intScanner.scanEntity()
            val validationContext = intValidator.validate(input)
            if (!validationContext.isValidated) {
                println("enter correct number")
            }
            else {
                menu.pickMenuItem(validationContext.result!!)
            }

        }
    }
}