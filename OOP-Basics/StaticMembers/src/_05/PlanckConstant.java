package _05;

public class PlanckConstant {
    public static void main(String[] args) {

        System.out.println(Calculations.reducesPlanck());
    }
}

class Calculations{
    static double planck = 6.62606896e-34;
    static double pi=3.14159;
    static double reducesPlanck(){
        return planck / (2* pi);
    }
}
