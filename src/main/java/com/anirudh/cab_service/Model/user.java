package com.anirudh.cab_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity (name = "users")
public class user {
    @Id
    private String userId;
    private String userName;
    private String type;

}
