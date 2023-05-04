public class Actor{

    private static int hp;
    private static String location;

    public Actor(){
        this.hp = 100;
        this.location = "purgatory";
    }

    public Actor(String location){
        this.hp = 100;
        this.location = location.toLowerCase();
    }

    public Actor(int hp, String location){
        this.hp = 100;
        this.location = location.toLowerCase();
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public int getHP(){
        return this.hp;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return this.location;
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
}
