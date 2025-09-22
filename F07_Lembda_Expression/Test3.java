package F07_Lembda_Expression;

public class Test3 {
    public static void main(String[] args) {
        Animal_02 cow= new Animal_02() {
            @Override
            public String feature(String asfood, String size, String type) {
                return "eats : " + "size : " + "type :" +type ;
            }
        };
        System.out.println(cow.feature("grass", "long", "pat"));
        // lambda expression of the above  function is below :

        Animal_02 lion= (String asfood, String size, String type) -> {
                return "eats : " + "size : " + "type :" +type ;

        };
        System.out.println(lion.feature("Meat", "medium", "Jungle"));

    }


}
