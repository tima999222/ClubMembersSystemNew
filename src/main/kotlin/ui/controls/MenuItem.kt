package ui.controls

import action.ActionInterface
import javax.inject.Inject

class MenuItem @Inject constructor(override val id: Int, override val caption: String, override val action: ActionInterface) : MenuItemInterface