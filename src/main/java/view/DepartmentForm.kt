package view

import data.entity.Department
import javax.swing.*

class DepartmentForm {

    companion object {
        const val SCREEN_HEIGHT = 1080
        const val SCREEN_WIDTH = 1920

        const val WINDOW_HEIGHT = 360
        const val WINDOW_WIDTH = 500

        const val FIRST_W = 80
        const val FIRST_H = 20
        const val FIRST_X = 10
        const val FIRST_Y = 20

        const val SECOND_W = 120
        const val SECOND_H = 20
        const val SECOND_X = 100
        const val SECOND_Y = 20

        const val STEP = 30
    }

    var locationHelper = 0

    val lManage = JLabel("Управление сущностью Department")
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

    val list = JList<Department>()
    val scList = JScrollPane(list)

    val bAdd = JButton("Добавить")
    val bUpdate = JButton("Обновить")

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

        lManage.apply {
            setSize(FIRST_W + 200, FIRST_H)
            setLocation((WINDOW_WIDTH - FIRST_W - 200) / 2, FIRST_Y + (STEP * locationHelper) - 10)
        }

        locationHelper++

        lName.apply {
            setSize(FIRST_W, FIRST_H)
            setLocation(FIRST_X, FIRST_Y + (STEP * locationHelper))
            isVisible = true
        }

        tfName.apply {
            setSize(SECOND_W, SECOND_H)
            setLocation(SECOND_X, SECOND_Y + (STEP * locationHelper))
            isVisible = true
        }

        list.apply {
            setSize(SECOND_W + 120, SECOND_H + 150)
            setLocation(SECOND_X + SECOND_W + 20, SECOND_Y + (STEP * locationHelper))
        }

        scList.apply {
            setSize(SECOND_W + 120, SECOND_H + 150)
            setLocation(SECOND_X + SECOND_W + 20, SECOND_Y + (STEP * locationHelper))
            verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
        }

        locationHelper++

        lPhone.apply {
            setSize(FIRST_W, FIRST_H)
            setLocation(FIRST_X, FIRST_Y + (STEP * locationHelper))
        }

        tfPhone.apply {
            setSize(SECOND_W, SECOND_H)
            setLocation(SECOND_X, SECOND_Y + (STEP * locationHelper))
        }

        locationHelper++

        lCity.apply {
            setSize(FIRST_W, FIRST_H)
            setLocation(FIRST_X, FIRST_Y + (STEP * locationHelper))
        }

        tfCity.apply {
            setSize(SECOND_W, SECOND_H)
            setLocation(SECOND_X, SECOND_Y + (STEP * locationHelper))
        }

        locationHelper++

        lStreet.apply {
            setSize(FIRST_W, FIRST_H)
            setLocation(FIRST_X, FIRST_Y + (STEP * locationHelper))
        }

        tfStreet.apply {
            setSize(SECOND_W, SECOND_H)
            setLocation(SECOND_X, SECOND_Y + (STEP * locationHelper))
        }

        locationHelper++

        lBuilding.apply {
            setSize(FIRST_W, FIRST_H)
            setLocation(FIRST_X, FIRST_Y + (STEP * locationHelper))
        }

        tfBuilding.apply {
            setSize(SECOND_W, SECOND_H)
            setLocation(SECOND_X, SECOND_Y + (STEP * locationHelper))
        }

        locationHelper++

        lOffice.apply {
            setSize(FIRST_W, FIRST_H)
            setLocation(FIRST_X, FIRST_Y + (STEP * locationHelper))
        }

        tfOffice.apply {
            setSize(SECOND_W, SECOND_H)
            setLocation(SECOND_X, SECOND_Y + (STEP * locationHelper))
        }

        locationHelper += 2

        bAdd.apply {
            setSize(FIRST_W + 50, FIRST_H)
            setLocation(FIRST_X, FIRST_Y + (STEP * locationHelper))
        }

        bUpdate.apply {
            setSize(FIRST_W + 50, FIRST_H)
            setLocation(FIRST_X + FIRST_W + 60, FIRST_Y + (STEP * locationHelper))
            isVisible = false
        }

        frMain.apply {
            add(lManage)
            add(lName)
            add(tfName)
            add(scList)
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
            add(bUpdate)
        }
    }
}