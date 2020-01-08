package life.qinwei.community.dto;

import lombok.Data;

@Data
public class CommentCrateDTO {
    private Long parentId;
    private String content;
    private Integer type;

}
