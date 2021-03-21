package view

import java.awt.Font
import javax.swing.*
import javax.swing.WindowConstants.EXIT_ON_CLOSE

class SigInForm {

    companion object {
        const val SCREEN_HEIGHT = 1080
        const val SCREEN_WIDTH = 1920

        const val WINDOW_HEIGHT = 480
        const val WINDOW_WIDTH = 360

        const val DEFAULT_FONT_SIZE = 14
    }

    val frMain = JFrame()
    val lSignin = JLabel("Sign in to Food Network")
    val lLogin = JLabel("Login")
    val tfLogin = JTextField()
    val lPassword = JLabel("Password")
    val pfPassword = JPasswordField()
    val bSignin = JButton("Sign In")

    fun createUI() {
        frMain.apply {
            setLocation((SCREEN_WIDTH - WINDOW_WIDTH) / 2, (SCREEN_HEIGHT - WINDOW_HEIGHT) / 2)
            layout = null
            title = "sign in"
            defaultCloseOperation = EXIT_ON_CLOSE
            isVisible = true
            isResizable = false
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT)
        }

        lSignin.apply {
            setSize(300, 100)
            setLocation((WINDOW_WIDTH - 300) / 2, 20)
            font = Font("TimesRoman", Font.PLAIN, 24)
            isVisible = true
        }

        lLogin.apply {
            setSize(100, 20)
            setLocation(60, 180)
            font = Font("TimesRoman", Font.PLAIN, DEFAULT_FONT_SIZE)
            isVisible = true
        }

        tfLogin.apply {
            setSize(120, 20)
            setLocation(150, 180)
            isVisible = true
        }

        lPassword.apply {
            setSize(100, 20)
            setLocation(60, 220)
            font = Font("TimesRoman", Font.PLAIN, DEFAULT_FONT_SIZE)
            isVisible = true
        }

        pfPassword.apply {
            setSize(120, 20)
            setLocation(150, 220)
            isVisible = true
        }

        bSignin.apply {
            setSize(100, 20)
            setLocation((WINDOW_WIDTH - 100) / 2, 340)
            font = Font("TimesRoman", Font.PLAIN, DEFAULT_FONT_SIZE)
            isVisible = true
        }

        frMain.apply {
            add(lSignin)
            add(lLogin)
            add(tfLogin)
            add(lPassword)
            add(pfPassword)
            add(bSignin)
        }
    }
}