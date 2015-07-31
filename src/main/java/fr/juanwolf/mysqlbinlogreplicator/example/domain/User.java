package fr.juanwolf.mysqlbinlogreplicator.example.domain;

import fr.juanwolf.mysqlbinlogreplicator.annotations.MysqlMapping;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import java.util.Date;

/**
 * Created by juanwolf on 17/07/15.
 */
@Document(indexName = "user")
@Mapping(mappingPath = "user")
@NoArgsConstructor
@Accessors(chain = true)
@MysqlMapping(table = "user", repository="userRepository")
public class User {

    @Id
    @Getter
    @Setter
    Integer id;

    @Getter
    @Field(type = FieldType.Long, index = FieldIndex.analyzed)
    long identifier;

    @Getter
    @Setter
    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    String mail;

    @Getter
    @Field(index = FieldIndex.analyzed, type = FieldType.Date)
    Date creationDate;

    @Getter
    @Field(index = FieldIndex.analyzed, type = FieldType.Float)
    float cartAmount;
}

