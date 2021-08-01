package vn.techmaster.shopingcart.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Validate user form
public class Customer {
    private Long id=1L;
    @Size(min = 5, max = 30, message = "{name_size_between_5_30}")
    private String name;
    @NotBlank(message = "email required")
    @Email
    private String email;
    @NotBlank(message = "phoneNumber is required")
    @Size(min = 10, max = 10)
    private String phone;
    @NotBlank(message = "address is required")
    private String address;

    public Customer(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.id++;
    }
}