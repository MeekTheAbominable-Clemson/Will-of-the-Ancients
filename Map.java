import java.util.HashMap;

public class Map{

    private static HashMap<String, Area> map;

    public Map(){
        this.map = new HashMap<>();
    }

    //log and add area
    public void addArea(Area area, IO io){

        io.log("Adding: \n");
        io.log("\t-Area Name: " + area.getName() + "\n");
        io.log("\t-Area Description: " + area.getDescription() + "\n");
        this.map.put(area.name.toLowerCase(), area);
    }

    public void addArea(Area area){
        this.map.put(area.name.toLowerCase(), area);
    }

    public Area getArea(String areaName){

        return this.map.get(areaName.toLowerCase());
    }

    //checks if area object exists on map
    public boolean containsArea(String areaName){

        return this.map.containsKey(areaName);
    }
}
