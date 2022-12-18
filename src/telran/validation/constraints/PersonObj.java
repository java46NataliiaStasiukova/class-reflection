package telran.validation.constraints;

public class PersonObj {
public PersonObj(String name, double salary, String email, String phoneNumber) {
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
@Min(value = 3, message = "name length should be no less then 3 letters")
@Max(value = 10, message = "name length should be no more them 10 letters")
@NotEmpty(message = "name field cannot be empty")
private String name;
@Min(value = 0, message = "salary value cannot be a negative value")
private double salary;
@Pattern(value ="^(?=.{1,64}@)[\\p{L}0-9\\+_-]+(\\.[\\p{L}0-9\\+_-]+)*@{0}"
        + "[^-][\\p{L}0-9\\+-]+(\\.[\\p{L}0-9\\+-]+)*(\\.[\\p{L}]{2,})$"
		, message = "Email not correct")
private String email;
@Pattern(value = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
message = "phone number not correct")
private String phoneNumber;
	
}
