package controller

import data.entity.Department
import logic.MainService
import view.DepartmentForm
import java.awt.event.ActionListener
import javax.swing.DefaultListModel
import javax.swing.JOptionPane
import javax.swing.event.ListSelectionListener


class DepartmentController(view: DepartmentForm, service: MainService) {

    private val view = view
    private val service = service

    var mock = Department()

    private val model = DefaultListModel<Department>()

    val options = arrayOf<Any>(
        "Изменить",
        "Удалить",
        "Закрыть"
    )


    fun initView() {
        view.apply {
            list.model = model
            loadItems()

            bAdd.addActionListener(actionOfAdd())
            bUpdate.addActionListener(actionOfUpdate())
            list.addListSelectionListener(actionOfUpdateOrDelete())
        }

        view.createUI()
    }

    private fun actionOfAdd() = ActionListener {
        val dep = Department()

        fromTextToField(dep, view)

        clean()
        view.list.repaint()
        service.depDao.create(dep)
        loadItems()
        view.bUpdate.isVisible = false
    }

    private fun actionOfUpdate() = ActionListener {

        view.bUpdate.isVisible = false

        fromTextToField(mock, view)

        clean()


        service.depDao.update(mock)
        loadItems()
    }

    private fun actionOfUpdateOrDelete() = ListSelectionListener {
        val temp = view.list.selectedValue as Department?
        if (temp != null) {
            val op = JOptionPane.showOptionDialog(
                view.frMain,
                "Что вы хотете сделать с выбраннм элементом?",
                "Выбор действия",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            )

            if (op == JOptionPane.YES_OPTION) {
                mock.id = temp.id
                view.bUpdate.isVisible = true
                fromFieldToText(view, temp)
            }
            if (op == JOptionPane.NO_OPTION) {
                //todo(cann't delete dep because ware has constraint)
                view.bUpdate.isVisible = false
                service.depDao.delete(temp)
                loadItems()
            }
        }
    }

    private fun update(temp: Department) {

    }

    private fun delete() {
        view.apply {
            val dep = list.selectedValue as Department
            service.depDao.delete(dep)
        }

        loadItems()
    }

    private fun fromTextToField(entity: Department, form: DepartmentForm) =
        entity.apply {
            form.apply {
                name = textComponents["tfName"]?.text
                phone = textComponents["tfPhone"]?.text
                city = textComponents["tfCity"]?.text
                street = textComponents["tfStreet"]?.text
                buildingNum = textComponents["tfBuilding"]?.text!!.toInt()
                officeNum = textComponents["tfOffice.text.toInt()"]?.text!!.toInt()
            }
        }

    private fun fromFieldToText(form: DepartmentForm, entity: Department) =
        entity.apply {
            form.apply {
                textComponents["tfName"]?.text = name
                textComponents["tfPhone"]?.text = phone
                textComponents["tfCity"]?.text = city
                textComponents["tfStreet"]?.text = street
                textComponents["tfBuilding"]?.text = buildingNum.toString()
                textComponents["tfOffice.text.toInt()"]?.text = officeNum.toString()
            }
        }

    private fun clean() {
        view.apply {
            textComponents["tfName"]?.text = ""
            textComponents["tfPhone"]?.text = ""
            textComponents["tfCity"]?.text = ""
            textComponents["tfStreet"]?.text = ""
            textComponents["tfBuilding"]?.text = ""
            textComponents["tfOffice.text.toInt()"]?.text = ""
        }
    }

    private fun loadItems() {
        model.clear()
        service.depDao.list.forEach { model.addElement(it) }
    }
}