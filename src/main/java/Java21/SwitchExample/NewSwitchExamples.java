package Java21.SwitchExample;

public class NewSwitchExamples {

    public static void main(String[] args) {

        TestSwitch1 newObject = new TestSwitch1();
        TestSwitch2 newObject2 = new TestSwitch2();

        expressionWithArrowLabels(); //This is South; NORTH
        instanceOfChecks(newObject);
        instanceOfChecks(newObject2);
        instanceOfChecks(null);
        instanceOfChecks(new Object());

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
            case default -> System.out.println("This is default"); //instanceOfChecks(new Object());
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
