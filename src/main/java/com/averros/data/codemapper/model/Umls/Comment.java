package com.averros.data.codemapper.model.Umls;

import com.averros.data.codemapper.model.User;
import lombok.Data;
import org.joda.time.DateTime;

@Data
public class Comment {

    private User author;
    private DateTime timeStamp;
    private String conceptUniqueIdentifier;
    private String text;
}
