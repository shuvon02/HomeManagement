package HomeService.Test.bean;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "member_info")
public class memberBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer oid;
    @NotNull
    @Column(nullable = false)
    String member_name;
    Date dob;
    @NotNull
    @Email(message = "Please provide a valid email address")
    String email;
    @Pattern(
            regexp = "^(013|014|015|016|017|018|019)\\d{8}$",
            message = "Please provide a valid Bangladeshi mobile number"
    )
    String mobile;
    String district;
    @PastOrPresent(message = "Entry Date cannot be in the future")
    Date entry_date;
    Date leave_date;
    Integer marital_status;
    Integer status;
    String company;
}


/*{
        "member_name": "Shuvon",
        "dob": "1998-12-01",
        "email": "shuvon@example.com",
        "mobile": "01712345678",
        "district": "Dhaka",
        "entry_date": "2024-06-01",
        "leave_date": null,
        "marital_status": 1,
        "status": 1,
        "company": "ABC Ltd"
  }*/
