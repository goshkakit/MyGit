package ru.ncedu.java.tasks;

public class EmployeeImpl implements Employee {

    private Employee owner = null;
    private int salary = 1000;
    private String name = null;
    private String surname = null;
    //private String managerName = "No manager";
   // private String managerSurname = "";

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void increaseSalary(int value) {
        salary = getSalary() + value;
    }

    @Override
    public String getFirstName() {
        return name;
    }

    @Override
    public void setFirstName(String firstName) {
        name = firstName;
    }

    @Override
    public String getLastName() {
        return surname;
    }

    @Override
    public void setLastName(String lastName) {
        surname = lastName;
    }

    @Override
    public String getFullName() {
        return name+' '+surname;
    }

    @Override
    public void setManager(Employee manager) {
        this.owner = manager;
    }

    @Override
    public String getManagerName() {
       if(owner!=null) {
           return owner.getFullName();
       }
       else{
           return "No manager";
       }
    }

    @Override
    public Employee getTopManager() {
        if(owner == null){
            return this;
        } else {
            return owner.getTopManager();
        }
    }


    public static void main(String[] args) {
        EmployeeImpl worker = new EmployeeImpl();
        EmployeeImpl man = new EmployeeImpl();
        man.setFirstName("dd");
        man.setLastName("fff");
        worker.setFirstName("mem");
        worker.setLastName("memes");
        worker.increaseSalary(1000);
        System.out.println(worker.getSalary());
        System.out.println(worker.getFullName());
        //worker.setManager(man);
        System.out.println(worker.getManagerName());
        //owner = worker;
        worker.getTopManager();
    }
}