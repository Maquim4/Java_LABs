import java.util.ArrayList;
import java.util.List;

public class AirCompany {

    private String nick;
    private List<Plane> planesList;

    public AirCompany(String nick) {
        planesList = new ArrayList<>();
        this.nick=nick;

    }



    public String getNick() {
        return nick;
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