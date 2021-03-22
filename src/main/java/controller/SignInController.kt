package controller

import view.SignInForm
import java.awt.event.ActionListener

class SignInController(view: SignInForm) {

    private val view = view

    private fun initView() {
        view.apply {
            bSignin.addActionListener(actionOfSignIn())
        }
    }

    private fun actionOfSignIn() = ActionListener {

    }

}