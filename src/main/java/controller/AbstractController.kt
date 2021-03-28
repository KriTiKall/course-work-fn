package controller

import data.dao.DAO
import view.AbstractForm
import java.awt.event.ActionListener
import javax.swing.DefaultListModel
import javax.swing.JOptionPane
import javax.swing.event.ListSelectionListener

abstract class AbstractController<Entity, Form : AbstractForm<Entity>>(
    view: Form,
    dao: DAO<Entity, Long>,
    mock: Entity
) {

    protected val view = view
    protected val dao = dao

    var mock: Entity = mock

    protected val model = DefaultListModel<Entity>()

    val options = arrayOf<Any>(
        "Изменить",
        "Удалить",
        "Закрыть"
    )

    fun initView() {
        view.apply {
            list.model = model
            loadItems()

            bAdd.addActionListener(actionOfAdd())
            bUpdate.addActionListener(actionOfUpdate())
            list.addListSelectionListener(actionOfUpdateOrDelete())
        }

        view.createUI()
    }

    private fun actionOfAdd() = ActionListener {
        val temp = mock

        fromTextToField(temp, view)

        clean()
        view.list.repaint()
        dao.create(temp)
        loadItems()
        view.bUpdate.isVisible = false
    }

    private fun actionOfUpdate() = ActionListener {
        view.bUpdate.isVisible = false
        fromTextToField(mock, view)
        clean()
        dao.update(mock)
        loadItems()
    }

    private fun actionOfUpdateOrDelete() = ListSelectionListener {
        val temp = view.getSelected()
        if (temp != null) {
            val op = showDialog()

            if (op == JOptionPane.YES_OPTION)
                update(temp)
            if (op == JOptionPane.NO_OPTION)
                delete(temp)
        }
    }

    private fun showDialog() = JOptionPane.showOptionDialog(
        view.frMain,
        "Что вы хотете сделать с выбраннм элементом?",
        "Выбор действия",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[0]
    )

    protected abstract fun update(entity: Entity)

    protected abstract fun delete(entity: Entity)

    protected abstract fun fromTextToField(entity: Entity, form: Form)

    protected abstract fun fromFieldToText(form: Form, entity: Entity)

    protected abstract fun clean()

    protected abstract fun loadItems()
}