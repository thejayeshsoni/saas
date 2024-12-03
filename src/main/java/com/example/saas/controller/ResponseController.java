package com.example.saas.controller;

import com.example.saas.dto.ResponseDTO;
import com.example.saas.entity.Response;
import com.example.saas.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @GetMapping("/{queryId}")
    public ResponseEntity<Response> getResponseByQueryId(@PathVariable UUID queryId) {
        return ResponseEntity.ok(responseService.getResponseByQueryId(queryId));
    }

    @PostMapping
    public ResponseEntity<Response> createResponse(@RequestBody ResponseDTO responseDTO, @RequestParam UUID queryId) {
        return ResponseEntity.ok(responseService.createResponse(responseDTO, queryId));
    }
}
