package wiiboard;

import gui.GuiInterface;
import logic.LogicInterface;

import java.util.List;

public interface WiiboardInterface {

    void registerGui(GuiInterface gui);

    void registerLogic(LogicInterface logic);

    void startWiiboardDiscoverer();

    void startRecordingData(int seconds);





}