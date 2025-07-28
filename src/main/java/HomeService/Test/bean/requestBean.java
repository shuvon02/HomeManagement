package HomeService.Test.bean;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class requestBean {
    private Integer find;
    private Integer update;
    private Integer delete;
    private Integer insert;

    JsonNode data;
}
