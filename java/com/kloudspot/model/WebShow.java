package com.kloudspot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Document(collection = "webshow")
public class WebShow {
    private String webshowName, maleactorName, femaleactorName, directorName;
    @Id
    private int _id;
    @Field(name = "IMDB")
    private double IMDBRating;
}
