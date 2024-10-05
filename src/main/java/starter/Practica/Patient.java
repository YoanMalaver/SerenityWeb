package starter.Practica;

public class Patient {
    int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    public Patient(String pName,String pEmail){
        this.name = pName;
        this.email = pEmail;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public String getWeight(){
        return this.weight + "kg";
    }

    public String getName() {
        return this.name ;

    }
}
