package patterns.factory.gui

import org.junit.jupiter.api.Test
import patterns.factory.gui.interfaces.GUIButton
import patterns.factory.gui.interfaces.GUICheckbox
import patterns.factory.gui.interfaces.GUIFactory

class GUIFactoryTest {
    @Test fun win() = defaultGUITest(WinGUIFactory())
    @Test fun mac() = defaultGUITest(MacGUIFactory())

    fun defaultGUITest(f : GUIFactory) {
        val btn1 : GUIButton = f.createButton()
        println(btn1.label)
        println(btn1.uiElementId)
        println(f.statistics.buttonCreated)

        val btn2 : GUIButton = f.createButton()
        btn2.setOnClick { println("Button(${it.uiElementId}) : exe onClick") }
        btn2.click()
        println(btn2.label)
        println(btn2.uiElementId)
        println(f.statistics.buttonCreated)

        val checkbox1 : GUICheckbox  = f.createCheckbox()
        println(checkbox1.label)
        println(checkbox1.isChecked)
        println(f.statistics.checkboxCreated)

        val checkbox2 : GUICheckbox  = f.createCheckbox()
        checkbox2.isChecked = true
        println(checkbox2.label)
        println(checkbox2.isChecked)
        println(f.statistics.checkboxCreated)
    }
}