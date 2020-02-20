package hyperskill.inheritance;

public class SuperEmployee {

}
class Employeer {

    protected String name;
    protected String birthDate;

    public Employeer(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}

class RegularEmployee extends Employeer {

    protected long salary;
    protected String hireDate;

    public RegularEmployee(String name, String birthDate, long salary, String hireDate) {
        super(name, birthDate);
        this.salary = salary;
        this.hireDate = hireDate;
    }
}

class ContractEmployee extends Employeer {

    protected long payPerHour;
    protected String contractPeriod;

    public ContractEmployee(String name, String birthDate, long payPerHour, String contractPeriod) {
        super(name, birthDate);
        this.payPerHour = payPerHour;
        this.contractPeriod = contractPeriod;
    }
}