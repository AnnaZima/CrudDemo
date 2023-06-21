package model;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    int id;
    String content;
    LocalDateTime created;
    LocalDateTime updated;
    List<Label> labels;

}
