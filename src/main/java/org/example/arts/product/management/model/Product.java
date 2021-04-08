package org.example.arts.product.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

@Document(collection = "products")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String name;
    private String image;
    private List<String> description;
    private List<String> tags;
    private String soldBy;
    private String entryTime;
    private String lastUpdatedBy;
    private String lastUpdateTime;
    private Map<String,String> attributes;
}
