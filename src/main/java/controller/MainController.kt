package controller

import data.entity.*
import logic.MainService
import view.DepartmentForm
import view.MainForm
import view.WarehouseForm
import java.awt.event.ActionListener
import java.util.*
import javax.swing.DefaultListModel


class MainController(view: MainForm, service: MainService) {

    private val view = view
    private val service = service
    private val model = DefaultListModel<OrderItem>()

    private val items = ArrayList<OrderItem>()
    private val orderMain = Order()

    init {
        view.init()
        initView()
    }

    fun initView() {
        view.apply {
            service.clientDao.list.forEach { view.cbClient.addItem(it) }
            service.warDao.list.forEach { view.cbWarehouse.addItem(it) }
            service.productDao.list.forEach { view.cbProduct.addItem(it) }

            bKeep.addActionListener(actionOfKeep())
            bAddProduct.addActionListener(actionOfAdd())
            button.addActionListener(actionOfTotal())

            miWarehouse.addActionListener(actionOfWarehouse())
            miDepartment.addActionListener(actionOfDepartment())
        }
    }

    private fun actionOfKeep() = ActionListener {
        with(orderMain) {
            idWarehouse = (view.cbWarehouse.selectedItem as Warehouse).id.toInt()
            idClient = (view.cbClient.selectedItem as Client).id.toInt()
            description = view.tpDescription.text
        }
        service.orderDao.getId(orderMain)
    }

    private fun actionOfTotal() = ActionListener {
        val order = Order()
        with(order) {
            idWarehouse = (view.cbWarehouse.selectedItem as Warehouse).id.toInt()
            idClient = (view.cbClient.selectedItem as Client).id.toInt()
            description = view.tpDescription.text
        }

        service.orderDao.create(order)
    }

    private fun actionOfAdd() = ActionListener {
        val product = view.cbProduct.selectedItem as Product
        val orderItem = OrderItem()
        with(orderItem) {
            idProduct = product.id.toInt()
            idOrder = orderMain.id.toInt()
            count = (view.numberSpinner.value as Integer).toInt()
            unitPrice = product.deliveryPrice * 1.20
        }
        service.itemDao.create(orderItem)
        model.addElement(orderItem)
        view.listItems.model = model
    }

    private fun actionOfWarehouse() = ActionListener {
        val form = WarehouseForm()
        val controller = WarehouseController(form, service)
        controller.initView()
    }

    private fun actionOfDepartment() = ActionListener {
        val form = DepartmentForm()
        val controller = DepartmentController(form, service)
        controller.initView()
    }
}