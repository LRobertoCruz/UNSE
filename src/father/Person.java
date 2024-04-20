/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package father;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import tools.InputScanner;

/**
 *
 * @author Luis Cruz
 * @version 1.0-SNAPSHOT
 */
public class Person {
    
    private String identification;
    private String lastName;
    private String firstName;
    private String address;
    private LocalDate birthday;
    private char sex;
    
    public Person() {
        this.identification = "";
        this.lastName = "";
        this.firstName = "";
        this.address = "";
        this.birthday = null;
        this.sex = ' ';
    }
    
    public Person(String identification, String lastName, String firstName, String address, LocalDate birthday, char sex) {
        this.identification = identification;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.birthday = LocalDate.of(birthday.getYear(), birthday.getMonth(), birthday.getDayOfMonth());
        this.sex = sex;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.identification);
        hash = 59 * hash + Objects.hashCode(this.lastName);
        hash = 59 * hash + Objects.hashCode(this.firstName);
        hash = 59 * hash + Objects.hashCode(this.address);
        hash = 59 * hash + Objects.hashCode(this.birthday);
        hash = 59 * hash + this.sex;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.sex != other.sex) {
            return false;
        }
        if (!Objects.equals(this.identification, other.identification)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return Objects.equals(this.birthday, other.birthday);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("identification=").append(identification);
        sb.append(", lastName=").append(lastName);
        sb.append(", firstName=").append(firstName);
        sb.append(", address=").append(address);
        sb.append(", birthday=").append(birthday);
        sb.append(", sex=").append(sex);
        sb.append('}');
        return sb.toString();
    }
    
    // Class-specific methods (public)

    public void uploadPersonalData() {
        uploadID();
        uploadLastName();
        uploadFirstName();
        uploadAddress();
        uploadBirthday();
    }
    
    public int getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    // Class-Specific methods (private)

    private void uploadID() {
        System.out.print("Identificacion:");
        String iden = InputScanner.readString();
        
        if (!verifyID(iden)) {
            setIdentification(iden);
        }
    }

    private boolean verifyID(String identification) {
        return identification.trim().matches("//d+");
    }
    
    private void uploadLastName() {
        System.out.print("Apellido:");
        String lastN = InputScanner.readString();
        
        setLastName(lastN.trim());
    }
    
    private void uploadFirstName() {
        System.out.print("Nombre:");
        String firstN = InputScanner.readString();
        
        setFirstName(firstN.trim());
    }
    
    private void uploadAddress() {
        System.out.print("Dirección:");
        String ads = InputScanner.readString();
        
        setAddress(ads.trim());
    }
    
    private void uploadBirthday() {
        System.out.print("Dia:");
        int day = InputScanner.readInt();
        System.out.print("Mes:");
        int month = InputScanner.readInt();
        System.out.print("Año:");
        int year = InputScanner.readInt();
        
        if (verifyBirthday(year, month, day)) {
            LocalDate birthd = LocalDate.of(year, month, day);
            setBirthday(birthd);
        } else {
            System.out.println("Datos invalidos...");
            uploadBirthday();
        }
    }
    
    private boolean verifyBirthday(int year, int month, int day) {
        if (year < 1) {
            return false;
        }
        
        if (month < 1 || month > 12) {
            return false;
        }
        
        return !(day < 1 || day > dayInMonth(year, month));
    }
    
    private int dayInMonth(int year, int month) {
        return switch (month) {
            case 2 -> isLeapYear(year) ? 28 : 29;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    private void uploadSex() {
        
    }
    
    private boolean verifySex(char sex) {
        return false;
    }
    
}
