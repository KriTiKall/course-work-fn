package view

import data.entity.Department
import javax.swing.*
import javax.swing.text.JTextComponent

abstract class AbstractForm {

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
    var locationDiv = 0

    val lManage = JLabel("Управление сущностью")
    val frMain = JFrame()

    val list = JList<Department>()
    val scList = JScrollPane(list)

    val bAdd = JButton("Добавить")
    val bUpdate = JButton("Обновить")

    open fun createUI() {
        frMain.apply {
            setLocation(
                (SCREEN_WIDTH - WINDOW_WIDTH) / 2,
                (SCREEN_HEIGHT - WINDOW_HEIGHT) / 2
            )
            layout = null
            title = "null"
            defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
            isVisible = true
            isResizable = false
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT)
        }

        lManage.apply {
            setSize(FIRST_W + 200, FIRST_H)
            setLocation(
                (WINDOW_WIDTH - FIRST_W - 200) / 2,
                FIRST_Y + (STEP * locationHelper) - 10
            )
        }

        locationHelper++

        list.apply {
            setSize(SECOND_W + 120, SECOND_H + 150)
            setLocation(SECOND_X + SECOND_W + 20, SECOND_Y + (STEP * locationHelper))
        }

        scList.apply {
            setSize(SECOND_W + 120, SECOND_H + 150)
            setLocation(SECOND_X + SECOND_W + 20, SECOND_Y + (STEP * locationHelper))
            verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
        }

        locationHelper--

        frMain.apply {
            add(lManage)
            add(scList)
            add(bAdd)
            add(bUpdate)
        }
    }

    protected fun initButton() {
        bAdd.apply {
            setSize(FIRST_W + 50, FIRST_H)
            setLocation(FIRST_X, FIRST_Y + (STEP * locationHelper))
        }

        bUpdate.apply {
            setSize(FIRST_W + 50, FIRST_H)
            setLocation(FIRST_X + FIRST_W + 60, FIRST_Y + (STEP * locationHelper))
            isVisible = false
        }
    }

    protected fun toPlace(component: JComponent) {
        component.apply {
            setSize(FIRST_W, FIRST_H)
            setLocation(FIRST_X, FIRST_Y + (STEP * locationHelper))
        }
        frMain.add(component)
    }

    protected fun toPlaceText(component: JTextComponent) {
        component.apply {
            setSize(SECOND_W, SECOND_H)
            setLocation(SECOND_X, SECOND_Y + (STEP * locationHelper))
        }
        frMain.add(component)
    }
}