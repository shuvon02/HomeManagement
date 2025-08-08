package HomeService.Test.controller;

import HomeService.Test.bean.MemberBean;
import HomeService.Test.service.MemberConfigService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberConfigService memberConfigService;


    public MemberController(MemberConfigService memberConfigService) {
        this.memberConfigService = memberConfigService;
    }

    @PostMapping("/admission")
    ResponseEntity<?> memberAdmissoin(@Valid @RequestBody MemberBean memberBean) {
        var responseBody = memberConfigService.addMember(memberBean);
        var customResponseHeaders = new HttpHeaders();
        customResponseHeaders.add("custom-header", "custom-header-value");
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(customResponseHeaders)
                .body(responseBody);
    }
    @RequestMapping(value = "/purposewiseloan",method = RequestMethod.POST,produces = "application/json")
    ResponseEntity<?> getMemberById(HttpServletRequest request, @RequestParam("json") String json) throws JsonProcessingException {
        return memberConfigService.getMember(json);
    }
}
