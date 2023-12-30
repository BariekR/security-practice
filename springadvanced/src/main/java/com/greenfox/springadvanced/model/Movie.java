package com.greenfox.springadvanced.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "movies")
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    @SerializedName(value = "original_title")
    private String originalTitle;
    @SerializedName(value = "original_language")
    private String originalLanguage;
    @Column(columnDefinition = "TEXT")
    private String overview;
}
