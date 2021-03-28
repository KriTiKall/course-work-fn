package view

import javax.swing.*
import javax.swing.text.JTextComponent

class DepartmentForm : AbstractForm() {

    val components: Map<String, JComponent> = mapOf(
        "name" to JLabel("Название"),
        "phone" to JLabel("Телефон"),
        "city" to JLabel("Город"),
        "street" to JLabel("Улица"),
        "building" to JLabel("Дом"),
        "office" to JLabel("Офис"),
    )

    val textComponents: Map<String, JTextComponent> = mapOf(
        "name" to JTextField(),
        "phone" to JTextField(),
        "city" to JTextField(),
        "street" to JTextField(),
        "building" to JTextField(),
        "office" to JTextField(),
    )

    override fun createUI() {
        super.createUI()

        val com = components.values
        val textCom = textComponents.values

        for (x in 0..(com.size - 1) ) {
            locationHelper++
            toPlace(com.elementAt(x))
            toPlaceText(textCom.elementAt(x))
        }

        lManage.text += " Department"
        frMain.title = " Department"

        locationHelper += 2
        initButton()
    }
}