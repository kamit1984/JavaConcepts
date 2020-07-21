package General;

import java.io.Serializable;

public class Rectangle implements Serializable {
    int length;
    int breadth;
    transient int area;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
        area = length * breadth;
    }

    public int getArea(){
        area = length * breadth;
        return area;
    }
}
