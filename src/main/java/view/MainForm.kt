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

        const val WINDOW_HEIGHT = 600
        const val WINDOW_WIDTH = 800

        const val DEFAULT_FONT_SIZE = 14
    }

    val mbPlatform = JMenuBar()
    val mAdd = JMenu("Add")
    val miWarehouse = JMenuItem("warehouse")
    val miClient = JMenuItem("client")
    val miProduct = JMenuItem("product")
    val miDepartment = JMenuItem("department")


    val cbClient = JComboBox<Client>()
    val cbWarehouse = JComboBox<Warehouse>()
    val cbProduct = JComboBox<Product>()
    val numberSpinner = JSpinner(SpinnerNumberModel(1, 1, 1000, 1))
    val listItems = JList<OrderItem>()
    val scroll1 = JScrollPane(listItems)
    val tpDescription = JTextPane()
    val scroll2 = JScrollPane(tpDescription)
    val lOrder = JLabel("Оформление заказа")
    val client = JLabel()
    val lWarehouse = JLabel()
    val lItem = JLabel()
    val bAddProduct = JButton("Добавить")
    val bKeep = JButton("Закрепить")
    val button = JButton("Завершить")

    fun init() {
        setSize(500, 370)
        setLocation((SCREEN_WIDTH - WINDOW_WIDTH) / 2, (SCREEN_HEIGHT - WINDOW_HEIGHT) / 2)
        layout = null
        title = "food network"
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isVisible = true
        isResizable = false

        mbPlatform.add(mAdd)
        mAdd.apply {
            add(miWarehouse)
            add(miClient)
            add(miProduct)
            add(miDepartment)
        }
        jMenuBar = mbPlatform

        lOrder.apply {
            setSize(160, 20)
            setLocation(10, 20)
            isVisible = true
        }

        client.setSize(70, 20)
        client.setText("Клиенты")
        client.setLocation(10, 50)

        cbClient.setSize(120, 20)
        cbClient.setLocation(80, 50)

        lWarehouse.setSize(50, 20)
        lWarehouse.setText("Склад")
        lWarehouse.setLocation(10, 80)

        cbWarehouse.setSize(120, 20)
        cbWarehouse.setLocation(80, 80)

        tpDescription.setSize(200, 60)
        tpDescription.setLocation(10, 120)

        scroll2.apply {
            setSize(200, 60)
            setLocation(10, 120)
            verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
            isVisible = true
        }


        lItem.setSize(120, 20)
        lItem.setText("Создание Item")
        lItem.setLocation(310, 20)

        cbProduct.setSize(120, 20)
        cbProduct.setLocation(230, 50)

        numberSpinner.setSize(120, 20)
        numberSpinner.setLocation(360, 50)

        listItems.setSize(250, 120)
        listItems.setLocation(230, 120)
        listItems.isEnabled = false

        scroll1.apply {
            setSize(250, 120)
            setLocation(230, 120)
            verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
            isVisible = true
        }

        bAddProduct.apply {
            setSize(120, 20)
            setLocation(360, 80)
        }

        bKeep.apply {
            setSize(120, 20)
            setLocation(10, 200)
        }

        button.setSize(120, 20)
        button.setLocation(10, 280)


        add(mbPlatform)
        add(lOrder)
        add(client)
        add(lWarehouse)
        add(cbClient)
        add(cbWarehouse)
        add(cbProduct)
        add(numberSpinner)
        add(lItem)
        add(scroll1)
        add(scroll2)
        add(bAddProduct)
        add(bKeep)
        add(button)
    }
}