package controller

import data.entity.Department
import logic.MainService
import view.DepartmentForm
import java.awt.event.ActionListener

class DepartmentController(view: DepartmentForm, service: MainService) {

    private val view = view
    private val service = service


    fun initView() {
        view.apply {
            view.bAdd.addActionListener(actionOfAdd())
        }

        view.createUI()
    }

    private fun actionOfAdd() = ActionListener {
        val dep = Department()
        with(dep) {
            phone = view.tfPhone.text
            city = view.tfCity.text
            street = view.tfStreet.text
            buildingNum = view.tfBuilding.text.toInt()
            officeNum = view.tfOffice.text.toInt()
        }
        service.depDao.create(dep)
    }
}