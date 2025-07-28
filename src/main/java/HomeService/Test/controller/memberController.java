package HomeService.Test.controller;

import HomeService.Test.bean.memberBean;
import HomeService.Test.service.MemberConfigService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class memberController {

    private final MemberConfigService memberConfigService;


    public memberController(MemberConfigService memberConfigService) {
        this.memberConfigService = memberConfigService;
    }

    @PostMapping("/admission")
    ResponseEntity<?> memberAdmissoin(@Valid @RequestBody memberBean memberBean) {
        var responseBody = memberConfigService.addMember(memberBean);
        var customResponseHeaders = new HttpHeaders();
        customResponseHeaders.add("custom-header", "custom-header-value");

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(customResponseHeaders)
                .body(responseBody);
    }
}
