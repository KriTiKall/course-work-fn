package controller

import data.entity.Department
import data.entity.Warehouse
import logic.MainService
import view.WarehouseForm
import java.awt.event.ActionListener

class WarehouseController(view: WarehouseForm, service: MainService) {

    private val view = view
    private val service = service

    fun initView() {
        view.apply {
            service.depDao.list.forEach{view.cbDepartment.addItem(it)}

            view.bAdd.addActionListener(actionOfAdd())
        }

        view.createUI()
    }

    private fun actionOfAdd() = ActionListener {
        val ware = Warehouse()
        with(ware) {
            idDepartment = (view.cbDepartment.selectedItem as Department).id.toInt()
            phone = view.tfPhone.text
            city = view.tfCity.text
            street = view.tfStreet.text
            buildingNum = view.tfBuilding.text.toInt()
        }
        service.warDao.create(ware)
        view.frMain.dispose()
    }
}