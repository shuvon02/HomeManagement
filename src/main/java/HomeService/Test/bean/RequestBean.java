package HomeService.Test.bean;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class RequestBean {
    private int find;
    private int update;
    private int delete;
    private int insert;

    JsonNode data;
}
