import java.util.HashMap;

public class Map{

    private static HashMap<String, Area> map;

    public Map(){
        this.map = new HashMap<>();
    }

    public void addArea(Area area){

        this.map.put(area.name.toLowerCase(), area);
    }

    public Area getArea(String areaName){

        return this.map.get(areaName.toLowerCase());
    }

    public boolean containsArea(String areaName){

        return this.map.containsKey(areaName);
    }
}
