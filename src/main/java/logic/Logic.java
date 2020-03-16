package logic;

import java.util.ArrayList;
import java.util.List;

public class Logic implements LogicInterface {

    private List<double[]> cop;

    public Logic() {
        this.cop = new ArrayList<>();
    }

    @Override
    public void addCopPoint(double tr, double tl, double br, double bl, double time) {
        int L = 433; //wiiboardStack length
        int W = 228; // wiiboardStack width

        double xVal = (L/2) * (((tr+br)-(tl+bl))/(tr+br+tl+bl));
        double yVal = (W/2) * (((tr+tl)-(br+bl))/(tr+br+tl+bl));

        cop.add(new double[]{xVal,yVal,time});
    }

    @Override
    public double calculateTurningPointForMaintainingBalance() {
        double tp = 0.0;

        //TODO calculate turning point

        return tp;
    }

    /**
     * This gets the COP points. Each entry is on the format [x,y,time]
     * @return A List with COP points in format [x,y,time]
     */
    @Override
    public List getCopList() {
        return this.cop;
    }

    @Override
    public double calculateCurveLength() {
        double curveLength = 0.0;

        for(int i = 1; i < cop.size(); i++) {
            double[] cops = cop.get(i);
            double[] copsPrev = cop.get(i-1);
            double x1 = cops[0];
            double y1 = cops[1];
            double x2 = copsPrev[0];
            double y2 = copsPrev[1];

            curveLength += Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        }

        return curveLength;
    }

    @Override
    public double calculateCurveArea() {
        double curveArea = 0.0;

        //TODO calculate curve area

        return curveArea;
    }

    @Override
    public void clearData() {
        cop.clear();
    }


}
