package com.example.Veritas.AI.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUser {
    @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
     int id;
    String username;
    String password;
}
