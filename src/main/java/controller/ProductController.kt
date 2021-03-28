package controller

import data.entity.Product
import logic.MainService
import view.ProductFrom
import java.awt.event.ActionListener

class ProductController(view: ProductFrom, service: MainService) {

    private val view = view
    private val service = service


    fun initView() {
        view.apply {
            view.bAdd.addActionListener(actionOfAdd())
        }

        view.createUI()
    }

    private fun actionOfAdd() = ActionListener {
        val product = Product()
        with(product) {
            name = view.tfName.text
            deliveryPrice = view.tfPrice.text.toDouble()
            description = view.tfDescription.text
        }
        service.productDao.create(product)
        view.frMain.dispose()
    }
}