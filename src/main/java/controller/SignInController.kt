package controller

import view.SignInForm
import java.awt.event.ActionListener

class SignInController(view: SignInForm) {

    private val view = view

    fun initView() {
        view.apply {
            bSignin.addActionListener(actionOfSignIn())
        }

        view.createUI()
    }

    private fun actionOfSignIn() = ActionListener {
        print("fuck u, u dead to me ${view.pfPassword.text}\n")
    }

}