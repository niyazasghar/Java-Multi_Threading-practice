package F07_Lembda_Expression;

public class Test2 {
    public static void main(String[] args) {
        Animal cow= new Animal() {
            @Override
            public String canEat(String asfood) {
                return "Cow can eat : "+ asfood;
            }
        };
        System.out.println(cow.canEat("grass"));
        // lambda expression of the above  function is below :
        Animal lion= (String asfood) ->{
                return "lion can eat : "+ asfood;
        };
        System.out.println(lion.canEat("Meat"));


    }


}
