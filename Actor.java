public class Actor{

    private int hp;
    private int attack;
    private String name;
    private String location;

    public Actor(){
        this.hp = 100;
        this.name = "nameless";
        this.location = "purgatory";
    }

    public Actor(int hp, int attack, String name, String location){
        this.hp = hp;
        this.attack = attack;
        this.name = name;
        this.location = location.toLowerCase();
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public int getHP(){
        return this.hp;
    }

    //adds input value to objects hp
    public void changeHP(int hp){
        this.hp += hp;
    }

    //checks if object is alive
    public boolean isAlive(){
        return this.hp > 0;
    }

    //gets objects name
    public String getName(){
        return this.name;
    }

    //sets objects location
    private void setLocation(String location){
        this.location = location;
    }

    //gets objects location
    public String getLocation(){
        return this.location;
    }

    //gets objects attack power
    public int getAttackPower(){

        return this.attack;
    }

    //ensures that enemy is valid then subtracts
    //the players attack power from enemy hp
    public boolean attack(String enemy, Map map){

        if(map.getArea(this.location).containsEnemy(enemy)){

            map.getArea(this.location).getEnemy(enemy).changeHP(-this.attack);
            return true;
        }else{
            System.out.println("No Such Enemy");
            return false;
        }
    }

    //encures that object exists in area
    //then returns objects description string
    public boolean inspect(String objectName, Map map){

        if(map.getArea(this.location).containsObject(objectName)){

            System.out.println(map.getArea(this.location).getObject(objectName));
            return true;
        }else{
            System.out.println("No Such Object");
            return false;
        }
    }

    //encures that exit exists in current room
    //then changes player location
    public boolean travelTo(String location, Map map){

        System.out.println(location);

        if(map.containsArea(location)){

            if(map.getArea(this.location).containsExit(location)){
                this.setLocation(location);
                return true;
            }else System.out.println("No way to get there");
        }else System.out.println("No Such Area");

        return false;
    }
}

