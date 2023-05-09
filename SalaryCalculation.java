public class SalaryCalculation {
    public static void calculatePay(double basePay, int hoursWorked) {
        if (basePay < 100) {
            System.out.println("Base pay cannot be less than 100 TL");
            return;
        }
        if (hoursWorked > 60) {
            System.out.println("Hours worked cannot be greater than 60");
            return;
        } 
        double totalPay = basePay > 0 ? basePay * 40 : 0; 
        totalPay += hoursWorked > 40 ? basePay * 1.5 * (hoursWorked - 40) : 0;
        System.out.println("Total amount to be paid to the employee: " + totalPay);
    }

    public static void main(String[] args) {
        calculatePay(90.5, 35);
        calculatePay(120.5, 47);
        calculatePay(150.0, 73);
    }
    
}
