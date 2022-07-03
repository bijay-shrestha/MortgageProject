import java.time.LocalDate;
import java.time.Period;

public class MortgageCalculator {

    public double computeMaxMortgage(int yearOfBirt,
                                     int month, int day,
                                     double monthlyIncome,
                                     boolean married,
                                     double monthlyIncomePartner,
                                     String profession) {
        double maxMortgage = 0;
        int age = getAge(yearOfBirt, month, day);
        boolean isAdult = age > 18;

        if (!isAdult) {
            return maxMortgage;
        }
        if (!married) {
            maxMortgage = calculateMaxMortgage(profession, monthlyIncome);
        } else {
            double totalIncome = monthlyIncome + monthlyIncomePartner * 0.94;
            maxMortgage = calculateMaxMortgage(profession, totalIncome);
        }

        return maxMortgage;
    }

    private double calculateMaxMortgage(String profession, double income) {
        if (income >= 2000 && income < 3000) {
            return calculateMaxMortgageForIncomeIsGreaterThan2000ButLessThan3000(profession);
        }
        if (income >= 3000 && income < 5000) {
            return calculateMaxMortgageForIncomeIsGreaterThan3000ButLessThan5000(profession);
        }
        if (income >= 5000) {
            return calculateMaxMortgageForIncomeGreaterThan5000(profession);
        }
        return 0;
    }


    private int getAge(int yearOfBirt, int month, int day) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(yearOfBirt, month, day);

        Period p = Period.between(birthday, today);
        int age = p.getYears();
        System.out.println(age);
        return age;
    }

    private boolean isDeveloperOrArchitectOrScrumMaster(String profession) {
        return profession.equals("Developer") || profession.equals("Architect") || profession.equals("Scrum master");
    }

    private boolean isTesterSystemOrAdministrator(String profession) {
        return profession.equals("Tester") || profession.equals("System Administrator") || profession.equals("Technical writer");
    }

    private boolean isDepartmentHeadOrProfessor(String profession) {
        return profession.equals("Department head") || profession.equals("Professor");
    }

    private double calculateMaxMortgageForIncomeGreaterThan5000(String profession) {
        if (isDeveloperOrArchitectOrScrumMaster(profession)) return 220000;
        if (isTesterSystemOrAdministrator(profession)) return 160000;
        if (isDepartmentHeadOrProfessor(profession)) return 280000;
        return 0;
    }

    private double calculateMaxMortgageForIncomeIsGreaterThan3000ButLessThan5000(String profession) {
        if (isDeveloperOrArchitectOrScrumMaster(profession)) return 180000;
        if (isTesterSystemOrAdministrator(profession)) return 140000;
        if (isDepartmentHeadOrProfessor(profession)) return 250000;
        return 0;
    }

    private double calculateMaxMortgageForIncomeIsGreaterThan2000ButLessThan3000(String profession) {
        if (isDeveloperOrArchitectOrScrumMaster(profession)) return 160000;
        if (isTesterSystemOrAdministrator(profession)) return 120000;
        if (isDepartmentHeadOrProfessor(profession)) return 220000;
        return 0;
    }


}
