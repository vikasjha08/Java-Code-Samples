package Java21.SwitchExample;

public class NewSwitchExamples {

    public static void main(String[] args) {

        TestSwitch1 newObject = new TestSwitch1();
        TestSwitch2 newObject2 = new TestSwitch2();
        User user = new User("1","Vikas");
        User newUser = new User("1","Akash");

        expressionWithArrowLabels(); //This is South; NORTH
        instanceOfChecks(newObject);
        instanceOfChecks(newObject2);
        instanceOfChecks(null);
        instanceOfChecks(new Object());
        System.out.println(extractValueAndCheck(user));
        System.out.println(extractValueAndCheckOtherWay(newUser));

    }

    private static String extractValueAndCheckOtherWay(User user) {

        if(user instanceof User(String id, String name) && name.equals("Vikas")){
            return "Match Found";
        }
        else {
            return "No Match";
        }

    }

    private static String extractValueAndCheck(User user) {
        return switch (user){ // first part is checking type and then condition
          case User(String id, String name) when name.equals("Vikas") -> "Matched Case";
            default -> throw new IllegalStateException("Unexpected value: " + user);
        };
    }

    private static void instanceOfChecks(Object newObject) {

        //Before
        if(newObject instanceof NewSwitchExamples){
            System.out.println("This is of Type NewSwitchExamples");
        } else if (newObject instanceof Number) {
            System.out.println("This is of Type Number");
        }
        else {
            System.out.println("None Matched"); //Below Default and Null Check can be handled easily
        }

        //After Java 21 Switch
        switch (newObject){
            case null -> System.out.println("This is null"); //instanceOfChecks(null);
            case NewSwitchExamples a -> System.out.println("This is of Type NewSwitchExamples");
            case Number n -> System.out.println("This is of Type number");
            default -> System.out.println("This is default"); //instanceOfChecks(new Object());
        }


    }

    private static void expressionWithArrowLabels() {
        System.out.println(Directions.SOUTH.completeValue()); //This is South
        System.out.println(Directions.valueOf("NORTH")); //NORTH
    }


    enum Directions{
        SOUTH, NORTH, EAST, WEST;

        String completeValue(){
            return switch(this){ //can be directly returned now

                case SOUTH -> "This is South"; //Can be Defined with Arrow now
                case NORTH -> "This is North"; //With Arrow type define no break statement is needed
                case EAST -> "This is East"; //Exhaustive check : if you comment any possible value, it gives compile issue
                case WEST -> "This is West";
            };


        }
    }




}
