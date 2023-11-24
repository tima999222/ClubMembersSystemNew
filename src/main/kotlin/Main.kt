import di.DaggerAppComponent

fun main() {
    val component = DaggerAppComponent.builder().build()

    component.menuInitializer.initMenu()
}
