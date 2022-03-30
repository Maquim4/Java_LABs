import java.util.ArrayList;
import java.util.List;

public class AirCompany {

    private List<Plane> planesList;

    public AirCompany() {
        planesList = new ArrayList<>();

    }

    public AirCompany (List<Plane> planesList) {
        this.planesList = planesList;

    }

    public List<Plane> getPlanesList() {
        return planesList;
    }

    public void setPlanesList(List<Plane> planesList) {
        this.planesList = planesList;
    }

    public void addPlane (Plane plane){

        planesList.add(plane);
    }



}
