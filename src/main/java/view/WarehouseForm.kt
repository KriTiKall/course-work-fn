package view

import data.entity.Department
import javax.swing.*
import javax.swing.WindowConstants.DISPOSE_ON_CLOSE

class WarehouseForm {

    companion object {
        const val SCREEN_HEIGHT = 1080
        const val SCREEN_WIDTH = 1920

        const val WINDOW_HEIGHT = 250
        const val WINDOW_WIDTH = 250
    }

    val frMain = JFrame()
    val lDepartment = JLabel("отдел")
    val cbDepartment = JComboBox<Department>()
    val lPhone = JLabel("Телефон")
    val tfPhone = JTextField()
    val lCity = JLabel("Город")
    val tfCity = JTextField()
    val lStreet = JLabel("Улица")
    val tfStreet = JTextField()
    val lBuilding = JLabel("Дом")
    val tfBuilding = JTextField()
    val bAdd = JButton("Добавить")

    fun createUI() {
        frMain.apply {
            setLocation((SCREEN_WIDTH - WINDOW_WIDTH) / 2, (SCREEN_HEIGHT - WINDOW_HEIGHT) / 2)
            layout = null
            title = "Warehouse"
            defaultCloseOperation = DISPOSE_ON_CLOSE
            isVisible = true
            isResizable = false
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT)
        }

        lDepartment.apply {
            setSize(80, 20)
            setLocation(10, 10)
            isVisible = true
        }

        cbDepartment.apply {
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

        bAdd.apply {
            setSize(120, 20)
            setLocation(10, 160)
        }

        frMain.apply {
            add(lDepartment)
            add(cbDepartment)
            add(lPhone)
            add(tfPhone)
            add(lCity)
            add(tfCity)
            add(lStreet)
            add(tfStreet)
            add(lBuilding)
            add(tfBuilding)
            add(bAdd)
        }
    }
}