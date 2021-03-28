package controller

import data.entity.*
import logic.MainService
import view.*
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

            bKeep.addActionListener(fillTemplate())
            bAddProduct.addActionListener(saveOrderItem())
            button.addActionListener(saveOrder())

            miWarehouse.addActionListener(openWarehouse())
            miDepartment.addActionListener(openDepartment())
            miClient.addActionListener(openClient())
            miProduct.addActionListener(openProduct())
        }
    }

    private fun fillTemplate() = ActionListener {
        with(orderMain) {
            idWarehouse = (view.cbWarehouse.selectedItem as Warehouse).id.toInt()
            idClient = (view.cbClient.selectedItem as Client).id.toInt()
            description = view.tpDescription.text
        }
        service.orderDao.getId(orderMain)
    }

    private fun saveOrder() = ActionListener {
        val order = Order()
        with(order) {
            idWarehouse = (view.cbWarehouse.selectedItem as Warehouse).id.toInt()
            idClient = (view.cbClient.selectedItem as Client).id.toInt()
            description = view.tpDescription.text
        }

        service.orderDao.create(order)
    }

    private fun saveOrderItem() = ActionListener {
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

    private fun openWarehouse() = ActionListener {
        val form = WarehouseForm()
        val controller = WarehouseController(form, service)
        controller.initView()
    }

    private fun openDepartment() = ActionListener {
        val form = DepartmentForm()
        val controller = DepartmentController(form, service)
        controller.initView()
    }

    private fun openClient() = ActionListener {
        val form = ClientForm()
        val controller = ClientController(form, service)
        controller.initView()
    }

    private fun openProduct() = ActionListener {
        val form = ProductFrom()
        val controller = ProductController(form, service)
        controller.initView()
    }
}