import java.util.Comparator;
public class DistanceComparator implements Comparator<Plane> {



        public int compare(Plane p1 , Plane p2) {
            if(p1.getDistance() == p2.getDistance())
                return 0;
            else if(p1.getDistance() > p2.getDistance())
                return 1;
            else
                return -1;
        }



}
