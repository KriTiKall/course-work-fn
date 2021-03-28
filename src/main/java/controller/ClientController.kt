package controller

import data.entity.Client
import logic.MainService
import view.ClientForm
import java.awt.event.ActionListener

class ClientController(view: ClientForm, service: MainService) {

    private val view = view
    private val service = service

    fun initView() {
        view.apply {
            view.bAdd.addActionListener(actionOfAdd())
        }

        view.createUI()
    }

    private fun actionOfAdd() = ActionListener {
        val client = Client()

        with(client) {
            phone = view.tfPhone.text
            mail = view.tfMail.text
            phone = view.tfPhone.text
        }

        service.clientDao.create(client)
        view.frMain.dispose()
    }
}