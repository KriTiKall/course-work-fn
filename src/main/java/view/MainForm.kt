package view

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.WindowConstants

class MainForm {

    companion object {
        const val SCREEN_HEIGHT = 1080
        const val SCREEN_WIDTH = 1920

        const val WINDOW_HEIGHT = 480
        const val WINDOW_WIDTH = 360

        const val DEFAULT_FONT_SIZE = 14
    }

    val frMain = JFrame()
//    val list = JList<>

    fun createUI() {
        frMain.apply {
            setLocation((SigInForm.SCREEN_WIDTH - SigInForm.WINDOW_WIDTH) / 2, (SigInForm.SCREEN_HEIGHT - SigInForm.WINDOW_HEIGHT) / 2)
            layout = null
            title = "food network"
            defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            isVisible = true
            isResizable = false
            setSize(SigInForm.WINDOW_WIDTH, SigInForm.WINDOW_HEIGHT)
        }

        frMain.apply {
//            add(lSignin)
        }
    }
}