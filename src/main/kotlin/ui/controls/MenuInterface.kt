package ui.controls

interface MenuInterface {
    val menuItems: MutableList<MenuItemInterface>
    fun pickMenuItem(id: Int)
}