package test;

import wiiboard.wiiboard.WiiBoard;
import wiiboard.wiiboard.WiiBoardDiscoverer;
import wiiboard.wiiboard.WiiBoardDiscoveryListener;
import wiiboard.wiiboard.event.WiiBoardButtonEvent;
import wiiboard.wiiboard.event.WiiBoardListener;
import wiiboard.wiiboard.event.WiiBoardMassEvent;
import wiiboard.wiiboard.event.WiiBoardStatusEvent;


public class WiiboardTest {

    public static void main(String[] args)  {
        System.setProperty("bluecove.jsr82.psm_minimum_off", "true");

        WiiBoardListener wiiBoardListener = new WiiBoardListener() {

            @Override
            public void wiiBoardButtonEvent(WiiBoardButtonEvent buttonEvent) {

            }

            @Override
            public void wiiBoardMassReceived(WiiBoardMassEvent massEvent) {
                Double xVal = (massEvent.getTopRight()+massEvent.getBottomRight())-(massEvent.getBottomLeft()+massEvent.getTopLeft());
                Double yVal = (massEvent.getTopLeft()+massEvent.getTopRight())-(massEvent.getBottomLeft()+massEvent.getBottomRight());

                System.out.println("X:"+xVal+" Y:"+yVal);
            }

            @Override
            public void wiiBoardStatusReceived(WiiBoardStatusEvent status) {

            }

            @Override
            public void wiiBoardDisconnected() {

            }

        };

        WiiBoardDiscoveryListener wiiBoardDiscoveryListener = new WiiBoardDiscoveryListener() {
            @Override
            public void wiiBoardDiscovered(WiiBoard wiiboard) {
                wiiboard.addListener(wiiBoardListener);
            }
        };

        WiiBoardDiscoverer discoverer = WiiBoardDiscoverer.getWiiBoardDiscoverer();
        discoverer.addWiiBoardDiscoveryListener(wiiBoardDiscoveryListener);
        discoverer.startWiiBoardSearch();

    }
}