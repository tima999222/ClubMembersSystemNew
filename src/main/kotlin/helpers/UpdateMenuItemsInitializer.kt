package helpers

import action.Action
import action.factories.ActionFactoryInterface
import data.entities.ClubMember
import data.factories.ClubMemberFactoryInterface
import data.repositories.ClubMemberRepositoryInterface
import scanners.ScannerInterface
import ui.controls.MenuItem
import ui.factories.MenuItemFactoryInterface
import validation.EntityValidator

class UpdateMenuItemsInitializer(
    id: Int,
    private val menuItemFactory: MenuItemFactoryInterface,
    private val actionFactory: ActionFactoryInterface<Action>,
    private val clubMemberRepository: ClubMemberRepositoryInterface,
    private val strScanner: ScannerInterface<String>,
    private val strValidator: EntityValidator<String>,
    private val clubMemberFactory: ClubMemberFactoryInterface) : MenuItemsInitializerInterface
{

    private var clubMember: ClubMember? = null

    init {
        clubMember = clubMemberRepository.getClubMemberById(id)
    }

    override fun initMenuItems(): List<MenuItem> {
        val surnameButton = menuItemFactory.createMenuItem(1, "surname",
            actionFactory.createAction {
                print("Enter new surname: ")
                val surname = strScanner.scanEntity()
                val validContext = strValidator.validate(surname)
                if (!validContext.isValidated) {
                    println("enter correct surname")
                }
                else {
                    val updatedClubMember = clubMemberFactory.createClubMember(
                        clubMember!!.id,
                        validContext.result,
                        clubMember!!.name,
                        clubMember!!.patronymic,
                        clubMember!!.bicycleType,
                        clubMember!!.experience
                    )

                    clubMemberRepository.updateClubMember(updatedClubMember!!.id!!, updatedClubMember)
                }

            }
        )

        return listOf(surnameButton)
    }
}