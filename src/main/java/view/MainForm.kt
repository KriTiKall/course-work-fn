package view

import data.entity.Client
import data.entity.OrderItem
import data.entity.Product
import data.entity.Warehouse
import javax.swing.*


class MainForm : JFrame() {

    companion object {
        const val SCREEN_HEIGHT = 1080
        const val SCREEN_WIDTH = 1920

        const val WINDOW_HEIGHT = 450
        const val WINDOW_WIDTH = 600

        const val DEFAULT_FONT_SIZE = 14
    }

    val mbPlatform = JMenuBar()
    val mAdd = JMenu("Управление")
    val mTut = JMenu("Справка")
    val miWarehouse = JMenuItem("warehouse")
    val miClient = JMenuItem("client")
    val miProduct = JMenuItem("product")
    val miDepartment = JMenuItem("department")


    val cbClient = JComboBox<Client>()
    val cbWarehouse = JComboBox<Warehouse>()
    val cbProduct = JComboBox<Product>()
    val numberSpinner = JSpinner(SpinnerNumberModel(1, 1, 1000, 1))
    val listItems = JList<OrderItem>()
    val scList = JScrollPane(listItems)
    val tpDescription = JTextPane()
    val scDesc = JScrollPane(tpDescription)
    val lOrder = JLabel("Оформление заказа")
    val lClient = JLabel()
    val lWarehouse = JLabel()
    val lItem = JLabel()
    val bAddProduct = JButton("Добавить")
    val bKeep = JButton("Закрепить")
    val button = JButton("Завершить")

    fun init() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT)
        setLocation((SCREEN_WIDTH - WINDOW_WIDTH) / 2, (SCREEN_HEIGHT - WINDOW_HEIGHT) / 2)
        layout = null
        title = "food network"
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isVisible = true
        isResizable = false

        mbPlatform.add(mAdd)
        mbPlatform.add(mTut)

        mAdd.apply {
            add(miWarehouse)
            add(miClient)
            add(miProduct)
            add(miDepartment)
        }
        jMenuBar = mbPlatform

        lOrder.apply {
            setSize(160, 20)
            setLocation(30, 50)
            isVisible = true
        }

        lClient.apply {
            setSize(70, 20)
            setText("Клиенты")
            setLocation(30, 80)
        }

        cbClient.apply {
            setSize(160, 20)
            setLocation(100, 80)
        }

        lWarehouse.apply {
            setSize(50, 20)
            setText("Склад")
            setLocation(30, 120)
        }

        cbWarehouse.apply {
            setSize(160, 20)
            setLocation(100, 120)
        }

        tpDescription.apply {
            setSize(230, 100)
            setLocation(30, 160)
        }

        scDesc.apply {
            setSize(230, 100)
            setLocation(30, 160)
            verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
            isVisible = true
        }

        bKeep.apply {
            setSize(120, 20)
            setLocation(30, 280)
        }

        lItem.apply {
            setSize(120, 20)
            setText("Создание Item")
            setLocation(320, 50)
        }

        cbProduct.apply {
            setSize(120, 20)
            setLocation(320, 80)
        }

        numberSpinner.apply {
            setSize(120, 20)
            setLocation(450, 80)
        }

        bAddProduct.apply {
            setSize(120, 20)
            setLocation(450, 120)
        }

        listItems.apply {
            setSize(250, 120)
            setLocation(320, 160)
            isEnabled = false
        }

        scList.apply {
            setSize(250, 120)
            setLocation(320, 160)
            verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
            isVisible = true
        }

        button.apply {
            setSize(120, 20)
            setLocation(450, 350)
        }

        add(mbPlatform)
        add(lOrder)
        add(lClient)
        add(lWarehouse)
        add(cbClient)
        add(cbWarehouse)
        add(cbProduct)
        add(numberSpinner)
        add(lItem)
        add(scList)
        add(scDesc)
        add(bAddProduct)
        add(bKeep)
        add(button)
    }
}