package view

import javax.swing.*

class ProductFrom {

    companion object {
        const val SCREEN_HEIGHT = 1080
        const val SCREEN_WIDTH = 1920

        const val WINDOW_HEIGHT = 250
        const val WINDOW_WIDTH = 250
    }

    val frMain = JFrame()
    val lName = JLabel("Название")
    val tfName = JTextField()
    val lDescription = JLabel("Описание")
    val tfDescription = JTextField()
    val lPrice = JLabel("Цена")
    val tfPrice = JTextField()
    val bAdd = JButton("Добавить")

    fun createUI() {
        frMain.apply {
            setLocation((SCREEN_WIDTH - WINDOW_WIDTH) / 2, (SCREEN_HEIGHT - WINDOW_HEIGHT) / 2)
            layout = null
            title = "Product"
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

        lDescription.apply {
            setSize(80, 20)
            setLocation(10, 40)
        }

        tfDescription.apply {
            setSize(120, 20)
            setLocation(100, 40)
        }

        lPrice.apply {
            setSize(80, 20)
            setLocation(10, 70)
        }

        tfPrice.apply {
            setSize(120, 20)
            setLocation(100, 70)
        }

        bAdd.apply {
            setSize(120, 20)
            setLocation(10, 180)
        }

        frMain.apply {
            add(lName)
            add(tfName)
            add(lDescription)
            add(tfDescription)
            add(lPrice)
            add(tfPrice)
            add(bAdd)
        }
    }
}