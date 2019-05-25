import org.junit.Test;

import static org.junit.Assert.*;

public class SetModesTest {

    @Test
    public void enterSettingModes() {
    }

    @Test
    public void getEnterSettingModesTrue() {
    }

    @Test
    public void exitSettingModes() {
        SetModes sm = new SetModes();
    }

    @Test
    public void getNewModes() {
    }

    @Test
    public void getCurrentMode() {
    }

    @Test
    public void selectNextSelectableMode() {
        SetModes sm = new SetModes();
        assertEquals(sm.getCurrentMode(),0);
        sm.selectNextSelectableMode(sm.getCurrentMode());
        assertEquals(sm.getCurrentMode(),1);
        sm.selectNextSelectableMode(sm.getCurrentMode());
        assertEquals(sm.getCurrentMode(),2);
        sm.selectNextSelectableMode(sm.getCurrentMode());
        assertEquals(sm.getCurrentMode(),3);
        sm.selectNextSelectableMode(sm.getCurrentMode());
        assertEquals(sm.getCurrentMode(),0);
    }

    @Test
    public void changeToNextSelectableMode() {
        SetModes sm = new SetModes();
        sm.saveMode();
        sm.changeToNextSelectableMode();
        sm.saveMode();
        sm.changeToNextSelectableMode();
        sm.saveMode();
        sm.changeToNextSelectableMode();

        assertArrayEquals(sm.getNewModes(), new boolean[]{true, true, true, true, false, false});
    }

    @Test
    public void saveMode() {
    }

    @Test
    public void resetNewModes() {
        SetModes sm = new SetModes();
        sm.resetNewModes();
        assertArrayEquals(sm.getNewModes(), new boolean[]{true, false, false, false, false, false});
    }
}