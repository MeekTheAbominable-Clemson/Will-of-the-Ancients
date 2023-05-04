public class World{

    private static Map map;
    private static Actor player;
    private static Actor[] enemies;
    private static boolean requiresUpdate;

    public World(Map m, Actor p){

        this.map = m;
        this.player = p;
        this.map.addArea(new Area("Purgatory", "You feel cold and utterly alone. What did you do to deserve a fate like this?"));
    }

    public void setLocation(String location){
        this.player.setLocation(location);
    }

    public void setPlayer(Actor player){
        this.player = player;
    }

    public boolean travelTo(Command command){

        String location = command.getOption(0).toLowerCase();

        if(this.map.containsArea(location)){

            if(this.map.getArea(this.player.getLocation()).containsExit(location)){

                this.player.setLocation(location);
                return true;
            }else System.out.println("No way to get there");
        }else System.out.println("No Such Area");

        return false;
    }

    public Area playerLocation(){

        return this.map.getArea(this.player.getLocation());
    }

}
