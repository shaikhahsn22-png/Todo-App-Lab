package com.ga.todoapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"password", "userProfile", "recipeList", "categoryList"})
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String emailAddress;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    //user can have one profile only
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name ="profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    //user can have one or more items
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Item> itemList;

    //user can have one or more categories
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Category> categoryList;

    @JsonIgnore
    public String getPassword(){
        return password;
    }
}
