package view

import data.entity.Department
import javax.swing.*

class DepartmentForm {

    companion object {
        const val SCREEN_HEIGHT = 1080
        const val SCREEN_WIDTH = 1920

        const val WINDOW_HEIGHT = 250
        const val WINDOW_WIDTH = 250
    }

    val frMain = JFrame()
    val lName = JLabel("Название")
    val tfName = JTextField()
    val lPhone = JLabel("Телефон")
    val tfPhone = JTextField()
    val lCity = JLabel("Город")
    val tfCity = JTextField()
    val lStreet = JLabel("Улица")
    val tfStreet = JTextField()
    val lBuilding = JLabel("Дом")
    val tfBuilding = JTextField()
    val lOffice = JLabel("Офис")
    val tfOffice = JTextField()
    val bAdd = JButton("Добавить")

    fun createUI() {
        frMain.apply {
            setLocation((SCREEN_WIDTH - WINDOW_WIDTH) / 2, (SCREEN_HEIGHT - WINDOW_HEIGHT) / 2)
            layout = null
            title = "Department"
            defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
            isVisible = true
            isResizable = false
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT)
        }

        lName.apply {
            setSize(80, 20)
            setLocation(10, 10)
            isVisible = true
        }

        tfName.apply {
            setSize(120, 20)
            setLocation(100, 10)
            isVisible = true
        }

        lPhone.apply {
            setSize(80, 20)
            setLocation(10, 40)
        }

        tfPhone.apply {
            setSize(120, 20)
            setLocation(100, 40)
        }

        lCity.apply {
            setSize(80, 20)
            setLocation(10, 70)
        }

        tfCity.apply {
            setSize(120, 20)
            setLocation(100, 70)
        }

        lStreet.apply {
            setSize(80, 20)
            setLocation(10, 100)
        }

        tfStreet.apply {
            setSize(120, 20)
            setLocation(100, 100)
        }

        lBuilding.apply {
            setSize(50, 20)
            setLocation(10, 130)
        }

        tfBuilding.apply {
            setSize(120, 20)
            setLocation(100, 130)
        }

        lOffice.apply {
            setSize(50, 20)
            setLocation(10, 160)
        }

        tfOffice.apply {
            setSize(120, 20)
            setLocation(100, 160)
        }

        bAdd.apply {
            setSize(120, 20)
            setLocation(10, 160)
        }

        frMain.apply {
            add(lName)
            add(tfName)
            add(lPhone)
            add(tfPhone)
            add(lCity)
            add(tfCity)
            add(lStreet)
            add(tfStreet)
            add(lBuilding)
            add(tfBuilding)
            add(lOffice)
            add(tfOffice)
            add(bAdd)
        }
    }
}