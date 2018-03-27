package edu.tamu.cap.controller;

import static edu.tamu.weaver.response.ApiStatus.SUCCESS;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tamu.cap.service.VerifiableIRService;
import edu.tamu.weaver.response.ApiResponse;

@RestController
@RequestMapping("ir/{type}/test")
public class TestIRSettingsController {

    @RequestMapping(value = "/ping", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ApiResponse testIRPing(VerifiableIRService<?> irService) throws Exception {
        irService.verifyPing();
        return new ApiResponse(SUCCESS, "Ping was successful!");
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ApiResponse testIRAuth(VerifiableIRService<?> irService) throws Exception {
        irService.verifyAuth();
        return new ApiResponse(SUCCESS);
    }

    @RequestMapping(value = "/content", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ApiResponse testIRContent(VerifiableIRService<?> irService) throws Exception {
        irService.verifyRoot();
        return new ApiResponse(SUCCESS);
    }

}
