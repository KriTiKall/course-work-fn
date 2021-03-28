package controller

import data.entity.Department
import logic.MainService
import view.DepartmentForm


class DepartmentController(view: DepartmentForm, service: MainService) :
    AbstractController<Department, DepartmentForm>(view = view, dao = service.depDao, mock = Department()) {

    private val service = service

    override fun update(entity: Department) {
        mock.id = entity.id
        view.bUpdate.isVisible = true
        fromFieldToText(view, entity)
    }

    override fun delete(entity: Department) {
        view.bUpdate.isVisible = false
        service.depDao.delete(entity)
        loadItems()
    }

    override fun fromTextToField(entity: Department, form: DepartmentForm) {
        entity.apply {
            form.apply {
                name = textComponents["name"]?.text
                phone = textComponents["pone"]?.text
                city = textComponents["city"]?.text
                street = textComponents["street"]?.text
                buildingNum = textComponents["building"]?.text!!.toInt()
                officeNum = textComponents["office"]?.text!!.toInt()
            }
        }
    }

    override fun fromFieldToText(form: DepartmentForm, entity: Department) {
        entity.apply {
            form.apply {
                textComponents["name"]?.text = name
                textComponents["phone"]?.text = phone
                textComponents["city"]?.text = city
                textComponents["street"]?.text = street
                textComponents["building"]?.text = buildingNum.toString()
                textComponents["office"]?.text = officeNum.toString()
            }
        }
    }

    override fun clean() {
        view.apply {
            textComponents["name"]?.text = ""
            textComponents["phone"]?.text = ""
            textComponents["city"]?.text = ""
            textComponents["street"]?.text = ""
            textComponents["building"]?.text = ""
            textComponents["office"]?.text = ""
        }
    }

    override fun loadItems() {
        model.clear()
        dao.list.forEach { model.addElement(it) }
    }
}